package com.jshoperx.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the goods_type_t_n database table.
 * 
 */
@Entity
@Table(name="goods_type_t_n")
@NamedQuery(name="GoodsTypeTN.findAll", query="SELECT g FROM GoodsTypeTN g")
public class GoodsTypeTN implements Serializable {
	private static final long serialVersionUID = 1L;
	private String goodsTypeId;
	private Date createtime;
	private String creatorid;
	private String goodsParameter;
	private String name;

	public GoodsTypeTN() {
	}


	@Id
	@Column(name="GOODS_TYPE_ID")
	public String getGoodsTypeId() {
		return this.goodsTypeId;
	}

	public void setGoodsTypeId(String goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}


	@Lob
	@Column(name="GOODS_PARAMETER")
	public String getGoodsParameter() {
		return this.goodsParameter;
	}

	public void setGoodsParameter(String goodsParameter) {
		this.goodsParameter = goodsParameter;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}