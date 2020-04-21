package com.rest.webapp.vo;

public class TaskList {
	
	String id;
	String name;
	String assignee;
	String created;
	String due;
	String followUp;
	String delegationState;
	String description;
	String executionId;
	String owner;
	String parentTaskId;
	int priority;
	String processDefinitionId;
	String processInstanceId;
	String taskDefinitionKey;
	String caseExecutionId;
	String caseInstanceId;
	String caseDefinitionId;
	boolean suspended;
	String formKey;
	String tenantId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getDue() {
		return due;
	}
	public void setDue(String due) {
		this.due = due;
	}
	public String getFollowUp() {
		return followUp;
	}
	public void setFollowUp(String followUp) {
		this.followUp = followUp;
	}
	public String getDelegationState() {
		return delegationState;
	}
	public void setDelegationState(String delegationState) {
		this.delegationState = delegationState;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getExecutionId() {
		return executionId;
	}
	public void setExecutionId(String executionId) {
		this.executionId = executionId;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getParentTaskId() {
		return parentTaskId;
	}
	public void setParentTaskId(String parentTaskId) {
		this.parentTaskId = parentTaskId;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getProcessDefinitionId() {
		return processDefinitionId;
	}
	public void setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
	}
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	public String getTaskDefinitionKey() {
		return taskDefinitionKey;
	}
	public void setTaskDefinitionKey(String taskDefinitionKey) {
		this.taskDefinitionKey = taskDefinitionKey;
	}
	public String getCaseExecutionId() {
		return caseExecutionId;
	}
	public void setCaseExecutionId(String caseExecutionId) {
		this.caseExecutionId = caseExecutionId;
	}
	public String getCaseInstanceId() {
		return caseInstanceId;
	}
	public void setCaseInstanceId(String caseInstanceId) {
		this.caseInstanceId = caseInstanceId;
	}
	public String getCaseDefinitionId() {
		return caseDefinitionId;
	}
	public void setCaseDefinitionId(String caseDefinitionId) {
		this.caseDefinitionId = caseDefinitionId;
	}
	public boolean isSuspended() {
		return suspended;
	}
	public void setSuspended(boolean suspended) {
		this.suspended = suspended;
	}
	public String getFormKey() {
		return formKey;
	}
	public void setFormKey(String formKey) {
		this.formKey = formKey;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	
}
