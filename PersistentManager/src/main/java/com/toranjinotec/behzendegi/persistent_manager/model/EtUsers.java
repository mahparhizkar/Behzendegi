package com.toranjinotec.behzendegi.persistent_manager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Users")
public class EtUsers extends EtFlatEntity {

	private static final long serialVersionUID = 2404531209445642179L;
	
	@Id
	@Column(name = "userId", nullable = false)
	private String userId;
	
	private String password;
	
	private int language;
	
	private long groupId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLanguage() {
		return language;
	}

	public void setLanguage(int language) {
		this.language = language;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	
	

}
