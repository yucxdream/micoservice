package cn.enilu.guns.dao.insuranceservice;

import cn.enilu.guns.bean.entity.user.OrOrderFluxExpand;
import cn.enilu.guns.bean.entity.user.OrOrderInsuranceExpand;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author zhaoxinguo on 2017/9/13.
 */
@Repository
public interface OrOrderInsuranceExpandRepository extends BaseRepository<OrOrderInsuranceExpand, Integer> {
    @Query
    OrOrderFluxExpand findOrOrderInsuranceExpandBySerialNumber(Integer serialNumber);
}
