/**
 * 管理初始化
 */
var PProductExpandGroup = {
    id: "PProductExpandGroupTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
PProductExpandGroup.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '产品组合表ID', field: 'pgId', visible: true, align: 'center', valign: 'middle'},
            {title: '主产品编号', field: 'masterPid', visible: true, align: 'center', valign: 'middle'},
            {title: '附产品编号', field: 'attachPid', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
PProductExpandGroup.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        PProductExpandGroup.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
PProductExpandGroup.openAddPProductExpandGroup = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/pProductExpandGroup/pProductExpandGroup_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
PProductExpandGroup.openPProductExpandGroupDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/pProductExpandGroup/pProductExpandGroup_update/' + PProductExpandGroup.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
PProductExpandGroup.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/pProductExpandGroup/delete", function (data) {
            Feng.success("删除成功!");
            PProductExpandGroup.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("pProductExpandGroupId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询列表
 */
PProductExpandGroup.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    PProductExpandGroup.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = PProductExpandGroup.initColumn();
    var table = new BSTable(PProductExpandGroup.id, "/pProductExpandGroup/list", defaultColunms);
    table.setPaginationType("client");
    PProductExpandGroup.table = table.init();
});
