package com.xymy.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	
	/**
	 * @Title batchInsertProductCategory:(批量新增商品类别). 
	 * @author ChenDongWei
	 * @date 2020年4月2日上午11:49:31
	 * @param productCategoryList
	 * @return
	 */
	int batchInsertProductCategory(List<ProductCategory> productCategoryList);
	
	/**
	 * @Title deleteProductCategory:(删除指定的商品类别). 
	 * @author ChenDongWei
	 * @date 2020年4月2日下午2:40:04
	 * @param productCategoryId
	 * @param shopId
	 * @return
	 */
	int deleteProductCategory(@Param("productCategoryId")long productCategoryId, @Param("shopId") long shopId);
}
