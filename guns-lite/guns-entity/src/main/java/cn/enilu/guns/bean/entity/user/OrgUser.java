package cn.enilu.guns.bean.entity.user;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by sunlm on 2018/11/13.
 */
@Entity
@Table(name = "org_user", schema = "insure_service_sit" )
public class OrgUser implements Serializable{
    private String userAccount;
    private String pwd;
    private String cpCode;
    private String superUserAccount;
    private String superPwd;
    private String superCpCode;
    private String wxOpenId;
    private String cpId;
    private String cpName;
    private String orgCode;
    private String scCode;
    private String oBCpId;
    private String orgName;
    private String name;
    private String idNum;
    private String phone;
    private String weixin;
    private String zhifubao;
    private BigInteger isLicence;
    private Timestamp regTime;
    private String introduceAccount;
    private Timestamp lastLoginTime;
    private Timestamp createTime;
    private Timestamp updateTime;
    private BigInteger isStaff;
    private String token;
    private String img;
    private String column28;
    //角色信息
    private List<PPermission> pPermissions;

    @Id
    @Column(name = "USER_ACCOUNT", nullable = false, length = 20)
    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    @Basic
    @Column(name = "PWD", nullable = false, length = 60)
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Basic
    @Column(name = "CP_CODE", nullable = true, length = 50)
    public String getCpCode() {
        return cpCode;
    }

    public void setCpCode(String cpCode) {
        this.cpCode = cpCode;
    }

    @Basic
    @Column(name = "SUPER_USER_ACCOUNT", nullable = false, length = 20)
    public String getSuperUserAccount() {
        return superUserAccount;
    }

    public void setSuperUserAccount(String superUserAccount) {
        this.superUserAccount = superUserAccount;
    }

    @Basic
    @Column(name = "SUPER_PWD", nullable = true, length = 20)
    public String getSuperPwd() {
        return superPwd;
    }

    public void setSuperPwd(String superPwd) {
        this.superPwd = superPwd;
    }

    @Basic
    @Column(name = "SUPER_CP_CODE", nullable = true, length = 50)
    public String getSuperCpCode() {
        return superCpCode;
    }

    public void setSuperCpCode(String superCpCode) {
        this.superCpCode = superCpCode;
    }

    @Basic
    @Column(name = "WX_OPEN_ID", nullable = true, length = 32)
    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
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
    @Column(name = "CP_NAME", nullable = false, length = 200)
    public String getCpName() {
        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName;
    }

    @Basic
    @Column(name = "ORG_CODE", nullable = false, length = 50)
    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    @Basic
    @Column(name = "SC_CODE", nullable = true, length = 20)
    public String getScCode() {
        return scCode;
    }

    public void setScCode(String scCode) {
        this.scCode = scCode;
    }

    @Basic
    @Column(name = "O_B_CP_ID", nullable = true, length = 20)
    public String getoBCpId() {
        return oBCpId;
    }

    public void setoBCpId(String oBCpId) {
        this.oBCpId = oBCpId;
    }

    @Basic
    @Column(name = "ORG_NAME", nullable = false, length = 200)
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "ID_NUM", nullable = false, length = 50)
    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    @Basic
    @Column(name = "PHONE", nullable = false, length = 50)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "WEIXIN", nullable = true, length = 50)
    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    @Basic
    @Column(name = "ZHIFUBAO", nullable = true, length = 50)
    public String getZhifubao() {
        return zhifubao;
    }

    public void setZhifubao(String zhifubao) {
        this.zhifubao = zhifubao;
    }

    @Basic
    @Column(name = "IS_LICENCE", nullable = true, precision = 0)
    public BigInteger getIsLicence() {
        return isLicence;
    }

    public void setIsLicence(BigInteger isLicence) {
        this.isLicence = isLicence;
    }

    @Basic
    @Column(name = "REG_TIME", nullable = false)
    public Timestamp getRegTime() {
        return regTime;
    }

    public void setRegTime(Timestamp regTime) {
        this.regTime = regTime;
    }

    @Basic
    @Column(name = "INTRODUCE_ACCOUNT", nullable = true, length = 20)
    public String getIntroduceAccount() {
        return introduceAccount;
    }

    public void setIntroduceAccount(String introduceAccount) {
        this.introduceAccount = introduceAccount;
    }

    @Basic
    @Column(name = "LAST_LOGIN_TIME", nullable = true)
    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Basic
    @Column(name = "CREATE_TIME", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "UPDATE_TIME", nullable = false)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "IS_STAFF", nullable = true, precision = 0)
    public BigInteger getIsStaff() {
        return isStaff;
    }

    public void setIsStaff(BigInteger isStaff) {
        this.isStaff = isStaff;
    }

    @Basic
    @Column(name = "TOKEN", nullable = true, length = 32)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "IMG", nullable = true, length = 50)
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Basic
    @Column(name = "COLUMN_28", nullable = true, length = 10)
    public String getColumn28() {
        return column28;
    }

    public void setColumn28(String column28) {
        this.column28 = column28;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrgUser orgUser = (OrgUser) o;

        if (userAccount != null ? !userAccount.equals(orgUser.userAccount) : orgUser.userAccount != null) return false;
        if (pwd != null ? !pwd.equals(orgUser.pwd) : orgUser.pwd != null) return false;
        if (cpCode != null ? !cpCode.equals(orgUser.cpCode) : orgUser.cpCode != null) return false;
        if (superUserAccount != null ? !superUserAccount.equals(orgUser.superUserAccount) : orgUser.superUserAccount != null)
            return false;
        if (superPwd != null ? !superPwd.equals(orgUser.superPwd) : orgUser.superPwd != null) return false;
        if (superCpCode != null ? !superCpCode.equals(orgUser.superCpCode) : orgUser.superCpCode != null) return false;
        if (wxOpenId != null ? !wxOpenId.equals(orgUser.wxOpenId) : orgUser.wxOpenId != null) return false;
        if (cpId != null ? !cpId.equals(orgUser.cpId) : orgUser.cpId != null) return false;
        if (cpName != null ? !cpName.equals(orgUser.cpName) : orgUser.cpName != null) return false;
        if (orgCode != null ? !orgCode.equals(orgUser.orgCode) : orgUser.orgCode != null) return false;
        if (scCode != null ? !scCode.equals(orgUser.scCode) : orgUser.scCode != null) return false;
        if (oBCpId != null ? !oBCpId.equals(orgUser.oBCpId) : orgUser.oBCpId != null) return false;
        if (orgName != null ? !orgName.equals(orgUser.orgName) : orgUser.orgName != null) return false;
        if (name != null ? !name.equals(orgUser.name) : orgUser.name != null) return false;
        if (idNum != null ? !idNum.equals(orgUser.idNum) : orgUser.idNum != null) return false;
        if (phone != null ? !phone.equals(orgUser.phone) : orgUser.phone != null) return false;
        if (weixin != null ? !weixin.equals(orgUser.weixin) : orgUser.weixin != null) return false;
        if (zhifubao != null ? !zhifubao.equals(orgUser.zhifubao) : orgUser.zhifubao != null) return false;
        if (isLicence != null ? !isLicence.equals(orgUser.isLicence) : orgUser.isLicence != null) return false;
        if (regTime != null ? !regTime.equals(orgUser.regTime) : orgUser.regTime != null) return false;
        if (introduceAccount != null ? !introduceAccount.equals(orgUser.introduceAccount) : orgUser.introduceAccount != null)
            return false;
        if (lastLoginTime != null ? !lastLoginTime.equals(orgUser.lastLoginTime) : orgUser.lastLoginTime != null)
            return false;
        if (createTime != null ? !createTime.equals(orgUser.createTime) : orgUser.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(orgUser.updateTime) : orgUser.updateTime != null) return false;
        if (isStaff != null ? !isStaff.equals(orgUser.isStaff) : orgUser.isStaff != null) return false;
        if (token != null ? !token.equals(orgUser.token) : orgUser.token != null) return false;
        if (img != null ? !img.equals(orgUser.img) : orgUser.img != null) return false;
        if (column28 != null ? !column28.equals(orgUser.column28) : orgUser.column28 != null) return false;

        return true;
    }

    @Transient
    public List<PPermission> getpPermissions() {
        return pPermissions;
    }

    public void setpPermissions(List<PPermission> pPermissions) {
        this.pPermissions = pPermissions;
    }

    @Override
    public int hashCode() {
        int result = userAccount != null ? userAccount.hashCode() : 0;
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        result = 31 * result + (cpCode != null ? cpCode.hashCode() : 0);
        result = 31 * result + (superUserAccount != null ? superUserAccount.hashCode() : 0);
        result = 31 * result + (superPwd != null ? superPwd.hashCode() : 0);
        result = 31 * result + (superCpCode != null ? superCpCode.hashCode() : 0);
        result = 31 * result + (wxOpenId != null ? wxOpenId.hashCode() : 0);
        result = 31 * result + (cpId != null ? cpId.hashCode() : 0);
        result = 31 * result + (cpName != null ? cpName.hashCode() : 0);
        result = 31 * result + (orgCode != null ? orgCode.hashCode() : 0);
        result = 31 * result + (scCode != null ? scCode.hashCode() : 0);
        result = 31 * result + (oBCpId != null ? oBCpId.hashCode() : 0);
        result = 31 * result + (orgName != null ? orgName.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (idNum != null ? idNum.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (weixin != null ? weixin.hashCode() : 0);
        result = 31 * result + (zhifubao != null ? zhifubao.hashCode() : 0);
        result = 31 * result + (isLicence != null ? isLicence.hashCode() : 0);
        result = 31 * result + (regTime != null ? regTime.hashCode() : 0);
        result = 31 * result + (introduceAccount != null ? introduceAccount.hashCode() : 0);
        result = 31 * result + (lastLoginTime != null ? lastLoginTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (isStaff != null ? isStaff.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (img != null ? img.hashCode() : 0);
        result = 31 * result + (column28 != null ? column28.hashCode() : 0);
        return result;
    }
}
