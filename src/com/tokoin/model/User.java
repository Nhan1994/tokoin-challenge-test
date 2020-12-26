package com.tokoin.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class User {

	@SerializedName("_id")
	private int id;
	
	@SerializedName("url")
	private String url;

	@SerializedName("external_id")
	private String externalId;

	@SerializedName("name")
	private String name;

	@SerializedName("alias")
	private String alias;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("active")
	private boolean active;

	@SerializedName("verified")
	private boolean verified;

	@SerializedName("shared")
	private boolean shared;

	@SerializedName("locale")
	private String locale;

	@SerializedName("timezone")
	private String timezone;

	@SerializedName("last_login_at")
	private String lastLoginAt;

	@SerializedName("email")
	private String email;

	@SerializedName("phone")
	private String phone;

	@SerializedName("signature")
	private String signature;

	@SerializedName("organization_id")
	private int organizationId;

	@SerializedName("tags")
	private List<String> tags;

	@SerializedName("suspended")
	private boolean suspended;

	@SerializedName("role")
	private String role;

	public int getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}

	public String getExternalId() {
		return externalId;
	}

	public String getName() {
		return name;
	}

	public String getAlias() {
		return alias;
	}

	public String getCreatedAt() {
		return createdAt;
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

	public String getLastLoginAt() {
		return lastLoginAt;
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

	public int getOrganizationId() {
		return organizationId;
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

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
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

	public void setLastLoginAt(String lastLoginAt) {
		this.lastLoginAt = lastLoginAt;
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

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
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
