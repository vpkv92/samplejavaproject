<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Camunda Rest Client</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">CamundaRestClient</a>
    </div>
  </div>
</nav>
<%
String tskky=request.getParameter("task");
%>
<div class="container">
<form action="startTask" method="post" style="width:'30%'">
  <div class="form-group">
  	<input type="hidden" name="task" value="<%=tskky%>">
    <label for="custId">Customer Id</label>
    <input type="text" class="form-control" name="custId" placeholder="Enter Customer Id">
  </div>
  <div class="form-group">
    <label for="msisdn">MSISDN</label>
    <input type="text" class="form-control" name="msisdn" placeholder="Enter MSISDN">
  </div>
  <div class="form-group">
    <label for="protype">Service Provider</label>
    <input type="text" class="form-control" name="protype" placeholder="Enter Service Provider Code(SP101/SP102)">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</body>
</html>