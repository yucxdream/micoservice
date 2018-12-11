package cn.enilu.guns.bean.domain;

import cn.enilu.guns.bean.entity.user.PProductBase;

import java.util.List;

public class ChannelProductDomain {
    private PProductBase mainProduct;
    private List<PProductBase> productGroupList;

    public PProductBase getMainProduct() {
        return mainProduct;
    }

    public void setMainProduct(PProductBase mainProduct) {
        this.mainProduct = mainProduct;
    }

    public List<PProductBase> getProductGroupList() {
        return productGroupList;
    }

    public void setProductGroupList(List<PProductBase> productGroupList) {
        this.productGroupList = productGroupList;
    }
}
