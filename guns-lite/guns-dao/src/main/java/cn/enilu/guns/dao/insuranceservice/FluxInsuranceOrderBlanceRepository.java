package cn.enilu.guns.dao.insuranceservice;

import cn.enilu.guns.bean.entity.user.FluxInsuranceOrderBalance;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

/**
 * @author zhaoxinguo on 2017/9/13.
 */
@Repository
public interface FluxInsuranceOrderBlanceRepository extends BaseRepository<FluxInsuranceOrderBalance, Long> {
    @Modifying
    @Transactional(rollbackOn = Exception.class)
    @Query(value = "update FluxInsuranceOrderBalance set balanceSerial = ?1 where bid = ?2")
    void updateFluxInsuranceOrderBalanceByBalanceSerial(String balanceSerial, Integer bid);

    @Modifying
    @Query(value = "update FluxInsuranceOrderBalance set balanceStatus = ?1 where balanceSerial = ?2 and balanceStatus = ?3")
    int updateFluxInsuranceOrderBalanceByBalanceSerial(Integer balanceStatus, String balanceSerial, Integer beforeBalanceStatus);
}
