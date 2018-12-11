/**
 * 流量和保险订单结算管理初始化
 */
var FluxInsuranceOrderBalance = {
    id: "FluxInsuranceOrderBalanceTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
FluxInsuranceOrderBalance.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '结算单号', field: 'balanceSerial', visible: true, align: 'center', valign: 'middle'},
            {title: '包含激活码数量', field: 'activateSum', visible: true, align: 'center', valign: 'middle'},
            {title: '订单总价', field: 'price', visible: true, align: 'center', valign: 'middle'},
            {title: '结算条件开始时间', field: 'startTime', visible: true, align: 'center', valign: 'middle'},
            {title: '结算条件结束时间', field: 'endTime', visible: true, align: 'center', valign: 'middle'},
            {title: '结算状态', field: 'balanceStatus', visible: true, align: 'center', valign: 'middle',
                formatter: function(value, row, index) {
                    if(value == '0') {
                        return "未结算";
                    }
                    if(value == '1') {
                        return "应收";
                    }
                    if(value == '2') {
                        return "已收";
                    }
                }}
    ];
};

/**
 * 检查是否选中
 */
FluxInsuranceOrderBalance.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        FluxInsuranceOrderBalance.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加流量和保险订单结算
 */
FluxInsuranceOrderBalance.openAddFluxInsuranceOrderBalance = function () {
    var index = layer.open({
        type: 2,
        title: '添加流量和保险订单结算',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/fluxInsuranceOrderBalance/fluxInsuranceOrderBalance_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看流量和保险订单结算详情
 */
FluxInsuranceOrderBalance.openFluxInsuranceOrderBalanceDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '流量和保险订单结算详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/fluxInsuranceOrderBalance/fluxInsuranceOrderBalance_update/' + FluxInsuranceOrderBalance.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除流量和保险订单结算
 */
FluxInsuranceOrderBalance.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/fluxInsuranceOrderBalance/delete", function (data) {
            Feng.success("删除成功!");
            FluxInsuranceOrderBalance.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("fluxInsuranceOrderBalanceId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询流量和保险订单结算列表
 */
FluxInsuranceOrderBalance.search = function () {
    // var queryData = {};
    // queryData['condition'] = $("#condition").val();
    // FluxInsuranceOrderBalance.table.refresh({query: queryData});

    //初始化时间控件
    var startDateTimePickerEle = $("#startTime-datetimepicker");
    var endDateTimePickerEle = $("#endTime-datetimepicker");
    var balanceStatusEle = $("#balance");
    var defaultColunms = FluxInsuranceOrderBalance.initColumn();
    //$("#resource_table").bootstrapTable('destroy');
    FluxInsuranceOrderBalance.table.clear();
    //var table = new BSTable(ActivateCode.id, "/activateCode/list", defaultColunms);
    var temp = {
        startTime:startDateTimePickerEle.val(),
        endTime:endDateTimePickerEle.val(),
        balanceStatus:balanceStatusEle.val()
    }
    // var queryParams = function(param){
    //     return temp;
    // }
    FluxInsuranceOrderBalance.table.setQueryParams(temp);
    FluxInsuranceOrderBalance.table.setPaginationType("client");
    //ActivateCode.table = table.init();

    // var queryData = {};
    // queryData['condition'] = $("#condition").val();

    FluxInsuranceOrderBalance.table.refresh();
   // ActivateCode.table.refresh();
};

/**
 * 已收操作
 */
FluxInsuranceOrderBalance.received = function () {
    if (this.check()) {
        var temp = {
            balanceSerial: this.seItem.balanceSerial
        };

        //if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/fluxInsuranceOrderBalance/received", function (data) {
            if (data.message) {
                Feng.success(data.message);
            } else {
                Feng.success("操作成功!");
            }
            FluxInsuranceOrderBalance.table.refresh();
        }, function (data) {
            Feng.error("操作失败!" + data.responseJSON.message + "!");
        });
        ajax.setData(temp);
        ajax.start();
    }
    // }
};

$(function () {
    // var defaultColunms = FluxInsuranceOrderBalance.initColumn();
    // var table = new BSTable(FluxInsuranceOrderBalance.id, "/fluxInsuranceOrderBalance/list", defaultColunms);
    // table.setPaginationType("client");
    // FluxInsuranceOrderBalance.table = table.init();


    //初始化时间控件
    var startDateTimePickerEle = $("#startTime-datetimepicker");
    var endDateTimePickerEle = $("#endTime-datetimepicker");
    var balanceStatusEle = $("#balance");

    startDateTimePickerEle.val(DateUtils.dateFormat("yyyy-MM-dd HH:mm:ss",DateUtils.getCurrentMonthFirst()));
    endDateTimePickerEle.val(DateUtils.dateFormat("yyyy-MM-dd HH:mm:ss",DateUtils.getCurrentMonthLast()));

    console.log(DateUtils.dateFormat("yyyy-MM-dd HH:mm:ss",DateUtils.getCurrentMonthFirst()));

    startDateTimePickerEle.datetimepicker({
        format: 'yyyy-mm-dd hh:ii:ss'
    });

    endDateTimePickerEle.datetimepicker({
        format: 'yyyy-mm-dd hh:ii:ss'
    });

    var defaultColunms = FluxInsuranceOrderBalance.initColumn();
    var table = new BSTable(FluxInsuranceOrderBalance.id, "/fluxInsuranceOrderBalance/list", defaultColunms);
    var temp = {
        startTime:startDateTimePickerEle.val(),
        endTime:endDateTimePickerEle.val(),
        balanceStatus:balanceStatusEle.val()
    }
    table.setQueryParams(temp);
    //table.setQueryParams(queryParams);
    table.setPaginationType("client");
    FluxInsuranceOrderBalance.table = table.init();
});
