<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Find User</title>

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
            <h1>Search for User by Name</h1>

            <div class="container p-3 my-3">
                <form action="findusers" method="post">
                    <div class="form-group">
                        <label for="name">name:</label>
                        <input type="text" class="form-control" id="name"
                               placeholder="Enter name here" name="name"
                               value="${fn:escapeXml(param.name)}">
                    </div>
                    <button type="submit" class="btn btn-primary">Search</button>
                    <a href="usercreate" class="btn btn-primary">Create User</a>
                </form>

                <c:if test="${messages.showToast}">
                    <div class="toast" data-autohide="false">
                        <div class="toast-header">
                            <strong class="mr-auto text-primary">Search Result</strong>
                            <button type="button" class="ml-2 mb-1 close" data-dismiss="toast">&times;</button>
                        </div>
                        <div class="toast-body">
                            ${messages.resultMessage}
                        </div>
                    </div>
                </c:if>
            </div>

            <h1>Matching Users</h1>

            <div class="container table-responsive p-3 my-3">
                <table class="table table-dark table-striped">
                    <thead>
                    <tr>
                        <th>userId</th>
                        <th>email</th>
                        <th>password</th>
                        <th>name</th>
                        <th>memberSince</th>
                        <th>reviewCount</th>
                        <th>useful</th>
                        <th>Delete User</th>
                        <th>Update Password</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${users}" var="user" >
                        <tr>
                            <td><c:out value="${user.getUserId()}" /></td>
                            <td><c:out value="${user.getEmail()}" /></td>
                            <td><c:out value="${user.getPassword()}" /></td>
                            <td><c:out value="${user.getName()}" /></td>
                            <td><c:out value="${user.getMemberSince()}" /></td>
                            <td><c:out value="${user.getReviewCount()}" /></td>
                            <td><c:out value="${user.getUseful()}" /></td>
                            <td><a href="userdelete?userId=<c:out value="${user.getUserId()}"/>"
                                   class="btn btn-primary">Delete</a></td>
                            <td><a href="userupdate?userId=<c:out value="${user.getUserId()}"/>"
                                   class="btn btn-primary">Update</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>

    <script>
        $(document).ready(function(){
            $('.toast').toast('show');
        });
    </script>
</html>
