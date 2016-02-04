package com.jmsousa.web.core.bean;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Main abstract class for beans
 * 
 * @author jmsousa
 * 
 */
public abstract class AbstractBean
	implements Serializable {

	private static final long	serialVersionUID	= 1L;

	// Bean Fields

	private Long				id;

	private Date				creationDate;

	private Long				creationUser;

	private Date				updateDate;

	private Long				updateUser;

	// Public methods

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}

		if (this == obj) {
			return true;
		}

		if (obj instanceof AbstractBean && this.getClass().getName().equals(obj.getClass().getName())) {

			AbstractBean bean = (AbstractBean) obj;

			if (getEquality() == null || getEquality() == this) {
				if (getId().equals(bean.getId())) {
					return true;
				}
			} else {
				EqualsBuilder equalsBuilder = new EqualsBuilder();
				equalsBuilder.append(getEquality(), bean.getEquality());

				return equalsBuilder.isEquals();
			}
		}

		return false;
	}

	@Override
	public int hashCode() {

		if (getEquality() == null) {
			return super.hashCode();
		}

		if (getEquality() == this) {
			return HashCodeBuilder.reflectionHashCode(this);
		}

		HashCodeBuilder newHashCodeBuilder = new HashCodeBuilder();
		newHashCodeBuilder.append(getEquality());
		return newHashCodeBuilder.toHashCode();
	}

	@Override
	public String toString() {
		ToStringBuilder toStringBuilder = new ToStringBuilder(this);

		Object equalityForKey = getEquality();

		if (equalityForKey == null || equalityForKey == this) {
			toStringBuilder.append(getId());
		} else {
			toStringBuilder.append(equalityForKey);
		}

		return toStringBuilder.toString();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long getCreationUser() {
		return creationUser;
	}

	public void setCreationUser(Long creationUser) {
		this.creationUser = creationUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Long getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Long updateUser) {
		this.updateUser = updateUser;
	}

	// Protected methods

	/**
	 * Get the fields of bean for the equality
	 * 
	 * @return Field(s) for the equality
	 */
	protected abstract Object getEquality();
}
