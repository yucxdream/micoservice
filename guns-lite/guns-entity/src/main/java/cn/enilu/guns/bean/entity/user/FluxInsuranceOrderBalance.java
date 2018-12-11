package cn.enilu.guns.bean.entity.user;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "flux_insurance_order_balance", schema = "insure_service_sit")
public class FluxInsuranceOrderBalance {
    private int bid;
    private String balanceSerial;
    private Float price;
    private Timestamp startTime;
    private Timestamp endTime;
    private Integer balanceStatus;
    private Integer activateSum;
    private Timestamp balanceTime;
    private String cpId;
    private String orgCode;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid")
    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    @Basic
    @Column(name = "balance_serial")
    public String getBalanceSerial() {
        return balanceSerial;
    }

    public void setBalanceSerial(String balanceSerial) {
        this.balanceSerial = balanceSerial;
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
    @Column(name = "balance_status")
    public Integer getBalanceStatus() {
        return balanceStatus;
    }

    public void setBalanceStatus(Integer balanceStatus) {
        this.balanceStatus = balanceStatus;
    }

    @Basic
    @Column(name = "activate_sum")
    public Integer getActivateSum() {
        return activateSum;
    }

    @Basic
    @Column(name = "balance_time")
    public Timestamp getBalanceTime() {
        return balanceTime;
    }

    public void setBalanceTime(Timestamp balanceTime) {
        this.balanceTime = balanceTime;
    }

    public void setActivateSum(Integer activateSum) {
        this.activateSum = activateSum;
    }

    @Basic
    @Column(name = "cp_id")
    public String getCpId() {
        return cpId;
    }

    public void setCpId(String cpId) {
        this.cpId = cpId;
    }

    @Basic
    @Column(name = "org_code")
    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FluxInsuranceOrderBalance that = (FluxInsuranceOrderBalance) o;

        if (bid != that.bid) return false;
        if (balanceSerial != null ? !balanceSerial.equals(that.balanceSerial) : that.balanceSerial != null)
            return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (balanceStatus != null ? !balanceStatus.equals(that.balanceStatus) : that.balanceStatus != null)
            return false;
        if (activateSum != null ? !activateSum.equals(that.activateSum) : that.activateSum != null) return false;
        if (balanceTime != null ? !balanceTime.equals(that.balanceTime) : that.balanceTime != null) return false;
        if (cpId != null ? !cpId.equals(that.cpId) : that.cpId != null) return false;
        return orgCode != null ? orgCode.equals(that.orgCode) : that.orgCode == null;
    }

    @Override
    public int hashCode() {
        int result = bid;
        result = 31 * result + (balanceSerial != null ? balanceSerial.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (balanceStatus != null ? balanceStatus.hashCode() : 0);
        result = 31 * result + (activateSum != null ? activateSum.hashCode() : 0);
        result = 31 * result + (balanceTime != null ? balanceTime.hashCode() : 0);
        result = 31 * result + (cpId != null ? cpId.hashCode() : 0);
        result = 31 * result + (orgCode != null ? orgCode.hashCode() : 0);
        return result;
    }
}
