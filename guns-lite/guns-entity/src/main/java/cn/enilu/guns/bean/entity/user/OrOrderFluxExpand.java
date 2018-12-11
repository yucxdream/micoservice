package cn.enilu.guns.bean.entity.user;

import javax.persistence.*;

@Entity
@Table(name = "or_order_flux_expand", schema = "insure_service_sit", catalog = "")
public class OrOrderFluxExpand {
    private Integer orderFluxId;
    private String activateCode;
    private String userName;
    private String addressDetail;
    private String provice;
    private String city;
    private String area;
    private Integer serialNumber;

    public void setOrderFluxId(int orderFluxId) {
        this.orderFluxId = orderFluxId;
    }

    @Id
    @GeneratedValue
    @Column(name = "ORDER_FLUX_ID")
    public Integer getOrderFluxId() {
        return orderFluxId;
    }

    public void setOrderFluxId(Integer orderFluxId) {
        this.orderFluxId = orderFluxId;
    }

    @Basic
    @Column(name = "ACTIVATE_CODE")
    public String getActivateCode() {
        return activateCode;
    }

    public void setActivateCode(String activateCode) {
        this.activateCode = activateCode;
    }

    @Basic
    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "ADDRESS_DETAIL")
    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    @Basic
    @Column(name = "PROVICE")
    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }

    @Basic
    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "AREA")
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrOrderFluxExpand that = (OrOrderFluxExpand) o;

        if (orderFluxId != that.orderFluxId) return false;
        if (activateCode != null ? !activateCode.equals(that.activateCode) : that.activateCode != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (addressDetail != null ? !addressDetail.equals(that.addressDetail) : that.addressDetail != null)
            return false;
        if (provice != null ? !provice.equals(that.provice) : that.provice != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (area != null ? !area.equals(that.area) : that.area != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderFluxId != null ? orderFluxId.hashCode() : 0;
        result = 31 * result + (activateCode != null ? activateCode.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (addressDetail != null ? addressDetail.hashCode() : 0);
        result = 31 * result + (provice != null ? provice.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (area != null ? area.hashCode() : 0);
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
