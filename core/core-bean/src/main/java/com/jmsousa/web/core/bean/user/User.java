package com.jmsousa.web.core.bean.user;

import javax.persistence.Entity;

import com.jmsousa.web.core.bean.AbstractBean;

/**
 * Bean for user data
 * 
 * @author jmsousa
 */
@Entity
public class User
	extends AbstractBean {

	// Fields

	private String	email;

	private String	name;

	// Public classes

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Protected classes

	@Override
	protected Object getEquality() {
		return getEmail();
	}
}
