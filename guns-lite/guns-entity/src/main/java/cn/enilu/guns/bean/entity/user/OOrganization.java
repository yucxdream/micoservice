package cn.enilu.guns.bean.entity.user;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by sunlm on 2018/11/13.
 */
@Entity
@Table(name = "o_organization", schema = "insure_service_sit" )
public class OOrganization {
    private String orgCode;
    private String cpId;
    private String orgName;
    private String orgNode;
    private String remark;
    private Timestamp createTime;
    private Timestamp updateTime;
    private BigInteger type;

    public OOrganization() {
    }

    public OOrganization(String orgCode, String cpId, String orgName, String orgNode, String remark, Timestamp createTime, Timestamp updateTime, BigInteger type) {
        this.orgCode = orgCode;
        this.cpId = cpId;
        this.orgName = orgName;
        this.orgNode = orgNode;
        this.remark = remark;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.type = type;
    }

    @Id
    @Column(name = "ORG_CODE", nullable = false, length = 50)
    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    @Basic
    @Column(name = "CP_ID", nullable = false, length = 20)
    public String getCpId() {
        return cpId;
    }

    public void setCpId(String cpId) {
        this.cpId = cpId;
    }

    @Basic
    @Column(name = "ORG_NAME", nullable = true, length = 200)
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Basic
    @Column(name = "ORG_NODE", nullable = true, length = 200)
    public String getOrgNode() {
        return orgNode;
    }

    public void setOrgNode(String orgNode) {
        this.orgNode = orgNode;
    }

    @Basic
    @Column(name = "REMARK", nullable = true, length = 200)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "CREATE_TIME", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "UPDATE_TIME", nullable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
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

        OOrganization that = (OOrganization) o;

        if (orgCode != null ? !orgCode.equals(that.orgCode) : that.orgCode != null) return false;
        if (cpId != null ? !cpId.equals(that.cpId) : that.cpId != null) return false;
        if (orgName != null ? !orgName.equals(that.orgName) : that.orgName != null) return false;
        if (orgNode != null ? !orgNode.equals(that.orgNode) : that.orgNode != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orgCode != null ? orgCode.hashCode() : 0;
        result = 31 * result + (cpId != null ? cpId.hashCode() : 0);
        result = 31 * result + (orgName != null ? orgName.hashCode() : 0);
        result = 31 * result + (orgNode != null ? orgNode.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
