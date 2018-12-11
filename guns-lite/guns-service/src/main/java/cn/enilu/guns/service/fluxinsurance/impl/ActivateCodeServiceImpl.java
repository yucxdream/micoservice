package cn.enilu.guns.service.fluxinsurance.impl;

import cn.enilu.guns.bean.core.ShiroUser;
import cn.enilu.guns.bean.domain.ActivateCodeDomain;
import cn.enilu.guns.bean.entity.user.ActivateCode;
import cn.enilu.guns.bean.entity.user.FluxInsuranceOrderBalance;
import cn.enilu.guns.bean.entity.user.OrgUser;
import cn.enilu.guns.dao.insuranceservice.ActivateCodeRepository;
import cn.enilu.guns.dao.insuranceservice.FluxInsuranceOrderBlanceRepository;
import cn.enilu.guns.dao.insuranceservice.OrOrderRepository;
import cn.enilu.guns.service.fluxinsurance.IActivateCodeService;
import cn.enilu.guns.service.fluxinsurance.IFluxOrderBalanceService;
import cn.enilu.guns.utils.StringUtils;
import cn.enilu.guns.utils.UUIDUtils;
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
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * InnoDB free: 0 kB 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2018-11-22
 */
@Service
public class ActivateCodeServiceImpl implements IActivateCodeService {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ActivateCodeRepository activateCodeRepository;

    @Autowired
    private IFluxOrderBalanceService fluxOrderBalanceService;

    @Autowired
    private FluxInsuranceOrderBlanceRepository fluxInsuranceOrderBlanceRepository;

    @Autowired
    private OrOrderRepository orOrderRepository;
    /**
     * 添加激活码
     * @param activateCodeDomain
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean insertActivateByCount(ActivateCodeDomain activateCodeDomain, ShiroUser shiroUser){
        for(int i = 0; i < activateCodeDomain.getCount(); i ++) {
            ActivateCode activateCode = new ActivateCode();
            activateCode.setCreateTime(new Timestamp(new Date().getTime()));
            activateCode.setUseTime(null);
            activateCode.setActivateCode(UUIDUtils.getActivateCodeByUUId());
            activateCode.setBpId(activateCodeDomain.getBpId());
            activateCode.setUsed(0);
            activateCode.setDisabled(1);
            activateCode.setBalanceStatus(0);
            activateCode.setCpId(shiroUser.getCpId());
            activateCode.setOrgCode(shiroUser.getOrgCode());
            //activateCode.setScCode(activateCodeDomain.getScCode());
            activateCodeRepository.save(activateCode);
        //    super.insert(activateCode);
        }
        return true;
    }

    @Override
    public List<ActivateCode> selectActivateConditions(ActivateCodeDomain activateCodeDomain, ShiroUser shiroUser) {
        StringBuffer baseSql = new StringBuffer("SELECT ac.activateCode, ac.bpId ,ac.used, ac.createTime, ac.disabled, ac.useTime, ac.balanceStatus, ac.cpId, ac.orgCode, ac.balanceSerial, pb.name FROM ActivateCode ac, PProductBase pb WHERE ac.cpId = :cpId AND ac.orgCode = :orgCode AND ac.createTime BETWEEN :startTime AND :endTime AND pb.bpId = ac.bpId");
        Map<String, Object> dataMap = new HashMap<>();
        Session session = entityManager.unwrap(Session.class);
        if(StringUtils.isNotNullOrEmpty(activateCodeDomain.getUsed())) {
            baseSql.append(" AND ac.used = :used ");
            dataMap.put("used", activateCodeDomain.getUsed());
        }
        if(StringUtils.isNotNullOrEmpty(activateCodeDomain.getBalanceStatus())) {
            baseSql.append(" AND ac.balanceStatus = :balanceStatus ");
            dataMap.put("balanceStatus", activateCodeDomain.getBalanceStatus());
        }
        if(StringUtils.isNotNullOrEmpty(activateCodeDomain.getBalanceSerial())) {
            baseSql.append(" AND ac.balanceSerial = :balanceSerial ");
            dataMap.put("balanceSerial", activateCodeDomain.getBalanceSerial());
        }
        baseSql.append(" order by ac.createTime desc");

        Query query = session.createQuery(baseSql.toString());
        query.setParameter("cpId", shiroUser.getCpId());
        query.setParameter("orgCode", shiroUser.getOrgCode());
        query.setParameter("startTime", activateCodeDomain.getStartTime());
        query.setParameter("endTime", activateCodeDomain.getEndTime());

        for (String key : dataMap.keySet()) {
            query.setParameter(key,dataMap.get(key));
        }
        query.list();
        return convertObjectToActivateCode(query.list());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int balanceActivateByStartTimeAndEndTime(ActivateCodeDomain activateCodeDomain, ShiroUser shiroUser) throws Exception {
        return updateActivateAndSaveBalance(activateCodeDomain, shiroUser);
    }

    /**
     * 更新激活码表并且在结算表中插入一条结算数据
     */
    public int updateActivateAndSaveBalance(ActivateCodeDomain activateCodeDomain, ShiroUser shiroUser) throws Exception {
        //查询出所有需要结算的激活码
        List<ActivateCode> activateCodeList = activateCodeRepository.findByCreateTimeBetweenAndBalanceStatusAndOrgCodeAndCpIdAndUsed(
                activateCodeDomain.getStartTime(),
                activateCodeDomain.getEndTime(),
                0,
                shiroUser.getOrgCode(),
                shiroUser.getCpId(),
                1);

        //录入结算数据
        String balanceSerial = null;
        if(activateCodeList.size() > 0) {
            //查询出结算激活码对应的订单总金额
            String activateCodes [] = getActivateCodesList(activateCodeList);
            Double price = orOrderRepository.findOrderPriceByActivate(activateCodes);

            FluxInsuranceOrderBalance fluxInsuranceOrderBalance = new FluxInsuranceOrderBalance();
            fluxInsuranceOrderBalance.setStartTime(new Timestamp(activateCodeDomain.getStartTime().getTime()));
            fluxInsuranceOrderBalance.setEndTime(new Timestamp(activateCodeDomain.getEndTime().getTime()));
            fluxInsuranceOrderBalance.setBalanceTime(new Timestamp(new Date().getTime()));
            fluxInsuranceOrderBalance.setBalanceStatus(1);
            fluxInsuranceOrderBalance.setPrice(price.floatValue());
            fluxInsuranceOrderBalance.setActivateSum(activateCodeList.size());
            fluxInsuranceOrderBalance.setCpId(shiroUser.getCpId());
            fluxInsuranceOrderBalance.setOrgCode(shiroUser.getOrgCode());
            fluxInsuranceOrderBlanceRepository.save(fluxInsuranceOrderBalance);
            //生成结算批次号
            balanceSerial = new Date().getTime()+"" + fluxInsuranceOrderBalance.getBid();
            fluxInsuranceOrderBalance.setBalanceSerial(balanceSerial);
            fluxInsuranceOrderBlanceRepository.save(fluxInsuranceOrderBalance);

            //更新激活码表数据
            activateCodeRepository.updateActionCode(activateCodeDomain.getStartTime(),
                    activateCodeDomain.getEndTime(),
                    0,
                    shiroUser.getOrgCode(),
                    shiroUser.getCpId(),
                    1,
                    1,
                    balanceSerial);
        }
        return activateCodeList.size();
    }


    private String [] getActivateCodesList(List<ActivateCode> activateCodeList){
        String activates [] = new String[activateCodeList.size()];
        for(int i = 0; i < activates.length; i ++) {
            activates[i] = activateCodeList.get(i).getActivateCode();
        }
        return activates;
    }

    /**
     * 转换object为ActivateCode对象
     * @param list 包含有ActivateCode属性的对象数组集合
     * @return
     */
    private List<ActivateCode> convertObjectToActivateCode(List<Object[]> list) {
        List<ActivateCode> covList = new ArrayList<>();
        for(Object o[]:list) {
            ActivateCode activateCode = new ActivateCode();
            activateCode.setActivateCode(o[0].toString());
            activateCode.setBpId(o[1].toString());
            activateCode.setUsed((Integer)o[2]);
            activateCode.setCreateTime((Timestamp)o[3]);
            activateCode.setDisabled((Integer)o[4]);
            activateCode.setUseTime((Timestamp)o[5]);
            activateCode.setBalanceStatus((Integer)o[6]);
            activateCode.setCpId(o[7].toString());
            activateCode.setOrgCode(o[8].toString());
            activateCode.setBalanceSerial(o[9] == null ? "":o[9].toString());
            activateCode.setName(o[10].toString());
            covList.add(activateCode);
        }
        return covList;
    }
}
