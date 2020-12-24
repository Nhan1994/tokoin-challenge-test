package com.tokoin.dao;

import java.util.Date;
import java.util.List;

public class Ticket {
	private int id;
	private String url;
	private String external_id;
	private Date created_at;
	private String type;
	private String subject;
	private String description;
	private String priority;
	private String status;
	private User submitter_id;
	private User assignee_id;
	private Organization organization_id;
	private List<String> tags;
	private boolean has_incidents;
	private Date due_at;
	private String via;

	public int getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}

	public String getExternal_id() {
		return external_id;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public String getType() {
		return type;
	}

	public String getSubject() {
		return subject;
	}

	public String getDescription() {
		return description;
	}

	public String getPriority() {
		return priority;
	}

	public String getStatus() {
		return status;
	}

	public User getSubmitter_id() {
		return submitter_id;
	}

	public User getAssignee_id() {
		return assignee_id;
	}

	public Organization getOrganization_id() {
		return organization_id;
	}

	public List<String> getTags() {
		return tags;
	}

	public boolean isHas_incidents() {
		return has_incidents;
	}

	public Date getDue_at() {
		return due_at;
	}

	public String getVia() {
		return via;
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

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setSubmitter_id(User submitter_id) {
		this.submitter_id = submitter_id;
	}

	public void setAssignee_id(User assignee_id) {
		this.assignee_id = assignee_id;
	}

	public void setOrganization_id(Organization organization_id) {
		this.organization_id = organization_id;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public void setHas_incidents(boolean has_incidents) {
		this.has_incidents = has_incidents;
	}

	public void setDue_at(Date due_at) {
		this.due_at = due_at;
	}

	public void setVia(String via) {
		this.via = via;
	}

}
