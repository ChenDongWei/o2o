package com.xymy.o2o.service;

import java.util.List;

import com.xymy.o2o.entity.ShopCategory;

/**
 * ShopCategoryService:店铺类别service接口
 * @author ChenDongWei
 * @date 2020年3月13日下午5:22:04
 */
public interface ShopCategoryService {
	/**
	 * @Title getShopCategoryList:(查询店铺类别列表). 
	 * @author ChenDongWei
	 * @date 2020年3月30日下午5:46:15
	 * @param shopCategoryCondition
	 * @return
	 */
	List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
