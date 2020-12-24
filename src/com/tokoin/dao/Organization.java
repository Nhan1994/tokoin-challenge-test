package com.tokoin.dao;

import java.util.Date;
import java.util.List;

public class Organization {
	private int id;
	private String url;
	private String external_id;
	private String name;
	private List<String> domain_names;
	private Date created_at;
	private String details;
	private boolean shared_tickets;
	private List<String> tags;

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

	public List<String> getDomain_names() {
		return domain_names;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public String getDetails() {
		return details;
	}

	public boolean isShared_tickets() {
		return shared_tickets;
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

	public void setExternal_id(String external_id) {
		this.external_id = external_id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDomain_names(List<String> domain_names) {
		this.domain_names = domain_names;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public void setShared_tickets(boolean shared_tickets) {
		this.shared_tickets = shared_tickets;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

}
