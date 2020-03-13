package com.xymy.o2o.service;

import java.util.List;

import com.xymy.o2o.entity.Area;

/**
 * AreaService:区域service接口
 * @author ChenDongWei
 * @date 2020年3月13日下午5:22:04
 */
public interface AreaService {
	/**
	 * queryArea:(查询区域列表). <br/> 
	 * @author ChenDongWei
	 * @date 2020年3月13日下午4:35:59
	 * @return
	 */
	List<Area> getAreaList();
}
