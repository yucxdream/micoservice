/**
 * 初始化渠道机构管理详情对话框
 */
var OOrganizationInfoDlg = {
    oOrganizationInfoData : {}
};

/**
 * 清除数据
 */
OOrganizationInfoDlg.clearData = function() {
    this.oOrganizationInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
OOrganizationInfoDlg.set = function(key, val) {
    this.oOrganizationInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
OOrganizationInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
OOrganizationInfoDlg.close = function() {
    parent.layer.close(window.parent.OOrganization.layerIndex);
}

/**
 * 收集数据
 */
OOrganizationInfoDlg.collectData = function() {
    this
    .set('orgCode')
    .set('cpId')
    .set('orgName')
    .set('orgNode')
    .set('remark')
    .set('createTime')
    .set('updateTime')
    .set('type');
}

/**
 * 提交添加
 */
OOrganizationInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/oOrganization/add", function(data){
        Feng.success("添加成功!");
        window.parent.OOrganization.table.refresh();
        OOrganizationInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.oOrganizationInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
OOrganizationInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/oOrganization/update", function(data){
        Feng.success("修改成功!");
        window.parent.OOrganization.table.refresh();
        OOrganizationInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.oOrganizationInfoData);
    ajax.start();
}

$(function() {

});
