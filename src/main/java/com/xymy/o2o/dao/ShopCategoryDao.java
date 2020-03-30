package com.xymy.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xymy.o2o.entity.ShopCategory;

/**
 * ShopCategoryDao:店铺类别dao接口
 * @author ChenDongWei
 * @date 2020年3月13日下午4:34:56
 */
public interface ShopCategoryDao {
	/**
	 * @Title queryShopCategory:(查询店铺类别列表). 
	 * @author ChenDongWei
	 * @date 2020年3月30日下午5:46:55
	 * @param shopCategoryCondition
	 * @return
	 */
	List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition")ShopCategory shopCategoryCondition);
}
