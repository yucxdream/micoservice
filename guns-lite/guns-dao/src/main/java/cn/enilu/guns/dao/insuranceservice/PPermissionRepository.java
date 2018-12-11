package cn.enilu.guns.dao.insuranceservice;

import cn.enilu.guns.bean.entity.user.PPermission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhaoxinguo on 2017/9/13.
 */
@Repository
public interface PPermissionRepository extends BaseRepository<PPermission, Long> {

    @Query(value = "select * from p_permission where id in (:ids)", nativeQuery = true)
    List<PPermission> findPermissionInIds(@Param("ids") List<Integer> ids);

}
