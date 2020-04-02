package com.xymy.o2o.web.shop;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xymy.o2o.entity.Shop;
import com.xymy.o2o.util.HttpServletRequestUtil;

@Controller
@RequestMapping(value="shopadmin", method= {RequestMethod.GET})
public class ShopAdminController {
	@RequestMapping(value="shopedit")
	public ModelAndView shopedit() {
		ModelAndView modelAndView = new ModelAndView("shop/shopedit");
		return modelAndView;
	}
	
	@RequestMapping(value="shoplist")
	public ModelAndView shopList() {
		ModelAndView modelAndView = new ModelAndView("shop/shoplist");
		return modelAndView;
	}
	
	@RequestMapping(value = "/shopmanage", method = RequestMethod.GET)
	public String shopManage(HttpServletRequest request) {
		long shopId = HttpServletRequestUtil.getLong(request, "shopId");
		if (shopId <= 0) {
			Object currentShopObj = request.getSession().getAttribute(
					"currentShop");
			if (currentShopObj == null) {
				return "shop/shoplist";
			} else {
				return "shop/shopmanage";
			}
		} else {
			Shop currentShop = new Shop();
			currentShop.setShopId(shopId);
			request.getSession().setAttribute("currentShop", currentShop);
			return "shop/shopmanage";
		}
	}
	
	@RequestMapping(value = "/productcategorymanage", method = RequestMethod.GET)
	public String productCategoryManage() {
		return "shop/productcategorymanage";
	}

}
