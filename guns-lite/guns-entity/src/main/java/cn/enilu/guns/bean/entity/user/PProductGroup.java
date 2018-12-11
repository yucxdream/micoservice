package cn.enilu.guns.bean.entity.user;

import javax.persistence.*;

@Entity
@Table(name = "p_product_group", schema = "insure_service_sit", catalog = "")
public class PProductGroup {
    private int id;
    private String productGroupCode;
    private String name;
    private String bpId;
    private String remark;
    private Integer type;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PRODUCT_GROUP_CODE")
    public String getProductGroupCode() {
        return productGroupCode;
    }

    public void setProductGroupCode(String productGroupCode) {
        this.productGroupCode = productGroupCode;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "REMARK")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "TYPE")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PProductGroup that = (PProductGroup) o;

        if (id != that.id) return false;
        if (productGroupCode != null ? !productGroupCode.equals(that.productGroupCode) : that.productGroupCode != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (bpId != null ? !bpId.equals(that.bpId) : that.bpId != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (productGroupCode != null ? productGroupCode.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (bpId != null ? bpId.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
