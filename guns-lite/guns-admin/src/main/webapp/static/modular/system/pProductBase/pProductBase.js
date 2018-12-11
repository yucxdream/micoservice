/**
 * 产品管理管理初始化
 */
var PProductBase = {
    id: "PProductBaseTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
PProductBase.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '产品代码', field: 'bpId', visible: true, align: 'center', valign: 'middle'},
            {title: '类型代码', field: 'ptCode', visible: true, align: 'center', valign: 'middle'},
            {title: '来源代码', field: 'psCode', visible: true, align: 'center', valign: 'middle'},
            {title: '源产品代码', field: 'sCode', visible: true, align: 'center', valign: 'middle'},
            {title: '源产品名称', field: 'sName', visible: true, align: 'center', valign: 'middle'},
            {title: '平台产品名称', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '核保页面路径', field: 'insurePath', visible: true, align: 'center', valign: 'middle'},
            {title: '产品展示路径', field: 'viewPath', visible: true, align: 'center', valign: 'middle'},
            {title: '太保组织机构', field: 'cpId', visible: true, align: 'center', valign: 'middle'},
            {title: '排序', field: 'pOrder', visible: true, align: 'center', valign: 'middle'},
            {title: '描述', field: 'ntext', visible: true, align: 'center', valign: 'middle'},
            {title: '列表图片', field: 'listImg', visible: true, align: 'center', valign: 'middle'},
            {title: '抬头图片', field: 'titleImg', visible: true, align: 'center', valign: 'middle'},
            {title: '产品特色图片', field: 'introduceImg', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '更新时间', field: 'updateTime', visible: true, align: 'center', valign: 'middle'},
            {title: '价格', field: 'price', visible: true, align: 'center', valign: 'middle'},
            {title: '销售价格', field: 'sellPrice', visible: true, align: 'center', valign: 'middle'},
            {title: '最高佣金比例', field: 'maxCommissionRate', visible: true, align: 'center', valign: 'middle'},
            {title: 'B2BI账号', field: 'b2biAccount', visible: true, align: 'center', valign: 'middle'},
            {title: 'B2BI密码', field: 'b2biPwd', visible: true, align: 'center', valign: 'middle'},
            {title: '前台是否显示(0:显示 1 不现实)', field: 'isDisplay', visible: true, align: 'center', valign: 'middle'},
            {title: '分公司', field: 'branch', visible: true, align: 'center', valign: 'middle'},
            {title: '中支公司', field: 'subbranch', visible: true, align: 'center', valign: 'middle'},
            {title: '产品类型(0 单产品 1 组合产)', field: 'productType', visible: true, align: 'center', valign: 'middle'},
            {title: '派生产品(0 保险公司直接提供 1派生产品)', field: 'derivedProduct', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
PProductBase.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        PProductBase.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加产品管理
 */
PProductBase.openAddPProductBase = function () {
    var index = layer.open({
        type: 2,
        title: '添加产品管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/pProductBase/pProductBase_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看产品管理详情
 */
PProductBase.openPProductBaseDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '产品管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/pProductBase/pProductBase_update/' + PProductBase.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除产品管理
 */
PProductBase.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/pProductBase/delete", function (data) {
            Feng.success("删除成功!");
            PProductBase.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("pProductBaseId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询产品管理列表
 */
PProductBase.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    PProductBase.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = PProductBase.initColumn();
    var table = new BSTable(PProductBase.id, "/pProductBase/list", defaultColunms);
    table.setPaginationType("client");
    PProductBase.table = table.init();
});
