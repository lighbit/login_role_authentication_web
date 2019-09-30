<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>

<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a
		href="${pageContext.request.contextPath}/">Home</a></li>
	<li class="breadcrumb-item active">Form 1 Data</li>
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
						<th>Jenis Usaha Agent</th>
						<th>Kategori Jaringan Kantor</th>
						<th>Status Perkembangan Agen</th>
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
						<th>Jenis Usaha Agent</th>
						<th>Kategori Jaringan Kantor</th>
						<th>Status Perkembangan Agen</th>
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
							<td>${fn:escapeXml(form1.jenisUsahaAgent)}</td>
							<td>${fn:escapeXml(form1.kategoriJaringanKantor)}</td>
							<td>${fn:escapeXml(form1.statusPerkembanganAgent)}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- <div class="card-footer small text-muted">Updated yesterday at
		11:59 PM</div>  -->
</div>