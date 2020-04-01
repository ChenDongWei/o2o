package com.xymy.o2o.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.xymy.o2o.dto.ShopExecution;
import com.xymy.o2o.entity.Shop;
import com.xymy.o2o.exceptions.ShopOperationException;

/**
 * AreaService:区域service接口
 * @author ChenDongWei
 * @date 2020年3月13日下午5:22:04
 */
public interface ShopService {
	/**
	 * @Title getByShopId:(根据店铺Id获取店铺信息). 
	 * @author ChenDongWei
	 * @date 2020年3月31日下午5:43:21
	 * @param shopId
	 * @return
	 */
	Shop getByShopId(long shopId);
	
	/**
	 * @Title modifyShop:(更新店铺信息，包括对图片的处理). 
	 * @author ChenDongWei
	 * @date 2020年3月31日下午5:43:44
	 * @param shop
	 * @param shopImg
	 * @return
	 */
	ShopExecution modifyShop(Shop shop, CommonsMultipartFile shopImg) throws ShopOperationException;
	
	/**
	 * @Title addShop:(添加店铺). 
	 * @author ChenDongWei
	 * @date 2020年3月22日下午2:19:57
	 * @param shop
	 * @param shopImg
	 * @return
	 */
	ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg) throws ShopOperationException;
	
}
