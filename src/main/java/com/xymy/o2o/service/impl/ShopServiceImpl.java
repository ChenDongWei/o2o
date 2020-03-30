package com.xymy.o2o.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.xymy.o2o.dao.ShopDao;
import com.xymy.o2o.dto.ShopExecution;
import com.xymy.o2o.entity.Shop;
import com.xymy.o2o.enuma.ShopStateEnum;
import com.xymy.o2o.exceptions.ShopOperationException;
import com.xymy.o2o.service.ShopService;
import com.xymy.o2o.util.FileUtil;
import com.xymy.o2o.util.ImageUtil;

/**
 * AreaService:区域service接口
 * @author ChenDongWei
 * @date 2020年3月13日下午5:22:04
 */
@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopDao shopDao;
	
	@Override
	public ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg) {
		//空值判断
		if (shop == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP_INFO);
		}
		try {
			//店铺信息赋初始值
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			//添加店铺信息
			int effectedNum = shopDao.insertShop(shop);
			if (effectedNum <= 0) {
				throw new ShopOperationException("店铺创建失败");
			}else {
				if (shopImg != null) {
					//存储图片
					try {
						addShopImg(shop, shopImg);
					} catch (Exception e) {
						throw new ShopOperationException("addShopImg error:" + e.getMessage());
					}
					//更新店铺的图片地址
					effectedNum = shopDao.updateShop(shop);
					if (effectedNum <= 0) {
						throw new ShopOperationException("更新图片地址失败");
					}
				}
			}
		} catch (Exception e) {
			throw new ShopOperationException("addShop error:" + e.getMessage());
		}
		return new ShopExecution(ShopStateEnum.CHECK, shop);
	}

	private void addShopImg(Shop shop, CommonsMultipartFile shopImg) {
		//获取shop图片目录的相对值路径
		String dest = FileUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr = ImageUtil.generateThumbnail(shopImg, dest);
		shop.setShopImg(shopImgAddr);
	}

}
