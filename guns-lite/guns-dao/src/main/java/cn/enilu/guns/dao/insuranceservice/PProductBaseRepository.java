package cn.enilu.guns.dao.insuranceservice;

import cn.enilu.guns.bean.entity.user.PProductBase;
import cn.enilu.guns.bean.entity.user.PProductGroup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhaoxinguo on 2017/9/13.
 */
@Repository
public interface PProductBaseRepository extends BaseRepository<PProductBase, String> {
    @Query
    PProductBase findPProductBaseByBpId(String bpId);

    @Query(value = "select * from p_product_base where bp_id in (select BP_ID from p_product_sell_channel where CP_ID = ?1 and ORG_CODE = ?2) and PRODUCT_TYPE = 1",nativeQuery = true)
    List<PProductBase> findProductBaseGroupByCpIdAndOrgCode(String cpId, String orgCode);

    @Query(value = "SELECT * from p_product_base where BP_ID in (select BP_ID from p_product_group where PRODUCT_GROUP_CODE = ?1)", nativeQuery = true)
    List<PProductBase> findProductBaseByProductGroupCode(String productGroupCode);
}
