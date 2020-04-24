<%@page import="com.google.protobuf.Empty"%>
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
          <li class="active"><a data-toggle="tab" href="#sectionB">Processes</a></li>
          <li><a data-toggle="tab" href="#sectionC">Running Status</a></li>
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
				<h2>Processess</h2>
				<form action="tasksubmission.jsp" method="post">
				<table class='table table-striped'>
					<thead>
						<tr>
							<th>Select Process</th>
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
							if(procDef.getName()==null)
								out.println("<td></td>");
							else
								out.println("<td>" + procDef.getName()+ "</td>");
							if(procDef.getId()==null)
								out.println("<td></td>");
							else
								out.println("<td>" + procDef.getId() + "</td>");
							
							out.println("<td>" + procDef.getVersion() + "</td>");
							
							if(procDef.getKey()==null)
								out.println("<td></td></tr>");
							else
								out.println("<td>" + procDef.getKey() + "</td></tr>");
						}
						%>
					</tbody>
				</table>
				<button type="submit" class="btn btn-primary">Run Selected Process </button>
				</form>
			</div>
			<div id='sectionC' class='tab-pane fade'>
				<h2>Running Status</h2>
				<table class='table table-striped'>
					<thead>
						<tr>
							<th>Customer Id</th>
							<th>MSISDN</th>
							<th>Camunda Request Id</th>
							<th>Camunda Status</th>
						</tr>
					</thead>
					<tbody>
						<%
						List<Map<String,String>> processTaskList = (ArrayList<Map<String,String>>)request.getAttribute("processTaskList");
						for (Map<String,String> taskMap : processTaskList) {
							if(taskMap.get("custId")==null)
								out.println("<tr><td></td>");
							else
								out.println("<tr><td>"+taskMap.get("custId")+"</td>");
							if(taskMap.get("msisdn")==null)
								out.println("<td></td>");
							else
								out.println("<td>"+taskMap.get("msisdn")+"</td>");
							if(taskMap.get("cmreqid")==null)
								out.println("<td></td>");
							else
								out.println("<td>"+taskMap.get("cmreqid")+"</td>");
							if(taskMap.get("cmstatus")==null)
								out.println("<td></td></tr>");
							else
								out.println("<td>"+taskMap.get("cmstatus")+"</td></tr>");
						}
						%>
					</tbody>
				
				</table>
				
			</div>
			



		</div>
	</div>
</body>
</html>