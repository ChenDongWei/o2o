package com.xymy.o2o.dao;

import java.util.List;

import com.xymy.o2o.entity.ProductCategory;

/**
 * 商品类别dao接口
 * @Title ProductCategoryDao
 * @author ChenDongWei
 * @date 2020年4月2日上午10:35:58
 */
public interface ProductCategoryDao {
	/**
	 * @Title queryProductCategory:(根据shopId查询店铺商品类别). 
	 * @author ChenDongWei
	 * @date 2020年4月2日上午10:36:58
	 * @param shopId
	 * @return
	 */
	List<ProductCategory> queryProductCategory(long shopId);
}
