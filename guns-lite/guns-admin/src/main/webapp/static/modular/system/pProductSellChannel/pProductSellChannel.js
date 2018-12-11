/**
 * 销售渠道管理管理初始化
 */
var PProductSellChannel = {
    id: "PProductSellChannelTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
PProductSellChannel.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '销售渠道代码', field: 'scCode', visible: true, align: 'center', valign: 'middle'},
            {title: '经济公司代码', field: 'cpId', visible: true, align: 'center', valign: 'middle'},
            {title: '组织机构代码', field: 'orgCode', visible: true, align: 'center', valign: 'middle'},
            {title: '产品代码', field: 'bpId', visible: true, align: 'center', valign: 'middle'},
            {title: '公司返佣ID', field: 'pcId', visible: true, align: 'center', valign: 'middle'},
            {title: '销售价格', field: 'price', visible: true, align: 'center', valign: 'middle'},
            {title: '是否可降解(0 是 1 不)', field: 'isCutPrice', visible: true, align: 'center', valign: 'middle'},
            {title: '降价比例', field: 'cutPriceRate', visible: true, align: 'center', valign: 'middle'},
            {title: '业务分佣方式(0 比例 1定额)', field: 'commType', visible: true, align: 'center', valign: 'middle'},
            {title: '定额金额', field: 'commQuota', visible: true, align: 'center', valign: 'middle'},
            {title: '定额分配方式(0 销售 1 上级销售 2 渠道 3公司)', field: 'distType', visible: true, align: 'center', valign: 'middle'},
            {title: '上级业务员分佣比例', field: 'superSellerRate', visible: true, align: 'center', valign: 'middle'},
            {title: '预计上级业务员佣金', field: 'superSellerExCommission', visible: true, align: 'center', valign: 'middle'},
            {title: '业务员分佣比例', field: 'sellerRate', visible: true, align: 'center', valign: 'middle'},
            {title: '预计业务员佣金', field: 'sellerExCommission', visible: true, align: 'center', valign: 'middle'},
            {title: '渠道分佣比例', field: 'orgRate', visible: true, align: 'center', valign: 'middle'},
            {title: '预计渠道佣金', field: 'orgExCommission', visible: true, align: 'center', valign: 'middle'},
            {title: '公司分佣比例', field: 'companyRate', visible: true, align: 'center', valign: 'middle'},
            {title: '预计公司佣金', field: 'orgCompanyCommission', visible: true, align: 'center', valign: 'middle'},
            {title: '额外补贴', field: 'perks', visible: true, align: 'center', valign: 'middle'},
            {title: '浮动价格(0:固定价格 1:浮动价格)', field: 'floatPriceFlag', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
PProductSellChannel.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        PProductSellChannel.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加销售渠道管理
 */
PProductSellChannel.openAddPProductSellChannel = function () {
    var index = layer.open({
        type: 2,
        title: '添加销售渠道管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/pProductSellChannel/pProductSellChannel_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看销售渠道管理详情
 */
PProductSellChannel.openPProductSellChannelDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '销售渠道管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/pProductSellChannel/pProductSellChannel_update/' + PProductSellChannel.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除销售渠道管理
 */
PProductSellChannel.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/pProductSellChannel/delete", function (data) {
            Feng.success("删除成功!");
            PProductSellChannel.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("pProductSellChannelId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询销售渠道管理列表
 */
PProductSellChannel.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    PProductSellChannel.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = PProductSellChannel.initColumn();
    var table = new BSTable(PProductSellChannel.id, "/pProductSellChannel/list", defaultColunms);
    table.setPaginationType("client");
    PProductSellChannel.table = table.init();
});
