package com.xymy.o2o.entity;

import java.io.Serializable;

/**
 * 本地账号实体
 * @author ChenDongWei
 * @date 2020年3月11日上午11:25:37
 */
import java.util.Date;
public class LocalAuth implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long localAuthId;
	
	private String username;
	
	private String password;
	
	private Date createTime;
	
	private Date lastEditTime;
	
	private PersonInfo personInfo;

	public Long getLocalAuthId() {
		return localAuthId;
	}

	public void setLocalAuthId(Long localAuthId) {
		this.localAuthId = localAuthId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}
}
