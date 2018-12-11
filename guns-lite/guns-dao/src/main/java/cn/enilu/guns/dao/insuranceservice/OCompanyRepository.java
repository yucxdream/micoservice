package cn.enilu.guns.dao.insuranceservice;

import cn.enilu.guns.bean.entity.user.OCompany;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhaoxinguo on 2017/9/13.
 */
@Repository
public interface OCompanyRepository extends BaseRepository<OCompany, String> {

    @Query
    OCompany findBycpId(String cpId);
//    @Query("select new com.visionet.domain.userdomain.CompanyDomain(oc.cpId, oc.name) from OCompany oc")
//    List<CompanyDomain> findOCompanyAndOrganzation();

}
