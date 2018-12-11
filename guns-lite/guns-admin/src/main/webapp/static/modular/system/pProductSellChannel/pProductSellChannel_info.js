/**
 * 初始化销售渠道管理详情对话框
 */
var PProductSellChannelInfoDlg = {
    pProductSellChannelInfoData : {}
};

/**
 * 清除数据
 */
PProductSellChannelInfoDlg.clearData = function() {
    this.pProductSellChannelInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
PProductSellChannelInfoDlg.set = function(key, val) {
    this.pProductSellChannelInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
PProductSellChannelInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
PProductSellChannelInfoDlg.close = function() {
    parent.layer.close(window.parent.PProductSellChannel.layerIndex);
}

/**
 * 收集数据
 */
PProductSellChannelInfoDlg.collectData = function() {
    this
    .set('scCode')
    .set('cpId')
    .set('orgCode')
    .set('bpId')
    .set('pcId')
    .set('price')
    .set('isCutPrice')
    .set('cutPriceRate')
    .set('commType')
    .set('commQuota')
    .set('distType')
    .set('superSellerRate')
    .set('superSellerExCommission')
    .set('sellerRate')
    .set('sellerExCommission')
    .set('orgRate')
    .set('orgExCommission')
    .set('companyRate')
    .set('orgCompanyCommission')
    .set('perks')
    .set('floatPriceFlag');
}

/**
 * 提交添加
 */
PProductSellChannelInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/pProductSellChannel/add", function(data){
        Feng.success("添加成功!");
        window.parent.PProductSellChannel.table.refresh();
        PProductSellChannelInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.pProductSellChannelInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
PProductSellChannelInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/pProductSellChannel/update", function(data){
        Feng.success("修改成功!");
        window.parent.PProductSellChannel.table.refresh();
        PProductSellChannelInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.pProductSellChannelInfoData);
    ajax.start();
}

$(function() {

});
