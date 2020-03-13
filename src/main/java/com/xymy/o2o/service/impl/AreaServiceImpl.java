package com.xymy.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xymy.o2o.dao.AreaDao;
import com.xymy.o2o.entity.Area;
import com.xymy.o2o.service.AreaService;

/**
 * AreaService:区域service接口
 * @author ChenDongWei
 * @date 2020年3月13日下午5:22:04
 */
@Service
public class AreaServiceImpl implements AreaService {
	@Autowired
	private AreaDao areaDao;
	/**
	 * queryArea:(查询区域列表). <br/> 
	 * @author ChenDongWei
	 * @date 2020年3月13日下午4:35:59
	 * @return
	 */
	@Override
	public List<Area> getAreaList() {
		return areaDao.queryArea();
	}

}
