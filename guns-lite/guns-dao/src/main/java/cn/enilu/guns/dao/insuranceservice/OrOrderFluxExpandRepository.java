package cn.enilu.guns.dao.insuranceservice;

import cn.enilu.guns.bean.entity.user.OrOrderFluxExpand;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author zhaoxinguo on 2017/9/13.
 */
@Repository
public interface OrOrderFluxExpandRepository extends BaseRepository<OrOrderFluxExpand, Integer> {
    @Query
    OrOrderFluxExpand findOrOrderFluxExpandByOrderFluxId(String orderFluxId);
}
