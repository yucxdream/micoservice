package cn.enilu.guns.bean.entity.user;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by sunlm on 2018/11/13.
 */
@Entity
@Table(name = "o_company", schema = "insure_service_sit")
public class OCompany {
    private String cpId;
    private String name;
    private String supCpId;
    private String supName;
    private String address;
    private Integer totalPeople;
    private String quality;
    private Integer totalRegister;
    private String legalPerson;
    private String technology;
    private String technologyPhone;
    private String business;
    private String businessPhone;
    private Timestamp createTime;
    private Timestamp updateTime;
    private BigInteger type;
    private String merchantCode;
    private String secretKey;
    private String publicKey;
    private String privateKey;
    private BigInteger isRecon;
    private String reconFilePath;

    @Id
    @Column(name = "CP_ID", nullable = false, length = 20)
    public String getCpId() {
        return cpId;
    }

    public void setCpId(String cpId) {
        this.cpId = cpId;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 200)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "SUP_CP_ID", nullable = false, length = 20)
    public String getSupCpId() {
        return supCpId;
    }

    public void setSupCpId(String supCpId) {
        this.supCpId = supCpId;
    }

    @Basic
    @Column(name = "SUP_NAME", nullable = false, length = 200)
    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    @Basic
    @Column(name = "ADDRESS", nullable = true, length = 200)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "TOTAL_PEOPLE", nullable = true, precision = 0)
    public Integer getTotalPeople() {
        return totalPeople;
    }

    public void setTotalPeople(Integer totalPeople) {
        this.totalPeople = totalPeople;
    }

    @Basic
    @Column(name = "QUALITY", nullable = true, length = 20)
    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    @Basic
    @Column(name = "TOTAL_REGISTER", nullable = true, precision = 0)
    public Integer getTotalRegister() {
        return totalRegister;
    }

    public void setTotalRegister(Integer totalRegister) {
        this.totalRegister = totalRegister;
    }

    @Basic
    @Column(name = "LEGAL_PERSON", nullable = true, length = 50)
    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    @Basic
    @Column(name = "TECHNOLOGY", nullable = true, length = 50)
    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    @Basic
    @Column(name = "TECHNOLOGY_PHONE", nullable = true, length = 50)
    public String getTechnologyPhone() {
        return technologyPhone;
    }

    public void setTechnologyPhone(String technologyPhone) {
        this.technologyPhone = technologyPhone;
    }

    @Basic
    @Column(name = "BUSINESS", nullable = true, length = 50)
    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    @Basic
    @Column(name = "BUSINESS_PHONE", nullable = true, length = 50)
    public String getBusinessPhone() {
        return businessPhone;
    }

    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
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

    @Basic
    @Column(name = "MERCHANT_CODE", nullable = false, length = 30)
    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    @Basic
    @Column(name = "SECRET_KEY", nullable = true, length = 30)
    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @Basic
    @Column(name = "PUBLIC_KEY", nullable = true, length = 2500)
    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    @Basic
    @Column(name = "PRIVATE_KEY", nullable = true, length = 2500)
    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    @Basic
    @Column(name = "IS_RECON", nullable = true, precision = 0)
    public BigInteger getIsRecon() {
        return isRecon;
    }

    public void setIsRecon(BigInteger isRecon) {
        this.isRecon = isRecon;
    }

    @Basic
    @Column(name = "RECON_FILE_PATH", nullable = true, length = 200)
    public String getReconFilePath() {
        return reconFilePath;
    }

    public void setReconFilePath(String reconFilePath) {
        this.reconFilePath = reconFilePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OCompany oCompany = (OCompany) o;

        if (cpId != null ? !cpId.equals(oCompany.cpId) : oCompany.cpId != null) return false;
        if (name != null ? !name.equals(oCompany.name) : oCompany.name != null) return false;
        if (supCpId != null ? !supCpId.equals(oCompany.supCpId) : oCompany.supCpId != null) return false;
        if (supName != null ? !supName.equals(oCompany.supName) : oCompany.supName != null) return false;
        if (address != null ? !address.equals(oCompany.address) : oCompany.address != null) return false;
        if (totalPeople != null ? !totalPeople.equals(oCompany.totalPeople) : oCompany.totalPeople != null)
            return false;
        if (quality != null ? !quality.equals(oCompany.quality) : oCompany.quality != null) return false;
        if (totalRegister != null ? !totalRegister.equals(oCompany.totalRegister) : oCompany.totalRegister != null)
            return false;
        if (legalPerson != null ? !legalPerson.equals(oCompany.legalPerson) : oCompany.legalPerson != null)
            return false;
        if (technology != null ? !technology.equals(oCompany.technology) : oCompany.technology != null) return false;
        if (technologyPhone != null ? !technologyPhone.equals(oCompany.technologyPhone) : oCompany.technologyPhone != null)
            return false;
        if (business != null ? !business.equals(oCompany.business) : oCompany.business != null) return false;
        if (businessPhone != null ? !businessPhone.equals(oCompany.businessPhone) : oCompany.businessPhone != null)
            return false;
        if (createTime != null ? !createTime.equals(oCompany.createTime) : oCompany.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(oCompany.updateTime) : oCompany.updateTime != null) return false;
        if (type != null ? !type.equals(oCompany.type) : oCompany.type != null) return false;
        if (merchantCode != null ? !merchantCode.equals(oCompany.merchantCode) : oCompany.merchantCode != null)
            return false;
        if (secretKey != null ? !secretKey.equals(oCompany.secretKey) : oCompany.secretKey != null) return false;
        if (publicKey != null ? !publicKey.equals(oCompany.publicKey) : oCompany.publicKey != null) return false;
        if (privateKey != null ? !privateKey.equals(oCompany.privateKey) : oCompany.privateKey != null) return false;
        if (isRecon != null ? !isRecon.equals(oCompany.isRecon) : oCompany.isRecon != null) return false;
        if (reconFilePath != null ? !reconFilePath.equals(oCompany.reconFilePath) : oCompany.reconFilePath != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cpId != null ? cpId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (supCpId != null ? supCpId.hashCode() : 0);
        result = 31 * result + (supName != null ? supName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (totalPeople != null ? totalPeople.hashCode() : 0);
        result = 31 * result + (quality != null ? quality.hashCode() : 0);
        result = 31 * result + (totalRegister != null ? totalRegister.hashCode() : 0);
        result = 31 * result + (legalPerson != null ? legalPerson.hashCode() : 0);
        result = 31 * result + (technology != null ? technology.hashCode() : 0);
        result = 31 * result + (technologyPhone != null ? technologyPhone.hashCode() : 0);
        result = 31 * result + (business != null ? business.hashCode() : 0);
        result = 31 * result + (businessPhone != null ? businessPhone.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (merchantCode != null ? merchantCode.hashCode() : 0);
        result = 31 * result + (secretKey != null ? secretKey.hashCode() : 0);
        result = 31 * result + (publicKey != null ? publicKey.hashCode() : 0);
        result = 31 * result + (privateKey != null ? privateKey.hashCode() : 0);
        result = 31 * result + (isRecon != null ? isRecon.hashCode() : 0);
        result = 31 * result + (reconFilePath != null ? reconFilePath.hashCode() : 0);
        return result;
    }
}
