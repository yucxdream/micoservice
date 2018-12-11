package cn.enilu.guns.dao.insuranceservice;

import cn.enilu.guns.bean.entity.user.OOrganization;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhaoxinguo on 2017/9/13.
 */
@Repository
public interface OOrganizationRepository extends BaseRepository<OOrganization, String> {

    @Query
    OOrganization findByOrgCode(String orgCode);

    @Query
    List<OOrganization> findByCpId(String cpId);

}
