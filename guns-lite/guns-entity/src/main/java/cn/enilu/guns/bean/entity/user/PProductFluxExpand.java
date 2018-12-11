package cn.enilu.guns.bean.entity.user;

import javax.persistence.*;

@Entity
@Table(name = "p_product_flux_expand", schema = "insure_service_sit", catalog = "")
public class PProductFluxExpand {
    private int fluxExpandId;
    private String bpId;
    private String countyName;
    private Integer useDay;
    private String operator;

    @Id
    @Column(name = "FLUX_EXPAND_ID")
    public int getFluxExpandId() {
        return fluxExpandId;
    }

    public void setFluxExpandId(int fluxExpandId) {
        this.fluxExpandId = fluxExpandId;
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
    @Column(name = "COUNTY_NAME")
    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    @Basic
    @Column(name = "USE_DAY")
    public Integer getUseDay() {
        return useDay;
    }

    public void setUseDay(Integer useDay) {
        this.useDay = useDay;
    }

    @Basic
    @Column(name = "OPERATOR")
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PProductFluxExpand that = (PProductFluxExpand) o;

        if (fluxExpandId != that.fluxExpandId) return false;
        if (bpId != null ? !bpId.equals(that.bpId) : that.bpId != null) return false;
        if (countyName != null ? !countyName.equals(that.countyName) : that.countyName != null) return false;
        if (useDay != null ? !useDay.equals(that.useDay) : that.useDay != null) return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fluxExpandId;
        result = 31 * result + (bpId != null ? bpId.hashCode() : 0);
        result = 31 * result + (countyName != null ? countyName.hashCode() : 0);
        result = 31 * result + (useDay != null ? useDay.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        return result;
    }
}
