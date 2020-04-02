package com.xymy.o2o.service;

import java.util.List;

import com.xymy.o2o.entity.ProductCategory;

/**
 * 商品类别service接口
 * @Title ProductCategoryService
 * @author ChenDongWei
 * @date 2020年4月2日上午10:44:03
 */
public interface ProductCategoryService {
	/**
	 * @Title getProductCategoryList:(查询某个店铺下所有商品类别信息). 
	 * @author ChenDongWei
	 * @date 2020年4月2日上午10:44:45
	 * @param shopId
	 * @return
	 */
	List<ProductCategory> getProductCategoryList(long shopId);
}
