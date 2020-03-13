package xymy.o2o.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xymy.o2o.entity.Area;
import com.xymy.o2o.service.AreaService;

import xymy.o2o.BaseTest;

public class AreaServiceTest extends BaseTest {
	@Autowired
	private AreaService areaService;
	
	@Test
	public void testQueryArea() {
		List<Area> areaList = areaService.getAreaList();
		assertEquals(4, areaList.size());
	}
}
