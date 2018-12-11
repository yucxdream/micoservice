/**
 * 初始化激活码管理详情对话框
 */
var ActivateCodeInfoDlg = {
    activateCodeInfoData : {}
};

/**
 * 清除数据
 */
ActivateCodeInfoDlg.clearData = function() {
    this.activateCodeInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ActivateCodeInfoDlg.set = function(key, val) {
    this.activateCodeInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ActivateCodeInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ActivateCodeInfoDlg.close = function() {
    parent.layer.close(window.parent.ActivateCode.layerIndex);
}

/**
 * 收集数据
 */
ActivateCodeInfoDlg.collectData = function() {
    this
    .set('activateCode')
    .set('scCode')
    .set('bpId')
    .set('used')
    .set('createTime')
    .set('disabled')
    .set('useTime');
}

/**
 * 提交添加
 */
ActivateCodeInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/activateCode/add", function(data){
        Feng.success("添加成功!");
        window.parent.ActivateCode.table.refresh();
        ActivateCodeInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    //console.log($("#count").val() +$("#bpId").val())
    var activateCodeInfoData = {
        "count":$("#count").val(),
        "bpId":$("#bpId").val()
    }
    // $.ajax({
    //     url:Feng.ctxPath + "/activateCode/add",
    //     type:"post",
    //     date:{
    //         "count":$("#count").val(),
    //         "bpId":$("#bpId").val()
    //     },
    //     success:function(date) {
    //         console.log(date);
    //     }
    // })
    
    ajax.set(activateCodeInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ActivateCodeInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/activateCode/update", function(data){
        Feng.success("修改成功!");
        window.parent.ActivateCode.table.refresh();
        ActivateCodeInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.activateCodeInfoData);
    ajax.start();
}

$(function() {
    //alert("hello")
    var insurancePriceEle = $("#insurancePrice")
    var insuranceNameEle = $("#insuranceName")
    var fluxPriceEle = $("#fluxPrice");
    var fluxNameEle = $("#fluxName");
    var fluxDescriptionEle = $("#fluxDescription");
    var dataObject
    var currentDate
    var ajax = new $ax(Feng.ctxPath + "/product/channelProductList", function(data){
        //debugger
        dataObject = data
        //渲染页面数据
        var product = $("#bpId")
        for(var i = 0; i < data.length; i ++) {
            product.append("<option value='"+data[i].mainProduct.bpId+"'>"+data[i].mainProduct.name+"</option>")
        }
        currentDate = dataObject[0];
        update();

        product.change(function(){
             currentDate = dataObject[$("#bpId>option:selected").index()];
             update();
        })

        function update() {
            insurancePriceEle.text(currentDate.productGroupList[0].price+"元")
            insuranceNameEle.text(currentDate.productGroupList[0].name)
            fluxPriceEle.text(currentDate.productGroupList[1].price+"元")
            fluxNameEle.text(currentDate.productGroupList[1].name)
        }

        console.log($("#bpId"))
        console.log(data)
        Feng.success("数据获取成功!");
        //window.parent.ActivateCode.table.refresh();
        //ActivateCodeInfoDlg.close();
    },function(data){
        Feng.error("数据获取失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.activateCodeInfoData);
    ajax.start();
});
