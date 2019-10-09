<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>

<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a
		href="${pageContext.request.contextPath}/dashboard">Home</a></li>
	<li class="breadcrumb-item active">Form 4 Data</li>
</ol>

<c:url var="loginUrl" value="/searchForm4a" />
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

			$(function() {
				$(document).on("click", "#search", function() {
					document.getElementById('current').value = 0;
				});
			});

			$(document).ready(function() {
				$('#example').DataTable({
					dom : 'Bfrtip',
					buttons : [ {
						extend : 'excelHtml5',
						title : 'Data export Bank Riau Kepri Form4a'
					}, {
						extend : 'pdfHtml5',
						title : 'Data export Bank Riau Kepri Form4a',
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
		<i class="fas fa-table"></i> Data Table Form4a
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table id="example" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
					<tr>
						<th>No</th>
						<th>Kode Bank</th>
						<th>Nama Agen</th>
						<th>No Agen</th>
						<th>Jenis</th>
						<th>Lokasi</th>
						<th>Penolakan Pembukaan BSA</th>
						<th>Penolakan Penyetoran BSA</th>
						<th>Penolakan Penarikan BSA</th>
						<th>Penolakan Pemindahan buku BSA</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>No</th>
						<th>Kode Bank</th>
						<th>Nama Agen</th>
						<th>No Agen</th>
						<th>Jenis</th>
						<th>Lokasi</th>
						<th>Penolakan Pembukaan BSA</th>
						<th>Penolakan Penyetoran BSA</th>
						<th>Penolakan Penarikan BSA</th>
						<th>Penolakan Pemindahan buku BSA</th>
					</tr>
				</tfoot>
				<tbody>
					<c:forEach items="${models}" var="form4" varStatus="number">
						<!-- 10 total -->
						<tr>
							<td>${number.count}</td>
							<td>${fn:escapeXml(form4.sandiBank)}</td>
							<td>${fn:escapeXml(form4.namaAgent)}</td>
							<td>${fn:escapeXml(form4.noAgent)}</td>
							<td>${fn:escapeXml(form4.jenisAgent)}</td>
							<td>${fn:escapeXml(form4.lokasiAgent)}</td>
							<td>${fn:escapeXml(form4.tolakBuka)}</td>
							<td>${fn:escapeXml(form4.tolakSetor)}</td>
							<td>${fn:escapeXml(form4.tolakTarik)}</td>
							<td>${fn:escapeXml(form4.tolakPindaBuku)}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- <div class="card-footer small text-muted">Updated yesterday at
		11:59 PM</div> -->
</div>