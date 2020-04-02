package xymy.o2o.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xymy.o2o.dao.ShopDao;
import com.xymy.o2o.entity.PersonInfo;
import com.xymy.o2o.entity.Shop;
import com.xymy.o2o.entity.ShopCategory;

import xymy.o2o.BaseTest;

public class ShopDaoTest extends BaseTest {
	@Autowired
	private ShopDao shopDao;
	
	@Test
	public void testQueryShopList() {
		Shop shopCondition = new Shop();
		PersonInfo owner = new PersonInfo();
		owner.setUserId(8L);
		ShopCategory sc = new ShopCategory();
		sc.setShopCategoryId(22L);
		shopCondition.setOwner(owner);
		shopCondition.setShopCategory(sc);
		List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 5);
		int count = shopDao.queryShopCount(shopCondition);
		System.out.println("店铺数量:" + count + "," + shopList.size());
	}
	
	@Test
	@Ignore
	public void testQueryByShopId() {
		Shop shop = shopDao.queryByShopId(15);
		System.out.println(shop.getArea().getAreaName());
		System.out.println(shop.getArea().getAreaId());
	}
}
