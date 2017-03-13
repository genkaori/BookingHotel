<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<div class="row mt">
		<div class="col-lg-12">
			<div class="form-panel">
				<h4>
					<i class="fa fa-angle-right"></i> Update User infomation
				</h4>
				<form class="form-horizontal style-form" modelAttribute="userForm"
					action="${pageContext.request.contextPath}/updateUser"
					method="post">
					<c:if test="${!empty errUpdateUser}">
						<p>
						<h3 style="color: red">
							<c:out value="${errUpdateUser}" />
						</h3>
						</p>
					</c:if>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">Id</label>
						<div class="col-sm-10">
							<input class="form-control" name="id" name="id" type="text"
								path="id" value="${userForm.id}" readonly>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">Full name</label>
						<div class="col-sm-10">
							<p id="errFullname" style="color: red"></p>
							<input class="form-control" name="fullname" type="text"
								path="fullname" value="${userForm.fullname}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">Username</label>
						<div class="col-sm-10">
							<p id="errUsername" style="color: red"></p>
							<input class="form-control" name="username" type="text"
								path="username" value="${userForm.username}">
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<p id="errPassword" style="color: red"></p>
							<input class="form-control" name="password" type="text"
								path="password" value="${userForm.password}">
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">Email</label>
						<div class="col-sm-10">
							<p id="errEmail" style="color: red"></p>
							<input class="form-control" name="email" type="text" path="email"
								value="${userForm.email}">
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">Phone</label>
						<div class="col-sm-10">
							<p id="errPhone" style="color: red"></p>
							<input class="form-control" name="phone" type="text" path="phone"
								value="${userForm.phone}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">Role</label>
						<div class="col-sm-10">
							<p id="errRole" style="color: red"></p>
							<input class="form-control" name="role" type="text" path="role"
								value="${userForm.role}">
						</div>
					</div>
					<div style="text-align: left">
						<button type="submit" class="btn btn-theme" id="btnSubmit">Update</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
