package com.zulkarnaen.login.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class ReportRepositoryImpl implements ReportRepository {

	@Qualifier(value = "entityManager")
	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findCustomerByDate(String startDate, String endDate) {
		// TODO Auto-generated method stub

		String queryStr = "select (SELECT code FROM branch where id= cb.parentBranch_id) AS "
				+ "`branchCode`, c.createdDate AS `tanggalDibuat`, c.cardNo AS 'nomorKartu', "
				+ " c.string1 AS `nomorRekening`, c.updateDate AS `tanggalUpdate`, c.address AS "
				+ " `alamat`, c.cif AS `CIF`, c.dob AS `tanggalLahir`, c.email AS `email`, c.name "
				+ " AS `name`, c.phoneNo AS `phoneNo`, c.sex AS `sex`, c.status AS `status`, "
				+ " (SELECT a.agentNo FROM agent a where a.customer_id = c.agent_id) as 'agentNo' "
				+ " from (customer_bsa as cb join customer c) where (cb.customer_id = c.id and "
				+ " cb.createdDate BETWEEN :start AND :end) ";

		Query query = entityManager.createNativeQuery(queryStr);
		query.setParameter("start", startDate);
		query.setParameter("end", endDate);

		List<Object[]> objectList = query.getResultList();

		return objectList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findAgentByDate(String dateStart, String dateEnd) {
		String queryStr = " select \r\n" + "        ag.agentNo AS agentNo,\r\n"
				+ "        (SELECT code  FROM bolu_mamojo.branch where id= ag.parentBranch_id)  AS BranchCode,\r\n"
				+ "        c.createdDate AS createdDate,\r\n" + "        c.string1 AS AccountNo,\r\n"
				+ "        c.address AS address,\r\n" + "        c.cif AS CIF,\r\n" + "        c.dob AS dob,\r\n"
				+ "        c.email AS email,\r\n" + "        c.name AS name,\r\n" + "        c.phoneNo AS phoneNo,\r\n"
				+ "        c.sex AS sex,\r\n" + "        c.status AS statusAgent\r\n" + "    from\r\n"
				+ "        (bolu_mamojo.agent ag\r\n" + "        join bolu_mamojo.customer c)\r\n" + "    where\r\n"
				+ "        (ag.customer_id = c.id and\r\n" + "		ag.createdDate BETWEEN :start AND :end )";

		Query query = entityManager.createNativeQuery(queryStr);
		query.setParameter("start", dateStart);
		query.setParameter("end", dateEnd);

		List<Object[]> objectList = query.getResultList();

		return objectList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findTransactionByDate(String dateStart, String dateEnd) {

		String queryStr = "SELECT\r\n" + "	txbsa.createdDate as tglTransaksi,\r\n"
				+ "	(select cs.name from bolu_mamojo.customer as cs where cs.id = txbsa.customerBSA_id) as namaCustomer,\r\n"
				+ "	(select cs.phoneNo from bolu_mamojo.customer as cs where cs.id = txbsa.customerBSA_id) as phoneNoCustomer,\r\n"
				+ "	(select cs.name from bolu_mamojo.customer as cs where cs.id = txbsa.agent_id) as namaAgent,\r\n"
				+ "	(select ag.agentNo from bolu_mamojo.agent as ag where ag.customer_id = txbsa.agent_id) as noAgent,\r\n"
				+ "	(select tx.type from bolu_mamojo.transaction as tx where tx.id = txbsa.transaction_id) as transactionName,\r\n"
				+ "	(select tx.accountSourceName from bolu_mamojo.transaction as tx where tx.id = txbsa.transaction_id) as accountSourceName,\r\n"
				+ "	(select tx.accountSourceNo from bolu_mamojo.transaction as tx where tx.id = txbsa.transaction_id) as accountSourceNo,\r\n"
				+ "	(select tx.amount from bolu_mamojo.transaction as tx where tx.id = txbsa.transaction_id) as nominalTx,\r\n"
				+ "	(select msg.code from bolu_mamojo.msg_dictionary as msg where msg.id =\r\n"
				+ "		(select tx.responseCode_id from bolu_mamojo.transaction as tx where tx.id = txbsa.transaction_id)\r\n"
				+ "	) as codeResponse,\r\n"
				+ "	(select txh.accountDestination from transfer_history txh where txh.transaction_id = txbsa.transaction_id) as accountDestNo,\r\n"
				+ "	(select txh.accountDestinationName from transfer_history txh where txh.transaction_id = txbsa.transaction_id) as accountDestName,\r\n"
				+ "	(select txh.transferType from transfer_history txh where txh.transaction_id = txbsa.transaction_id) as txType\r\n"
				+ "FROM\r\n" + "	bolu_mamojo.transaction_bsa as txbsa\r\n" + "where \r\n"
				+ "	txbsa.createdDate BETWEEN :start AND :end";

		Query query = entityManager.createNativeQuery(queryStr);
		query.setParameter("start", dateStart);
		query.setParameter("end", dateEnd);

		List<Object[]> objectList = query.getResultList();

		return objectList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findAgentHistoryByDate(String dateStart, String dateEnd) {
		String queryStr = "SELECT\r\n"
				+ "	(select cs.name from bolu_mamojo.customer as cs where cs.id=ag.customer_id) as agentName,\r\n"
				+ "	ag.agentNo as agentNo,\r\n" + "	ag.createdDate as tglAgentDaftar,\r\n"
				+ "	agh.createdDate as tglPelaksanaan,\r\n" + "	(\r\n" + "		select \r\n"
				+ "			(select addr.latitude from bolu_mamojo.address as addr where addr.id=\r\n"
				+ "				(select \r\n" + "					br.address_id from bolu_mamojo.branch as br, \r\n"
				+ "					bolu_mamojo.agent as agY \r\n"
				+ "				where agY.branch_id = br.id and agY.agentID= agX.agentID) ) as latitude\r\n"
				+ "		from \r\n" + "			bolu_mamojo.agent as agX\r\n" + "		where \r\n"
				+ "			agX.agentID = ag.agentID\r\n" + "		\r\n" + "	) as latitude,\r\n" + "	(\r\n"
				+ "		select \r\n"
				+ "			(select addr.longitude from bolu_mamojo.address as addr where addr.id=\r\n"
				+ "				(select \r\n" + "					br.address_id from bolu_mamojo.branch as br, \r\n"
				+ "					bolu_mamojo.agent as agY \r\n"
				+ "				where agY.branch_id = br.id and agY.agentID= agX.agentID) ) as latitude\r\n"
				+ "		from \r\n" + "			bolu_mamojo.agent as agX\r\n" + "		where \r\n"
				+ "			agX.agentID = ag.agentID\r\n" + "		\r\n" + "	) as longitude,\r\n" + "	(\r\n"
				+ "		select \r\n"
				+ "			(select addr.postalCode from bolu_mamojo.address as addr where addr.id=\r\n"
				+ "				(select \r\n" + "					br.address_id from bolu_mamojo.branch as br, \r\n"
				+ "					bolu_mamojo.agent as agY \r\n"
				+ "				where agY.branch_id = br.id and agY.agentID= agX.agentID) ) as latitude\r\n"
				+ "		from \r\n" + "			bolu_mamojo.agent as agX\r\n" + "		where \r\n"
				+ "			agX.agentID = ag.agentID\r\n" + "		\r\n" + "	) as postalCode,\r\n" + "	(\r\n"
				+ "		select \r\n"
				+ "			(select ct.name from bolu_mamojo.address as addr, bolu_mamojo.city as ct where addr.id=\r\n"
				+ "				(select \r\n" + "					br.address_id from bolu_mamojo.branch as br, \r\n"
				+ "					bolu_mamojo.agent as agY \r\n"
				+ "				where agY.branch_id = br.id and agY.agentID= agX.agentID) and ct.id = addr.city_id ) as latitude\r\n"
				+ "		from \r\n" + "			bolu_mamojo.agent as agX\r\n" + "		where \r\n"
				+ "			agX.agentID = ag.agentID\r\n" + "	) as city,\r\n"
				+ "	agh.description as perubahanAgent,\r\n"
				+ "	(select br.code  from bolu_mamojo.branch as br, bolu_mamojo.agent agZ where agZ.branch_id= br.id and agZ.agentID= ag.agentID) as  cabangagent\r\n"
				+ "	FROM bolu_mamojo.agent_history as agh, bolu_mamojo.agent as ag\r\n"
				+ "	where agh.agent_agentID=ag.agentID\r\n" + "    and\r\n"
				+ "		 (agh.createdDate BETWEEN :start AND :end )";

		Query query = entityManager.createNativeQuery(queryStr);
		query.setParameter("start", dateStart);
		query.setParameter("end", dateEnd);

		List<Object[]> objectList = query.getResultList();

		return objectList;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findForm1ByDate(String dateStart, String dateEnd) {

		String queryStr = "SELECT\r\n"
				+ "	(select cs.name from bolu_mamojo.customer as cs where cs.id=ag.customer_id) as agentName,\r\n"
				+ "	ag.agentNo as agentNo,\r\n" + "	ag.createdDate as tglAgentDaftar,\r\n"
				+ "	agh.createdDate as tglPelaksanaan,\r\n" + "	(\r\n" + "		select \r\n"
				+ "			(select addr.latitude from bolu_mamojo.address as addr where addr.id=\r\n"
				+ "				(select \r\n" + "					br.address_id from bolu_mamojo.branch as br, \r\n"
				+ "					bolu_mamojo.agent as agY \r\n"
				+ "				where agY.branch_id = br.id and agY.agentID= agX.agentID) ) as latitude\r\n"
				+ "		from \r\n" + "			bolu_mamojo.agent as agX\r\n" + "		where \r\n"
				+ "			agX.agentID = ag.agentID\r\n" + "		\r\n" + "	) as latitude,\r\n" + "	(\r\n"
				+ "		select \r\n"
				+ "			(select addr.longitude from bolu_mamojo.address as addr where addr.id=\r\n"
				+ "				(select \r\n" + "					br.address_id from bolu_mamojo.branch as br, \r\n"
				+ "					bolu_mamojo.agent as agY \r\n"
				+ "				where agY.branch_id = br.id and agY.agentID= agX.agentID) ) as x\r\n"
				+ "		from \r\n" + "			bolu_mamojo.agent as agX\r\n" + "		where \r\n"
				+ "			agX.agentID = ag.agentID\r\n" + "		\r\n" + "	) as longitude,\r\n" + "	(\r\n"
				+ "		select \r\n"
				+ "			(select addr.postalCode from bolu_mamojo.address as addr where addr.id=\r\n"
				+ "				(select \r\n" + "					br.address_id from bolu_mamojo.branch as br, \r\n"
				+ "					bolu_mamojo.agent as agY \r\n"
				+ "				where agY.branch_id = br.id and agY.agentID= agX.agentID) ) as y\r\n"
				+ "		from \r\n" + "			bolu_mamojo.agent as agX\r\n" + "		where \r\n"
				+ "			agX.agentID = ag.agentID\r\n" + "		\r\n" + "	) as postalCode,\r\n" + "	(\r\n"
				+ "		select \r\n"
				+ "			(select ct.name from bolu_mamojo.address as addr, bolu_mamojo.city as ct where addr.id=\r\n"
				+ "				(select \r\n" + "					br.address_id from bolu_mamojo.branch as br, \r\n"
				+ "					bolu_mamojo.agent as agY \r\n"
				+ "				where agY.branch_id = br.id and agY.agentID= agX.agentID) and ct.id = addr.city_id ) as z\r\n"
				+ "		from \r\n" + "			bolu_mamojo.agent as agX\r\n" + "		where \r\n"
				+ "			agX.agentID = ag.agentID\r\n" + "	) as city,\r\n"
				+ "	agh.description as perubahanAgent,\r\n"
				+ "	(select br.code  from bolu_mamojo.branch as br, bolu_mamojo.agent agZ where agZ.branch_id= br.id and agZ.agentID= ag.agentID) as  cabangagent,\r\n "
				+ "   ag.status as agentStatus,\r\n (select br.code from bolu_mamojo.branch as br where br.id=ag.parentBranch_id) as jaringanKantorBank \r\n"
				+ "	FROM \r\n" + "		bolu_mamojo.agent_history as agh,\r\n" + "		bolu_mamojo.agent as ag\r\n"
				+ "	where \r\n" + "		agh.agent_agentID=ag.agentID\r\n" + "		and \r\n"
				+ "		 (agh.createdDate BETWEEN :start AND :end )";

		Query query = entityManager.createNativeQuery(queryStr);
		query.setParameter("start", dateStart);
		query.setParameter("end", dateEnd);

		List<Object[]> objectList = query.getResultList();

		return objectList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findForm2ByDate(String dateStart, String dateEnd) {
		String queryStr = "  select \r\n" + "        cst.name AS namaAgen,\r\n" + "        ag.agentNo AS noIdAgen,\r\n"
				+ "        2 AS jenisAgen,\r\n" + "        cast(NULL as char (255) charset utf8) AS lokasiAgen,\r\n"
				+ "		(select br.code from bolu_mamojo.branch as br where  br.id = ag.parentBranch_id) as branchCode,\r\n"
				+ "		(\r\n" + "		select \r\n"
				+ "			(select ct.name from bolu_mamojo.address as addr, bolu_mamojo.city as ct where addr.id=\r\n"
				+ "				(select \r\n" + "					br.address_id from bolu_mamojo.branch as br, \r\n"
				+ "					bolu_mamojo.agent as agY \r\n"
				+ "				where agY.branch_id = br.id and agY.agentID= agX.agentID) and ct.id = addr.city_id ) as kota\r\n"
				+ "		from \r\n" + "			bolu_mamojo.agent as agX\r\n" + "		where \r\n"
				+ "			agX.agentID = ag.agentID\r\n" + "	) as city,\r\n" + "        (\r\n"
				+ "			SELECT count(*) as freq\r\n" + "				FROM bolu_mamojo.customer C\r\n"
				+ "				where C.agent_id = ag.customer_id\r\n" + "		) AS jumRekCustPerAgent,\r\n"
				+ "        (\r\n"
				+ "		select setoran.nominal from (SELECT tx.amount as nominal, min(tx.transactionDate) as tgl, txbsa.agent_id as agent_id\r\n"
				+ "				FROM\r\n"
				+ "					bolu_mamojo.transfer_history as txh join bolu_mamojo.transaction_bsa as txbsa\r\n"
				+ "					on txh.transaction_id = txbsa.transaction_id\r\n"
				+ "					join transaction as tx\r\n" + "					on tx.id = txbsa.transaction_id\r\n"
				+ "				where txh.transferType = 'DEPOSIT' group by txbsa.agent_id) as setoran \r\n"
				+ "				where setoran.agent_id =ag.customer_id\r\n" + "		) as nominalSetoranAwal,\r\n"
				+ "		ag.customer_id as customer_id,\r\n" + "		(\r\n" + "			SELECT count(*)\r\n"
				+ "				FROM\r\n"
				+ "					bolu_mamojo.transfer_history as txh join bolu_mamojo.transaction_bsa as txbsa\r\n"
				+ "					on txh.transaction_id = txbsa.transaction_id\r\n"
				+ "				where txh.transferType = 'DEPOSIT'\r\n" + "					AND\r\n"
				+ "					txbsa.agent_id = ag.customer_id\r\n" + "		) as freqDeposit,\r\n"
				+ "		(\r\n" + "		SELECT sum(tx.amount) \r\n" + "				FROM\r\n"
				+ "					bolu_mamojo.transfer_history as txh join bolu_mamojo.transaction_bsa as txbsa\r\n"
				+ "					on txh.transaction_id = txbsa.transaction_id\r\n"
				+ "					join transaction as tx\r\n" + "					on tx.id = txbsa.transaction_id\r\n"
				+ "				where txh.transferType = 'DEPOSIT'\r\n" + "					AND\r\n"
				+ "					txbsa.agent_id = ag.customer_id\r\n" + "		) AS nomSetorTunai,\r\n"
				+ "        (SELECT count(*)\r\n" + "				FROM\r\n"
				+ "					bolu_mamojo.transfer_history as txh join bolu_mamojo.transaction_bsa as txbsa\r\n"
				+ "					on txh.transaction_id = txbsa.transaction_id\r\n"
				+ "				where txh.transferType = 'WITHDRAW'\r\n" + "					AND\r\n"
				+ "					txbsa.agent_id = ag.customer_id) AS frekTarikTunai,\r\n"
				+ "        (SELECT sum(tx.amount) \r\n" + "				FROM\r\n"
				+ "					bolu_mamojo.transfer_history as txh join bolu_mamojo.transaction_bsa as txbsa\r\n"
				+ "					on txh.transaction_id = txbsa.transaction_id\r\n"
				+ "					join transaction as tx\r\n" + "					on tx.id = txbsa.transaction_id\r\n"
				+ "				where txh.transferType = 'WITHDRAW'\r\n" + "					AND\r\n"
				+ "					txbsa.agent_id = ag.customer_id) AS nomTarikTunai,\r\n"
				+ "       (SELECT count(*)\r\n" + "				FROM\r\n"
				+ "					bolu_mamojo.transfer_history as txh join bolu_mamojo.transaction_bsa as txbsa\r\n"
				+ "					on txh.transaction_id = txbsa.transaction_id\r\n"
				+ "				where txh.transferType = 'BL_WITHIN_ONLINE'\r\n" + "					AND\r\n"
				+ "					txbsa.agent_id = ag.customer_id) AS frekPindahBuku,\r\n"
				+ "       (SELECT sum(tx.amount) \r\n" + "				FROM\r\n"
				+ "					bolu_mamojo.transfer_history as txh join bolu_mamojo.transaction_bsa as txbsa\r\n"
				+ "					on txh.transaction_id = txbsa.transaction_id\r\n"
				+ "					join transaction as tx\r\n" + "					on tx.id = txbsa.transaction_id\r\n"
				+ "				where txh.transferType = 'BL_WITHIN_ONLINE'\r\n" + "					AND\r\n"
				+ "					txbsa.agent_id = ag.customer_id) AS nomPindahBuku,\r\n" + "		(\r\n"
				+ "			SELECT count(*)\r\n"
				+ "			FROM bolu_mamojo.bl_customer_history as blch, bolu_mamojo.agent agx\r\n"
				+ "			where blch.agent_id = agx.customer_id \r\n"
				+ "			and blch.description = 'CLOSE_CUSTOMER' and blch.agent_id = ag.customer_id\r\n"
				+ "		) AS frekTutupBSA, \r\n" + "        cast(NULL as char (255) charset utf8) AS nomTutupBSA\r\n"
				+ "    from\r\n" + "        (bolu_mamojo.agent ag\r\n"
				+ "        join bolu_mamojo.customer cst ON ((ag.customer_id = cst.id)))\r\n" + "         where \r\n"
				+ "		 (cst.createdDate BETWEEN :start AND :end )";

		Query query = entityManager.createNativeQuery(queryStr);
		query.setParameter("start", dateStart);
		query.setParameter("end", dateEnd);

		List<Object[]> objectList = query.getResultList();

		return objectList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findForm4ByDate(String dateStart, String dateEnd) {
//		String queryStr = "  select \r\n" + 
//				"        cst.name AS namaAgen,\r\n" + 
//				"        ag.agentNo AS noIdAgen,\r\n" + 
//				"        2 AS jenisAgen,\r\n" + 
//				"        cast(NULL as char (255) charset utf8) AS lokasiAgen,\r\n" + 
//				"		(select br.code from bolu_mamojo.branch as br where  br.id = ag.parentBranch_id) as branchCode,\r\n" + 
//				"		(\r\n" + 
//				"		select \r\n" + 
//				"			(select ct.name from bolu_mamojo.address as addr, bolu_mamojo.city as ct where addr.id=\r\n" + 
//				"				(select \r\n" + 
//				"					br.address_id from bolu_mamojo.branch as br, \r\n" + 
//				"					bolu_mamojo.agent as agY \r\n" + 
//				"				where agY.branch_id = br.id and agY.agentID= agX.agentID) and ct.id = addr.city_id ) as kota\r\n" + 
//				"		from \r\n" + 
//				"			bolu_mamojo.agent as agX\r\n" + 
//				"		where \r\n" + 
//				"			agX.agentID = ag.agentID\r\n" + 
//				"	) as city\r\n" + 
//				"    from\r\n" + 
//				"        (bolu_mamojo.agent ag\r\n" + 
//				"        join bolu_mamojo.customer cst ON ((ag.customer_id = cst.id)))\r\n" + 
//				"         where \r\n" + 
//				"		 (cst.createdDate BETWEEN :start AND :end )";

		String queryStr = " SELECT \r\n"
				+ "(select cs.name from bolu_mamojo.customer as cs where cs.id = txbsa.agent_id) as namaAgent, \r\n"
				+ "(select ag.agentNo from bolu_mamojo.agent as ag where ag.customer_id = txbsa.agent_id) as noAgent, \r\n"
				+ "(select cty.NAME from bolu_mamojo.agent as ag , bolu_mamojo.city cty where ag.customer_id = txbsa.agent_id AND cty.id = ag.city_id ) AS kota, \r\n"
				+ "(select tx.type from bolu_mamojo.transaction as tx where tx.id = txbsa.transaction_id) as transactionName, \r\n"
				+ "(select tx.accountSourceNo from bolu_mamojo.transaction as tx where tx.id = txbsa.transaction_id) as accountSourceNo, \r\n"
				+ "(select msg.code from bolu_mamojo.msg_dictionary as msg where msg.id = \r\n"
				+ "(select tx.responseCode_id from bolu_mamojo.transaction as tx where tx.id = txbsa.transaction_id) \r\n"
				+ ") as codeResponse, \r\n"
				+ "(select txh.transferType from transfer_history txh where txh.transaction_id = txbsa.transaction_id) as txType \r\n"
				+ "FROM bolu_mamojo.transaction_bsa as txbsa WHERE txbsa.createdDate BETWEEN :start AND :end ORDER BY noAgent ASC";

		Query query = entityManager.createNativeQuery(queryStr);
		query.setParameter("start", dateStart);
		query.setParameter("end", dateEnd);

		List<Object[]> objectList = query.getResultList();

		return objectList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findForm9ByDate(String dateStart, String dateEnd) {
		String queryStr = " select \r\n" + "		count(ag.agentNo) as jmlAgent,\r\n"
				+ "		ag.parentBranch_id as idBranch,\r\n"
				+ "		(select br.code from bolu_mamojo.branch as br where  br.id = ag.parentBranch_id) as branchCode,\r\n"
				+ "		(\r\n" + "		select \r\n"
				+ "			(select ct.name from bolu_mamojo.address as addr, bolu_mamojo.city as ct where addr.id=\r\n"
				+ "				(select \r\n" + "					br.address_id from bolu_mamojo.branch as br, \r\n"
				+ "					bolu_mamojo.agent as agY \r\n"
				+ "				where agY.branch_id = br.id and agY.agentID= agX.agentID) and ct.id = addr.city_id ) as kota\r\n"
				+ "		from \r\n" + "			bolu_mamojo.agent as agX\r\n" + "		where \r\n"
				+ "			agX.agentID = ag.agentID\r\n" + "	) as city,\r\n"
				+ "	ag.parentBranch_id as parentBranchID,\r\n" + "	(SELECT COUNT(C.NAME) freq\r\n"
				+ "				FROM bolu_mamojo.customer C, bolu_mamojo.agent agx\r\n"
				+ "				where C.agent_id = agx.customer_id\r\n"
				+ "				and agx.parentBranch_id = ag.parentBranch_id\r\n"
				+ "				and c.sex ='F') as femaleCustmerCount,\r\n" + "(SELECT COUNT(C.NAME) freq\r\n"
				+ "				FROM bolu_mamojo.customer C, bolu_mamojo.agent agx\r\n"
				+ "				where C.agent_id = agx.customer_id\r\n"
				+ "				and agx.parentBranch_id = ag.parentBranch_id\r\n"
				+ "				and c.sex ='M') as maleCustmerCount,\r\n" + "(SELECT count(agx.agentNo)  freq\r\n"
				+ "				FROM  bolu_mamojo.agent agx,bolu_mamojo.customer c\r\n" + "				where \r\n"
				+ "				agx.customer_id = c.id and\r\n"
				+ "				agx.parentBranch_id = ag.parentBranch_id\r\n"
				+ "				AND c.sex = 'M' ) as agentMale,\r\n" + "(SELECT count(agx.agentNo)  freq\r\n"
				+ "				FROM  bolu_mamojo.agent agx,bolu_mamojo.customer c\r\n" + "				where \r\n"
				+ "				agx.customer_id = c.id and\r\n"
				+ "				agx.parentBranch_id = ag.parentBranch_id\r\n"
				+ "				AND c.sex = 'F' ) as agentFemale\r\n" + "    from\r\n"
				+ "        bolu_mamojo.agent as ag, bolu_mamojo.customer as cst\r\n"
				+ "	where ag.customer_id = cst.id and\r\n" + "		 (cst.createdDate BETWEEN :start AND :end )\r\n"
				+ "group by ag.parentBranch_id ";

		Query query = entityManager.createNativeQuery(queryStr);
		query.setParameter("start", dateStart);
		query.setParameter("end", dateEnd);

		List<Object[]> objectList = query.getResultList();

		return objectList;
	}

}
