package com.jshoperx.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the member_group_t database table.
 * 
 */
@Entity
@Table(name="member_group_t")
@NamedQuery(name="MemberGroupT.findAll", query="SELECT m FROM MemberGroupT m")
public class MemberGroupT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String attrs;
	private Date createtime;
	private String creatorid;
	private String name;
	private String shopid;
	private String shopname;
	private String status;
	private Date updatetime;
	private int versiont;

	public MemberGroupT() {
	}


	@Id
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getAttrs() {
		return this.attrs;
	}

	public void setAttrs(String attrs) {
		this.attrs = attrs;
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


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getShopid() {
		return this.shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}


	public String getShopname() {
		return this.shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}


	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}


	public int getVersiont() {
		return this.versiont;
	}

	public void setVersiont(int versiont) {
		this.versiont = versiont;
	}

}