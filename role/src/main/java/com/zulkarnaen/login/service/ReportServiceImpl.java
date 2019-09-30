package com.zulkarnaen.login.service;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zulkarnaen.login.model.AgentHistoryModel;
import com.zulkarnaen.login.model.AgentModel;
import com.zulkarnaen.login.model.CustomerModel;
import com.zulkarnaen.login.model.Form1Model;
import com.zulkarnaen.login.model.Form2Model;
import com.zulkarnaen.login.model.Form4Model;
import com.zulkarnaen.login.model.Form9Model;
import com.zulkarnaen.login.model.TransactionModel;
import com.zulkarnaen.login.model.form4ModelOut;
import com.zulkarnaen.login.repository.ReportRepository;

@Service("reportService")
@Transactional
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportRepository reportRepository;

	@Override
	public List<AgentModel> provideDataAgent(Date startDate, Date endDate) {
		// TODO GENERATE
		String dateStart = formatDateStart(startDate);
		String dateEnd = formatDateEnd(endDate);
		List<Object[]> agentObjects = reportRepository.findAgentByDate(dateStart, dateEnd);

		List<AgentModel> agents = new ArrayList<AgentModel>();
		for (Object[] object : agentObjects) {
			AgentModel agentModel = new AgentModel();
			// agentNo,BranchCode,createdDate,AccountNo,address,CIF,dob,email,name,phoneNo,sex,statusAgent
			agentModel.setAgentNo((String) object[0]);
			agentModel.setBranchCode((String) object[1]);
			agentModel.setCreatedDate((Date) object[2]);
			agentModel.setAccountNo((String) object[3]);
			agentModel.setAddress((String) object[4]);
			agentModel.setCIF((String) object[5]);
			agentModel.setDob((Date) object[6]);
			agentModel.setEmail((String) object[7]);
			agentModel.setName((String) object[8]);
			agentModel.setPhoneNo((String) object[9]);
			agentModel.setSex((String) object[10]);
			agentModel.setStatusAgent((String) object[11]);

			agents.add(agentModel);
		}
		return agents;
	}

	@Override
	public List<CustomerModel> provideDataCustomer(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		String dateStart = formatDateStart(startDate);
		String dateEnd = formatDateEnd(endDate);
		List<Object[]> customerObjects = reportRepository.findCustomerByDate(dateStart, dateEnd);

		List<CustomerModel> customers = new ArrayList<CustomerModel>();

		for (Object[] objects : customerObjects) {
			CustomerModel customer = new CustomerModel();
			customer.setBranchCode((String) objects[0]);
			customer.setTanggalDibuat((Date) objects[1]);
			customer.setNomorKartu((String) objects[2]);
			customer.setNomorRekening((String) objects[3]);
			customer.setTanggalUpdate((Date) objects[4]);
			customer.setAlamat((String) objects[5]);
			customer.setCIF((String) objects[6]);
			customer.setTanggalLahir((Date) objects[7]);
			customer.setEmail((String) objects[8]);
			customer.setName((String) objects[9]);
			customer.setPhoneNo((String) objects[10]);
			customer.setSex((String) objects[11]);
			customer.setStatus((String) objects[12]);
			customer.setAgentNo((String) objects[13]);

			customers.add(customer);

		}

		return customers;
	}

	private String formatDateStart(Date param) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar cal = Calendar.getInstance();
		cal.setTime(param);

		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);

		Date newFormatted = cal.getTime();

		String date = sdf.format(newFormatted);

		return date;
	}

	private String formatDateEnd(Date param) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar cal = Calendar.getInstance();
		cal.setTime(param);

		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.HOUR_OF_DAY, 23);

		Date newFormatted = cal.getTime();

		String date = sdf.format(newFormatted);

		return date;
	}

	@Override
	public List<TransactionModel> provideDataTransaction(Date startDate, Date endDate) {

		String dateStart = formatDateStart(startDate);
		String dateEnd = formatDateEnd(endDate);
		List<Object[]> transactionObjects = reportRepository.findTransactionByDate(dateStart, dateEnd);

		List<TransactionModel> transactionModels = new ArrayList<TransactionModel>();

		for (Object[] object : transactionObjects) {
			// tglTransaksi,namaCustomer,phoneNoCustomer,namaAgent,noAgent,transactionName,
			// accountSourceName,accountSourceNo,nominalTx,codeResponse,accountDestNo,accountDestName,txType

			TransactionModel model = new TransactionModel();

			model.setTglTransaksi((Date) object[0]);
			model.setNamaCustomer((String) object[1]);
			model.setPhoneNoCustomer((String) object[2]);
			model.setNamaAgent((String) object[3]);
			model.setNoAgent((String) object[4]);
			model.setTransactionName((String) object[5]);
			model.setAccountSourceName((String) object[6]);
			model.setAccountSourceNo((String) object[7]);
			model.setNominalTx((Double) object[8]);
			model.setCodeResponse((String) object[9]);
			model.setAccountDestNo((String) object[10]);
			model.setAccountDestName((String) object[11]);
			model.setTxType((String) object[12]);

			transactionModels.add(model);

		}

		return transactionModels;
	}

	@Override
	public List<AgentHistoryModel> provideDataAgentHistory(Date startDate, Date endDate) {

		String dateStart = formatDateStart(startDate);
		String dateEnd = formatDateEnd(endDate);
		List<Object[]> agentHistoryObjects = reportRepository.findAgentHistoryByDate(dateStart, dateEnd);

		List<AgentHistoryModel> agentHistoryModels = new ArrayList<AgentHistoryModel>();

		for (Object[] object : agentHistoryObjects) {
			// agentName,agentNo,tglAgentDaftar,
			// tglPelaksanaan,latitude,longitude,postalCode,city,perubahanAgent,cabangagent
			AgentHistoryModel model = new AgentHistoryModel();
			model.setAgentName((String) object[0]);
			model.setAgentNo((String) object[1]);
			model.setTglAgentDaftar((Date) object[2]);
			model.setTglPelaksanaan((Date) object[3]);
			model.setLatitude(((Double) object[4]).toString());
			model.setLongitude(((Double) object[5]).toString());
			model.setPostalCode((String) object[6]);
			model.setCity((String) object[7]);
			model.setPerubahanAgent((String) object[8]);
			model.setCabangAgent((String) object[9]);

			agentHistoryModels.add(model);
		}

		return agentHistoryModels;
	}

	@Override
	public List<Form1Model> provideForm1Data(Date startDate, Date endDate) {

		String dateStart = formatDateStart(startDate);
		String dateEnd = formatDateEnd(endDate);
		List<Object[]> form1Objects = reportRepository.findForm1ByDate(dateStart, dateEnd);

		List<Form1Model> form1Models = new ArrayList<Form1Model>();
		for (Object object[] : form1Objects) {

			// agentName,agentNo,tglAgentDaftar,tglPelaksanaan,latitude,longitude,postalCode,city,perubahanAgent,cabangagent

			Form1Model model = new Form1Model();
			model.setAgentName((String) object[0]);
			model.setAgentNo((String) object[1]);
			model.setTglAgentDaftar((Date) object[2]);
			model.setTglPelaksanaan((Date) object[3]);
			model.setLatitude(((Double) object[4]).toString());
			model.setLongitude(((Double) object[5]).toString());
			model.setPostalCode((String) object[6]);
			model.setCity((String) object[7]);
			model.setPerubahanAgent((String) object[8]);
			model.setCabangAgent((String) object[9]);

			model.setSandiBank("119");
			model.setElectronicDevice("Telepon Selular");
			model.setStatusAgent((String) object[10]);
			model.setJaringanKantor((String) object[11]);

			model.setJenisAgent("1");
			model.setKlasifikasiAgent("A");
			model.setJenisUsahaAgent("");
			model.setKategoriJaringanKantor("");
			model.setStatusPerkembanganAgent("");

			form1Models.add(model);

		}

		return form1Models;
	}

	@Override
	public List<Form2Model> provideForm2aData(Date startDate, Date endDate) {

		String dateStart = formatDateStart(startDate);
		String dateEnd = formatDateEnd(endDate);
		List<Object[]> form2Objects = reportRepository.findForm2ByDate(dateStart, dateEnd);

		List<Form2Model> form2aModels = new ArrayList<Form2Model>();

		for (Object[] object : form2Objects) {
			Form2Model model = new Form2Model();
			// namaAgen,noIdAgen,jenisAgen,lokasiAgen,branchCode,city,jumRekCustPerAgent,nominalSetoranAwal,
			// customer_id,freqDeposit,nomSetorTunai,frekTarikTunai,nomTarikTunai,frekPindahBuku,nomPindahBuku,frekTutupBSA,nomTutupBSA
			model.setBankCode("119");
			model.setNamaAgen((String) object[0]);
			model.setNoIdAgen((String) object[1]);
			model.setJenisAgen("1");
			model.setLokasiAgen((String) object[3]);
			model.setBranchCode((String) object[4]);
			model.setCity((String) object[5]);
			model.setJumRekCustPerAgent(((BigInteger) object[6]).toString());
			model.setNominalSetoranAwal((Double) object[7]);
			// model.setCustomer_id((String) object[8]);
			model.setFreqDeposit(((BigInteger) object[9]).intValue());
			model.setNomSetorTunai((Double) object[10]);
			model.setFrekTarikTunai(((BigInteger) object[11]).intValue());
			model.setNomTarikTunai((Double) object[12]);
			model.setFrekPindahBuku(((BigInteger) object[13]).intValue());
			model.setNomPindahBuku((Double) object[14]);
			model.setFrekTutupBSA(((BigInteger) object[15]).intValue());
			model.setNomTutupBSA((Double) object[16]);

			form2aModels.add(model);

		}

		return form2aModels;
	}

	@Override
	public List<form4ModelOut> provideForm4aData(Date startDate, Date endDate) {
		String dateStart = formatDateStart(startDate);
		String dateEnd = formatDateEnd(endDate);
		List<Object[]> form4Objects = reportRepository.findForm4ByDate(dateStart, dateEnd);

		List<Form4Model> form4aModels = new ArrayList<Form4Model>();

		for (Object[] object : form4Objects) {
			if (!("RC00").equals((String) object[5])) {
				Form4Model model = new Form4Model();
				model.setNamaAgen((String) object[0]);
				model.setNoIdAgen((String) object[1]);
				model.setJenisAgen((String) object[2]);
				model.setLokasiAgen((String) object[3]);
				model.setBranchCode((String) object[4]);
				model.setCity((String) object[5]);
				model.setBankCode((String) object[6]);

				form4aModels.add(model);
			}

		}

		List<form4ModelOut> form4aModelsOut = new ArrayList<form4ModelOut>();

		for (Object[] data : form4Objects) {
			form4ModelOut model = new form4ModelOut();
			if (!("RC00").equals((String) data[5])) {

				model.setNoAgent((String) data[1]);
				model.setAlasan("11");
				model.setJenisAgent("1");
				model.setLokasiAgent((String) data[2]);
				model.setNamaAgent((String) data[0]);
				model.setSandiBank("119");

				if (("DEPOSIT").equals((String) data[6])) {
					model.setTolakSetor((String) data[6]);

				} else if (("WITHDRAW").equals((String) data[6])) {
					model.setTolakTarik((String) data[6]);

				} else if (("BL_WITHIN_ONLINE").equals((String) data[6])) {
					model.setTolakPindaBuku((String) data[6]);

				} else if (("BLREGISTER").equals((String) data[3])) {
					model.setTolakBuka((String) data[3]);
				}

				form4aModelsOut.add(model);
			}
		}

		return form4aModelsOut;
	}

	@Override
	public List<Form9Model> provideForm9Data(Date startDate, Date endDate) {
		String dateStart = formatDateStart(startDate);
		String dateEnd = formatDateEnd(endDate);
		List<Object[]> form9Objects = reportRepository.findForm9ByDate(dateStart, dateEnd);

		List<Form9Model> form9Models = new ArrayList<Form9Model>();

		for (Object[] object : form9Objects) {
			Form9Model model = new Form9Model();
			model.setJmlAgent(((BigInteger) object[0]).intValue());
			model.setBankCode("119");
			model.setBranchCode((String) object[2]);
			model.setCity((String) object[3]);
			model.setFemaleCustmerCount(((BigInteger) object[5]).intValue());
			model.setMaleCustmerCount(((BigInteger) object[6]).intValue());
			model.setAgentMale(((BigInteger) object[7]).intValue());
			model.setAgentFemale(((BigInteger) object[8]).intValue());

			form9Models.add(model);

			// jmlAgent,idBranch,branchCode,city,parentBranchID,femaleCustmerCount,maleCustmerCount,agentMale,agentFemale

		}

		return form9Models;
	}

}