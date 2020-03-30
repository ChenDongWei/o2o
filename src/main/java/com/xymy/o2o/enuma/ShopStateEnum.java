package com.xymy.o2o.enuma;

/**
 * @Title ShopSataEnum 使用枚举表述常量数据字典
 * @author ChenDongWei
 * @date 2020年3月20日下午4:02:09
 */
public enum ShopStateEnum {
	CHECK(0, "审核中"), OFFLINE(-1, "非法商铺"), SUCCESS(1, "操作成功"), PASS(2, "通过认证"), 
	INNER_ERROR(-1001, "操作失败"), NULL_SHOPID(-1002, "ShopId为空"), 
	NULL_SHOP_INFO(-1003, "传入了空的信息");

	private int state;

	private String stateInfo;

	private ShopStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	/**
	 * @Title stateOf:(根据传入的state返回相应的enum值). 
	 * @author ChenDongWei
	 * @date 2020年3月20日下午4:19:38
	 * @param index
	 * @return
	 */
	public static ShopStateEnum stateOf(int state) {
		for (ShopStateEnum stateEnum : values()) {
			if (stateEnum.getState() == state) {
				return stateEnum;
			}
		}
		return null;
	}
}
