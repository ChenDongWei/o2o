package com.xymy.o2o.web.shop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xymy.o2o.dto.Result;
import com.xymy.o2o.entity.ProductCategory;
import com.xymy.o2o.entity.Shop;
import com.xymy.o2o.enuma.ProductCategoryStateEnum;
import com.xymy.o2o.service.ProductCategoryService;

@Controller
@RequestMapping("/shop")
public class ProductCategoryManagementController {
	@Autowired
	private ProductCategoryService productCategoryService;
	
	@RequestMapping(value="getproductcategorylist", method=RequestMethod.GET)
	@ResponseBody
	public Result<List<ProductCategory>> getProductCategoryList(HttpServletRequest request) {
		Shop currentShop = (Shop) request.getSession().getAttribute(
				"currentShop");
		List<ProductCategory> list = null;
		if (currentShop != null && currentShop.getShopId() > 0) {
			list = productCategoryService.getProductCategoryList(currentShop.getShopId());
			return new Result<List<ProductCategory>>(true, list);// WEB-INF/html/"shoplist".html
		} else {
			ProductCategoryStateEnum ps = ProductCategoryStateEnum.INNER_ERROR;
			return new Result<List<ProductCategory>>(false, ps.getState(),
					ps.getStateInfo());
		}
	}
}
