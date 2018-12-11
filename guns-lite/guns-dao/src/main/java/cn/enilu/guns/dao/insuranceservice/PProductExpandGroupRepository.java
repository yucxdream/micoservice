package cn.enilu.guns.dao.insuranceservice;

import cn.enilu.guns.bean.entity.user.PProductExpandGroup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhaoxinguo on 2017/9/13.
 */
@Repository
public interface PProductExpandGroupRepository extends BaseRepository<PProductExpandGroup, Integer> {
    @Query
    List<PProductExpandGroup> findPProductExpandGroupsByMasterPid(String masterPid);
}
