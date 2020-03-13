package com.xymy.o2o.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *  商品图片实体
 * @author ChenDongWei
 * @date 2020年3月13日下午2:11:05
 */
public class ProductImg implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long productImgId;
	
	private Long imgAddr;;
	
	private String imgDesc;
	
	private Integer priority;
	
	private Date createTime;
	
	private Long productId;

	public Long getProductImgId() {
		return productImgId;
	}

	public void setProductImgId(Long productImgId) {
		this.productImgId = productImgId;
	}

	public Long getImgAddr() {
		return imgAddr;
	}

	public void setImgAddr(Long imgAddr) {
		this.imgAddr = imgAddr;
	}

	public String getImgDesc() {
		return imgDesc;
	}

	public void setImgDesc(String imgDesc) {
		this.imgDesc = imgDesc;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}
