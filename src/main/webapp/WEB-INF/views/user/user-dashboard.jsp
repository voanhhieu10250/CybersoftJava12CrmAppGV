<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="cybersoft.java12.crmapp.util.UrlConst" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>User dashboard</title>
</head>
<body>
	<!-- Breadcrumb -->
	<div class="container page__heading-container">
	    <div class="page__heading">
	        <div class="d-flex align-items-center">
	            <div>
	                <nav aria-label="breadcrumb">
	                    <ol class="breadcrumb mb-0">
	                        <li class="breadcrumb-item"><a href="<c:url value="<%= UrlConst.HOME %>" />">Home</a></li>
	                        <li class="breadcrumb-item"><a href="#">User</a></li>
	                        <li class="breadcrumb-item active" aria-current="page">
	                            User Dashboard
	                        </li>
	                    </ol>
	                </nav>
	                <h1 class="m-0">User Dashboard</h1>
	            </div>
	            <div class="ml-auto">
	                <a href="<c:url value="<%= UrlConst.USER_ADD %>" />" class="btn btn-light">
	                	<i class="material-icons icon-16pt text-muted mr-1">settings</i>Add New User
	                </a>
	            </div>
	        </div>
	    </div>
	</div>
	<!-- End Breadcrumb -->
	
	<!-- START BODY -->
	<div class="container">
		<div class="card card-form">
	        <div class="row no-gutters">
                <table class="table mb-0 thead-border-top-0">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Role</th>
                            <th>Phone</th>
                            <th>#</th>
                        </tr>
                    </thead>
                    <tbody class="list" id="staff02">
                    	<c:choose>
                    		<c:when test="${users == null}">
                    			<tr>
                    				<td>There is no data</td>
                    			</tr>
                    		</c:when>
                    		<c:otherwise>
	                    		<c:forEach var="user" items="${users}">
		                    		<tr>
			                            <td>
			                                ${user.name}
			                            </td>
			                            <td>${user.email}</td>
			                            <td><span class="badge badge-primary">${user.role.name}</span></td>
			                            <td>${user.phone}</td>
			                            <td>
			                            	<a href="" class="text-muted"><span class="material-icons">settings</span></a>
			                            	<a href="<c:url value="<%= UrlConst.USER_DELETE %>"/>?id=${user.id}" class="text-muted"><span class="material-icons">delete</span></a>
			                            </td>
			                        </tr>
	                    		</c:forEach>
                    		</c:otherwise>
                    	</c:choose>
                    </tbody>
                </table>
	        </div>
	    </div>
	</div>
</body>
</html>