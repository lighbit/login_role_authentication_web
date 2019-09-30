<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>

<div class="card card-login mx-auto mt-5">
	<div class="card-header">Login</div>
	<div class="card-body">
		<c:url var="loginUrl" value="/login" />
		<form action="${loginUrl}" method="post">
			<c:if test="${param.error != null}">
				<div class="alert alert-danger">
					<p>Username atau Password Salah.</p>
				</div>
			</c:if>
			<c:if test="${param.logout != null}">
				<div class="alert alert-success">
					<p>Kamu Berhasil Logout.</p>
				</div>
			</c:if>

			<div class="form-group">
				<div class="form-label-group">
					<input type="text" class="form-control" placeholder="Email address"
						required="required" autofocus="autofocus" id="username"
						name="ssoId"> <label for="inputEmail">Username</label>
				</div>
			</div>
			<div class="form-group">
				<div class="form-label-group">
					<input type="password" class="form-control" placeholder="Password"
						required="required" id="password" name="password"> <label
						for="inputPassword">Password</label>
				</div>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</div>
			<input class="btn btn-primary btn-block" type="submit" value="LOG IN">
		</form>
	</div>
</div>