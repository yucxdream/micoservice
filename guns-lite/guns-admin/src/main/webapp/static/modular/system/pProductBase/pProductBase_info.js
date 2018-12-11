/**
 * 初始化产品管理详情对话框
 */
var PProductBaseInfoDlg = {
    pProductBaseInfoData : {}
};

/**
 * 清除数据
 */
PProductBaseInfoDlg.clearData = function() {
    this.pProductBaseInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
PProductBaseInfoDlg.set = function(key, val) {
    this.pProductBaseInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
PProductBaseInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
PProductBaseInfoDlg.close = function() {
    parent.layer.close(window.parent.PProductBase.layerIndex);
}

/**
 * 收集数据
 */
PProductBaseInfoDlg.collectData = function() {
    this
    .set('bpId')
    .set('ptCode')
    .set('psCode')
    .set('sCode')
    .set('sName')
    .set('name')
    .set('insurePath')
    .set('viewPath')
    .set('cpId')
    .set('pOrder')
    .set('ntext')
    .set('listImg')
    .set('titleImg')
    .set('introduceImg')
    .set('createTime')
    .set('updateTime')
    .set('price')
    .set('sellPrice')
    .set('maxCommissionRate')
    .set('b2biAccount')
    .set('b2biPwd')
    .set('isDisplay')
    .set('branch')
    .set('subbranch')
    .set('productType')
    .set('derivedProduct');
}

/**
 * 提交添加
 */
PProductBaseInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/pProductBase/add", function(data){
        Feng.success("添加成功!");
        window.parent.PProductBase.table.refresh();
        PProductBaseInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.pProductBaseInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
PProductBaseInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/pProductBase/update", function(data){
        Feng.success("修改成功!");
        window.parent.PProductBase.table.refresh();
        PProductBaseInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.pProductBaseInfoData);
    ajax.start();
}

$(function() {

});
