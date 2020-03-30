package com.xymy.o2o.web.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="shopadmin", method= {RequestMethod.GET})
public class ShopAdminController {
	@RequestMapping(value="shopedit")
	public ModelAndView shopOperation() {
		ModelAndView modelAndView = new ModelAndView("shop/shopedit");
		return modelAndView;
	}
}
