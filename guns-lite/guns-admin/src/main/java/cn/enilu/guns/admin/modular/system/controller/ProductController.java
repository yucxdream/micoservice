package cn.enilu.guns.admin.modular.system.controller;

import cn.enilu.guns.admin.core.base.controller.BaseController;
import cn.enilu.guns.bean.core.ShiroUser;
import cn.enilu.guns.bean.domain.ChannelProductDomain;
import cn.enilu.guns.bean.entity.user.PProductBase;
import cn.enilu.guns.service.fluxinsurance.IProductBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;

/**
 * 激活码管理控制器
 *
 * @author fengshuonan
 * @Date 2018-11-22 12:44:04
 */
@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {

    @Autowired
    private IProductBaseService productBaseService;

    private String PREFIX = "/system/activateCode/";


    /**
     * 跳转到激活码管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "activateCode.html";
    }

    /**
     * 跳转到激活码管理首页
     */
    @RequestMapping("/channelProductList")
    @ResponseBody
    public List<ChannelProductDomain> channelProductList() {
        ShiroUser shiroUser = (ShiroUser) super.getSession().getAttribute("shiroUser");
        return productBaseService.findChannelProduct(shiroUser);
    }
}
