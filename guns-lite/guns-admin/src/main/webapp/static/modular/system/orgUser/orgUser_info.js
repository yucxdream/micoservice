/**
 * 初始化用户管理详情对话框
 */
var OrgUserInfoDlg = {
    orgUserInfoData : {}
};

/**
 * 清除数据
 */
OrgUserInfoDlg.clearData = function() {
    this.orgUserInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
OrgUserInfoDlg.set = function(key, val) {
    this.orgUserInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
OrgUserInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
OrgUserInfoDlg.close = function() {
    parent.layer.close(window.parent.OrgUser.layerIndex);
}

/**
 * 收集数据
 */
OrgUserInfoDlg.collectData = function() {
    this
    .set('userAccount')
    .set('pwd')
    .set('cpCode')
    .set('superUserAccount')
    .set('superPwd')
    .set('superCpCode')
    .set('wxOpenId')
    .set('cpId')
    .set('cpName')
    .set('orgCode')
    .set('scCode')
    .set('oBCpId')
    .set('orgName')
    .set('name')
    .set('idNum')
    .set('phone')
    .set('weixin')
    .set('zhifubao')
    .set('isLicence')
    .set('regTime')
    .set('introduceAccount')
    .set('lastLoginTime')
    .set('createTime')
    .set('updateTime')
    .set('isStaff')
    .set('token')
    .set('img')
    .set('column28');
}

/**
 * 提交添加
 */
OrgUserInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/orgUser/add", function(data){
        Feng.success("添加成功!");
        window.parent.OrgUser.table.refresh();
        OrgUserInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.orgUserInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
OrgUserInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/orgUser/update", function(data){
        Feng.success("修改成功!");
        window.parent.OrgUser.table.refresh();
        OrgUserInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.orgUserInfoData);
    ajax.start();
}

$(function() {

});
