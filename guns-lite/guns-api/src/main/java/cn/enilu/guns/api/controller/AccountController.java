package cn.enilu.guns.api.controller;

import cn.enilu.guns.bean.core.ShiroUser;
import cn.enilu.guns.bean.entity.system.User;
import cn.enilu.guns.bean.vo.front.Rets;
import cn.enilu.guns.bean.vo.node.MenuNode;
import cn.enilu.guns.dao.cache.TokenCache;
import cn.enilu.guns.dao.system.UserRepository;
import cn.enilu.guns.service.system.AccountService;
import cn.enilu.guns.service.system.MenuService;
import cn.enilu.guns.utils.MD5;
import cn.enilu.guns.utils.Maps;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AccountController
 *
 * @author zt
 * @version 2018/9/12 0012
 */
@RestController
@RequestMapping("/user")
public class AccountController extends BaseController{
     private Logger logger = LoggerFactory.getLogger(AccountController.class);
    @Autowired
    UserRepository userRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private TokenCache tokenCache;
    /**
     * 用户登录<br>
     * 1，验证没有注册<br>
     * 2，验证密码错误<br>
     * 3，登录成功
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object login(@RequestParam("username") String userName,
                        @RequestParam("password") String password){
        try {
            logger.info("用户登录:" + userName + ",密码:" + password);
            //1,
            User user = userRepository.findByAccount(userName);
            if (user == null) {
                return Rets.failure("该用户不存在");
            }
            String password2 = MD5.md5(password, user.getSalt());
            //2,
            if (!user.getPassword().equals(password2)) {
                return Rets.failure("输入的密码错误");
            }

            String token = accountService.login(Long.valueOf(user.getId()));
            Map<String, String> result = new HashMap<>(1);
            logger.info("token:{}",token);
            result.put("token", token);

            return Rets.success(result);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return Rets.failure("登录时失败");
    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public Object logout(HttpServletRequest request){
        String token = this.getToken(request);
        accountService.logout(token);
        return Rets.success();
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public Object info(HttpServletRequest request){
        Long idUser = getIdUser(request);
        if(idUser!=null){
            User user =  userRepository.findOne(idUser.intValue());
            String token = getToken(request);
            ShiroUser shiroUser = tokenCache.getUser(token);
            Map map = Maps.newHashMap("name",user.getName(),"role","admin","roles", shiroUser.getRoleCodes());

            List<MenuNode> menuNodes =  menuService.getMenusTreeByRoleIds(shiroUser.getRoleList());
            map.put("menuNodes",generateRouters(menuNodes));
            return Rets.success(map);
        }
        return Rets.failure("获取用户信息失败");
    }
    private List<Map> generateRouters(List<MenuNode> list){
        List<Map> result = Lists.newArrayList();
        for(MenuNode menuNode:list){
            Map map = com.google.common.collect.Maps.newHashMap();
            map.put("path",menuNode.getUrl());
            map.put("component","Layout");
            map.put("redirect","#");
            map.put("name",menuNode.getName());
            List<Map> children = Lists.newArrayList();
            if(!menuNode.getChildren().isEmpty()){
                for(MenuNode child:menuNode.getChildren()) {
                    if(child.getIsmenu().intValue() != 1){
                        continue;
                    }
                    Map map1 = com.google.common.collect.Maps.newHashMap();
                    map1.put("path", child.getUrl());
                    map1.put("name", child.getName());
                    map1.put("component", "() => import('@/views/" + menuNode.getCode() + "/"+child.getCode()+"/index')");
                    map1.put("meta", Maps.newHashMap("title",child.getName()));
                    children.add(map1);

                }
                map.put("children",children);
            }
            result.add(map);

        }
        return result;
    }
}
