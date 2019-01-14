<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>Users</title>
 <link href="webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="webjars/jquery/3.0.0/jquery.min.js"></script>
</head>
<body>
 <div class="container">
  <div class="card-deck mt-2">
   <div class="card">
    <div class="card-header">
        <span class="font-weight-bold">Click here to download Data Siswa</span>
    </div>
    <div class="card-body">
     <spring:url value="/export" var="actionURL" />
     <form:form method="post" action="${actionURL }">
      <button type="submit" class="btn btn-info" >Download PDF</button>
     </form:form>
    </div>
   </div>
  </div>
 </div>
</body>
</html>