package cn.enilu.guns.service.fluxinsurance.impl;

import cn.enilu.guns.bean.core.ShiroUser;
import cn.enilu.guns.bean.domain.ActivateCodeDomain;
import cn.enilu.guns.bean.entity.user.FluxInsuranceOrderBalance;
import cn.enilu.guns.bean.entity.user.OrOrder;
import cn.enilu.guns.dao.insuranceservice.ActivateCodeRepository;
import cn.enilu.guns.dao.insuranceservice.FluxInsuranceOrderBlanceRepository;
import cn.enilu.guns.dao.insuranceservice.OrOrderRepository;
import cn.enilu.guns.service.fluxinsurance.IFluxOrderBalanceService;
import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class FluxOrderBalanceServiceImpl implements IFluxOrderBalanceService {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private FluxInsuranceOrderBlanceRepository fluxInsuranceOrderBlanceRepository;

    @Autowired
    private ActivateCodeRepository activateCodeRepository;

    @Autowired
    private OrOrderRepository orOrderRepository;

    public List<OrOrder> findByStartTimeAndEndTimeInActivateCode(ActivateCodeDomain activateCodeDomain, String cpId, String orgCode) throws ParseException {

        return orOrderRepository.findByStartTimeAndEndTimeInActivateCode(
                activateCodeDomain.getStartTime(),
                activateCodeDomain.getEndTime(),
                activateCodeDomain.getUsed(),
                activateCodeDomain.getBalanceStatus(),
                cpId,
                orgCode);
    }

    /**
     * 查询出时间范围内的所有结算单
     * @return
     */
    public List<FluxInsuranceOrderBalance> findFluxInsuranceOrderBalanceByBalanceTime(ActivateCodeDomain activateCodeDomain, ShiroUser shiroUser){
        StringBuffer baseSql = new StringBuffer("SELECT bid, balanceSerial ,price, startTime, endTime, balanceStatus, activateSum, balanceTime FROM FluxInsuranceOrderBalance WHERE CP_ID = :cpId AND ORG_CODE = :orgCode AND BALANCE_TIME BETWEEN :startTime AND :endTime ");
        Map<String, Object> dataMap = new HashMap<>();
        Session session = entityManager.unwrap(Session.class);
        if(activateCodeDomain.getBalanceStatus() != null) {
            baseSql.append(" AND balance_status = :balanceStatus");
            dataMap.put("balanceStatus", activateCodeDomain.getBalanceStatus());
        }
        baseSql.append(" order by balanceTime desc ");

        Query query = session.createQuery(baseSql.toString());
        query.setParameter("cpId", shiroUser.getCpId());
        query.setParameter("orgCode", shiroUser.getOrgCode());
        query.setParameter("startTime", activateCodeDomain.getStartTime());
        query.setParameter("endTime", activateCodeDomain.getEndTime());
        for (String key : dataMap.keySet()) {
            query.setParameter(key,dataMap.get(key));
        }
        return convertObjectToFluxInsuranceOrderBalance(query.list());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateFluxInsuranceOrderBalanceByBalanceSerial(Integer balanceStatus, String balanceSerial, Integer beforeBalanceStatus) {
        int i = fluxInsuranceOrderBlanceRepository.updateFluxInsuranceOrderBalanceByBalanceSerial(balanceStatus, balanceSerial, beforeBalanceStatus);
        activateCodeRepository.updateActionCodeBalanceStatusByBalanceSerial(balanceStatus, balanceSerial);
        return i;
    }

    private List<FluxInsuranceOrderBalance> convertObjectToFluxInsuranceOrderBalance(List<Object []> list) {
        List<FluxInsuranceOrderBalance> covList = new ArrayList<>();
        for(Object o[]:list) {
            FluxInsuranceOrderBalance fluxInsuranceOrderBalance = new FluxInsuranceOrderBalance();
            fluxInsuranceOrderBalance.setBid((Integer) o[0]);
            fluxInsuranceOrderBalance.setBalanceSerial(o[1].toString());
            fluxInsuranceOrderBalance.setPrice((Float) o[2]);
            fluxInsuranceOrderBalance.setStartTime((Timestamp)o[3]);
            fluxInsuranceOrderBalance.setEndTime((Timestamp) o[4]);
            fluxInsuranceOrderBalance.setBalanceStatus((Integer)o[5]);
            fluxInsuranceOrderBalance.setActivateSum((Integer)o[6]);
            fluxInsuranceOrderBalance.setBalanceTime((Timestamp)o[7]);
            covList.add(fluxInsuranceOrderBalance);
        }
        return covList;
    }
}
