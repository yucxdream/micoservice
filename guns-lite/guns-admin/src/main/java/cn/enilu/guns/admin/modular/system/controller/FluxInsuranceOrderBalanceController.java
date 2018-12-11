package cn.enilu.guns.admin.modular.system.controller;

import cn.enilu.guns.admin.core.base.controller.BaseController;
import cn.enilu.guns.bean.core.ShiroUser;
import cn.enilu.guns.bean.domain.ActivateCodeDomain;
import cn.enilu.guns.bean.entity.user.FluxInsuranceOrderBalance;
import cn.enilu.guns.bean.entity.user.OrgUser;
import cn.enilu.guns.service.fluxinsurance.IFluxOrderBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 流量和保险订单结算控制器
 *
 * @author fengshuonan
 * @Date 2018-11-26 13:06:53
 */
@Controller
@RequestMapping("/fluxInsuranceOrderBalance")
public class FluxInsuranceOrderBalanceController extends BaseController {

    @Autowired
    private IFluxOrderBalanceService fluxOrderBalanceService;

    private String PREFIX = "/system/fluxInsuranceOrderBalance/";



    /**
     * 跳转到流量和保险订单结算首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "fluxInsuranceOrderBalance.html";
    }

    /**
     * 跳转到添加流量和保险订单结算
     */
    @RequestMapping("/fluxInsuranceOrderBalance_add")
    public String fluxInsuranceOrderBalanceAdd() {
        return PREFIX + "fluxInsuranceOrderBalance_add.html";
    }

    /**
     * 跳转到修改流量和保险订单结算
     */
    @RequestMapping("/fluxInsuranceOrderBalance_update/{fluxInsuranceOrderBalanceId}")
    public String fluxInsuranceOrderBalanceUpdate(@PathVariable Integer fluxInsuranceOrderBalanceId, Model model) {
//        FluxInsuranceOrderBalance fluxInsuranceOrderBalance = fluxInsuranceOrderBalanceService.selectById(fluxInsuranceOrderBalanceId);
//        model.addAttribute("item",fluxInsuranceOrderBalance);
//        LogObjectHolder.me().set(fluxInsuranceOrderBalance);
        return PREFIX + "fluxInsuranceOrderBalance_edit.html";
    }

    /**
     * 获取流量和保险订单结算列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(ActivateCodeDomain activateCodeDomain) {
        ShiroUser shiroUser = (ShiroUser) super.getSession().getAttribute("shiroUser");
        return fluxOrderBalanceService.findFluxInsuranceOrderBalanceByBalanceTime(activateCodeDomain, shiroUser);
    }

    /**
     * 新增流量和保险订单结算
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(FluxInsuranceOrderBalance fluxInsuranceOrderBalance) {
       // fluxInsuranceOrderBalanceService.insert(fluxInsuranceOrderBalance);
        return SUCCESS_TIP;
    }

    /**
     * 删除流量和保险订单结算
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer fluxInsuranceOrderBalanceId) {
       // fluxInsuranceOrderBalanceService.deleteById(fluxInsuranceOrderBalanceId);
        return SUCCESS_TIP;
    }

    /**
     * 修改流量和保险订单结算
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(FluxInsuranceOrderBalance fluxInsuranceOrderBalance) {
       // fluxInsuranceOrderBalanceService.updateById(fluxInsuranceOrderBalance);
        return SUCCESS_TIP;
    }

    /**
     * 流量和保险订单结算详情
     */
    @RequestMapping(value = "/detail/{fluxInsuranceOrderBalanceId}")
    @ResponseBody
    public Object detail(@PathVariable("fluxInsuranceOrderBalanceId") Integer fluxInsuranceOrderBalanceId) {
        //return fluxInsuranceOrderBalanceService.selectById(fluxInsuranceOrderBalanceId);
        return null;
    }

    @RequestMapping(value = "/received")
    @ResponseBody
    public Object received(@RequestParam("balanceSerial") String balanceSerial) {
        System.out.println(balanceSerial);
        int i = fluxOrderBalanceService.updateFluxInsuranceOrderBalanceByBalanceSerial(2,balanceSerial,1);
        if(i==0) {
            SUCCESS_TIP.setMessage("该结算单已收");
        } else {
            SUCCESS_TIP.setMessage("成功已收");
        }
        return SUCCESS_TIP;
    }
}
