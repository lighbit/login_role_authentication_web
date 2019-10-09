<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>

<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a
		href="${pageContext.request.contextPath}/dashboard">Home</a></li>
	<li class="breadcrumb-item active">Form 1 Data</li>
</ol>
<c:url var="loginUrl" value="/searchForm1" />
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
					maskInput : false,
					todayHighlight : 'TRUE',
					autoclose : true
				});
			});

			$(function() {
				$('#datetimepicker7').datetimepicker({
					maskInput : false,
					todayHighlight : 'TRUE',
					autoclose : true
				});
			});

			$(document).ready(function() {
				$('#example').DataTable({
					dom : 'Bfrtip',
					buttons : [ {
						extend : 'excelHtml5',
						title : 'Data export Bank Riau Kepri Form1'
					}, {
						extend : 'pdfHtml5',
						title : 'Data export Bank Riau Kepri Form1',
						orientation: 'landscape',
		                pageSize: 'LEGAL'
					} ]
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
			<table id="example" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
					<tr>
						<th>No</th>
						<th>Kode Bank</th>
						<th>Nama</th>
						<th>Agent No</th>
						<th>Kode Cabang</th>
						<th>Latitude</th>
						<th>Longitude</th>
						<th>Kode Pos</th>
						<th>Kota</th>
						<th>Electronic Device</th>
						<th>Jaringan Kantor Bank</th>
						<th>Tgl Daftar</th>
						<th>Tgl Pelaksanaan</th>
						<th>Perubahan</th>
						<th>Agent Status</th>
						<th>Jenis Agent</th>
						<th>Klasifikasi Agent</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>No</th>
						<th>Kode Bank</th>
						<th>Nama</th>
						<th>Agent No</th>
						<th>Kode Cabang</th>
						<th>Latitude</th>
						<th>Longitude</th>
						<th>Kode Pos</th>
						<th>Kota</th>
						<th>Electronic Device</th>
						<th>Jaringan Kantor Bank</th>
						<th>Tgl Daftar</th>
						<th>Tgl Pelaksanaan</th>
						<th>Perubahan</th>
						<th>Agent Status</th>
						<th>Jenis Agent</th>
						<th>Klasifikasi Agent</th>
					</tr>
				</tfoot>
				<tbody>
					<c:forEach items="${models}" var="form1" varStatus="number">
						<!-- 20 total -->
						<tr>
							<td>${number.count}</td>
							<td>${fn:escapeXml(form1.sandiBank)}</td>
							<td>${fn:escapeXml(form1.agentName)}</td>
							<td>${fn:escapeXml(form1.agentNo)}</td>
							<td>${fn:escapeXml(form1.cabangAgent)}</td>
							<td>${fn:escapeXml(form1.latitude)}</td>
							<td>${fn:escapeXml(form1.longitude)}</td>
							<td>${fn:escapeXml(form1.postalCode)}</td>
							<td>${fn:escapeXml(form1.city)}</td>
							<td>${fn:escapeXml(form1.electronicDevice)}</td>
							<td>${fn:escapeXml(form1.jaringanKantor)}</td>
							<td>${fn:escapeXml(form1.tglAgentDaftar)}</td>
							<td>${fn:escapeXml(form1.tglPelaksanaan)}</td>
							<td>${fn:escapeXml(form1.perubahanAgent)}</td>
							<td>${fn:escapeXml(form1.statusAgent)}</td>
							<td>${fn:escapeXml(form1.jenisAgent)}</td>
							<td>${fn:escapeXml(form1.klasifikasiAgent)}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- <div class="card-footer small text-muted">Updated yesterday at
		11:59 PM</div>  -->
</div>