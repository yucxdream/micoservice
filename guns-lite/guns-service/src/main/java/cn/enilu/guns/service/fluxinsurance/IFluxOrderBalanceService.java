package cn.enilu.guns.service.fluxinsurance;

import cn.enilu.guns.bean.core.ShiroUser;
import cn.enilu.guns.bean.domain.ActivateCodeDomain;
import cn.enilu.guns.bean.entity.user.FluxInsuranceOrderBalance;
import cn.enilu.guns.bean.entity.user.OrOrder;

import java.text.ParseException;
import java.util.List;


/**
 * <p>
 * InnoDB free: 0 kB 服务类
 * </p>
 *
 * @author stylefeng
 * @since 2018-11-22
 */
public interface IFluxOrderBalanceService {
    List<OrOrder> findByStartTimeAndEndTimeInActivateCode(ActivateCodeDomain activateCodeDomain, String cpId, String orgCode) throws ParseException;
    List<FluxInsuranceOrderBalance> findFluxInsuranceOrderBalanceByBalanceTime(ActivateCodeDomain activateCodeDomain, ShiroUser shiroUser);
    int updateFluxInsuranceOrderBalanceByBalanceSerial(Integer balanceStatus, String balanceSerial, Integer beforeBalanceStatus);
}
