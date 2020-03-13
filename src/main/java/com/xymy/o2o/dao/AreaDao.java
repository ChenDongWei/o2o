package com.xymy.o2o.dao;

import java.util.List;

import com.xymy.o2o.entity.Area;

/**
 * AreaDao:区域dao接口
 * @author ChenDongWei
 * @date 2020年3月13日下午4:34:56
 */
public interface AreaDao {
	/**
	 * queryArea:(查询区域列表). <br/> 
	 * @author ChenDongWei
	 * @date 2020年3月13日下午4:35:59
	 * @return
	 */
	List<Area> queryArea();
}
