package cn.enilu.guns.bean.entity.user;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by sunlm on 2018/11/13.
 */
@Entity
@Table(name = "p_permission", schema = "insure_service_sit" )
public class PPermission {
    private Integer id;
    private String premissionName;
    private String premissionDesc;
    private String premissionUrl;
    private Integer parentId;
    private String premissionIcon;
    private Integer deleteFlag;
    private Integer orderDisplay;
    private BigInteger type;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PREMISSION_NAME", nullable = true, length = 200)
    public String getPremissionName() {
        return premissionName;
    }

    public void setPremissionName(String premissionName) {
        this.premissionName = premissionName;
    }

    @Basic
    @Column(name = "PREMISSION_DESC", nullable = true, length = 200)
    public String getPremissionDesc() {
        return premissionDesc;
    }

    public void setPremissionDesc(String premissionDesc) {
        this.premissionDesc = premissionDesc;
    }

    @Basic
    @Column(name = "PREMISSION_URL", nullable = true, length = 200)
    public String getPremissionUrl() {
        return premissionUrl;
    }

    public void setPremissionUrl(String premissionUrl) {
        this.premissionUrl = premissionUrl;
    }

    @Basic
    @Column(name = "PARENT_ID", nullable = true, precision = 0)
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "PREMISSION_ICON", nullable = true, length = 200)
    public String getPremissionIcon() {
        return premissionIcon;
    }

    public void setPremissionIcon(String premissionIcon) {
        this.premissionIcon = premissionIcon;
    }

    @Basic
    @Column(name = "DELETE_FLAG", nullable = true, precision = 0)
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Basic
    @Column(name = "ORDER_DISPLAY", nullable = true, precision = 0)
    public Integer getOrderDisplay() {
        return orderDisplay;
    }

    public void setOrderDisplay(Integer orderDisplay) {
        this.orderDisplay = orderDisplay;
    }

    @Basic
    @Column(name = "TYPE", nullable = true, precision = 0)
    public BigInteger getType() {
        return type;
    }

    public void setType(BigInteger type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PPermission that = (PPermission) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (premissionName != null ? !premissionName.equals(that.premissionName) : that.premissionName != null)
            return false;
        if (premissionDesc != null ? !premissionDesc.equals(that.premissionDesc) : that.premissionDesc != null)
            return false;
        if (premissionUrl != null ? !premissionUrl.equals(that.premissionUrl) : that.premissionUrl != null)
            return false;
        if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null) return false;
        if (premissionIcon != null ? !premissionIcon.equals(that.premissionIcon) : that.premissionIcon != null)
            return false;
        if (deleteFlag != null ? !deleteFlag.equals(that.deleteFlag) : that.deleteFlag != null) return false;
        if (orderDisplay != null ? !orderDisplay.equals(that.orderDisplay) : that.orderDisplay != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (premissionName != null ? premissionName.hashCode() : 0);
        result = 31 * result + (premissionDesc != null ? premissionDesc.hashCode() : 0);
        result = 31 * result + (premissionUrl != null ? premissionUrl.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (premissionIcon != null ? premissionIcon.hashCode() : 0);
        result = 31 * result + (deleteFlag != null ? deleteFlag.hashCode() : 0);
        result = 31 * result + (orderDisplay != null ? orderDisplay.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
