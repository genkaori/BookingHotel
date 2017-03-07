<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h2 class="margin-bottom-10">Add New User</h2>
<form:form action="${pageContext.request.contextPath}/newUser"
	modelAttribute="userForm" class="templatemo-login-form" method="post">
	<form:hidden path="id" class="form-control" id="id" />
	
	<div class="input-group input-sm">
		<label for="fullname">Full Name</label>
		<form:input path="fullname" class="form-control" id="fullname" />
	</div>

	<div class="input-group input-sm">
		<label for="username">User Name</label>
		<form:input path="username" class="form-control" id="username" />

	</div>
	<div class="input-group input-sm">
		<label for="password">Password</label>
		<form:input path="password" class="form-control" id="password" />

	</div>
	<div class="input-group input-sm">
		<label for="email"> email</label>
		<form:input path="email" class="form-control" id="email" />

	</div>
	<div class="input-group input-sm">
		<label for="phone"> phone</label>
		<form:input path="phone" class="form-control" id="phone" />

	</div>
	<div class="input-group input-sm">
		<label for="role">Role</label>
		<form:input path="role" class="form-control" id="role" />
		<!-- <select input path="role" class="form-control" id="role">
				<option value="volvo">User</option>
				<option value="saab">Admin</option>
			</select> -->
	</div>

	<div class="input-group input-sm">
		<input type="submit" value="Submit" class="btn btn-primary" />
	</div>
	</div>
</form:form>