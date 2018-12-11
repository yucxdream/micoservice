package cn.enilu.guns.service.system.impl;

import cn.enilu.guns.bean.entity.system.Menu;
import cn.enilu.guns.bean.enumeration.BizExceptionEnum;
import cn.enilu.guns.bean.exception.GunsException;
import cn.enilu.guns.bean.vo.node.MenuNode;
import cn.enilu.guns.bean.vo.node.ZTreeNode;
import cn.enilu.guns.dao.system.MenuRepository;
import cn.enilu.guns.service.system.MenuService;
import cn.enilu.guns.utils.ToolUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created  on 2018/3/23 0023.
 *
 * @author enilu
 */
@Service
public class MenuServiceImpl implements MenuService {
    private Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);
    @Autowired
    private MenuRepository menuRepository;


    @Override
    public void delMenu(Long menuId) {
        //删除菜单
        this.menuRepository.delete(menuId);
        //删除关联的relation
        this.menuRepository.deleteRelationByMenu(menuId);

    }

    @Override
    public void delMenuContainSubMenus(Long menuId) {
        Menu menu = menuRepository.findOne(menuId);
        //删除所有子菜单
        List<Menu> menus = menuRepository.findByPcodesLike("%[" + menu.getCode() + "]%");
        menuRepository.delete(menus);
        //删除当前菜单
        delMenu(menuId);

    }
    @Override
    public List<MenuNode> getMenusByRoleIds(List<Integer> roleList) {
        List menus = menuRepository.getMenusByRoleIds(roleList);
       return transferMenuNode(menus);

    }

    @Override
    public List<MenuNode> getMenusTreeByRoleIds(List<Integer> roleList) {
        List menus = menuRepository.getMenusByRoleIds(roleList);
        List<MenuNode> result =  generateTree(transferMenuNode(menus));
        for(MenuNode menuNode:result){
            if(!menuNode.getChildren().isEmpty()){
                sortTree(menuNode.getChildren());
                for(MenuNode menuNode1: menuNode.getChildren()){
                    if(!menuNode1.getChildren().isEmpty()) {
                        sortTree(menuNode1.getChildren());
                    }
                }
            }
        }
        sortTree(result);
        return result;
    }

    @Override
    public List<MenuNode> getMenus() {
        List<MenuNode> list =  transferMenuNode(menuRepository.getMenus());
        List<MenuNode> result =  generateTree(list);


        for(MenuNode menuNode:result){
            if(!menuNode.getChildren().isEmpty()){
                sortTree(menuNode.getChildren());
                for(MenuNode menuNode1: menuNode.getChildren()){
                    if(!menuNode1.getChildren().isEmpty()) {
                        sortTree(menuNode1.getChildren());
                    }
                }
            }
        }
        sortTree(result);
        return result;
    }
    private void sortTree(List<MenuNode> list){
        Collections.sort(list, new Comparator<MenuNode>() {
            @Override
            public int compare(MenuNode o1, MenuNode o2) {
                return o1.getNum()-o2.getNum();
            }
        });
    }
    private List<MenuNode> generateTree(List<MenuNode> list){
        List<MenuNode> result = new ArrayList<>(20);
        Map<Long,MenuNode> map = cn.enilu.guns.utils.Lists.toMap(list,"id");
        for(Map.Entry<Long,MenuNode> entry:map.entrySet()){
            MenuNode menuNode = entry.getValue();

            if(menuNode.getParentId().intValue()!=0){
                MenuNode parentNode = map.get(menuNode.getParentId());
                parentNode.getChildren().add(menuNode);
            }else{
                result.add(menuNode);
            }
        }
        return result;

    }
    private List<MenuNode> transferMenuNode(List menus){
        List<MenuNode> menuNodes = new ArrayList<>();
        try {
            for(int i=0;i<menus.size();i++){
                Object[] source = (Object[]) menus.get(i);
                MenuNode menuNode = new MenuNode();
                menuNode.setId(Long.valueOf(source[0].toString()));
                menuNode.setIcon(String.valueOf(source[1]));
                menuNode.setParentId(Long.valueOf(source[2].toString()));
                menuNode.setName(String.valueOf(source[3]));
                menuNode.setUrl(String.valueOf(source[4]));
                menuNode.setLevels((Integer) source[5]);
                menuNode.setIsmenu((Integer) source[6]);
                menuNode.setNum((Integer) source[7]);
                menuNode.setCode(String.valueOf(source[8]));
                menuNode.setStatus((Integer)source[9]);
                menuNodes.add(menuNode);

            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return menuNodes;
    }
    @Override
    public List<ZTreeNode> menuTreeList() {
        List list = menuRepository.menuTreeList();
        List<ZTreeNode> nodes  =new ArrayList<>();
        for(int i=0;i<list.size();i++){
           Object[] source = (Object[]) list.get(i);
            ZTreeNode node = new ZTreeNode();
            node.setId(Long.valueOf(source[0].toString()));
            node.setpId(Long.valueOf(source[1].toString()));
            node.setName(source[2].toString());
            node.setIsOpen(Boolean.valueOf(source[3].toString()));
            nodes.add(node);
        }
        return nodes;
    }

    @Override
    public List<ZTreeNode> menuTreeListByMenuIds(List<Long> menuIds) {
        List list = menuRepository.menuTreeListByMenuIds(menuIds);
        List<ZTreeNode> nodes  =new ArrayList<>();
        for(int i=0;i<list.size();i++){
            Object[] source = (Object[]) list.get(i);
            ZTreeNode node = new ZTreeNode();
            node.setId(Long.valueOf(source[0].toString()));
            node.setpId(Long.valueOf(source[1].toString()));
            node.setName(source[2].toString());
            node.setIsOpen(Boolean.valueOf(source[3].toString()));
            node.setChecked(Boolean.valueOf(source[4].toString()));
            nodes.add(node);
        }
        return nodes;
    }

    @Override
    public void menuSetPcode(Menu menu) {
        if (ToolUtil.isEmpty(menu.getPcode()) || menu.getPcode().equals("0")) {
            menu.setPcode("0");
            menu.setPcodes("[0],");
            menu.setLevels(1);
        } else {

            Menu pMenu = menuRepository.findByCode(menu.getPcode());
            Integer pLevels = pMenu.getLevels();
            menu.setPcode(pMenu.getCode());

            //如果编号和父编号一致会导致无限递归
            if (menu.getCode().equals(menu.getPcode())) {
                throw new GunsException(BizExceptionEnum.MENU_PCODE_COINCIDENCE);
            }

            menu.setLevels(pLevels + 1);
            menu.setPcodes(pMenu.getPcodes() + "[" + pMenu.getCode() + "],");
        }
    }

}
