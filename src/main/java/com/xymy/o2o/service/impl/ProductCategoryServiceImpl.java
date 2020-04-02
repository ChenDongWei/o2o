package com.xymy.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xymy.o2o.dao.ProductCategoryDao;
import com.xymy.o2o.dto.ProductCategoryExecution;
import com.xymy.o2o.entity.ProductCategory;
import com.xymy.o2o.enuma.ProductCategoryStateEnum;
import com.xymy.o2o.exceptions.ProductCategoryOperationException;
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

	/**
	 * @Title batchAddProductCategory:(批量新增店铺商品类别). 
	 * @author ChenDongWei
	 * @date 2020年4月2日下午2:15:39
	 * @param productCategoryList
	 * @return
	 * @throws ProductCategoryOperationException
	 */
	@Override
	public ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
			throws ProductCategoryOperationException {
		if (productCategoryList != null && productCategoryList.size() > 0) {
			try {
				int effectedNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
				if (effectedNum <= 0) {
					throw new RuntimeException("店铺商品类别创建失败");
				} else {
					return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
				}
			} catch (Exception e) {
				throw new ProductCategoryOperationException("batchAddProductCategory error: " + e.getMessage());
			}
		} else {
			return new ProductCategoryExecution(ProductCategoryStateEnum.INNER_ERROR);
		}
	}

	/**
	 * @Title deleteProductCategory:(将此类别写的商品里的类别id置空，再删除掉该商品类别). 
	 * @author ChenDongWei
	 * @date 2020年4月2日下午2:51:11
	 * @param productCategoryId
	 * @param shopId
	 * @return
	 * @throws ProductCategoryOperationException
	 */
	@Override
	@Transactional
	public ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId) throws ProductCategoryOperationException {
		//TODO 将此商品类别下的商品的类别id置空
		/*try {
			int effectedNum = productDao.updateProductCategoryToNull(productCategoryId);
			if (effectedNum < 0) {
				throw new RuntimeException("商品类别更新失败");
			}
		} catch (Exception e) {
			throw new RuntimeException("deleteProductCategory error: "
					+ e.getMessage());
		}*/
		try {
			int effectedNum = productCategoryDao.deleteProductCategory(productCategoryId, shopId);
			if (effectedNum <= 0) {
				throw new ProductCategoryOperationException("店铺类别删除失败");
			} else {
				return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
			}

		} catch (Exception e) {
			throw new ProductCategoryOperationException("deleteProductCategory error: " + e.getMessage());
		}
	}

}
