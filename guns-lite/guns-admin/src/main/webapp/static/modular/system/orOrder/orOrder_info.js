/**
 * 初始化订单管理详情对话框
 */
var OrOrderInfoDlg = {
    orOrderInfoData : {}
};

/**
 * 清除数据
 */
OrOrderInfoDlg.clearData = function() {
    this.orOrderInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
OrOrderInfoDlg.set = function(key, val) {
    this.orOrderInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
OrOrderInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
OrOrderInfoDlg.close = function() {
    parent.layer.close(window.parent.OrOrder.layerIndex);
}

/**
 * 收集数据
 */
OrOrderInfoDlg.collectData = function() {
    this
    .set('orderId')
    .set('serialNumber')
    .set('applyNo')
    .set('bpId')
    .set('productName')
    .set('sCode')
    .set('sName')
    .set('sellerCpCode')
    .set('sellerAccount')
    .set('reconcilCode')
    .set('ogId')
    .set('cpId')
    .set('productGroupCode')
    .set('psCode')
    .set('psName')
    .set('proudctGroupName')
    .set('sellerName')
    .set('sellerRate')
    .set('sellerCommission')
    .set('supperSellerCpCode')
    .set('supperSellerAccount')
    .set('supperSellerName')
    .set('supperSellerRate')
    .set('supperSellerCommission')
    .set('policyNo')
    .set('insuredName')
    .set('insuredId')
    .set('insuredIdType')
    .set('holderName')
    .set('holderId')
    .set('holderIdType')
    .set('holderPhone')
    .set('insuredPhone')
    .set('relation')
    .set('policySDate')
    .set('policySTime')
    .set('policyEDate')
    .set('policyETime')
    .set('insureType')
    .set('cTime')
    .set('uTime')
    .set('payTime')
    .set('payType')
    .set('payFloat')
    .set('payState')
    .set('payEffectLength')
    .set('errorMessage')
    .set('state')
    .set('type')
    .set('price')
    .set('sellPrice')
    .set('profit')
    .set('commissionRate')
    .set('totleCommission')
    .set('sellerCpName')
    .set('orgCode')
    .set('sellerOrgName')
    .set('isCutPrice')
    .set('cutPriceRate')
    .set('commType')
    .set('commQuota')
    .set('orgRate')
    .set('orgExCommission')
    .set('companyRate')
    .set('orgCompanyCommission')
    .set('perks')
    .set('reconcil')
    .set('recTime')
    .set('merchantCode')
    .set('cpicId')
    .set('regionCode')
    .set('regionName')
    .set('orgName')
    .set('mOrder')
    .set('sumInsured')
    .set('distType')
    .set('historyGroupId')
    .set('orderExtraInfoId')
    .set('merchantSerialNumber')
    .set('asynState')
    .set('asynHandleTime')
    .set('asynNoticeState')
    .set('asynNoticeNum')
    .set('asynNoticeTime');
}

/**
 * 提交添加
 */
OrOrderInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/orOrder/add", function(data){
        Feng.success("添加成功!");
        window.parent.OrOrder.table.refresh();
        OrOrderInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.orOrderInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
OrOrderInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/orOrder/update", function(data){
        Feng.success("修改成功!");
        window.parent.OrOrder.table.refresh();
        OrOrderInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.orOrderInfoData);
    ajax.start();
}

$(function() {

});
