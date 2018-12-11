package cn.enilu.guns.dao.insuranceservice;

import cn.enilu.guns.bean.entity.user.PUserPremission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhaoxinguo on 2017/9/13.
 */
@Repository
public interface PUserPremissionRepository extends BaseRepository<PUserPremission, Long> {

    @Query
    List<PUserPremission> findByUserAccount(String userAccount);

}
