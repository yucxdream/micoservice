package cn.enilu.guns.dao.insuranceservice;

import cn.enilu.guns.bean.entity.user.OrgUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author zhaoxinguo on 2017/9/13.
 */
@Repository
public interface OrgUserRepository extends BaseRepository<OrgUser, Long> {

    @Query
    OrgUser findByUserAccount(String userAccount);

}
