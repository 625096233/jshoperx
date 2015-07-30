package com.jshoperx.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the module_m database table.
 * 
 */
@Entity
@Table(name="module_m")
@NamedQuery(name="ModuleM.findAll", query="SELECT m FROM ModuleM m")
public class ModuleM implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private Date createtime;
	private String modulename;

	public ModuleM() {
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


	public String getModulename() {
		return this.modulename;
	}

	public void setModulename(String modulename) {
		this.modulename = modulename;
	}

}