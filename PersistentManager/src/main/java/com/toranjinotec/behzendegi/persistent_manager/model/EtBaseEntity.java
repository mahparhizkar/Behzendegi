package com.toranjinotec.behzendegi.persistent_manager.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class EtBaseEntity implements Serializable {

	private static final long serialVersionUID = 2526852556070702680L;

	@Id
	@Column(name = "oid", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long oid;

	@Version
	private long version;

	private Date CreationDate;

	private boolean IsActive;

	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

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
