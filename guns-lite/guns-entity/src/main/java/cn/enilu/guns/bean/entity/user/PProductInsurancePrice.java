package cn.enilu.guns.bean.entity.user;

import javax.persistence.*;

@Entity
@Table(name = "p_product_insurance_price", schema = "insure_service_sit")
public class PProductInsurancePrice {
    private int tippId;
    private String productId;
    private Integer ipSort;
    private Integer dayStart;
    private Integer dayEnd;
    private Float price;

    @Id
    @Column(name = "TIPP_ID")
    public int getTippId() {
        return tippId;
    }

    public void setTippId(int tippId) {
        this.tippId = tippId;
    }

    @Basic
    @Column(name = "PRODUCT_ID")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "IP_SORT")
    public Integer getIpSort() {
        return ipSort;
    }

    public void setIpSort(Integer ipSort) {
        this.ipSort = ipSort;
    }

    @Basic
    @Column(name = "DAY_START")
    public Integer getDayStart() {
        return dayStart;
    }

    public void setDayStart(Integer dayStart) {
        this.dayStart = dayStart;
    }

    @Basic
    @Column(name = "DAY_END")
    public Integer getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(Integer dayEnd) {
        this.dayEnd = dayEnd;
    }

    @Basic
    @Column(name = "PRICE")
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PProductInsurancePrice that = (PProductInsurancePrice) o;

        if (tippId != that.tippId) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (ipSort != null ? !ipSort.equals(that.ipSort) : that.ipSort != null) return false;
        if (dayStart != null ? !dayStart.equals(that.dayStart) : that.dayStart != null) return false;
        if (dayEnd != null ? !dayEnd.equals(that.dayEnd) : that.dayEnd != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tippId;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (ipSort != null ? ipSort.hashCode() : 0);
        result = 31 * result + (dayStart != null ? dayStart.hashCode() : 0);
        result = 31 * result + (dayEnd != null ? dayEnd.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
