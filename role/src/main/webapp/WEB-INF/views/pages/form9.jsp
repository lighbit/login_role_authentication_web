<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>

<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a
		href="${pageContext.request.contextPath}/dashboard">Home</a></li>
	<li class="breadcrumb-item active">Form 9 Data</li>
</ol>

<c:url var="loginUrl" value="/searchForm9" />
<form action="${loginUrl}" method="post">
	<div class="row">
		<div class='col-sm-3'>
			<div class="form-group">
				<div class='input-append date' id='datetimepicker6'>
					<input data-format="yyyy-MM-dd" type='text' class="form-control"
						name="date" value="${fn:escapeXml(date)}" placeholder="start"
						readonly /> <span class="add-on"> <i class="icon-th"></i>
					</span>
				</div>
			</div>
		</div>
		<div class='col-sm-3'>
			<div class="form-group">
				<div class='input-append date' id='datetimepicker7'>
					<input data-format="yyyy-MM-dd" type='text' class="form-control"
						name="endDate" value="${fn:escapeXml(endDate)}" placeholder="end"
						readonly /> <span class="add-on"> <i class="icon-th"></i>
					</span>
				</div>

			</div>
		</div>
		<div class='col-sm-3'>
			<div class="form-group">
				<button type="submit" class="btn btn-primary" name="search"
					id="search">Cari</button>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />

			</div>
		</div>
		<script type="text/javascript">
			$(function() {
				$('#datetimepicker6').datetimepicker({
					maskInput : false
				});
			});

			$(function() {
				$('#datetimepicker7').datetimepicker({
					maskInput : false
				});
			});

			$(function() {
				$(document).on("click", "#search", function() {
					document.getElementById('current').value = 0;
				});
			});
		</script>
	</div>
</form>

<!-- DataTables Example -->
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> Data Table Example
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th>No</th>
						<th>Kode Bank</th>
						<th>Kode Cabang</th>
						<th>Kota/Kabupaten</th>
						<th>Jml Agent Laki-Laki</th>
						<th>Jml Agent Perempuan</th>
						<th>Jml Agent Total</th>
						<th>Jml Customer Laki-Laki</th>
						<th>Jml Customer Perempuan</th>
						<th>Jml Customer Total</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>No</th>
						<th>Kode Bank</th>
						<th>Kode Cabang</th>
						<th>Kota/Kabupaten</th>
						<th>Jml Agent Laki-Laki</th>
						<th>Jml Agent Perempuan</th>
						<th>Jml Agent Total</th>
						<th>Jml Customer Laki-Laki</th>
						<th>Jml Customer Perempuan</th>
						<th>Jml Customer Total</th>
					</tr>
				</tfoot>
				<tbody>
					<c:forEach items="${models}" var="form9" varStatus="number">
						<!-- 10 total -->
						<tr>
							<td>${number.count}</td>
							<td>${fn:escapeXml(form9.bankCode)}</td>
							<td>${fn:escapeXml(form9.branchCode)}</td>
							<td>${fn:escapeXml(form9.city)}</td>
							<td>${fn:escapeXml(form9.agentMale)}</td>
							<td>${fn:escapeXml(form9.agentFemale)}</td>
							<td>${fn:escapeXml(form9.jmlAgent)}</td>
							<td>${fn:escapeXml(form9.maleCustmerCount)}</td>
							<td>${fn:escapeXml(form9.femaleCustmerCount)}</td>
							<td>${fn:escapeXml(form9.jmlCustomer)}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- <div class="card-footer small text-muted">Updated yesterday at
		11:59 PM</div> -->
</div>