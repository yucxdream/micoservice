/**
 * 用户管理管理初始化
 */
var OrgUser = {
    id: "OrgUserTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
OrgUser.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '用户账号', field: 'userAccount', visible: true, align: 'center', valign: 'middle'},
            {title: '用户密码', field: 'pwd', visible: true, align: 'center', valign: 'middle'},
            {title: '所属公司业务员工号', field: 'cpCode', visible: true, align: 'center', valign: 'middle'},
            {title: '上级用户账号', field: 'superUserAccount', visible: true, align: 'center', valign: 'middle'},
            {title: '上级用户名称', field: 'superPwd', visible: true, align: 'center', valign: 'middle'},
            {title: '上级所属公司业务员工号2', field: 'superCpCode', visible: true, align: 'center', valign: 'middle'},
            {title: '微信OPEN_ID', field: 'wxOpenId', visible: true, align: 'center', valign: 'middle'},
            {title: '经济公司代码', field: 'cpId', visible: true, align: 'center', valign: 'middle'},
            {title: '经纪公司名称', field: 'cpName', visible: true, align: 'center', valign: 'middle'},
            {title: '组织机构代码', field: 'orgCode', visible: true, align: 'center', valign: 'middle'},
            {title: '销售渠道代码', field: 'scCode', visible: true, align: 'center', valign: 'middle'},
            {title: '太保组_经济公司代码', field: 'oBCpId', visible: true, align: 'center', valign: 'middle'},
            {title: '组织机构名称', field: 'orgName', visible: true, align: 'center', valign: 'middle'},
            {title: '名称', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '身份证号', field: 'idNum', visible: true, align: 'center', valign: 'middle'},
            {title: '手机号', field: 'phone', visible: true, align: 'center', valign: 'middle'},
            {title: '微信号', field: 'weixin', visible: true, align: 'center', valign: 'middle'},
            {title: '支付宝', field: 'zhifubao', visible: true, align: 'center', valign: 'middle'},
            {title: '保险牌照(0 有 1 无)', field: 'isLicence', visible: true, align: 'center', valign: 'middle'},
            {title: '注册时间', field: 'regTime', visible: true, align: 'center', valign: 'middle'},
            {title: '介绍账号', field: 'introduceAccount', visible: true, align: 'center', valign: 'middle'},
            {title: '最后登录时间', field: 'lastLoginTime', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '更新时间', field: 'updateTime', visible: true, align: 'center', valign: 'middle'},
            {title: '正式员工(0是1否)', field: 'isStaff', visible: true, align: 'center', valign: 'middle'},
            {title: 'token', field: 'token', visible: true, align: 'center', valign: 'middle'},
            {title: '头像', field: 'img', visible: true, align: 'center', valign: 'middle'},
            {title: '类型(0 太保 1 经纪公司)', field: 'column28', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
OrgUser.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        OrgUser.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加用户管理
 */
OrgUser.openAddOrgUser = function () {
    var index = layer.open({
        type: 2,
        title: '添加用户管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/orgUser/orgUser_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看用户管理详情
 */
OrgUser.openOrgUserDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '用户管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/orgUser/orgUser_update/' + OrgUser.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除用户管理
 */
OrgUser.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/orgUser/delete", function (data) {
            Feng.success("删除成功!");
            OrgUser.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("orgUserId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询用户管理列表
 */
OrgUser.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    OrgUser.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = OrgUser.initColumn();
    var table = new BSTable(OrgUser.id, "/orgUser/list", defaultColunms);
    table.setPaginationType("client");
    OrgUser.table = table.init();
});
