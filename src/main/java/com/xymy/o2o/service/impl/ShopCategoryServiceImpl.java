package com.xymy.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xymy.o2o.dao.ShopCategoryDao;
import com.xymy.o2o.entity.ShopCategory;
import com.xymy.o2o.service.ShopCategoryService;

/**
 * ShopCategoryServiceImpl:店铺类别service接口
 * @author ChenDongWei
 * @date 2020年3月13日下午5:22:04
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
	@Autowired
	private ShopCategoryDao shopCategoryDao;

	/**
	 * @Title getShopCategoryList:(查询店铺类别列表). 
	 * @author ChenDongWei
	 * @date 2020年3月30日下午5:46:15
	 * @param shopCategoryCondition
	 * @return
	 */
	@Override
	public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
		return shopCategoryDao.queryShopCategory(shopCategoryCondition);
	}

}
