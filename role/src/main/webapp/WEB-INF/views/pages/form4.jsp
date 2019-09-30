<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>

<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a
		href="${pageContext.request.contextPath}/">Home</a></li>
	<li class="breadcrumb-item active">Form 4 Data</li>
</ol>

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