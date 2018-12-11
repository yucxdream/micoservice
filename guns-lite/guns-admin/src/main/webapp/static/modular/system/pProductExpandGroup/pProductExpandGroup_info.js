/**
 * 初始化详情对话框
 */
var PProductExpandGroupInfoDlg = {
    pProductExpandGroupInfoData : {}
};

/**
 * 清除数据
 */
PProductExpandGroupInfoDlg.clearData = function() {
    this.pProductExpandGroupInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
PProductExpandGroupInfoDlg.set = function(key, val) {
    this.pProductExpandGroupInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
PProductExpandGroupInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
PProductExpandGroupInfoDlg.close = function() {
    parent.layer.close(window.parent.PProductExpandGroup.layerIndex);
}

/**
 * 收集数据
 */
PProductExpandGroupInfoDlg.collectData = function() {
    this
    .set('pgId')
    .set('masterPid')
    .set('attachPid');
}

/**
 * 提交添加
 */
PProductExpandGroupInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/pProductExpandGroup/add", function(data){
        Feng.success("添加成功!");
        window.parent.PProductExpandGroup.table.refresh();
        PProductExpandGroupInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.pProductExpandGroupInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
PProductExpandGroupInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/pProductExpandGroup/update", function(data){
        Feng.success("修改成功!");
        window.parent.PProductExpandGroup.table.refresh();
        PProductExpandGroupInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.pProductExpandGroupInfoData);
    ajax.start();
}

$(function() {

});
