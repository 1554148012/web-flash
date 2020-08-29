package cn.enilu.flash.service.bussiness;


import cn.enilu.flash.bean.entity.bussiness.ShopGoodsCategory;
import cn.enilu.flash.dao.bussiness.ShopGoodsCategoryRepository;

import cn.enilu.flash.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopGoodsCategoryService extends BaseService<ShopGoodsCategory,Long,ShopGoodsCategoryRepository>  {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ShopGoodsCategoryRepository shopGoodsCategoryRepository;

}

