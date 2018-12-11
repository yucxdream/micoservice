/**
 * 订单管理管理初始化
 */
var OrOrder = {
    id: "OrOrderTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
OrOrder.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '订单编号', field: 'orderId', visible: true, align: 'center', valign: 'middle'},
            {title: '交易流水号', field: 'serialNumber', visible: true, align: 'center', valign: 'middle'},
            {title: '预校验核保单号', field: 'applyNo', visible: true, align: 'center', valign: 'middle'},
            {title: '产品代码', field: 'bpId', visible: true, align: 'center', valign: 'middle'},
            {title: '产品名称', field: 'productName', visible: true, align: 'center', valign: 'middle'},
            {title: '源产品代码', field: 'sCode', visible: true, align: 'center', valign: 'middle'},
            {title: '源产品名称', field: 'sName', visible: true, align: 'center', valign: 'middle'},
            {title: '销售公司工号', field: 'sellerCpCode', visible: true, align: 'center', valign: 'middle'},
            {title: '销售账号', field: 'sellerAccount', visible: true, align: 'center', valign: 'middle'},
            {title: '对账单编号', field: 'reconcilCode', visible: true, align: 'center', valign: 'middle'},
            {title: '订单组编号', field: 'ogId', visible: true, align: 'center', valign: 'middle'},
            {title: '经济公司代码', field: 'cpId', visible: true, align: 'center', valign: 'middle'},
            {title: '产品组代码', field: 'productGroupCode', visible: true, align: 'center', valign: 'middle'},
            {title: '来源代码', field: 'psCode', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'psName', visible: true, align: 'center', valign: 'middle'},
            {title: '产品组名称', field: 'proudctGroupName', visible: true, align: 'center', valign: 'middle'},
            {title: '销售姓名', field: 'sellerName', visible: true, align: 'center', valign: 'middle'},
            {title: '销售分佣比例', field: 'sellerRate', visible: true, align: 'center', valign: 'middle'},
            {title: '销售佣金', field: 'sellerCommission', visible: true, align: 'center', valign: 'middle'},
            {title: '上级销售公司工号', field: 'supperSellerCpCode', visible: true, align: 'center', valign: 'middle'},
            {title: '上级销售账号', field: 'supperSellerAccount', visible: true, align: 'center', valign: 'middle'},
            {title: '上级销售名称', field: 'supperSellerName', visible: true, align: 'center', valign: 'middle'},
            {title: '上级销售分佣比例', field: 'supperSellerRate', visible: true, align: 'center', valign: 'middle'},
            {title: '上级销售佣金', field: 'supperSellerCommission', visible: true, align: 'center', valign: 'middle'},
            {title: '保单号', field: 'policyNo', visible: true, align: 'center', valign: 'middle'},
            {title: '被保人姓名', field: 'insuredName', visible: true, align: 'center', valign: 'middle'},
            {title: '被保人证件号码', field: 'insuredId', visible: true, align: 'center', valign: 'middle'},
            {title: '被保人证件类型', field: 'insuredIdType', visible: true, align: 'center', valign: 'middle'},
            {title: '投保人姓名', field: 'holderName', visible: true, align: 'center', valign: 'middle'},
            {title: '投保人证件号码', field: 'holderId', visible: true, align: 'center', valign: 'middle'},
            {title: '投保人证件类型', field: 'holderIdType', visible: true, align: 'center', valign: 'middle'},
            {title: '投保人手机号', field: 'holderPhone', visible: true, align: 'center', valign: 'middle'},
            {title: '被保人手机号', field: 'insuredPhone', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'relation', visible: true, align: 'center', valign: 'middle'},
            {title: '客户传入的保险起期', field: 'policySDate', visible: true, align: 'center', valign: 'middle'},
            {title: '保险公司返回的保险起期', field: 'policySTime', visible: true, align: 'center', valign: 'middle'},
            {title: '客户传入的保险止期', field: 'policyEDate', visible: true, align: 'center', valign: 'middle'},
            {title: '保险公司返回的保险起期', field: 'policyETime', visible: true, align: 'center', valign: 'middle'},
            {title: '投保类型(0 新保 1续保)', field: 'insureType', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'cTime', visible: true, align: 'center', valign: 'middle'},
            {title: '修改时间', field: 'uTime', visible: true, align: 'center', valign: 'middle'},
            {title: '支付时间', field: 'payTime', visible: true, align: 'center', valign: 'middle'},
            {title: '支付方式(0 支付宝 1银联  2 微信)', field: 'payType', visible: true, align: 'center', valign: 'middle'},
            {title: '支付流水号', field: 'payFloat', visible: true, align: 'center', valign: 'middle'},
            {title: '支付状态(0未支付 1 支付成功 2支付失败)', field: 'payState', visible: true, align: 'center', valign: 'middle'},
            {title: '有效时长', field: 'payEffectLength', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'errorMessage', visible: true, align: 'center', valign: 'middle'},
            {title: '状态(0 创建 1核保 2 支付 3 生效 4退保)', field: 'state', visible: true, align: 'center', valign: 'middle'},
            {title: '类型(0 保险 1 其他)', field: 'type', visible: true, align: 'center', valign: 'middle'},
            {title: '产品定价', field: 'price', visible: true, align: 'center', valign: 'middle'},
            {title: '销售价格', field: 'sellPrice', visible: true, align: 'center', valign: 'middle'},
            {title: '利润', field: 'profit', visible: true, align: 'center', valign: 'middle'},
            {title: '最高佣金比例', field: 'commissionRate', visible: true, align: 'center', valign: 'middle'},
            {title: '总分佣金额', field: 'totleCommission', visible: true, align: 'center', valign: 'middle'},
            {title: '经济公司名称', field: 'sellerCpName', visible: true, align: 'center', valign: 'middle'},
            {title: '组织机构代码', field: 'orgCode', visible: true, align: 'center', valign: 'middle'},
            {title: '组织机构名称', field: 'sellerOrgName', visible: true, align: 'center', valign: 'middle'},
            {title: '是否可降解(0 是 1 不)', field: 'isCutPrice', visible: true, align: 'center', valign: 'middle'},
            {title: '降价比例', field: 'cutPriceRate', visible: true, align: 'center', valign: 'middle'},
            {title: '业务分佣方式(0 比例 1定额)', field: 'commType', visible: true, align: 'center', valign: 'middle'},
            {title: '定额金额', field: 'commQuota', visible: true, align: 'center', valign: 'middle'},
            {title: '渠道分佣比例', field: 'orgRate', visible: true, align: 'center', valign: 'middle'},
            {title: '实际渠道佣金', field: 'orgExCommission', visible: true, align: 'center', valign: 'middle'},
            {title: '公司分佣比例', field: 'companyRate', visible: true, align: 'center', valign: 'middle'},
            {title: '实际公司佣金', field: 'orgCompanyCommission', visible: true, align: 'center', valign: 'middle'},
            {title: '额外补贴', field: 'perks', visible: true, align: 'center', valign: 'middle'},
            {title: '产品方对账结果(0 未对账 1 对账 2失败 )', field: 'reconcil', visible: true, align: 'center', valign: 'middle'},
            {title: '对账时间', field: 'recTime', visible: true, align: 'center', valign: 'middle'},
            {title: '商户代码', field: 'merchantCode', visible: true, align: 'center', valign: 'middle'},
            {title: '太保组织机构', field: 'cpicId', visible: true, align: 'center', valign: 'middle'},
            {title: '区域代码', field: 'regionCode', visible: true, align: 'center', valign: 'middle'},
            {title: '区域名称', field: 'regionName', visible: true, align: 'center', valign: 'middle'},
            {title: '保险公司组织机构名称', field: 'orgName', visible: true, align: 'center', valign: 'middle'},
            {title: '商户订单号', field: 'mOrder', visible: true, align: 'center', valign: 'middle'},
            {title: '保额', field: 'sumInsured', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'distType', visible: true, align: 'center', valign: 'middle'},
            {title: '历史订单组编号(|分割)', field: 'historyGroupId', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'orderExtraInfoId', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'merchantSerialNumber', visible: true, align: 'center', valign: 'middle'},
            {title: '异步处理状态(0待处理 1已处理 2交易成功 3交易失败)', field: 'asynState', visible: true, align: 'center', valign: 'middle'},
            {title: '异步处理时间', field: 'asynHandleTime', visible: true, align: 'center', valign: 'middle'},
            {title: '异步回调状态(0未通知 1已通知)', field: 'asynNoticeState', visible: true, align: 'center', valign: 'middle'},
            {title: '异步回调次数(最多5次)', field: 'asynNoticeNum', visible: true, align: 'center', valign: 'middle'},
            {title: '异步回调最后时间', field: 'asynNoticeTime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
OrOrder.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        OrOrder.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加订单管理
 */
OrOrder.openAddOrOrder = function () {
    var index = layer.open({
        type: 2,
        title: '添加订单管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/orOrder/orOrder_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看订单管理详情
 */
OrOrder.openOrOrderDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '订单管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/orOrder/orOrder_update/' + OrOrder.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除订单管理
 */
OrOrder.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/orOrder/delete", function (data) {
            Feng.success("删除成功!");
            OrOrder.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("orOrderId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询订单管理列表
 */
OrOrder.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    OrOrder.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = OrOrder.initColumn();
    var table = new BSTable(OrOrder.id, "/orOrder/list", defaultColunms);
    table.setPaginationType("client");
    OrOrder.table = table.init();
});
