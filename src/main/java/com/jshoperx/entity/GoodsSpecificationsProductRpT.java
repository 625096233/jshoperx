package com.jshoperx.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the goods_specifications_product_rp_t database table.
 * 
 */
@Entity
@Table(name="goods_specifications_product_rp_t")
@NamedQuery(name="GoodsSpecificationsProductRpT.findAll", query="SELECT g FROM GoodsSpecificationsProductRpT g")
public class GoodsSpecificationsProductRpT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String goodsSpecificationsProductRpTid;
	private String goodsid;
	private String productid;
	private String specidicationsid;

	public GoodsSpecificationsProductRpT() {
	}


	@Id
	@Column(name="GOODS_SPECIFICATIONS_PRODUCT_RP_TID")
	public String getGoodsSpecificationsProductRpTid() {
		return this.goodsSpecificationsProductRpTid;
	}

	public void setGoodsSpecificationsProductRpTid(String goodsSpecificationsProductRpTid) {
		this.goodsSpecificationsProductRpTid = goodsSpecificationsProductRpTid;
	}


	public String getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}


	public String getProductid() {
		return this.productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}


	public String getSpecidicationsid() {
		return this.specidicationsid;
	}

	public void setSpecidicationsid(String specidicationsid) {
		this.specidicationsid = specidicationsid;
	}

}