package com.xymy.o2o.dao;

import com.xymy.o2o.entity.Shop;

/**
 * ShopDao：店铺dao接口
 * @author ChenDongWei
 * @date 2020年3月20日下午2:45:10
 */
public interface ShopDao {
	/**
	 * @Title: insertShop:(新增店铺). 
	 * @author ChenDongWei
	 * @date 2020年3月20日下午2:48:38
	 * @param shop
	 * @return
	 */
	int insertShop(Shop shop);
	
	/**
	 * @Title updateShop:(更新店铺信息). 
	 * @author ChenDongWei
	 * @date 2020年3月20日下午3:28:00
	 * @param shop
	 * @return
	 */
	int updateShop(Shop shop);
}
