<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Delete a User</title>

		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	</head>
	<body>
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<a class="navbar-brand" href="#">Trip Planning Assistant</a>
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link" href="home">Home</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="findlistings">Listing</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="findusers">User</a>
				</li>
			</ul>
		</nav>

		<div class="container p-3 my-3 border">
			<h1>Delete User</h1>

			<div class="container p-3 my-3">
				<form action="userdelete" method="post">
					<div class="form-group">
						<label for="userId">userId:</label>
						<input type="text" class="form-control" id="userId"
							   placeholder="Enter userId here" name="userId"
							   value="${fn:escapeXml(param.userId)}">
					</div>
					<button type="submit" class="btn btn-primary">Delete</button>
					<a href="findusers" class="btn btn-primary">Back</a>
				</form>

				<c:if test="${messages.showToast}">
					<div class="toast" data-autohide="false">
						<div class="toast-header">
							<strong class="mr-auto text-primary">Update Result</strong>
							<button type="button" class="ml-2 mb-1 close" data-dismiss="toast">&times;</button>
						</div>
						<div class="toast-body">
							${messages.resultMessage}
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</body>

	<script>
		$(document).ready(function(){
			$('.toast').toast('show');
		});
	</script>
</html>