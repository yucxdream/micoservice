/**
 * 初始化渠道管理详情对话框
 */
var OCompanyInfoDlg = {
    oCompanyInfoData : {}
};

/**
 * 清除数据
 */
OCompanyInfoDlg.clearData = function() {
    this.oCompanyInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
OCompanyInfoDlg.set = function(key, val) {
    this.oCompanyInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
OCompanyInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
OCompanyInfoDlg.close = function() {
    parent.layer.close(window.parent.OCompany.layerIndex);
}

/**
 * 收集数据
 */
OCompanyInfoDlg.collectData = function() {
    this
    .set('cpId')
    .set('name')
    .set('supCpId')
    .set('supName')
    .set('address')
    .set('totalPeople')
    .set('quality')
    .set('totalRegister')
    .set('legalPerson')
    .set('technology')
    .set('technologyPhone')
    .set('business')
    .set('businessPhone')
    .set('createTime')
    .set('updateTime')
    .set('type')
    .set('merchantCode')
    .set('secretKey')
    .set('publicKey')
    .set('privateKey')
    .set('isRecon')
    .set('reconFilePath');
}

/**
 * 提交添加
 */
OCompanyInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/oCompany/add", function(data){
        Feng.success("添加成功!");
        window.parent.OCompany.table.refresh();
        OCompanyInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.oCompanyInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
OCompanyInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/oCompany/update", function(data){
        Feng.success("修改成功!");
        window.parent.OCompany.table.refresh();
        OCompanyInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.oCompanyInfoData);
    ajax.start();
}

$(function() {

});
