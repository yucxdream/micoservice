package cn.enilu.guns.dao.insuranceservice;

import cn.enilu.guns.bean.entity.user.OrOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author zhaoxinguo on 2017/9/13.
 */
@Repository
public interface OrOrderRepository extends BaseRepository<OrOrder, Integer> {
    @Query
    OrOrder findOrOrderBySerialNumber(Integer serialNumber);

    @Query(value = "SELECT" +
            " * " +
            " FROM " +
            " or_order " +
            " WHERE " +
            "SERIAL_NUMBER IN ( SELECT SERIAL_NUMBER FROM or_order_flux_expand WHERE activate_code IN ( SELECT activate_code FROM activate_code WHERE create_time BETWEEN ?1 AND ?2 AND used = ?3 AND balance_status = ?4 AND CP_ID = ?5 AND ORG_CODE = ?6 ) )", nativeQuery = true)
    List<OrOrder> findByStartTimeAndEndTimeInActivateCode(Date startTime, Date endTime, Integer used, Integer balanceStatus, String cpId, String orgCode);

    @Query(value = "select sum(price) from or_order where SERIAL_NUMBER in (select SERIAL_NUMBER from or_order_flux_expand where activate_code in (?1))", nativeQuery = true)
    Double findOrderPriceByActivate(String [] activateCodes);
}
