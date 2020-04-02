package com.xymy.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xymy.o2o.dao.ProductCategoryDao;
import com.xymy.o2o.entity.ProductCategory;
import com.xymy.o2o.service.ProductCategoryService;

/**
 * ShopCategoryServiceImpl:店铺类别service接口
 * @author ChenDongWei
 * @date 2020年3月13日下午5:22:04
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
	@Autowired
	private ProductCategoryDao productCategoryDao;

	/**
	 * @Title getProductCategoryList:(查询某个店铺下所有商品类别信息). 
	 * @author ChenDongWei
	 * @date 2020年4月2日上午10:44:45
	 * @param shopId
	 * @return
	 */
	@Override
	public List<ProductCategory> getProductCategoryList(long shopId) {
		return productCategoryDao.queryProductCategory(shopId);
	}

}
