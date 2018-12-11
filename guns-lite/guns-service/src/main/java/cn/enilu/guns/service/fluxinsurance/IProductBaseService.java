package cn.enilu.guns.service.fluxinsurance;

import cn.enilu.guns.bean.core.ShiroUser;
import cn.enilu.guns.bean.domain.ChannelProductDomain;
import cn.enilu.guns.bean.entity.user.PProductBase;
import java.util.List;


/**
 * <p>
 * InnoDB free: 0 kB 服务类
 * </p>
 *
 * @author stylefeng
 * @since 2018-11-22
 */
public interface IProductBaseService {
    List<PProductBase> findProductGroupByScCode(ShiroUser shiroUser);
    List<PProductBase> findProductByProductGroupCode(String productGroupCode);
    List<ChannelProductDomain> findChannelProduct(ShiroUser shiroUser);
}
