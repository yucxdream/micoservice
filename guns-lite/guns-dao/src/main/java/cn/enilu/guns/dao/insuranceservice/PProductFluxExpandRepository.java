package cn.enilu.guns.dao.insuranceservice;

import cn.enilu.guns.bean.entity.user.PProductFluxExpand;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author zhaoxinguo on 2017/9/13.
 */
@Repository
public interface PProductFluxExpandRepository extends BaseRepository<PProductFluxExpand, Integer> {
    @Query
    PProductFluxExpand findPProductFluxExpandBybpId(String bpId);
}
