/**
 * 渠道机构管理管理初始化
 */
var OOrganization = {
    id: "OOrganizationTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
OOrganization.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '组织机构代码', field: 'orgCode', visible: true, align: 'center', valign: 'middle'},
            {title: '经济公司代码', field: 'cpId', visible: true, align: 'center', valign: 'middle'},
            {title: '组织机构名称', field: 'orgName', visible: true, align: 'center', valign: 'middle'},
            {title: '组织机构节点', field: 'orgNode', visible: true, align: 'center', valign: 'middle'},
            {title: '备注', field: 'remark', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '更新时间', field: 'updateTime', visible: true, align: 'center', valign: 'middle'},
            {title: '类型(0 保险公司 1 经纪公司)', field: 'type', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
OOrganization.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        OOrganization.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加渠道机构管理
 */
OOrganization.openAddOOrganization = function () {
    var index = layer.open({
        type: 2,
        title: '添加渠道机构管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/oOrganization/oOrganization_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看渠道机构管理详情
 */
OOrganization.openOOrganizationDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '渠道机构管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/oOrganization/oOrganization_update/' + OOrganization.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除渠道机构管理
 */
OOrganization.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/oOrganization/delete", function (data) {
            Feng.success("删除成功!");
            OOrganization.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("oOrganizationId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询渠道机构管理列表
 */
OOrganization.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    OOrganization.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = OOrganization.initColumn();
    var table = new BSTable(OOrganization.id, "/oOrganization/list", defaultColunms);
    table.setPaginationType("client");
    OOrganization.table = table.init();
});
