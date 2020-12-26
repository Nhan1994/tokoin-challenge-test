package com.tokoin.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Ticket {

	@SerializedName("_id")
	private String id;

	@SerializedName("url")
	private String url;

	@SerializedName("external_id")
	private String externalId;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("type")
	private String type;

	@SerializedName("subject")
	private String subject;

	@SerializedName("description")
	private String description;

	@SerializedName("priority")
	private String priority;

	@SerializedName("status")
	private String status;

	@SerializedName("submitter_id")
	private int submitterId;

	@SerializedName("assignee_id")
	private int assigneeId;

	@SerializedName("organization_id")
	private int organizationId;

	@SerializedName("tags")
	private List<String> tags;

	@SerializedName("has_incidents")
	private boolean hasIncidents;

	@SerializedName("due_at")
	private String dueAt;

	@SerializedName("via")
	private String via;

	public String getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}

	public String getExternalId() {
		return externalId;
	}

	public String getCreatedAt() {
		return createdAt;
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

	public int getSubmitterId() {
		return submitterId;
	}

	public int getAssigneeId() {
		return assigneeId;
	}

	public int getOrganizationId() {
		return organizationId;
	}

	public List<String> getTags() {
		return tags;
	}

	public boolean isHasIncidents() {
		return hasIncidents;
	}

	public String getDueAt() {
		return dueAt;
	}

	public String getVia() {
		return via;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
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

	public void setSubmitterId(int submitterId) {
		this.submitterId = submitterId;
	}

	public void setAssigneeId(int assigneeId) {
		this.assigneeId = assigneeId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public void setHasIncidents(boolean hasIncidents) {
		this.hasIncidents = hasIncidents;
	}

	public void setDueAt(String dueAt) {
		this.dueAt = dueAt;
	}

	public void setVia(String via) {
		this.via = via;
	}
}
