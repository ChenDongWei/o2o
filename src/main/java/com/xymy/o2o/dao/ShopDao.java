package com.xymy.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xymy.o2o.entity.Shop;

/**
 * ShopDao：店铺dao接口
 * @author ChenDongWei
 * @date 2020年3月20日下午2:45:10
 */
public interface ShopDao {
	
	/**
	 * @Title queryShopList:(分页查询店铺). 
	 * @author ChenDongWei
	 * @date 2020年4月1日下午3:21:58
	 * @param shopCondition
	 * @param rowIndex 从第几行开始取
	 * @param pageSize 返回的条数
	 * @return
	 */
	List<Shop> queryShopList(@Param("shopCondition")Shop shopCondition, @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);
	
	/**
	 * @Title queryShopCount:(查询店铺列表数据总数). 
	 * @author ChenDongWei
	 * @date 2020年4月1日下午3:37:07
	 * @param shopCondition
	 * @return
	 */
	int queryShopCount(@Param("shopCondition")Shop shopCondition);
	
	/**
	 * @Title queryByShopId:(通过shopId查询店铺信息). 
	 * @author ChenDongWei
	 * @date 2020年3月31日下午4:53:47
	 * @param shopId
	 * @return
	 */
	Shop queryByShopId(long shopId);
	
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

	/**
	 * @Title getByEmployeeId:(根据用户id获取用户店铺). 
	 * @author ChenDongWei
	 * @date 2020年4月1日下午5:18:25
	 * @param employeeId
	 * @return
	 * @throws RuntimeException
	 */
	List<Shop> queryByEmployeeId(long employeeId);
}
