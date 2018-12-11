package cn.enilu.guns.service.fluxinsurance.impl;

import cn.enilu.guns.bean.core.ShiroUser;
import cn.enilu.guns.bean.domain.ChannelProductDomain;
import cn.enilu.guns.bean.entity.user.PProductBase;
import cn.enilu.guns.bean.entity.user.PProductFluxExpand;
import cn.enilu.guns.bean.entity.user.PProductInsurancePrice;
import cn.enilu.guns.dao.insuranceservice.PProductBaseRepository;
import cn.enilu.guns.dao.insuranceservice.PProductFluxExpandRepository;
import cn.enilu.guns.dao.insuranceservice.PProductInsurancePriceRepository;
import cn.enilu.guns.service.fluxinsurance.IProductBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * InnoDB free: 0 kB 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2018-11-22
 */
@Service
public class productBaseServiceImpl implements IProductBaseService {
    @Autowired
    private IProductBaseService productBaseService;

    @Autowired
    private PProductBaseRepository pProductBaseRepository;

    @Autowired
    private PProductInsurancePriceRepository pProductInsurancePriceRepository;

    @Autowired
    private PProductFluxExpandRepository pProductFluxExpandRepository;



    @Override
    public List<PProductBase> findProductGroupByScCode(ShiroUser shiroUser) {
        return pProductBaseRepository.findProductBaseGroupByCpIdAndOrgCode(shiroUser.getCpId(), shiroUser.getOrgCode());
        //查询出销售渠道下所有产品
        //select BP_ID from p_product_sell_channel where SC_CODE = 'HBSJLJB011'
        //查询出销售渠道下所有组合产品
        //select * from p_product_base where bp_id in (select BP_ID from p_product_sell_channel where SC_CODE = 'HBSJLJB011') and PRODUCT_TYPE = 1
        //查询出某一个组合产品下的所有产品信息
        //SELECT * from p_product_base where BP_ID in (select BP_ID from p_product_group where PRODUCT_GROUP_CODE = (select BP_ID from p_product_sell_channel where SC_CODE = 'HBSJLJB011') and BP_ID = '产品ID')

    }

    @Override
    public List<PProductBase> findProductByProductGroupCode(String productGroupCode) {
        return pProductBaseRepository.findProductBaseByProductGroupCode(productGroupCode);
    }

    @Override
    public List<ChannelProductDomain> findChannelProduct(ShiroUser shiroUser) {
        List<PProductBase> obj = productBaseService.findProductGroupByScCode(shiroUser);
        List<ChannelProductDomain> resultList = new ArrayList<>();
        for(PProductBase pProductBase:obj){
            List<PProductBase> pp = productBaseService.findProductByProductGroupCode(pProductBase.getBpId());
            //Map<String, PProductBase> pProductBaseMap = covertProductsToMap(pp);
            ChannelProductDomain channelProductDomain = new ChannelProductDomain();
            channelProductDomain.setMainProduct(pProductBase);
            handlerProducts(pp);
            //System.out.println(calcInsurancePrice(findProductBase(pp,"0"), pProductFluxExpand.getUseDay()));
            channelProductDomain.setProductGroupList(pp);
            resultList.add(channelProductDomain);
        }
        System.out.println(resultList);
        return resultList;
    }

    public float calcInsurancePrice(PProductBase insuranceProduct, int day){
        //获得当前保险所有价格区间
        List<PProductInsurancePrice> productPriceList =  pProductInsurancePriceRepository.findPProductInsurancePricesByProductId(insuranceProduct.getBpId());
        for (PProductInsurancePrice productPrice : productPriceList) {

            //判断天数是否在当前区间
            if(day >= productPrice.getDayStart() && day <= productPrice.getDayEnd()) {
                //价格累加
                return productPrice.getPrice();
            }
        }
        return 1/0;
    }

    /**
     * 在集合中寻找流量产品和保险产品返回
     * @param pp
     * @return
     */
    public PProductBase findProductBase(List<PProductBase> pp, String ptType) {
        for(PProductBase pProductBase:pp) {
            if(ptType.equals(pProductBase.getPtCode())) {
                return pProductBase;
            }
        }
        return null;
    }

    public Map<String, PProductBase> covertProductsToMap(List<PProductBase> pp){
        Map<String,PProductBase> stringPProductBaseMap = new HashMap<>();
        for(PProductBase pProductBase:pp) {
            stringPProductBaseMap.put(pProductBase.getPtCode(), pProductBase);
        }
        return stringPProductBaseMap;
    }

    /**
     * 处理一下pproductBase
     * 因为前端在获取数据时依赖于下标，所以需要排列
     * @param pp
     */
    public void handlerProducts(List<PProductBase> pp) {
        PProductBase insuranceProduct = null;
        PProductBase fluxProduct = null;

        for(PProductBase pProductBase:pp) {
            if("0".equals(pProductBase.getPtCode())) {
                //保险
                insuranceProduct = pProductBase;
            }
            if("1".equals(pProductBase.getPtCode())) {
                //流量
                fluxProduct = pProductBase;
            }
        }
        //计算价格
        PProductFluxExpand pProductFluxExpand = pProductFluxExpandRepository.findPProductFluxExpandBybpId(fluxProduct.getBpId());
        insuranceProduct.setPrice(new BigDecimal(calcInsurancePrice(insuranceProduct, pProductFluxExpand.getUseDay())));
        pp.set(1,fluxProduct);
        pp.set(0,insuranceProduct);
    }
}
