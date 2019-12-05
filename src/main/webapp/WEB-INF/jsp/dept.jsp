<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
<title>部门</title>
</head>
<body>
	<div class="container">
	   <table class="table table-hover table-bordered" >
	      <tr>
	        <th>ID</th>
	        <th>部门</th>
	        <th colspan="3">操作</th>
	      </tr>
	      <c:forEach items="${depts}" var="dept">
	       <tr>
	         <td>${dept.did}</td>
	         <td>${dept.dname}</td>
	         <td><a href="${pageContext.request.contextPath }/saveDept">增加</a> </td>
	         <td><a>删除</a> </td>
	         <td><a>修改</a> </td>
	       </tr>
	      </c:forEach>
	    </table>
	</div>
</body>
</html>