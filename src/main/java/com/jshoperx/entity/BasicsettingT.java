package com.jshoperx.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the basicsetting_t database table.
 * 
 */
@Entity
@Table(name="basicsetting_t")
@NamedQuery(name="BasicsettingT.findAll", query="SELECT b FROM BasicsettingT b")
public class BasicsettingT implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;

	public BasicsettingT() {
	}


	@Id
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

}