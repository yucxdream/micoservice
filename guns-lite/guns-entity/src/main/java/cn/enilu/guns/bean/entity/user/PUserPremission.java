package cn.enilu.guns.bean.entity.user;

import javax.persistence.*;

/**
 * Created by sunlm on 2018/11/13.
 */
@Entity
@Table(name = "p_user_premission", schema = "insure_service_sit" )
public class PUserPremission {
    private Integer pid;
    private Integer permissionCode;
    private String userAccount;

    @Id
    @GeneratedValue
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "PERMISSION_CODE", nullable = true, precision = 0)
    public Integer getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(Integer permissionCode) {
        this.permissionCode = permissionCode;
    }

    @Basic
    @Column(name = "USER_ACCOUNT", nullable = true, length = 20)
    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PUserPremission that = (PUserPremission) o;

        if (permissionCode != null ? !permissionCode.equals(that.permissionCode) : that.permissionCode != null)
            return false;
        if (userAccount != null ? !userAccount.equals(that.userAccount) : that.userAccount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = permissionCode != null ? permissionCode.hashCode() : 0;
        result = 31 * result + (userAccount != null ? userAccount.hashCode() : 0);
        return result;
    }
}
