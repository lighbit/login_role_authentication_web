<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:getAsString name="title" /></title>

<!-- CSS -->
<link href="<c:url value='/static/css/sb-admin.css' />" rel="stylesheet"
	type="text/css"></link>
<link href="<c:url value='/static/css/sb-admin.min.css' />"
	rel="stylesheet" type="text/css"></link>
<link
	href="<c:url value='/static/vendor/datatables/dataTables.bootstrap4.css' />"
	rel="stylesheet" type="text/css"></link>

<!-- JS -->
<script src="<c:url value='/static/vendor/jquery/jquery.min.js' />"
	type="text/javascript"></script>

<script src="<c:url value='/static/js/sb-admin.js' />"
	type="text/javascript"></script>

<script src="<c:url value='/static/js/sb-admin.min.js' />"
	type="text/javascript"></script>

<script src="<c:url value='/static/js/demo/datatables-demo.js' />"
	type="text/javascript"></script>

<script
	src="<c:url value='/static/vendor/jquery-easing/jquery.easing.min.js' />"
	type="text/javascript"></script>
<script
	src="<c:url value='/static/vendor/bootstrap/js/bootstrap.bundle.min.js' />"
	type="text/javascript"></script>
<script
	src="<c:url value='/static/vendor/datatables/jquery.dataTables.js' />"
	type="text/javascript"></script>
<script
	src="<c:url value='/static/vendor/datatables/dataTables.bootstrap4.js' />"></script>

<!-- FONT -->
<link
	href="<c:url value='/static/vendor/fontawesome-free/css/all.min.css' />"
	rel="stylesheet" type="text/css"></link>

</head>

<body id="page-top">
	<header id="header">
		<tiles:insertAttribute name="header" />
	</header>

	<div id="wrapper">
		<section id="sidemenu">
			<tiles:insertAttribute name="menu" />
		</section>
		<div id="content-wrapper">
			<div class="container-fluid">
				<section id="site-content">
					<tiles:insertAttribute name="body" />
				</section>
			</div>
			<footer id="footer">
				<tiles:insertAttribute name="footer" />
			</footer>
		</div>
	</div>

	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">�</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary"
						href="${pageContext.request.contextPath}/login">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		!function(l) {
			"use strict";
			l("#sidebarToggle").on(
					"click",
					function(o) {
						o.preventDefault(), l("body").toggleClass(
								"sidebar-toggled"), l(".sidebar").toggleClass(
								"toggled")
					}), l("body.fixed-nav .sidebar").on(
					"mousewheel DOMMouseScroll wheel",
					function(o) {
						if (768 < l(window).width()) {
							var e = o.originalEvent, t = e.wheelDelta
									|| -e.detail;
							this.scrollTop += 30 * (t < 0 ? 1 : -1), o
									.preventDefault()
						}
					}), l(document).on(
					"scroll",
					function() {
						100 < l(this).scrollTop() ? l(".scroll-to-top")
								.fadeIn() : l(".scroll-to-top").fadeOut()
					}), l(document).on("click", "a.scroll-to-top", function(o) {
				var e = l(this);
				l("html, body").stop().animate({
					scrollTop : l(e.attr("href")).offset().top
				}, 1e3, "easeInOutExpo"), o.preventDefault()
			})
		}(jQuery);
	</script>

</body>
</html>