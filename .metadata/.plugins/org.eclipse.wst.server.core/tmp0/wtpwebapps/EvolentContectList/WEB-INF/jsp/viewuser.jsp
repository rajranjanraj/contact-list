<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="jumbotron text-center bg-primary ">
<h1>List of Contacts</h1>
</div>
<div class="container">
<table class="table table-hover table-active">  
<tr class="bg-dark text-white"><th>FirstName</th><th>LastName</th><th>Email. </th><th>Phone No.</th><th>Status</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="user" items="${list}">   
   <tr>  
   <td>${user.firstName}</td>  
   <td>${user.lastName}</td>  
   <td>${user.emailId}</td>  
   <td>${user.phoneNo}</td> 
   <td>${user.status}</td>  
   <td><a href="edituser/${user.id}">Edit</a></td>  
   <td><a href="deleteuser/${user.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table> 
 </div>   
   <br/> 
   <div class="container"> 
   <a href="userform" class="btn btn-primary">Add New Contact</a>  
   </div>
</body>
</html>