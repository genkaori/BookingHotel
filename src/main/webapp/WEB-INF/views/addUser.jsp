<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h2 class="margin-bottom-10">Add User Instance</h2>
<form:form action="${pageContext.request.contextPath}/addUser"
	modelAttribute="userForm" class="templatemo-login-form" method="post">
	<form:hidden path="id" class="form-control" id="id" />
	<div class="row form-group">

		<div class="col-lg-6 col-md-6 form-group">
			<label for="fullname">Full Name</label>
			<form:input path="fullname" class="form-control" id="fullname" />

		</div>

		<div class="col-lg-6 col-md-6 form-group">
			<label for="username">User Name</label>
			<form:input path="username" class="form-control" id="username" />

		</div>
		<div class="col-lg-6 col-md-6 form-group">
			<label for="password">Password</label>
			<form:input path="password" class="form-control" id="password" />

		</div>
		<div class="col-lg-6 col-md-6 form-group">
			<label for="email"> email</label>
			<form:input path="email" class="form-control" id="email" />

		</div>
		<div class="col-lg-6 col-md-6 form-group">
			<label for="phone"> email</label>
			<form:input path="phone" class="form-control" id="phone" />

		</div>
		<div class="col-lg-6 col-md-6 form-group">
			<label for="role">Role</label>
			<form:input path="role" class="form-control" id="role" />

		</div>



		<div class="col-lg-6 col-md-6 form-group">

			<form:errors path="*"></form:errors>

		</div>

		<div class="col-lg-6 col-md-6 form-group">
			<input type="submit" value="Submit" class="btn btn-primary" />

		</div>

	</div>
</form:form>
