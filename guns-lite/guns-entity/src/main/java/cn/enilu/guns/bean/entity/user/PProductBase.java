package cn.enilu.guns.bean.entity.user;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "p_product_base", schema = "insure_service_sit", catalog = "")
public class PProductBase {
    private String bpId;
    private String ptCode;
    private String sCode;
    private String sName;
    private String name;
    private String insurePath;
    private String viewPath;
    private String cpId;
    private Integer pOrder;
    private String ntext;
    private String listImg;
    private String titleImg;
    private String introduceImg;
    private Timestamp createTime;
    private Timestamp updateTime;
    private BigDecimal price;
    private BigDecimal sellPrice;
    private BigDecimal maxCommissionRate;
    private String b2BiAccount;
    private String b2BiPwd;
    private BigInteger isDisplay;
    private String branch;
    private String subbranch;
    private BigInteger productType;
    private BigInteger derivedProduct;

    @Id
    @Column(name = "BP_ID")
    public String getBpId() {
        return bpId;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

    @Basic
    @Column(name = "PT_CODE")
    public String getPtCode() {
        return ptCode;
    }

    public void setPtCode(String ptCode) {
        this.ptCode = ptCode;
    }

    @Basic
    @Column(name = "S_CODE")
    public String getsCode() {
        return sCode;
    }

    public void setsCode(String sCode) {
        this.sCode = sCode;
    }

    @Basic
    @Column(name = "S_NAME")
    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
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
    @Column(name = "INSURE_PATH")
    public String getInsurePath() {
        return insurePath;
    }

    public void setInsurePath(String insurePath) {
        this.insurePath = insurePath;
    }

    @Basic
    @Column(name = "VIEW_PATH")
    public String getViewPath() {
        return viewPath;
    }

    public void setViewPath(String viewPath) {
        this.viewPath = viewPath;
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
    @Column(name = "P_ORDER")
    public Integer getpOrder() {
        return pOrder;
    }

    public void setpOrder(Integer pOrder) {
        this.pOrder = pOrder;
    }

    @Basic
    @Column(name = "NTEXT")
    public String getNtext() {
        return ntext;
    }

    public void setNtext(String ntext) {
        this.ntext = ntext;
    }

    @Basic
    @Column(name = "LIST_IMG")
    public String getListImg() {
        return listImg;
    }

    public void setListImg(String listImg) {
        this.listImg = listImg;
    }

    @Basic
    @Column(name = "TITLE_IMG")
    public String getTitleImg() {
        return titleImg;
    }

    public void setTitleImg(String titleImg) {
        this.titleImg = titleImg;
    }

    @Basic
    @Column(name = "INTRODUCE_IMG")
    public String getIntroduceImg() {
        return introduceImg;
    }

    public void setIntroduceImg(String introduceImg) {
        this.introduceImg = introduceImg;
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
    @Column(name = "UPDATE_TIME")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "SELL_PRICE")
    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    @Basic
    @Column(name = "MAX_COMMISSION_RATE")
    public BigDecimal getMaxCommissionRate() {
        return maxCommissionRate;
    }

    public void setMaxCommissionRate(BigDecimal maxCommissionRate) {
        this.maxCommissionRate = maxCommissionRate;
    }

    @Basic
    @Column(name = "B2BI_ACCOUNT")
    public String getB2BiAccount() {
        return b2BiAccount;
    }

    public void setB2BiAccount(String b2BiAccount) {
        this.b2BiAccount = b2BiAccount;
    }

    @Basic
    @Column(name = "B2BI_PWD")
    public String getB2BiPwd() {
        return b2BiPwd;
    }

    public void setB2BiPwd(String b2BiPwd) {
        this.b2BiPwd = b2BiPwd;
    }

    @Basic
    @Column(name = "IS_DISPLAY")
    public BigInteger getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(BigInteger isDisplay) {
        this.isDisplay = isDisplay;
    }

    @Basic
    @Column(name = "BRANCH")
    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Basic
    @Column(name = "SUBBRANCH")
    public String getSubbranch() {
        return subbranch;
    }

    public void setSubbranch(String subbranch) {
        this.subbranch = subbranch;
    }

    @Basic
    @Column(name = "PRODUCT_TYPE")
    public BigInteger getProductType() {
        return productType;
    }

    public void setProductType(BigInteger productType) {
        this.productType = productType;
    }

    @Basic
    @Column(name = "DERIVED_PRODUCT")
    public BigInteger getDerivedProduct() {
        return derivedProduct;
    }

    public void setDerivedProduct(BigInteger derivedProduct) {
        this.derivedProduct = derivedProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PProductBase that = (PProductBase) o;

        if (bpId != null ? !bpId.equals(that.bpId) : that.bpId != null) return false;
        if (ptCode != null ? !ptCode.equals(that.ptCode) : that.ptCode != null) return false;
        if (sCode != null ? !sCode.equals(that.sCode) : that.sCode != null) return false;
        if (sName != null ? !sName.equals(that.sName) : that.sName != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (insurePath != null ? !insurePath.equals(that.insurePath) : that.insurePath != null) return false;
        if (viewPath != null ? !viewPath.equals(that.viewPath) : that.viewPath != null) return false;
        if (cpId != null ? !cpId.equals(that.cpId) : that.cpId != null) return false;
        if (pOrder != null ? !pOrder.equals(that.pOrder) : that.pOrder != null) return false;
        if (ntext != null ? !ntext.equals(that.ntext) : that.ntext != null) return false;
        if (listImg != null ? !listImg.equals(that.listImg) : that.listImg != null) return false;
        if (titleImg != null ? !titleImg.equals(that.titleImg) : that.titleImg != null) return false;
        if (introduceImg != null ? !introduceImg.equals(that.introduceImg) : that.introduceImg != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (sellPrice != null ? !sellPrice.equals(that.sellPrice) : that.sellPrice != null) return false;
        if (maxCommissionRate != null ? !maxCommissionRate.equals(that.maxCommissionRate) : that.maxCommissionRate != null)
            return false;
        if (b2BiAccount != null ? !b2BiAccount.equals(that.b2BiAccount) : that.b2BiAccount != null) return false;
        if (b2BiPwd != null ? !b2BiPwd.equals(that.b2BiPwd) : that.b2BiPwd != null) return false;
        if (isDisplay != null ? !isDisplay.equals(that.isDisplay) : that.isDisplay != null) return false;
        if (branch != null ? !branch.equals(that.branch) : that.branch != null) return false;
        if (subbranch != null ? !subbranch.equals(that.subbranch) : that.subbranch != null) return false;
        if (productType != null ? !productType.equals(that.productType) : that.productType != null) return false;
        if (derivedProduct != null ? !derivedProduct.equals(that.derivedProduct) : that.derivedProduct != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bpId != null ? bpId.hashCode() : 0;
        result = 31 * result + (ptCode != null ? ptCode.hashCode() : 0);
        result = 31 * result + (sCode != null ? sCode.hashCode() : 0);
        result = 31 * result + (sName != null ? sName.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (insurePath != null ? insurePath.hashCode() : 0);
        result = 31 * result + (viewPath != null ? viewPath.hashCode() : 0);
        result = 31 * result + (cpId != null ? cpId.hashCode() : 0);
        result = 31 * result + (pOrder != null ? pOrder.hashCode() : 0);
        result = 31 * result + (ntext != null ? ntext.hashCode() : 0);
        result = 31 * result + (listImg != null ? listImg.hashCode() : 0);
        result = 31 * result + (titleImg != null ? titleImg.hashCode() : 0);
        result = 31 * result + (introduceImg != null ? introduceImg.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (sellPrice != null ? sellPrice.hashCode() : 0);
        result = 31 * result + (maxCommissionRate != null ? maxCommissionRate.hashCode() : 0);
        result = 31 * result + (b2BiAccount != null ? b2BiAccount.hashCode() : 0);
        result = 31 * result + (b2BiPwd != null ? b2BiPwd.hashCode() : 0);
        result = 31 * result + (isDisplay != null ? isDisplay.hashCode() : 0);
        result = 31 * result + (branch != null ? branch.hashCode() : 0);
        result = 31 * result + (subbranch != null ? subbranch.hashCode() : 0);
        result = 31 * result + (productType != null ? productType.hashCode() : 0);
        result = 31 * result + (derivedProduct != null ? derivedProduct.hashCode() : 0);
        return result;
    }
}
