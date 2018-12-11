package cn.enilu.guns.bean.entity.user;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "or_order", schema = "insure_service_sit")
public class OrOrder {

    private int orderId;
    private Integer serialNumber;
    private String applyNo;
    private String bpId;
    private String productName;
    private String sCode;
    private String sName;
    private String sellerCpCode;
    private String sellerAccount;
    private String reconcilCode;
    private String ogId;
    private String cpId;
    private String productGroupCode;
    private String psCode;
    private String psName;
    private String proudctGroupName;
    private String sellerName;
    private BigDecimal sellerRate;
    private BigDecimal sellerCommission;
    private String supperSellerCpCode;
    private String supperSellerAccount;
    private String supperSellerName;
    private BigDecimal supperSellerRate;
    private BigDecimal supperSellerCommission;
    private String policyNo;
    private String insuredName;
    private String insuredId;
    private String insuredIdType;
    private String holderName;
    private String holderId;
    private String holderIdType;
    private String holderPhone;
    private String insuredPhone;
    private BigInteger relation;
    private Timestamp policySDate;
    private Timestamp policySTime;
    private Timestamp policyEDate;
    private Timestamp policyETime;
    private Integer insureType;
    private Timestamp cTime;
    private Timestamp uTime;
    private Timestamp payTime;
    private BigInteger payType;
    private String payFloat;
    private BigInteger payState;
    private BigDecimal payEffectLength;
    private String errorMessage;
    private Integer state;
    private Integer type;
    private BigDecimal price;
    private BigDecimal sellPrice;
    private BigDecimal profit;
    private BigDecimal commissionRate;
    private BigDecimal totleCommission;
    private String sellerCpName;
    private String orgCode;
    private String sellerOrgName;
    private BigInteger isCutPrice;
    private BigDecimal cutPriceRate;
    private BigInteger commType;
    private BigDecimal commQuota;
    private BigDecimal orgRate;
    private BigDecimal orgExCommission;
    private BigDecimal companyRate;
    private BigDecimal orgCompanyCommission;
    private BigDecimal perks;
    private BigInteger reconcil;
    private Timestamp recTime;
    private String merchantCode;
    private String cpicId;
    private String regionCode;
    private String regionName;
    private String orgName;
    private String mOrder;
    private BigDecimal sumInsured;
    private Integer distType;
    private String historyGroupId;
    private String merchantSerialNumber;
    private BigInteger asynState;
    private Timestamp asynHandleTime;
    private BigInteger asynNoticeState;
    private BigInteger asynNoticeNum;
    private Timestamp asynNoticeTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "SERIAL_NUMBER")
    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Basic
    @Column(name = "APPLY_NO")
    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
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
    @Column(name = "PRODUCT_NAME")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
    @Column(name = "SELLER_CP_CODE")
    public String getSellerCpCode() {
        return sellerCpCode;
    }

    public void setSellerCpCode(String sellerCpCode) {
        this.sellerCpCode = sellerCpCode;
    }

    @Basic
    @Column(name = "SELLER_ACCOUNT")
    public String getSellerAccount() {
        return sellerAccount;
    }

    public void setSellerAccount(String sellerAccount) {
        this.sellerAccount = sellerAccount;
    }

    @Basic
    @Column(name = "RECONCIL_CODE")
    public String getReconcilCode() {
        return reconcilCode;
    }

    public void setReconcilCode(String reconcilCode) {
        this.reconcilCode = reconcilCode;
    }

    @Basic
    @Column(name = "OG_ID")
    public String getOgId() {
        return ogId;
    }

    public void setOgId(String ogId) {
        this.ogId = ogId;
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
    @Column(name = "PRODUCT_GROUP_CODE")
    public String getProductGroupCode() {
        return productGroupCode;
    }

    public void setProductGroupCode(String productGroupCode) {
        this.productGroupCode = productGroupCode;
    }

    @Basic
    @Column(name = "PS_CODE")
    public String getPsCode() {
        return psCode;
    }

    public void setPsCode(String psCode) {
        this.psCode = psCode;
    }

    @Basic
    @Column(name = "PS_NAME")
    public String getPsName() {
        return psName;
    }

    public void setPsName(String psName) {
        this.psName = psName;
    }

    @Basic
    @Column(name = "PROUDCT_GROUP_NAME")
    public String getProudctGroupName() {
        return proudctGroupName;
    }

    public void setProudctGroupName(String proudctGroupName) {
        this.proudctGroupName = proudctGroupName;
    }

    @Basic
    @Column(name = "SELLER_NAME")
    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    @Basic
    @Column(name = "SELLER_RATE")
    public BigDecimal getSellerRate() {
        return sellerRate;
    }

    public void setSellerRate(BigDecimal sellerRate) {
        this.sellerRate = sellerRate;
    }

    @Basic
    @Column(name = "SELLER_COMMISSION")
    public BigDecimal getSellerCommission() {
        return sellerCommission;
    }

    public void setSellerCommission(BigDecimal sellerCommission) {
        this.sellerCommission = sellerCommission;
    }

    @Basic
    @Column(name = "SUPPER_SELLER_CP_CODE")
    public String getSupperSellerCpCode() {
        return supperSellerCpCode;
    }

    public void setSupperSellerCpCode(String supperSellerCpCode) {
        this.supperSellerCpCode = supperSellerCpCode;
    }

    @Basic
    @Column(name = "SUPPER_SELLER_ACCOUNT")
    public String getSupperSellerAccount() {
        return supperSellerAccount;
    }

    public void setSupperSellerAccount(String supperSellerAccount) {
        this.supperSellerAccount = supperSellerAccount;
    }

    @Basic
    @Column(name = "SUPPER_SELLER_NAME")
    public String getSupperSellerName() {
        return supperSellerName;
    }

    public void setSupperSellerName(String supperSellerName) {
        this.supperSellerName = supperSellerName;
    }

    @Basic
    @Column(name = "SUPPER_SELLER_RATE")
    public BigDecimal getSupperSellerRate() {
        return supperSellerRate;
    }

    public void setSupperSellerRate(BigDecimal supperSellerRate) {
        this.supperSellerRate = supperSellerRate;
    }

    @Basic
    @Column(name = "SUPPER_SELLER_COMMISSION")
    public BigDecimal getSupperSellerCommission() {
        return supperSellerCommission;
    }

    public void setSupperSellerCommission(BigDecimal supperSellerCommission) {
        this.supperSellerCommission = supperSellerCommission;
    }

    @Basic
    @Column(name = "POLICY_NO")
    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    @Basic
    @Column(name = "INSURED_NAME")
    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    @Basic
    @Column(name = "INSURED_ID")
    public String getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(String insuredId) {
        this.insuredId = insuredId;
    }

    @Basic
    @Column(name = "INSURED_ID_TYPE")
    public String getInsuredIdType() {
        return insuredIdType;
    }

    public void setInsuredIdType(String insuredIdType) {
        this.insuredIdType = insuredIdType;
    }

    @Basic
    @Column(name = "HOLDER_NAME")
    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    @Basic
    @Column(name = "HOLDER_ID")
    public String getHolderId() {
        return holderId;
    }

    public void setHolderId(String holderId) {
        this.holderId = holderId;
    }

    @Basic
    @Column(name = "HOLDER_ID_TYPE")
    public String getHolderIdType() {
        return holderIdType;
    }

    public void setHolderIdType(String holderIdType) {
        this.holderIdType = holderIdType;
    }

    @Basic
    @Column(name = "HOLDER_PHONE")
    public String getHolderPhone() {
        return holderPhone;
    }

    public void setHolderPhone(String holderPhone) {
        this.holderPhone = holderPhone;
    }

    @Basic
    @Column(name = "INSURED_PHONE")
    public String getInsuredPhone() {
        return insuredPhone;
    }

    public void setInsuredPhone(String insuredPhone) {
        this.insuredPhone = insuredPhone;
    }

    @Basic
    @Column(name = "RELATION")
    public BigInteger getRelation() {
        return relation;
    }

    public void setRelation(BigInteger relation) {
        this.relation = relation;
    }

    @Basic
    @Column(name = "POLICY_S_DATE")
    public Timestamp getPolicySDate() {
        return policySDate;
    }

    public void setPolicySDate(Timestamp policySDate) {
        this.policySDate = policySDate;
    }

    @Basic
    @Column(name = "POLICY_S_TIME")
    public Timestamp getPolicySTime() {
        return policySTime;
    }

    public void setPolicySTime(Timestamp policySTime) {
        this.policySTime = policySTime;
    }

    @Basic
    @Column(name = "POLICY_E_DATE")
    public Timestamp getPolicyEDate() {
        return policyEDate;
    }

    public void setPolicyEDate(Timestamp policyEDate) {
        this.policyEDate = policyEDate;
    }

    @Basic
    @Column(name = "POLICY_E_TIME")
    public Timestamp getPolicyETime() {
        return policyETime;
    }

    public void setPolicyETime(Timestamp policyETime) {
        this.policyETime = policyETime;
    }

    @Basic
    @Column(name = "INSURE_TYPE")
    public Integer getInsureType() {
        return insureType;
    }

    public void setInsureType(Integer insureType) {
        this.insureType = insureType;
    }

    @Basic
    @Column(name = "C_TIME")
    public Timestamp getcTime() {
        return cTime;
    }

    public void setcTime(Timestamp cTime) {
        this.cTime = cTime;
    }

    @Basic
    @Column(name = "U_TIME")
    public Timestamp getuTime() {
        return uTime;
    }

    public void setuTime(Timestamp uTime) {
        this.uTime = uTime;
    }

    @Basic
    @Column(name = "PAY_TIME")
    public Timestamp getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }

    @Basic
    @Column(name = "PAY_TYPE")
    public BigInteger getPayType() {
        return payType;
    }

    public void setPayType(BigInteger payType) {
        this.payType = payType;
    }

    @Basic
    @Column(name = "PAY_FLOAT")
    public String getPayFloat() {
        return payFloat;
    }

    public void setPayFloat(String payFloat) {
        this.payFloat = payFloat;
    }

    @Basic
    @Column(name = "PAY_STATE")
    public BigInteger getPayState() {
        return payState;
    }

    public void setPayState(BigInteger payState) {
        this.payState = payState;
    }

    @Basic
    @Column(name = "PAY_EFFECT_LENGTH")
    public BigDecimal getPayEffectLength() {
        return payEffectLength;
    }

    public void setPayEffectLength(BigDecimal payEffectLength) {
        this.payEffectLength = payEffectLength;
    }

    @Basic
    @Column(name = "ERROR_MESSAGE")
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Basic
    @Column(name = "STATE")
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Basic
    @Column(name = "TYPE")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
    @Column(name = "PROFIT")
    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    @Basic
    @Column(name = "COMMISSION_RATE")
    public BigDecimal getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(BigDecimal commissionRate) {
        this.commissionRate = commissionRate;
    }

    @Basic
    @Column(name = "TOTLE_COMMISSION")
    public BigDecimal getTotleCommission() {
        return totleCommission;
    }

    public void setTotleCommission(BigDecimal totleCommission) {
        this.totleCommission = totleCommission;
    }

    @Basic
    @Column(name = "SELLER_CP_NAME")
    public String getSellerCpName() {
        return sellerCpName;
    }

    public void setSellerCpName(String sellerCpName) {
        this.sellerCpName = sellerCpName;
    }

    @Basic
    @Column(name = "ORG_CODE")
    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    @Basic
    @Column(name = "SELLER_ORG_NAME")
    public String getSellerOrgName() {
        return sellerOrgName;
    }

    public void setSellerOrgName(String sellerOrgName) {
        this.sellerOrgName = sellerOrgName;
    }

    @Basic
    @Column(name = "IS_CUT_PRICE")
    public BigInteger getIsCutPrice() {
        return isCutPrice;
    }

    public void setIsCutPrice(BigInteger isCutPrice) {
        this.isCutPrice = isCutPrice;
    }

    @Basic
    @Column(name = "CUT_PRICE_RATE")
    public BigDecimal getCutPriceRate() {
        return cutPriceRate;
    }

    public void setCutPriceRate(BigDecimal cutPriceRate) {
        this.cutPriceRate = cutPriceRate;
    }

    @Basic
    @Column(name = "COMM_TYPE")
    public BigInteger getCommType() {
        return commType;
    }

    public void setCommType(BigInteger commType) {
        this.commType = commType;
    }

    @Basic
    @Column(name = "COMM_QUOTA")
    public BigDecimal getCommQuota() {
        return commQuota;
    }

    public void setCommQuota(BigDecimal commQuota) {
        this.commQuota = commQuota;
    }

    @Basic
    @Column(name = "ORG_RATE")
    public BigDecimal getOrgRate() {
        return orgRate;
    }

    public void setOrgRate(BigDecimal orgRate) {
        this.orgRate = orgRate;
    }

    @Basic
    @Column(name = "ORG_EX_COMMISSION")
    public BigDecimal getOrgExCommission() {
        return orgExCommission;
    }

    public void setOrgExCommission(BigDecimal orgExCommission) {
        this.orgExCommission = orgExCommission;
    }

    @Basic
    @Column(name = "COMPANY_RATE")
    public BigDecimal getCompanyRate() {
        return companyRate;
    }

    public void setCompanyRate(BigDecimal companyRate) {
        this.companyRate = companyRate;
    }

    @Basic
    @Column(name = "ORG_COMPANY_COMMISSION")
    public BigDecimal getOrgCompanyCommission() {
        return orgCompanyCommission;
    }

    public void setOrgCompanyCommission(BigDecimal orgCompanyCommission) {
        this.orgCompanyCommission = orgCompanyCommission;
    }

    @Basic
    @Column(name = "PERKS")
    public BigDecimal getPerks() {
        return perks;
    }

    public void setPerks(BigDecimal perks) {
        this.perks = perks;
    }

    @Basic
    @Column(name = "RECONCIL")
    public BigInteger getReconcil() {
        return reconcil;
    }

    public void setReconcil(BigInteger reconcil) {
        this.reconcil = reconcil;
    }

    @Basic
    @Column(name = "REC_TIME")
    public Timestamp getRecTime() {
        return recTime;
    }

    public void setRecTime(Timestamp recTime) {
        this.recTime = recTime;
    }

    @Basic
    @Column(name = "MERCHANT_CODE")
    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    @Basic
    @Column(name = "CPIC_ID")
    public String getCpicId() {
        return cpicId;
    }

    public void setCpicId(String cpicId) {
        this.cpicId = cpicId;
    }

    @Basic
    @Column(name = "REGION_CODE")
    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    @Basic
    @Column(name = "REGION_NAME")
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Basic
    @Column(name = "ORG_NAME")
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Basic
    @Column(name = "M_ORDER")
    public String getmOrder() {
        return mOrder;
    }

    public void setmOrder(String mOrder) {
        this.mOrder = mOrder;
    }

    @Basic
    @Column(name = "SUM_INSURED")
    public BigDecimal getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(BigDecimal sumInsured) {
        this.sumInsured = sumInsured;
    }

    @Basic
    @Column(name = "DIST_TYPE")
    public Integer getDistType() {
        return distType;
    }

    public void setDistType(Integer distType) {
        this.distType = distType;
    }

    @Basic
    @Column(name = "HISTORY_GROUP_ID")
    public String getHistoryGroupId() {
        return historyGroupId;
    }

    public void setHistoryGroupId(String historyGroupId) {
        this.historyGroupId = historyGroupId;
    }

    @Basic
    @Column(name = "MERCHANT_SERIAL_NUMBER")
    public String getMerchantSerialNumber() {
        return merchantSerialNumber;
    }

    public void setMerchantSerialNumber(String merchantSerialNumber) {
        this.merchantSerialNumber = merchantSerialNumber;
    }

    @Basic
    @Column(name = "ASYN_STATE")
    public BigInteger getAsynState() {
        return asynState;
    }

    public void setAsynState(BigInteger asynState) {
        this.asynState = asynState;
    }

    @Basic
    @Column(name = "ASYN_HANDLE_TIME")
    public Timestamp getAsynHandleTime() {
        return asynHandleTime;
    }

    public void setAsynHandleTime(Timestamp asynHandleTime) {
        this.asynHandleTime = asynHandleTime;
    }

    @Basic
    @Column(name = "ASYN_NOTICE_STATE")
    public BigInteger getAsynNoticeState() {
        return asynNoticeState;
    }

    public void setAsynNoticeState(BigInteger asynNoticeState) {
        this.asynNoticeState = asynNoticeState;
    }

    @Basic
    @Column(name = "ASYN_NOTICE_NUM")
    public BigInteger getAsynNoticeNum() {
        return asynNoticeNum;
    }

    public void setAsynNoticeNum(BigInteger asynNoticeNum) {
        this.asynNoticeNum = asynNoticeNum;
    }

    @Basic
    @Column(name = "ASYN_NOTICE_TIME")
    public Timestamp getAsynNoticeTime() {
        return asynNoticeTime;
    }

    public void setAsynNoticeTime(Timestamp asynNoticeTime) {
        this.asynNoticeTime = asynNoticeTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrOrder orOrder = (OrOrder) o;

        if (orderId != orOrder.orderId) return false;
        if (serialNumber != null ? !serialNumber.equals(orOrder.serialNumber) : orOrder.serialNumber != null)
            return false;
        if (applyNo != null ? !applyNo.equals(orOrder.applyNo) : orOrder.applyNo != null) return false;
        if (bpId != null ? !bpId.equals(orOrder.bpId) : orOrder.bpId != null) return false;
        if (productName != null ? !productName.equals(orOrder.productName) : orOrder.productName != null) return false;
        if (sCode != null ? !sCode.equals(orOrder.sCode) : orOrder.sCode != null) return false;
        if (sName != null ? !sName.equals(orOrder.sName) : orOrder.sName != null) return false;
        if (sellerCpCode != null ? !sellerCpCode.equals(orOrder.sellerCpCode) : orOrder.sellerCpCode != null)
            return false;
        if (sellerAccount != null ? !sellerAccount.equals(orOrder.sellerAccount) : orOrder.sellerAccount != null)
            return false;
        if (reconcilCode != null ? !reconcilCode.equals(orOrder.reconcilCode) : orOrder.reconcilCode != null)
            return false;
        if (ogId != null ? !ogId.equals(orOrder.ogId) : orOrder.ogId != null) return false;
        if (cpId != null ? !cpId.equals(orOrder.cpId) : orOrder.cpId != null) return false;
        if (productGroupCode != null ? !productGroupCode.equals(orOrder.productGroupCode) : orOrder.productGroupCode != null)
            return false;
        if (psCode != null ? !psCode.equals(orOrder.psCode) : orOrder.psCode != null) return false;
        if (psName != null ? !psName.equals(orOrder.psName) : orOrder.psName != null) return false;
        if (proudctGroupName != null ? !proudctGroupName.equals(orOrder.proudctGroupName) : orOrder.proudctGroupName != null)
            return false;
        if (sellerName != null ? !sellerName.equals(orOrder.sellerName) : orOrder.sellerName != null) return false;
        if (sellerRate != null ? !sellerRate.equals(orOrder.sellerRate) : orOrder.sellerRate != null) return false;
        if (sellerCommission != null ? !sellerCommission.equals(orOrder.sellerCommission) : orOrder.sellerCommission != null)
            return false;
        if (supperSellerCpCode != null ? !supperSellerCpCode.equals(orOrder.supperSellerCpCode) : orOrder.supperSellerCpCode != null)
            return false;
        if (supperSellerAccount != null ? !supperSellerAccount.equals(orOrder.supperSellerAccount) : orOrder.supperSellerAccount != null)
            return false;
        if (supperSellerName != null ? !supperSellerName.equals(orOrder.supperSellerName) : orOrder.supperSellerName != null)
            return false;
        if (supperSellerRate != null ? !supperSellerRate.equals(orOrder.supperSellerRate) : orOrder.supperSellerRate != null)
            return false;
        if (supperSellerCommission != null ? !supperSellerCommission.equals(orOrder.supperSellerCommission) : orOrder.supperSellerCommission != null)
            return false;
        if (policyNo != null ? !policyNo.equals(orOrder.policyNo) : orOrder.policyNo != null) return false;
        if (insuredName != null ? !insuredName.equals(orOrder.insuredName) : orOrder.insuredName != null) return false;
        if (insuredId != null ? !insuredId.equals(orOrder.insuredId) : orOrder.insuredId != null) return false;
        if (insuredIdType != null ? !insuredIdType.equals(orOrder.insuredIdType) : orOrder.insuredIdType != null)
            return false;
        if (holderName != null ? !holderName.equals(orOrder.holderName) : orOrder.holderName != null) return false;
        if (holderId != null ? !holderId.equals(orOrder.holderId) : orOrder.holderId != null) return false;
        if (holderIdType != null ? !holderIdType.equals(orOrder.holderIdType) : orOrder.holderIdType != null)
            return false;
        if (holderPhone != null ? !holderPhone.equals(orOrder.holderPhone) : orOrder.holderPhone != null) return false;
        if (insuredPhone != null ? !insuredPhone.equals(orOrder.insuredPhone) : orOrder.insuredPhone != null)
            return false;
        if (relation != null ? !relation.equals(orOrder.relation) : orOrder.relation != null) return false;
        if (policySDate != null ? !policySDate.equals(orOrder.policySDate) : orOrder.policySDate != null) return false;
        if (policySTime != null ? !policySTime.equals(orOrder.policySTime) : orOrder.policySTime != null) return false;
        if (policyEDate != null ? !policyEDate.equals(orOrder.policyEDate) : orOrder.policyEDate != null) return false;
        if (policyETime != null ? !policyETime.equals(orOrder.policyETime) : orOrder.policyETime != null) return false;
        if (insureType != null ? !insureType.equals(orOrder.insureType) : orOrder.insureType != null) return false;
        if (cTime != null ? !cTime.equals(orOrder.cTime) : orOrder.cTime != null) return false;
        if (uTime != null ? !uTime.equals(orOrder.uTime) : orOrder.uTime != null) return false;
        if (payTime != null ? !payTime.equals(orOrder.payTime) : orOrder.payTime != null) return false;
        if (payType != null ? !payType.equals(orOrder.payType) : orOrder.payType != null) return false;
        if (payFloat != null ? !payFloat.equals(orOrder.payFloat) : orOrder.payFloat != null) return false;
        if (payState != null ? !payState.equals(orOrder.payState) : orOrder.payState != null) return false;
        if (payEffectLength != null ? !payEffectLength.equals(orOrder.payEffectLength) : orOrder.payEffectLength != null)
            return false;
        if (errorMessage != null ? !errorMessage.equals(orOrder.errorMessage) : orOrder.errorMessage != null)
            return false;
        if (state != null ? !state.equals(orOrder.state) : orOrder.state != null) return false;
        if (type != null ? !type.equals(orOrder.type) : orOrder.type != null) return false;
        if (price != null ? !price.equals(orOrder.price) : orOrder.price != null) return false;
        if (sellPrice != null ? !sellPrice.equals(orOrder.sellPrice) : orOrder.sellPrice != null) return false;
        if (profit != null ? !profit.equals(orOrder.profit) : orOrder.profit != null) return false;
        if (commissionRate != null ? !commissionRate.equals(orOrder.commissionRate) : orOrder.commissionRate != null)
            return false;
        if (totleCommission != null ? !totleCommission.equals(orOrder.totleCommission) : orOrder.totleCommission != null)
            return false;
        if (sellerCpName != null ? !sellerCpName.equals(orOrder.sellerCpName) : orOrder.sellerCpName != null)
            return false;
        if (orgCode != null ? !orgCode.equals(orOrder.orgCode) : orOrder.orgCode != null) return false;
        if (sellerOrgName != null ? !sellerOrgName.equals(orOrder.sellerOrgName) : orOrder.sellerOrgName != null)
            return false;
        if (isCutPrice != null ? !isCutPrice.equals(orOrder.isCutPrice) : orOrder.isCutPrice != null) return false;
        if (cutPriceRate != null ? !cutPriceRate.equals(orOrder.cutPriceRate) : orOrder.cutPriceRate != null)
            return false;
        if (commType != null ? !commType.equals(orOrder.commType) : orOrder.commType != null) return false;
        if (commQuota != null ? !commQuota.equals(orOrder.commQuota) : orOrder.commQuota != null) return false;
        if (orgRate != null ? !orgRate.equals(orOrder.orgRate) : orOrder.orgRate != null) return false;
        if (orgExCommission != null ? !orgExCommission.equals(orOrder.orgExCommission) : orOrder.orgExCommission != null)
            return false;
        if (companyRate != null ? !companyRate.equals(orOrder.companyRate) : orOrder.companyRate != null) return false;
        if (orgCompanyCommission != null ? !orgCompanyCommission.equals(orOrder.orgCompanyCommission) : orOrder.orgCompanyCommission != null)
            return false;
        if (perks != null ? !perks.equals(orOrder.perks) : orOrder.perks != null) return false;
        if (reconcil != null ? !reconcil.equals(orOrder.reconcil) : orOrder.reconcil != null) return false;
        if (recTime != null ? !recTime.equals(orOrder.recTime) : orOrder.recTime != null) return false;
        if (merchantCode != null ? !merchantCode.equals(orOrder.merchantCode) : orOrder.merchantCode != null)
            return false;
        if (cpicId != null ? !cpicId.equals(orOrder.cpicId) : orOrder.cpicId != null) return false;
        if (regionCode != null ? !regionCode.equals(orOrder.regionCode) : orOrder.regionCode != null) return false;
        if (regionName != null ? !regionName.equals(orOrder.regionName) : orOrder.regionName != null) return false;
        if (orgName != null ? !orgName.equals(orOrder.orgName) : orOrder.orgName != null) return false;
        if (mOrder != null ? !mOrder.equals(orOrder.mOrder) : orOrder.mOrder != null) return false;
        if (sumInsured != null ? !sumInsured.equals(orOrder.sumInsured) : orOrder.sumInsured != null) return false;
        if (distType != null ? !distType.equals(orOrder.distType) : orOrder.distType != null) return false;
        if (historyGroupId != null ? !historyGroupId.equals(orOrder.historyGroupId) : orOrder.historyGroupId != null)
            return false;
        if (merchantSerialNumber != null ? !merchantSerialNumber.equals(orOrder.merchantSerialNumber) : orOrder.merchantSerialNumber != null)
            return false;
        if (asynState != null ? !asynState.equals(orOrder.asynState) : orOrder.asynState != null) return false;
        if (asynHandleTime != null ? !asynHandleTime.equals(orOrder.asynHandleTime) : orOrder.asynHandleTime != null)
            return false;
        if (asynNoticeState != null ? !asynNoticeState.equals(orOrder.asynNoticeState) : orOrder.asynNoticeState != null)
            return false;
        if (asynNoticeNum != null ? !asynNoticeNum.equals(orOrder.asynNoticeNum) : orOrder.asynNoticeNum != null)
            return false;
        if (asynNoticeTime != null ? !asynNoticeTime.equals(orOrder.asynNoticeTime) : orOrder.asynNoticeTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (serialNumber != null ? serialNumber.hashCode() : 0);
        result = 31 * result + (applyNo != null ? applyNo.hashCode() : 0);
        result = 31 * result + (bpId != null ? bpId.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (sCode != null ? sCode.hashCode() : 0);
        result = 31 * result + (sName != null ? sName.hashCode() : 0);
        result = 31 * result + (sellerCpCode != null ? sellerCpCode.hashCode() : 0);
        result = 31 * result + (sellerAccount != null ? sellerAccount.hashCode() : 0);
        result = 31 * result + (reconcilCode != null ? reconcilCode.hashCode() : 0);
        result = 31 * result + (ogId != null ? ogId.hashCode() : 0);
        result = 31 * result + (cpId != null ? cpId.hashCode() : 0);
        result = 31 * result + (productGroupCode != null ? productGroupCode.hashCode() : 0);
        result = 31 * result + (psCode != null ? psCode.hashCode() : 0);
        result = 31 * result + (psName != null ? psName.hashCode() : 0);
        result = 31 * result + (proudctGroupName != null ? proudctGroupName.hashCode() : 0);
        result = 31 * result + (sellerName != null ? sellerName.hashCode() : 0);
        result = 31 * result + (sellerRate != null ? sellerRate.hashCode() : 0);
        result = 31 * result + (sellerCommission != null ? sellerCommission.hashCode() : 0);
        result = 31 * result + (supperSellerCpCode != null ? supperSellerCpCode.hashCode() : 0);
        result = 31 * result + (supperSellerAccount != null ? supperSellerAccount.hashCode() : 0);
        result = 31 * result + (supperSellerName != null ? supperSellerName.hashCode() : 0);
        result = 31 * result + (supperSellerRate != null ? supperSellerRate.hashCode() : 0);
        result = 31 * result + (supperSellerCommission != null ? supperSellerCommission.hashCode() : 0);
        result = 31 * result + (policyNo != null ? policyNo.hashCode() : 0);
        result = 31 * result + (insuredName != null ? insuredName.hashCode() : 0);
        result = 31 * result + (insuredId != null ? insuredId.hashCode() : 0);
        result = 31 * result + (insuredIdType != null ? insuredIdType.hashCode() : 0);
        result = 31 * result + (holderName != null ? holderName.hashCode() : 0);
        result = 31 * result + (holderId != null ? holderId.hashCode() : 0);
        result = 31 * result + (holderIdType != null ? holderIdType.hashCode() : 0);
        result = 31 * result + (holderPhone != null ? holderPhone.hashCode() : 0);
        result = 31 * result + (insuredPhone != null ? insuredPhone.hashCode() : 0);
        result = 31 * result + (relation != null ? relation.hashCode() : 0);
        result = 31 * result + (policySDate != null ? policySDate.hashCode() : 0);
        result = 31 * result + (policySTime != null ? policySTime.hashCode() : 0);
        result = 31 * result + (policyEDate != null ? policyEDate.hashCode() : 0);
        result = 31 * result + (policyETime != null ? policyETime.hashCode() : 0);
        result = 31 * result + (insureType != null ? insureType.hashCode() : 0);
        result = 31 * result + (cTime != null ? cTime.hashCode() : 0);
        result = 31 * result + (uTime != null ? uTime.hashCode() : 0);
        result = 31 * result + (payTime != null ? payTime.hashCode() : 0);
        result = 31 * result + (payType != null ? payType.hashCode() : 0);
        result = 31 * result + (payFloat != null ? payFloat.hashCode() : 0);
        result = 31 * result + (payState != null ? payState.hashCode() : 0);
        result = 31 * result + (payEffectLength != null ? payEffectLength.hashCode() : 0);
        result = 31 * result + (errorMessage != null ? errorMessage.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (sellPrice != null ? sellPrice.hashCode() : 0);
        result = 31 * result + (profit != null ? profit.hashCode() : 0);
        result = 31 * result + (commissionRate != null ? commissionRate.hashCode() : 0);
        result = 31 * result + (totleCommission != null ? totleCommission.hashCode() : 0);
        result = 31 * result + (sellerCpName != null ? sellerCpName.hashCode() : 0);
        result = 31 * result + (orgCode != null ? orgCode.hashCode() : 0);
        result = 31 * result + (sellerOrgName != null ? sellerOrgName.hashCode() : 0);
        result = 31 * result + (isCutPrice != null ? isCutPrice.hashCode() : 0);
        result = 31 * result + (cutPriceRate != null ? cutPriceRate.hashCode() : 0);
        result = 31 * result + (commType != null ? commType.hashCode() : 0);
        result = 31 * result + (commQuota != null ? commQuota.hashCode() : 0);
        result = 31 * result + (orgRate != null ? orgRate.hashCode() : 0);
        result = 31 * result + (orgExCommission != null ? orgExCommission.hashCode() : 0);
        result = 31 * result + (companyRate != null ? companyRate.hashCode() : 0);
        result = 31 * result + (orgCompanyCommission != null ? orgCompanyCommission.hashCode() : 0);
        result = 31 * result + (perks != null ? perks.hashCode() : 0);
        result = 31 * result + (reconcil != null ? reconcil.hashCode() : 0);
        result = 31 * result + (recTime != null ? recTime.hashCode() : 0);
        result = 31 * result + (merchantCode != null ? merchantCode.hashCode() : 0);
        result = 31 * result + (cpicId != null ? cpicId.hashCode() : 0);
        result = 31 * result + (regionCode != null ? regionCode.hashCode() : 0);
        result = 31 * result + (regionName != null ? regionName.hashCode() : 0);
        result = 31 * result + (orgName != null ? orgName.hashCode() : 0);
        result = 31 * result + (mOrder != null ? mOrder.hashCode() : 0);
        result = 31 * result + (sumInsured != null ? sumInsured.hashCode() : 0);
        result = 31 * result + (distType != null ? distType.hashCode() : 0);
        result = 31 * result + (historyGroupId != null ? historyGroupId.hashCode() : 0);
        result = 31 * result + (merchantSerialNumber != null ? merchantSerialNumber.hashCode() : 0);
        result = 31 * result + (asynState != null ? asynState.hashCode() : 0);
        result = 31 * result + (asynHandleTime != null ? asynHandleTime.hashCode() : 0);
        result = 31 * result + (asynNoticeState != null ? asynNoticeState.hashCode() : 0);
        result = 31 * result + (asynNoticeNum != null ? asynNoticeNum.hashCode() : 0);
        result = 31 * result + (asynNoticeTime != null ? asynNoticeTime.hashCode() : 0);
        return result;
    }
}
