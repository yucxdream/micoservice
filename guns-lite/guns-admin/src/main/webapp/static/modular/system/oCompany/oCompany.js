/**
 * 渠道管理管理初始化
 */
var OCompany = {
    id: "OCompanyTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
OCompany.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '组织代码代码', field: 'cpId', visible: true, align: 'center', valign: 'middle'},
            {title: '组织名称名称', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '上级组织代码', field: 'supCpId', visible: true, align: 'center', valign: 'middle'},
            {title: '上级组织名称', field: 'supName', visible: true, align: 'center', valign: 'middle'},
            {title: '地址', field: 'address', visible: true, align: 'center', valign: 'middle'},
            {title: '公司人数', field: 'totalPeople', visible: true, align: 'center', valign: 'middle'},
            {title: '经济公司资质', field: 'quality', visible: true, align: 'center', valign: 'middle'},
            {title: '系统注册人数', field: 'totalRegister', visible: true, align: 'center', valign: 'middle'},
            {title: '法人', field: 'legalPerson', visible: true, align: 'center', valign: 'middle'},
            {title: '技术负责人', field: 'technology', visible: true, align: 'center', valign: 'middle'},
            {title: '技术负责人电话', field: 'technologyPhone', visible: true, align: 'center', valign: 'middle'},
            {title: '业务负责人', field: 'business', visible: true, align: 'center', valign: 'middle'},
            {title: '业务负责人电话', field: 'businessPhone', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '更新时间', field: 'updateTime', visible: true, align: 'center', valign: 'middle'},
            {title: '类型(0 保险 1 经纪 2商户)', field: 'type', visible: true, align: 'center', valign: 'middle'},
            {title: '商户代码', field: 'merchantCode', visible: true, align: 'center', valign: 'middle'},
            {title: '登录密码', field: 'secretKey', visible: true, align: 'center', valign: 'middle'},
            {title: '公钥(RS232)', field: 'publicKey', visible: true, align: 'center', valign: 'middle'},
            {title: '私钥(RS232)', field: 'privateKey', visible: true, align: 'center', valign: 'middle'},
            {title: '是否对账（0否  1 T+1对账）', field: 'isRecon', visible: true, align: 'center', valign: 'middle'},
            {title: '对账文件生成目录', field: 'reconFilePath', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
OCompany.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        OCompany.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加渠道管理
 */
OCompany.openAddOCompany = function () {
    var index = layer.open({
        type: 2,
        title: '添加渠道管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/oCompany/oCompany_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看渠道管理详情
 */
OCompany.openOCompanyDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '渠道管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/oCompany/oCompany_update/' + OCompany.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除渠道管理
 */
OCompany.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/oCompany/delete", function (data) {
            Feng.success("删除成功!");
            OCompany.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("oCompanyId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询渠道管理列表
 */
OCompany.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    OCompany.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = OCompany.initColumn();
    var table = new BSTable(OCompany.id, "/oCompany/list", defaultColunms);
    table.setPaginationType("client");
    OCompany.table = table.init();
});
