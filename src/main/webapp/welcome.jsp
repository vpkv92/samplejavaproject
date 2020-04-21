<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.rest.webapp.vo.ProcessDefinition" %>
<%@ page import="com.rest.webapp.vo.TaskList" %>

<!DOCTYPE html>
<html>
<head>
  <title>Camunda Rest Client</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script>
    $(document).ready(function(){
        $('a[data-toggle="tab"]').on('show.bs.tab', function(e) {
            localStorage.setItem('activeTab', $(e.target).attr('href'));
        });
        var activeTab = localStorage.getItem('activeTab');
        if(activeTab){
            $('#myTab a[href="' + activeTab + '"]').tab('show');
        }
    });
    </script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">CamundaRestClient</a>
    </div>
        <ul class="nav nav-tabs" id="myTab">
          <li class="active"><a data-toggle="tab" href="#sectionB">Running Processes</a></li>
          <li><a data-toggle="tab" href="#sectionC">Running Instances</a></li>
        </ul>
      </div>
    </nav>
 <%
 
 out.println("<br>");
 
 if(null!=request.getAttribute("message")){
	 String message=(String)request.getAttribute("message");
	 out.println(message);
	 
 }
 else
 {
	 out.println("");
 }
 
 out.println("<br>");
 
 
 
 %>
	<div class="container">
		<div class="tab-content">

			<div id='sectionB' class='tab-pane fade in active'>
				<h2>Running Processess</h2>
				<form action="tasksubmission.jsp" method="post">
				<table class='table table-striped'>
					<thead>
						<tr>
							<th>Process Name</th>
							<th>Id</th>
							<th>Version</th>
							<th>Process Key</th>
						</tr>
					</thead>
					<tbody>
						<%
						List<ProcessDefinition> list2 = (ArrayList<ProcessDefinition>) request.getAttribute("procList");
						for (ProcessDefinition procDef : list2) {
							out.println("<tr><td><input type='radio' name='task' value='"+procDef.getKey()+"'></td>");
							out.println("<td>" + procDef.getName() + "</td>");
							out.println("<td>" + procDef.getId() + "</td>");
							out.println("<td>" + procDef.getVersion() + "</td>");
							out.println("<td>" + procDef.getKey() + "</td></tr>");
						}
						%>
					</tbody>
				</table>
				<button type="submit" class="btn btn-primary">Run Selected Process </button>
				</form>
			</div>
			<div id='sectionC' class='tab-pane fade'>
				<h2>Running Instances</h2>
				<table class='table table-striped'>
					<thead>
						<tr>
							<th>Task Name</th>
							<th>Id</th>
							<th>Task Definition Key</th>
							<th>Assignee</th>
							<th>Created</th>
							<th>Due</th>
							<th>Priority</th>
							<th>Suspended</th>
						</tr>
					</thead>
					<tbody>
						<%
						List<TaskList> task = (ArrayList<TaskList>) request.getAttribute("taskList");
						for (TaskList taskLst : task) {
							out.println("<tr><td>" + taskLst.getName() + "</td>");
							out.println("<td>" + taskLst.getId() + "</td>");
							out.println("<td>" + taskLst.getTaskDefinitionKey() + "</td>");
							out.println("<td>" + taskLst.getAssignee() + "</td>");
							out.println("<td>" + taskLst.getCreated() + "</td>");
							out.println("<td>" + taskLst.getDue() + "</td>");
							out.println("<td>" + taskLst.getPriority() + "</td>");
							out.println("<td>" + taskLst.isSuspended() + "</td></tr>");
						}
						%>
					</tbody>
				
				</table>
				
			</div>
			



		</div>
	</div>
</body>
</html>