<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
<title>员工</title>
</head>
<body>
	<div class="container">
        <table class="table table-hover table-bordered">
          <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>创建时间</th>
            <th>部门</th>
            <th colspan="3">操作</th>
          </tr>
          <c:forEach items="${page.content}" var="emp">
          <tr>
            <td>${emp.eid}</td>
            <td>${emp.ename}</td>
            <td>${emp.eage}</td>
            <td>
            	<fmt:formatDate value="${emp.time}" pattern="yyyy-MM-dd"/>
            </td>
            <td>${emp.dept.dname}</td>
            <td>
				<a href="${pageContext.request.contextPath }/saveEmpPage">添加</a>
            </td>
	         <td><a href="${pageContext.request.contextPath }/deleteEmp?eid=${emp.eid}">删除</a> </td>
	         <td><a href="${pageContext.request.contextPath }/updatePage?eid=${emp.eid}">修改</a> </td>
          </tr>
          </c:forEach>
        </table>
        <p>共${page.totalPages}页</p>
        <p>当前第${page.number+1}页</p>
        <a href="list?pageNo=${page.number+1}">上一页</a>
        <a href="list?pageNo=${page.number+1-1}">上一页</a>
        <a href="list?pageNo=${page.number+1+1}">下一页</a>
    </div>
    <!-- 模态框（Modal） -->
	<%-- <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel">模态框（Modal）标题</h4>
	            </div>
	            <div class="modal-body">
					<form>
					  <div class="form-group">
					    <label for="exampleInputEmail1">姓名</label>
					    <input type="text" name="ename" class="form-control" id="exampleInputEmail1" placeholder="姓名">
					  </div>
					  <div class="form-group">
					    <label for="exampleInputPassword1">年龄</label>
					    <input type="text" name="eage" class="form-control" id="exampleInputPassword1" placeholder="年龄">
					  </div>
					  <label for="exampleInputEmail1">部门</label>
					  <select class="form-control" name="dept.did">
						    <c:forEach items="${depts }" var="dept">
						    	<option value="${dept.did }">${dept.dname }</option>
						    </c:forEach>	
					    </select>
					</form>
				</div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	                <button type="button" class="btn btn-primary">提交更改</button>
	            </div>
	        </div>
	    </div> 
	</div>--%>
  </body>
</html>