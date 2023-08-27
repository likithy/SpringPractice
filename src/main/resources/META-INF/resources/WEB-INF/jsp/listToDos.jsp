<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<title>To do page</title>
<body>
<div class="container">
<h1>List To do's for ${name}!!!</h1>
<hr><h1> Your Todos are </h1></hr>
<table class="table">
<thead>
<tr>
<th>id</th>
<th>username</th>
<th>description</th>
<th>target date</th>
<th>done status</th>
<th>Update</th>
<th>Delete</th>
</tr>
</thead>
<c:forEach items="${ToDos}" var ="todo">
<tr>
<td>${todo.id}</td>
<td>${todo.username}</td>
<td>${todo.description}</td>
<td>${todo.targetDate}</td>
<td>${todo.done}</td>
<td> <a href="update-todo?id=${todo.id}" class="btn btn-success"> UPDATE</a> </td>
<td> <a href="delete-todo?id=${todo.id}" class="btn btn-danger"> DELETE</a> </td>
</tr>
</c:forEach>
</table>
<a href="add-todo" class ="btn btn-success"> Add ToDo </a>
</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>