package cn.enilu.guns.bean.entity.user;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "or_order_insurance_expand", schema = "insure_service_sit", catalog = "")
public class OrOrderInsuranceExpand {
    private int oiid;
    private String bpId;
    private String policyNo;
    private Timestamp startTime;
    private Timestamp endTime;
    private String pName;
    private String insuranceName;
    private String insuranceId;
    private String insurancePhone;
    private Integer relation;
    private Float price;
    private Integer status;
    private String reason;
    private Integer serialNumber;

    @Basic
    @Column(name = "bp_id")
    public String getBpId() {
        return bpId;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

    @Id
    @Column(name = "oiid")
    public int getOiid() {
        return oiid;
    }

    public void setOiid(int oiid) {
        this.oiid = oiid;
    }

    @Basic
    @Column(name = "policy_no")
    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    @Basic
    @Column(name = "start_time")
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time")
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "p_name")
    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    @Basic
    @Column(name = "insurance_name")
    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    @Basic
    @Column(name = "insurance_id")
    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    @Basic
    @Column(name = "insurance_phone")
    public String getInsurancePhone() {
        return insurancePhone;
    }

    public void setInsurancePhone(String insurancePhone) {
        this.insurancePhone = insurancePhone;
    }

    @Basic
    @Column(name = "relation")
    public Integer getRelation() {
        return relation;
    }

    public void setRelation(Integer relation) {
        this.relation = relation;
    }

    @Basic
    @Column(name = "price")
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "reason")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrOrderInsuranceExpand that = (OrOrderInsuranceExpand) o;

        if (oiid != that.oiid) return false;
        if (bpId != null ? !bpId.equals(that.bpId) : that.bpId != null) return false;
        if (policyNo != null ? !policyNo.equals(that.policyNo) : that.policyNo != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (pName != null ? !pName.equals(that.pName) : that.pName != null) return false;
        if (insuranceName != null ? !insuranceName.equals(that.insuranceName) : that.insuranceName != null)
            return false;
        if (insuranceId != null ? !insuranceId.equals(that.insuranceId) : that.insuranceId != null) return false;
        if (insurancePhone != null ? !insurancePhone.equals(that.insurancePhone) : that.insurancePhone != null)
            return false;
        if (relation != null ? !relation.equals(that.relation) : that.relation != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = oiid;
        result = 31 * result + (bpId != null ? bpId.hashCode() : 0);
        result = 31 * result + (policyNo != null ? policyNo.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (pName != null ? pName.hashCode() : 0);
        result = 31 * result + (insuranceName != null ? insuranceName.hashCode() : 0);
        result = 31 * result + (insuranceId != null ? insuranceId.hashCode() : 0);
        result = 31 * result + (insurancePhone != null ? insurancePhone.hashCode() : 0);
        result = 31 * result + (relation != null ? relation.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "serial_number")
    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }
}
