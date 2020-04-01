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
 * ShopServiceImpl:店铺service接口
 * @author ChenDongWei
 * @date 2020年3月13日下午5:22:04
 */
@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopDao shopDao;
	
	/**
	 * @Title addShop:(添加店铺). 
	 * @author ChenDongWei
	 * @date 2020年3月22日下午2:19:57
	 * @param shop
	 * @param shopImg
	 * @return
	 */
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
						//更新店铺的图片地址
						effectedNum = shopDao.updateShop(shop);
						if (effectedNum <= 0) {
							throw new RuntimeException("创建图片地址失败");
						}
					} catch (Exception e) {
						throw new ShopOperationException("addShopImg error:" + e.getMessage());
					}
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

	/**
	 * @Title addShopImg:(新增店铺图片). 
	 * @author ChenDongWei
	 * @date 2020年4月1日上午10:55:49
	 * @param shop
	 * @param shopImg
	 */
	private void addShopImg(Shop shop, CommonsMultipartFile shopImg) {
		//获取shop图片目录的相对值路径
		String dest = FileUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr = ImageUtil.generateThumbnail(shopImg, dest);
		shop.setShopImg(shopImgAddr);
	}

	/**
	 * @Title getByShopId:(根据店铺Id获取店铺信息). 
	 * @author ChenDongWei
	 * @date 2020年3月31日下午5:43:21
	 * @param shopId
	 * @return
	 */
	@Override
	public Shop getByShopId(long shopId) {
		return shopDao.queryByShopId(shopId);
	}

	/**
	 * @Title modifyShop:(更新店铺信息，包括对图片的处理). 
	 * @author ChenDongWei
	 * @date 2020年3月31日下午5:43:44
	 * @param shop
	 * @param shopImg
	 * @return
	 */
	@Override
	public ShopExecution modifyShop(Shop shop, CommonsMultipartFile shopImg) throws ShopOperationException {
		if (shop == null || shop.getShopId() == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOPID);
		} else {
			try {
				//1、判断是否需要处理图片
				if (shopImg != null) {
					Shop tempShop = shopDao.queryByShopId(shop.getShopId());
					if (tempShop.getShopImg() != null) {
						FileUtil.deleteFile(tempShop.getShopImg());
					}
					addShopImg(shop, shopImg);
				}
				//2、更新店铺信息
				shop.setLastEditTime(new Date());
				int effectedNum = shopDao.updateShop(shop);
				if (effectedNum <= 0) {
					return new ShopExecution(ShopStateEnum.INNER_ERROR);
				} else {// 创建成功
					shop = shopDao.queryByShopId(shop.getShopId());
					return new ShopExecution(ShopStateEnum.SUCCESS, shop);
				}
			} catch (Exception e) {
				throw new RuntimeException("modifyShop error: "
						+ e.getMessage());
			}
		}
	}

}
