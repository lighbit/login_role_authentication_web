<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>

<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a
		href="${pageContext.request.contextPath}/dashboard">Home</a></li>
	<li class="breadcrumb-item active">Form 2 Data</li>
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
						<th>Jml Pembukaan Rek.</th>
						<th>Nom Setoran Awal</th>
						<th>Freq Setoran</th>
						<th>Nom Setoran</th>
						<th>Freq Tarik Tunai</th>
						<th>Nom Tarik Tunai</th>
						<th>Freq Pindah Buku</th>
						<th>Nom Pindah Buku</th>
						<th>Freq Tutup BSA</th>
						<th>Nom Tutup BSA</th>
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
						<th>Jml Pembukaan Rek.</th>
						<th>Nom Setoran Awal</th>
						<th>Freq Setoran</th>
						<th>Nom Setoran</th>
						<th>Freq Tarik Tunai</th>
						<th>Nom Tarik Tunai</th>
						<th>Freq Pindah Buku</th>
						<th>Nom Pindah Buku</th>
						<th>Freq Tutup BSA</th>
						<th>Nom Tutup BSA</th>
					</tr>
				</tfoot>
				<tbody>
					<c:forEach items="${models}" var="form2" varStatus="number">
						<!-- 16 total -->
						<tr>
							<td>${number.count}</td>
							<td>${fn:escapeXml(form2.bankCode)}</td>
							<td>${fn:escapeXml(form2.namaAgen)}</td>
							<td>${fn:escapeXml(form2.noIdAgen)}</td>
							<td>${fn:escapeXml(form2.jenisAgen)}</td>
							<td>${fn:escapeXml(form2.city)}</td>
							<td>${fn:escapeXml(form2.jumRekCustPerAgent)}</td>
							<td>${fn:escapeXml(form2.nominalSetoranAwal)}</td>
							<td>${fn:escapeXml(form2.freqDeposit)}</td>
							<td>${fn:escapeXml(form2.nomSetorTunai)}</td>
							<td>${fn:escapeXml(form2.frekTarikTunai)}</td>
							<td>${fn:escapeXml(form2.nomTarikTunai)}</td>
							<td>${fn:escapeXml(form2.frekPindahBuku)}</td>
							<td>${fn:escapeXml(form2.nomPindahBuku)}</td>
							<td>${fn:escapeXml(form2.frekTutupBSA)}</td>
							<td>${fn:escapeXml(form2.nomTutupBSA)}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- <div class="card-footer small text-muted">Updated yesterday at
		11:59 PM</div> -->
</div>