package com.xymy.o2o.entity;

import java.io.Serializable;

/**
 * wechat账号实体
 * @author ChenDongWei
 * @date 2020年3月11日上午11:25:37
 */
import java.util.Date;
public class WechatAuth implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long wechatAuthId;
	
	private String openId;
	
	private Date createTime;
	
	private PersonInfo personInfo;

	public Long getWechatAuthId() {
		return wechatAuthId;
	}

	public void setWechatAuthId(Long wechatAuthId) {
		this.wechatAuthId = wechatAuthId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}
}
