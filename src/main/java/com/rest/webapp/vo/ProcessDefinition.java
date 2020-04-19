package com.rest.webapp.vo;

public class ProcessDefinition {
	
	String id;
	String key;
	String category;
	String description;
	String name;
	int version;
	String resource;
	String deploymentId;
	String diagram;
	boolean suspended;
	String tenantId;
	String versionTag;
	String historyTimeToLive;
	boolean startableInTasklist;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getDeploymentId() {
		return deploymentId;
	}
	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}
	public String getDiagram() {
		return diagram;
	}
	public void setDiagram(String diagram) {
		this.diagram = diagram;
	}
	public boolean isSuspended() {
		return suspended;
	}
	public void setSuspended(boolean suspended) {
		this.suspended = suspended;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getVersionTag() {
		return versionTag;
	}
	public void setVersionTag(String versionTag) {
		this.versionTag = versionTag;
	}
	public String getHistoryTimeToLive() {
		return historyTimeToLive;
	}
	public void setHistoryTimeToLive(String historyTimeToLive) {
		this.historyTimeToLive = historyTimeToLive;
	}
	public boolean isStartableInTasklist() {
		return startableInTasklist;
	}
	public void setStartableInTasklist(boolean startableInTasklist) {
		this.startableInTasklist = startableInTasklist;
	}
	
	
}
