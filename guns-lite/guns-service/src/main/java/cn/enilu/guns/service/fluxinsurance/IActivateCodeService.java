package cn.enilu.guns.service.fluxinsurance;

import cn.enilu.guns.bean.core.ShiroUser;
import cn.enilu.guns.bean.domain.ActivateCodeDomain;
import cn.enilu.guns.bean.entity.user.ActivateCode;
import cn.enilu.guns.bean.entity.user.OrgUser;
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
public interface IActivateCodeService{
    boolean insertActivateByCount(ActivateCodeDomain activateCodeDomain, ShiroUser shiroUser);
    List<ActivateCode> selectActivateConditions(ActivateCodeDomain activateCodeDomain, ShiroUser shiroUser);
    int balanceActivateByStartTimeAndEndTime(ActivateCodeDomain activateCodeDomain, ShiroUser shiroUser) throws Exception;
}
