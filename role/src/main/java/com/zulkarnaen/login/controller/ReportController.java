package com.zulkarnaen.login.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zulkarnaen.login.model.AgentHistoryModel;
import com.zulkarnaen.login.model.AgentModel;
import com.zulkarnaen.login.model.CustomerModel;
import com.zulkarnaen.login.model.Form1Model;
import com.zulkarnaen.login.model.Form2Model;
import com.zulkarnaen.login.model.Form9Model;
import com.zulkarnaen.login.model.TransactionModel;
import com.zulkarnaen.login.model.form4ModelOut;
import com.zulkarnaen.login.requirement.Util;
import com.zulkarnaen.login.service.ReportService;

@Controller
public class ReportController {

	@Autowired
	ReportService reportService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String layout(Model model) {

		return "index";

	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error(Model model) {

		return "error";

	}

//=================================================================================================================

	// TODO AGEN BY DATE
	@RequestMapping(value = "/agentData", method = RequestMethod.GET)
	public String formSearchAgent(Model model) {

		Date endDate = new Date();
		Date startDate = null;
		Calendar oldDate = new GregorianCalendar(2015, 1, 1);
		startDate = oldDate.getTime();
		List<AgentModel> agents = reportService.provideDataAgent(startDate, endDate);
		model.addAttribute("agents", agents);
		model.addAttribute("searchform", new SearchModel());

		return "agents";

	}

	// TODO AGEN BY DATE
	@RequestMapping(value = "/searchAgent", method = RequestMethod.POST)
	public String formSearchAgent(Model model, @ModelAttribute("searchform") SearchModel searchform) {

		Date endDate = searchform.getEndDate();
		Date startDate = searchform.getStartDate();
		// Calendar oldDate = new GregorianCalendar(2015, 1, 28);
		// startDate = oldDate.getTime();
		List<AgentModel> agents = reportService.provideDataAgent(startDate, endDate);
		model.addAttribute("agents", agents);
		model.addAttribute("searchform", searchform);

		return "agents";

	}

//=================================================================================================================

	// TODO CUSTOMER BY DATE
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String formSearchCustomer(Model model) {

		Date endDate = new Date();
		Date startDate = null;
		Calendar oldDate = new GregorianCalendar(2015, 1, 1);
		startDate = oldDate.getTime();
		List<CustomerModel> customers = reportService.provideDataCustomer(startDate, endDate);
		model.addAttribute("customers", customers);
		model.addAttribute("searchform", new SearchModel());
		return "customer";

	}

	// TODO CUSTOMER BY DATE
	@RequestMapping(value = "/searchCustomer", method = RequestMethod.POST)
	public String formSearchCustomer(Model model, @ModelAttribute("searchform") SearchModel searchform) {

		Date endDate = searchform.getEndDate();
		Date startDate = searchform.getStartDate();
		List<CustomerModel> customers = reportService.provideDataCustomer(startDate, endDate);
		model.addAttribute("customers", customers);
		model.addAttribute("searchform", searchform);
		return "customer";
	}

//=================================================================================================================		

	// TODO TRANSACTION BY DATE
	@RequestMapping(value = "/transaction", method = RequestMethod.GET)
	public String formSearchTransaction(Model model) {

		Date endDate = new Date();
		Date startDate = null;
		Calendar oldDate = new GregorianCalendar(2015, 1, 1);
		startDate = oldDate.getTime();
		List<TransactionModel> transactions = reportService.provideDataTransaction(startDate, endDate);
		model.addAttribute("transactions", transactions);
		model.addAttribute("searchform", new SearchModel());
		return "transactions";

	}

	// TODO TRANSACTION BY DATE
	@RequestMapping(value = "/searchTransaction", method = RequestMethod.POST)
	public String formSearchTransaction(Model model, @ModelAttribute("searchform") SearchModel searchform) {

		Date endDate = searchform.getEndDate();
		Date startDate = searchform.getStartDate();
		List<TransactionModel> transactions = reportService.provideDataTransaction(startDate, endDate);
		model.addAttribute("transactions", transactions);
		model.addAttribute("searchform", searchform);
		return "transactions";

	}

//=================================================================================================================

	// TODO PERUBAHAN DATA AGENT
	@RequestMapping(value = "/agentHistory", method = RequestMethod.GET)
	public String formSearchAgentHistory(Model model) {

		Date endDate = new Date();
		Date startDate = null;
		Calendar oldDate = new GregorianCalendar(2015, 1, 1);
		startDate = oldDate.getTime();
		List<AgentHistoryModel> agentHistories = reportService.provideDataAgentHistory(startDate, endDate);
		model.addAttribute("agenthistories", agentHistories);
		model.addAttribute("searchform", new SearchModel());
		return "agenthistories";

	}

	// TODO PERUBAHAN DATA AGENT
	@RequestMapping(value = "/searchAgentHistory", method = RequestMethod.POST)
	public String formSearchAgentHistory(Model model, @ModelAttribute("searchform") SearchModel searchform) {

		Date endDate = searchform.getEndDate();
		Date startDate = searchform.getStartDate();
		List<AgentHistoryModel> agentHistories = reportService.provideDataAgentHistory(startDate, endDate);
		model.addAttribute("agenthistories", agentHistories);
		model.addAttribute("searchform", searchform);
		return "agenthistories";

	}

//=================================================================================================================

	// TODO form 1
	@RequestMapping(value = "/form1", method = RequestMethod.GET)
	public String formSearchForm1(Model model) {

		Date endDate = new Date();
		Date startDate = null;
		Calendar oldDate = new GregorianCalendar(2015, 1, 1);
		startDate = oldDate.getTime();
		List<Form1Model> form1Models = reportService.provideForm1Data(startDate, endDate);
		model.addAttribute("models", form1Models);
		model.addAttribute("searchform", new SearchModel());
		return "form1";

	}

	@RequestMapping(value = "/searchForm1", method = RequestMethod.POST)
	public String formSearchForm1(Model model, @RequestParam(required = false, value = "date") String awalDate,
			@RequestParam(required = false, value = "endDate") String akhirDate) {

		Date startDate = Util.formatDateTime(awalDate);
		Date endDate = Util.formatDateTime(akhirDate);

		List<Form1Model> form1Models = reportService.provideForm1Data(startDate, endDate);
		model.addAttribute("models", form1Models);
		return "form1";

	}

//=================================================================================================================

	@RequestMapping(value = "/form2a", method = RequestMethod.GET)
	public String formSearchForm2a(Model model) {

		Date endDate = new Date();
		Date startDate = null;
		Calendar oldDate = new GregorianCalendar(2015, 1, 1);
		startDate = oldDate.getTime();
		List<Form2Model> form2aModels = reportService.provideForm2aData(startDate, endDate);
		model.addAttribute("models", form2aModels);
		model.addAttribute("searchform", new SearchModel());
		return "form2";

	}

	@RequestMapping(value = "/searchForm2a", method = RequestMethod.POST)
	public String formSearchForm2a(Model model, @RequestParam(required = false, value = "date") String awalDate,
			@RequestParam(required = false, value = "endDate") String akhirDate) {

		Date startDate = Util.formatDateTime(awalDate);
		Date endDate = Util.formatDateTime(akhirDate);

		List<Form2Model> form2aModels = reportService.provideForm2aData(startDate, endDate);
		model.addAttribute("models", form2aModels);
		return "form2";

	}

	// =================================================================================================================

	@RequestMapping(value = "/form4a", method = RequestMethod.GET)
	public String formSearchForm4(Model model) {

		Date endDate = new Date();
		Date startDate = null;
		Calendar oldDate = new GregorianCalendar(2015, 1, 1);
		startDate = oldDate.getTime();
		List<form4ModelOut> form4Models = reportService.provideForm4aData(startDate, endDate);
		model.addAttribute("models", form4Models);
		model.addAttribute("searchform", new SearchModel());
		return "form4";

	}

	@RequestMapping(value = "/searchForm4", method = RequestMethod.POST)
	public String formSearchForm4(Model model, @RequestParam(required = false, value = "date") String awalDate,
			@RequestParam(required = false, value = "endDate") String akhirDate) {

		Date startDate = Util.formatDateTime(awalDate);
		Date endDate = Util.formatDateTime(akhirDate);

		List<form4ModelOut> form4Models = reportService.provideForm4aData(startDate, endDate);
		model.addAttribute("models", form4Models);
		return "form4";
	}

//=================================================================================================================

	@RequestMapping(value = "/form9", method = RequestMethod.GET)
	public String formSearchForm9(Model model) {

		Date endDate = new Date();
		Date startDate = null;
		Calendar oldDate = new GregorianCalendar(2015, 1, 1);
		startDate = oldDate.getTime();
		List<Form9Model> form9Models = reportService.provideForm9Data(startDate, endDate);
		model.addAttribute("models", form9Models);
		model.addAttribute("searchform", new SearchModel());
		return "form9";

	}

	@RequestMapping(value = "/searchForm9", method = RequestMethod.POST)
	public String formSearchForm9(Model model, @RequestParam(required = false, value = "date") String awalDate,
			@RequestParam(required = false, value = "endDate") String akhirDate) {

		Date startDate = Util.formatDateTime(awalDate);
		Date endDate = Util.formatDateTime(akhirDate);
		
		List<Form9Model> form9Models = reportService.provideForm9Data(startDate, endDate);
		model.addAttribute("models", form9Models);
		return "form9";
	}

}
