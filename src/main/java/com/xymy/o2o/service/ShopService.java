package com.xymy.o2o.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.xymy.o2o.dto.ShopExecution;
import com.xymy.o2o.entity.Shop;

/**
 * AreaService:区域service接口
 * @author ChenDongWei
 * @date 2020年3月13日下午5:22:04
 */
public interface ShopService {

	/**
	 * @Title addShop:(添加店铺). 
	 * @author ChenDongWei
	 * @date 2020年3月22日下午2:19:57
	 * @param shop
	 * @param shopImg
	 * @return
	 */
	ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg);
}
