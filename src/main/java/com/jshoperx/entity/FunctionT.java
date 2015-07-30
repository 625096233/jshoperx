package com.jshoperx.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the function_t database table.
 * 
 */
@Entity
@Table(name="function_t")
@NamedQuery(name="FunctionT.findAll", query="SELECT f FROM FunctionT f")
public class FunctionT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private Date createtime;
	private String functionname;
	private String moduleid;
	private String visitmethodname;
	private String visitpagesourceids;
	private String visiturl;

	public FunctionT() {
	}


	@Id
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	public String getFunctionname() {
		return this.functionname;
	}

	public void setFunctionname(String functionname) {
		this.functionname = functionname;
	}


	public String getModuleid() {
		return this.moduleid;
	}

	public void setModuleid(String moduleid) {
		this.moduleid = moduleid;
	}


	public String getVisitmethodname() {
		return this.visitmethodname;
	}

	public void setVisitmethodname(String visitmethodname) {
		this.visitmethodname = visitmethodname;
	}


	public String getVisitpagesourceids() {
		return this.visitpagesourceids;
	}

	public void setVisitpagesourceids(String visitpagesourceids) {
		this.visitpagesourceids = visitpagesourceids;
	}


	public String getVisiturl() {
		return this.visiturl;
	}

	public void setVisiturl(String visiturl) {
		this.visiturl = visiturl;
	}

}