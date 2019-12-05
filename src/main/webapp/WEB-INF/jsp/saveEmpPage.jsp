<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加员工页面</title>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#name").change(function(){
			var name = $("this").val();
			var args = {"ename":name,"date":new Date()};
			$.ajax({
				url:"${pageContext.request.contextPath}/checkName",
				type:"post",
				data:args,
				success:function(result){
					if(result=="0"){
						alert("用户名可用")
					}else {
						alert("用户名不可用")
					}
				}
			});
		});
	});
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/saveEmp" method="post">
		姓名<input type="text" id="name" name="ename">
		年龄<input type="text" name="eage">
		部门<select class="form-control" name="dept.did">
			    <c:forEach items="${depts }" var="dept">
			    	<option value="${dept.did }">${dept.dname }</option>
			    </c:forEach>	
		    </select>
		    <input type="submit" value="提交">
	</form>
</body>
</html>