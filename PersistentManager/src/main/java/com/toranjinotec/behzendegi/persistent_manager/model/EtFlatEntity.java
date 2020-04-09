package com.toranjinotec.behzendegi.persistent_manager.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class EtFlatEntity implements Serializable {

	private static final long serialVersionUID = 8226969694257638418L;

	@Version
	private long version;

	private Date CreationDate = new Date();

	@Column(name = "IsActive", columnDefinition = "boolean default true", nullable = false)
	private boolean IsActive = true;

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public Date getCreationDate() {
		return CreationDate;
	}
	

	public void setCreationDate(Date creationDate) {
		CreationDate = creationDate;
	}

	public boolean isIsActive() {
		return IsActive;
	}

	public void setIsActive(boolean isActive) {
		IsActive = isActive;
	}

}
