package com.xymy.o2o.service;

import java.util.List;

import com.xymy.o2o.dto.ProductCategoryExecution;
import com.xymy.o2o.entity.ProductCategory;
import com.xymy.o2o.exceptions.ProductCategoryOperationException;

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
	
	/**
	 * @Title batchAddProductCategory:(批量新增商品类别). 
	 * @author ChenDongWei
	 * @date 2020年4月2日下午2:15:39
	 * @param productCategoryList
	 * @return
	 * @throws ProductCategoryOperationException
	 */
	ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList) throws ProductCategoryOperationException;
	
	/**
	 * @Title deleteProductCategory:(将此类别写的商品里的类别id置空，再删除掉该商品类别). 
	 * @author ChenDongWei
	 * @date 2020年4月2日下午2:51:11
	 * @param productCategoryId
	 * @param shopId
	 * @return
	 * @throws ProductCategoryOperationException
	 */
	ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId) throws ProductCategoryOperationException;
}
