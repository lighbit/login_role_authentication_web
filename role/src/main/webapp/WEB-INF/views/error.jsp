<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>

<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a
		href="${pageContext.request.contextPath}/dashboard">Dashboard</a></li>
	<li class="breadcrumb-item active">404 Error</li>
</ol>

<!-- Page Content -->
<h1 class="display-1">SORRY :(</h1>
<p class="lead">
	Page not found. You can <a href="javascript:history.back()">go back</a>
	to the previous page, or <a href="${pageContext.request.contextPath}/">return
		home</a>.
</p>