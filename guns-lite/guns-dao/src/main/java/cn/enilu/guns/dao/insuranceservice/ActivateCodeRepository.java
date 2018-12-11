package cn.enilu.guns.dao.insuranceservice;

import cn.enilu.guns.bean.entity.user.ActivateCode;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * @author zhaoxinguo on 2017/9/13.
 */
@Repository
public interface ActivateCodeRepository extends BaseRepository<ActivateCode, String> {
    @Query
    ActivateCode findActivateCodeByActivateCode(String activateCode);

    //Integer balanceStatus, Date startTime, Date endTime, Integer used, Integer beforeBalanceStatus, String orgCode, String cpId WHERE createTime between ?2 and ?3 and used = ?4 and balanceStatus = ?5 and orgCode = ?6 and cpId = ?7
    @Modifying
    @Transactional()
    @Query("UPDATE ActivateCode set balanceStatus = ?7, balanceSerial = ?8 where used = ?6 and createTime between ?1 and ?2 and balanceStatus = ?3 and orgCode = ?4 and cpId = ?5")
    int updateActionCode(Date startTime, Date endTime, Integer balanceStatus, String orgCode, String cpId, Integer used, Integer currentBalanceStatus, String balanceSerial);

//    @Query(value = "SELECT * FROM activate_code where used = ?6 and createTime between ?1 and ?2 and balanceStatus = ?3 and orgCode = ?4 and cpId = ?5",nativeQuery = true)
//    List<ActivateCode> findActivateByBalanceStatus(Date startTime, Date endTime, Integer balanceStatus, String orgCode, String cpId, Integer used);

    @Query
    List<ActivateCode> findByCreateTimeBetweenAndBalanceStatusAndOrgCodeAndCpIdAndUsed(Date startTime, Date endTime, Integer balanceStatus, String orgCode, String cpId, Integer used);

    @Modifying
    @Query("UPDATE ActivateCode set balanceStatus = ?1 where balanceSerial = ?2")
    int updateActionCodeBalanceStatusByBalanceSerial(Integer balanceStatus, String balanceSerial);
}
