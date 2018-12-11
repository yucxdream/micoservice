package cn.enilu.guns.admin.modular.system.controller;

import cn.enilu.guns.admin.core.base.controller.BaseController;
import cn.enilu.guns.bean.domain.ActivateCodeDomain;
import cn.enilu.guns.bean.core.ShiroUser;
import cn.enilu.guns.bean.entity.user.ActivateCode;
import cn.enilu.guns.service.fluxinsurance.IActivateCodeService;
import cn.enilu.guns.utils.DateUtil;
import cn.enilu.guns.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 激活码管理控制器
 */
@Controller
@RequestMapping("/activateCode")
public class ActivateCodeController extends BaseController {

    @Autowired
    private IActivateCodeService activateCodeService;

    private String PREFIX = "/system/activateCode/";


    /**
     * 跳转到激活码管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "activateCode.html";
    }

    /**
     * 下载激活码
     */
    @RequestMapping("/generateXls")
    public void generateXls(HttpServletResponse response, ActivateCodeDomain activateCodeDomain) {
        ShiroUser shiroUser = (ShiroUser) super.getSession().getAttribute("shiroUser");
        List<ActivateCode> activateCodeList = activateCodeService.selectActivateConditions(activateCodeDomain, shiroUser);
        String titles [] = {"激活码","产品代码","产品名称","生成时间","是否被使用","使用时间","结算状态","结算单号"};
        List<List<Object>> datas = new ArrayList<>();
        for(int i=0; i < activateCodeList.size(); i ++) {
            List<Object> rowDate = new ArrayList<>();
            rowDate.add(0, activateCodeList.get(i).getActivateCode());
            rowDate.add(1, activateCodeList.get(i).getBpId());
            rowDate.add(2, activateCodeList.get(i).getName());
            rowDate.add(3, activateCodeList.get(i).getCreateTime());
            rowDate.add(4, activateCodeList.get(i).getUsed() == 1?"已使用":"未使用");
            rowDate.add(5, activateCodeList.get(i).getUseTime());
            int balanceStatus = activateCodeList.get(i).getBalanceStatus();
            String balanceStatusString = null;
            if(balanceStatus==0){balanceStatusString = "未结算";}
            if(balanceStatus==1){balanceStatusString = "未收";}
            if(balanceStatus==2){balanceStatusString = "已收";}
            rowDate.add(6, balanceStatusString);
            rowDate.add(7, activateCodeList.get(i).getBalanceSerial());
            datas.add(rowDate);
        }
        try {
            ExcelUtil.generateXls(
                    titles,
                    datas,
                    response,
                    "",
                    URLEncoder.encode(DateUtil.formatDate(activateCodeDomain.getStartTime(),"yyyy年MM月dd月HH时mm分ss秒")+"到"+DateUtil.formatDate(activateCodeDomain.getEndTime(),"yyyy年MM月dd月HH时mm分ss秒")+"激活码记录","utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 跳转到添加激活码管理
     */
    @RequestMapping("/activateCode_add")
    public String activateCodeAdd() {
        return PREFIX + "activateCode_add.html";
    }

    /**
     * 获取激活码管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(ActivateCodeDomain activateCodeDomain) {
        ShiroUser shiroUser = (ShiroUser) super.getSession().getAttribute("shiroUser");
        return activateCodeService.selectActivateConditions(activateCodeDomain, shiroUser);
    }

    /**
     * 结算激活码
     */
    @RequestMapping(value = "/balance")
    @ResponseBody
    public Object balance(ActivateCodeDomain activateCodeDomain) throws Exception {
        ShiroUser shiroUser = (ShiroUser) super.getSession().getAttribute("shiroUser");
        int i = activateCodeService.balanceActivateByStartTimeAndEndTime(activateCodeDomain,shiroUser);
        System.out.println(i);
        if(i == 0) {
            SUCCESS_TIP.setMessage("所选时间内没有需要结算的激活码");
        }else {
            SUCCESS_TIP.setMessage("成功结算"+i+"个激活码");
        }
        return SUCCESS_TIP;
    }

    /**
     * 新增激活码管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(ActivateCodeDomain activateCodeDomain) {
        ShiroUser shiroUser = (ShiroUser) super.getSession().getAttribute("shiroUser");
        activateCodeService.insertActivateByCount(activateCodeDomain, shiroUser);
        return SUCCESS_TIP;
    }
}
