/**
 * 初始化流量和保险订单结算详情对话框
 */
var FluxInsuranceOrderBalanceInfoDlg = {
    fluxInsuranceOrderBalanceInfoData : {}
};

/**
 * 清除数据
 */
FluxInsuranceOrderBalanceInfoDlg.clearData = function() {
    this.fluxInsuranceOrderBalanceInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
FluxInsuranceOrderBalanceInfoDlg.set = function(key, val) {
    this.fluxInsuranceOrderBalanceInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
FluxInsuranceOrderBalanceInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
FluxInsuranceOrderBalanceInfoDlg.close = function() {
    parent.layer.close(window.parent.FluxInsuranceOrderBalance.layerIndex);
}

/**
 * 收集数据
 */
FluxInsuranceOrderBalanceInfoDlg.collectData = function() {
    this
    .set('bid')
    .set('balanceSerial')
    .set('price')
    .set('startTime')
    .set('endTime')
    .set('balanceStatus');
}

/**
 * 提交添加
 */
FluxInsuranceOrderBalanceInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/fluxInsuranceOrderBalance/add", function(data){
        Feng.success("添加成功!");
        window.parent.FluxInsuranceOrderBalance.table.refresh();
        FluxInsuranceOrderBalanceInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.fluxInsuranceOrderBalanceInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
FluxInsuranceOrderBalanceInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/fluxInsuranceOrderBalance/update", function(data){
        Feng.success("修改成功!");
        window.parent.FluxInsuranceOrderBalance.table.refresh();
        FluxInsuranceOrderBalanceInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.fluxInsuranceOrderBalanceInfoData);
    ajax.start();
}

$(function() {

});
