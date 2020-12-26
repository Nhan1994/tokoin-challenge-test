package com.tokoin.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Organization {
	
	@SerializedName("_id")
	private int id;
	
	@SerializedName("url")
	private String url;
	
	@SerializedName("external_id")
	private String externalId;

	@SerializedName("name")
	private String name;
	
	@SerializedName("domain_names")
	private List<String> domainNames;
	
	@SerializedName("created_at")
	private String createdAt;
	
	@SerializedName("details")
	private String details;

	@SerializedName("shared_tickets")
	private boolean sharedTickets;
	
	@SerializedName("tags")
	private List<String> tags;

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

	public List<String> getDomainNames() {
		return domainNames;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getDetails() {
		return details;
	}

	public boolean isSharedTickets() {
		return sharedTickets;
	}

	public List<String> getTags() {
		return tags;
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

	public void setDomainNames(List<String> domainNames) {
		this.domainNames = domainNames;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public void setShared_tickets(boolean sharedTickets) {
		this.sharedTickets = sharedTickets;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
}
