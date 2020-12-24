package com.tokoin.dao;

import java.util.Date;
import java.util.List;

public class User {
	private int id;
	private String url;
	private String external_id;
	private String name;
	private String alias;
	private Date created_at;
	private boolean active;
	private boolean verified;
	private boolean shared;
	private String locale;
	private String timezone;
	private Date last_login_at;
	private String email;
	private String phone;
	private String signature;
	private Organization organization_id;
	private List<String> tags;
	private boolean suspended;
	private String role;
	
	public int getId() {
		return id;
	}
	public String getUrl() {
		return url;
	}
	public String getExternal_id() {
		return external_id;
	}
	public String getName() {
		return name;
	}
	public String getAlias() {
		return alias;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public boolean isActive() {
		return active;
	}
	public boolean isVerified() {
		return verified;
	}
	public boolean isShared() {
		return shared;
	}
	public String getLocale() {
		return locale;
	}
	public String getTimezone() {
		return timezone;
	}
	public Date getLast_login_at() {
		return last_login_at;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public String getSignature() {
		return signature;
	}
	public Organization getOrganization_id() {
		return organization_id;
	}
	public List<String> getTags() {
		return tags;
	}
	public boolean isSuspended() {
		return suspended;
	}
	public String getRole() {
		return role;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setExternal_id(String external_id) {
		this.external_id = external_id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public void setShared(boolean shared) {
		this.shared = shared;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public void setLast_login_at(Date last_login_at) {
		this.last_login_at = last_login_at;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public void setOrganization_id(Organization organization_id) {
		this.organization_id = organization_id;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public void setSuspended(boolean suspended) {
		this.suspended = suspended;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
