package cn.enilu.guns.bean.entity.user;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "activate_code", schema = "insure_service_sit")
public class ActivateCode {
    private String activateCode;
    private String scCode;
    private String bpId;
    private Integer used;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;
    private Integer disabled;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp useTime;
    private Integer balanceStatus;
    private String cpId;
    private String orgCode;
    private String balanceSerial;
    private String name;

    @Transient
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "ACTIVATE_CODE")
    public String getActivateCode() {
        return activateCode;
    }

    public void setActivateCode(String activateCode) {
        this.activateCode = activateCode;
    }

    @Basic
    @Column(name = "SC_CODE")
    public String getScCode() {
        return scCode;
    }

    public void setScCode(String scCode) {
        this.scCode = scCode;
    }

    @Basic
    @Column(name = "BP_ID")
    public String getBpId() {
        return bpId;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

    @Basic
    @Column(name = "\"USED\"")
    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    @Basic
    @Column(name = "CREATE_TIME")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "DISABLED")
    public Integer getDisabled() {
        return disabled;
    }

    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }

    @Basic
    @Column(name = "USE_TIME")
    public Timestamp getUseTime() {
        return useTime;
    }

    public void setUseTime(Timestamp useTime) {
        this.useTime = useTime;
    }

    @Basic
    @Column(name = "BALANCE_STATUS")
    public Integer getBalanceStatus() {
        return balanceStatus;
    }

    public void setBalanceStatus(Integer balanceStatus) {
        this.balanceStatus = balanceStatus;
    }


    @Basic
    @Column(name = "CP_ID")
    public String getCpId() {
        return cpId;
    }

    public void setCpId(String cpId) {
        this.cpId = cpId;
    }

    @Basic
    @Column(name = "ORG_CODE")
    public String getOrgCode() {
        return orgCode;
    }

    @Basic
    @Column(name = "balance_serial")
    public String getBalanceSerial() {
        return balanceSerial;
    }

    public void setBalanceSerial(String balanceSerial) {
        this.balanceSerial = balanceSerial;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivateCode that = (ActivateCode) o;

        if (activateCode != null ? !activateCode.equals(that.activateCode) : that.activateCode != null) return false;
        if (scCode != null ? !scCode.equals(that.scCode) : that.scCode != null) return false;
        if (bpId != null ? !bpId.equals(that.bpId) : that.bpId != null) return false;
        if (used != null ? !used.equals(that.used) : that.used != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (disabled != null ? !disabled.equals(that.disabled) : that.disabled != null) return false;
        if (useTime != null ? !useTime.equals(that.useTime) : that.useTime != null) return false;
        if (balanceStatus != null ? !balanceStatus.equals(that.balanceStatus) : that.balanceStatus != null)
            return false;
        if (cpId != null ? !cpId.equals(that.cpId) : that.cpId != null) return false;
        if (orgCode != null ? !orgCode.equals(that.orgCode) : that.orgCode != null) return false;
        return balanceSerial != null ? balanceSerial.equals(that.balanceSerial) : that.balanceSerial == null;
    }

    @Override
    public int hashCode() {
        int result = activateCode != null ? activateCode.hashCode() : 0;
        result = 31 * result + (scCode != null ? scCode.hashCode() : 0);
        result = 31 * result + (bpId != null ? bpId.hashCode() : 0);
        result = 31 * result + (used != null ? used.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (disabled != null ? disabled.hashCode() : 0);
        result = 31 * result + (useTime != null ? useTime.hashCode() : 0);
        result = 31 * result + (balanceStatus != null ? balanceStatus.hashCode() : 0);
        result = 31 * result + (cpId != null ? cpId.hashCode() : 0);
        result = 31 * result + (orgCode != null ? orgCode.hashCode() : 0);
        result = 31 * result + (balanceSerial != null ? balanceSerial.hashCode() : 0);
        return result;
    }
}
