package xymy.o2o.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xymy.o2o.dao.ShopDao;
import com.xymy.o2o.entity.Shop;

import xymy.o2o.BaseTest;

public class ShopDaoTest extends BaseTest {
	@Autowired
	private ShopDao shopDao;
	
	@Test
	public void testQueryByShopId() {
		Shop shop = shopDao.queryByShopId(15);
		System.out.println(shop.getArea().getAreaName());
		System.out.println(shop.getArea().getAreaId());
	}
}
