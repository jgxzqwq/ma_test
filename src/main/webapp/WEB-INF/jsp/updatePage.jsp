<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改页面</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/update" method="post">
		<input type="hidden" name="eid" value="${emp.eid }">
		姓名<input type="text" name="ename" value="${emp.ename }">
		年龄<input type="text" name="eage" value="${emp.eage }">
		部门<%-- <select class="form-control" name="dept.did">
			    <c:forEach items="${depts }" var="dept">
			    	<option value="${dept.did }">${dept.dname }</option>
			    </c:forEach>	
		    </select> --%>
		    <input type="submit" value="提交">
	</form>
</body>
</html>