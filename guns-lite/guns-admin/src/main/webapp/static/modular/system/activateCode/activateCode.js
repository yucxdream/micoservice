//初始化时间控件
var startDateTimePickerEle = $("#startTime-datetimepicker");
var endDateTimePickerEle = $("#endTime-datetimepicker");
var usedStatusEle = $("#used");
var balanceStatusEle = $("#balance");
var balanceSerialEle = $("#balanceSerial");
/**
 * 激活码管理管理初始化
 */
var ActivateCode = {
    id: "ActivateCodeTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
ActivateCode.initColumn = function () {
    return [
        {field: 'selectItem', select: true, visible: false},
            {title: '激活码兼主键', field: 'activateCode', visible: true, align: 'center', valign: 'middle'},
            {title: '产品代码', field: 'bpId', visible: true, align: 'center', valign: 'middle'},
            {title: '产品名称', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '是否被使用', field: 'used', visible: true, align: 'center', valign: 'middle',
                formatter: function(value, row, index) {
                    if(value == '0') {
                        return "<span style='color:#8eee70'>未使用</span>";
                    }
                    if(value == '1') {
                        return "<span style='color:#ff1236'>已使用</span>";
                    }
                }},
            {title: '生成时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '使用时间', field: 'useTime', visible: true, align: 'center', valign: 'middle'},
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
                }},
        {title: '结算单号', field: 'balanceSerial', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
ActivateCode.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        ActivateCode.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加激活码管理
 */
ActivateCode.openAddActivateCode = function () {
    var index = layer.open({
        type: 2,
        title: '添加激活码管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/activateCode/activateCode_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看激活码管理详情
 */
ActivateCode.openActivateCodeDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '激活码管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/activateCode/activateCode_update/' + ActivateCode.seItem.activateCode
        });
        this.layerIndex = index;
    }
};

/**
 * 删除激活码管理
 */
ActivateCode.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/activateCode/delete", function (data) {
            Feng.success("删除成功!");
            ActivateCode.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("activateCodeId",this.seItem.activateCode);
        ajax.start();
    }
};

/**
 * 查询激活码管理列表
 */
ActivateCode.search = function () {
    console.log(usedStatusEle.val())
    //debugger
    var defaultColunms = ActivateCode.initColumn();
    //$("#resource_table").bootstrapTable('destroy');
    ActivateCode.table.clear();
    //var table = new BSTable(ActivateCode.id, "/activateCode/list", defaultColunms);
    var temp = {
        startTime:startDateTimePickerEle.val(),
        endTime:endDateTimePickerEle.val(),
        used:usedStatusEle.val(),
        balanceStatus:balanceStatusEle.val(),
        balanceSerial:balanceSerialEle.val()
    }
    // var queryParams = function(param){
    //     return temp;
    // }
    ActivateCode.table.setQueryParams(temp);
    ActivateCode.table.setPaginationType("client");
    //ActivateCode.table = table.init();

    // var queryData = {};
    // queryData['condition'] = $("#condition").val();

    ActivateCode.table.refresh();
};

/**
 * 激活码结算
 */
ActivateCode.balance = function () {
    console.log($("#startTime-datetimepicker").data("datetimepicker").getDate());

    var temp = {
        startTime:startDateTimePickerEle.val(),
        endTime:endDateTimePickerEle.val()
    };

    //if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/activateCode/balance", function (data) {
            if(data.message){
                Feng.success(data.message);
            } else {
                Feng.success("结算成功!");
            }
            ActivateCode.table.refresh();
        }, function (data) {
            Feng.error("结算失败!" + data.responseJSON.message + "!");
        });
        ajax.setData(temp);
        ajax.start();
   // }
};

/**
 * 下载激活码
 */
ActivateCode.generateXls = function () {
    if($("#ActivateCodeTable > tbody > tr").length > 1) {
        var temp = {
            startTime:startDateTimePickerEle.val(),
            endTime:endDateTimePickerEle.val(),
            used:usedStatusEle.val(),
            balanceStatus:balanceStatusEle.val(),
            balanceSerial:balanceSerialEle.val()
        }
        var params = '';
        Object.keys(temp).forEach(function(key){
            console.log(key,temp[key]);
            params += key+"="+temp[key]+"&";
        });
        params = params.substring(0, params.length - 1);
        console.log(params)
        window.location.href = Feng.ctxPath + "/activateCode/generateXls?"+params;
    } else {
        Feng.error("当前没有查询数据,无法下载!");
    }
}

$(function () {
    startDateTimePickerEle.val(DateUtils.dateFormat("yyyy-MM-dd HH:mm:ss",DateUtils.getCurrentMonthFirst()));
    endDateTimePickerEle.val(DateUtils.dateFormat("yyyy-MM-dd HH:mm:ss",DateUtils.getCurrentMonthLast()));

    console.log(DateUtils.dateFormat("yyyy-MM-dd HH:mm:ss",DateUtils.getCurrentMonthFirst()));

    startDateTimePickerEle.datetimepicker({
        format: 'yyyy-mm-dd hh:ii:ss'
    });

    endDateTimePickerEle.datetimepicker({
        format: 'yyyy-mm-dd hh:ii:ss'
    });

    var defaultColunms = ActivateCode.initColumn();
    var table = new BSTable(ActivateCode.id, "/activateCode/list", defaultColunms);
    var temp = {
        startTime:startDateTimePickerEle.val(),
        endTime:endDateTimePickerEle.val(),
        used:usedStatusEle.val(),
        balanceStatus:balanceStatusEle.val(),
        balanceSerial:balanceSerialEle.val(),
    }
    //table.set()
    table.setQueryParams(temp);
    //table.setQueryParams(queryParams);
    table.setPaginationType("client");
    ActivateCode.table = table.init();
});




