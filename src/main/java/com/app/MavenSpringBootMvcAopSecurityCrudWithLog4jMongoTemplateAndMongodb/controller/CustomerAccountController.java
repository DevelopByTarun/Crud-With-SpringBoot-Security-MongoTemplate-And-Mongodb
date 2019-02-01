package com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.controller;

import java.util.List;
import java.util.UUID;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.dao.ICustomerAccountDAO;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.modal.AccountDTO;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.modal.CustomerDTO;

@Controller
public class CustomerAccountController {

    private Logger logger = Logger.getLogger(CustomerAccountController.class);

    @Autowired
    private ICustomerAccountDAO customerAccountDAO;

    @RequestMapping(value = "/welcome-customer-account", method = RequestMethod.GET)
    public ModelAndView showAddCustomerAccountPage() {
        logger.debug("****Going To Enter On Add CustomerAccount Page****");
        logger.debug("");
        logger.debug("");
        ModelAndView model = new ModelAndView();
        model.setViewName("addCustomerAccount");
        return model;
    }
    
	@RequestMapping(value = "/add-customer-account", method = RequestMethod.POST)
	public ModelAndView callSaveCustomerAccountDetails(@RequestParam("customerFirstName") String customerFirstName,
			@RequestParam("customerLastName") String customerLastName,
			@RequestParam("customerAddress") String customerAddress,
			@RequestParam("accountType") String accountType,
			@RequestParam("accountStatus") String accountStatus,
			@ModelAttribute() CustomerDTO customerDTO,
			@ModelAttribute() AccountDTO accountDTO) throws Exception {
    	logger.debug("****Going To Start CallSaveCustomerAccountDetails Method****");
    	// for AccountDTO
    	accountDTO.setAccountNumber(UUID.randomUUID().toString());
    	accountDTO.setAccountType(accountType);
    	accountDTO.setAccountStatus(accountStatus);
    	// for CustomerDTO
    	customerDTO.setCustomerFirstName(customerFirstName);
    	customerDTO.setCustomerLastName(customerLastName);
    	customerDTO.setCustomerAddress(customerAddress);
    	customerDTO.setCustomerAccount(accountDTO);
    	customerAccountDAO.saveCustomerAccountDetails(customerDTO);
    	if(customerAccountDAO != null) {
			logger.debug(customerFirstName.concat(customerLastName)+" Is Save Successfully");
		}
		else {
			logger.debug("Unable To Save "+customerFirstName.concat(customerLastName));
		}
    	logger.debug("****Going To End CallSaveCustomerAccountDetails Method****");
		logger.debug("");
		logger.debug("");
		return new ModelAndView("redirect:/fetch-customer-account");
    }
    
    @RequestMapping(value = "/fetch-customer-account", method = RequestMethod.GET)
	public ModelAndView callGetAllCustomersAccountDetails() throws Exception {
		logger.debug("****Going To Start CallGetAllCustomersAccountDetails Method****");
		ModelAndView model = new ModelAndView("fetch-customer-account");
		List<CustomerDTO> customersAccountList = customerAccountDAO.getAllCustomersAccountDetails();
		if(customersAccountList != null && customersAccountList.size() > 0) {
			model.addObject("customersAccountList", customersAccountList);
			logger.debug("You Have Successfully Fetch All CustomersAccount Details List");
		}
		else {
			logger.debug("Unable To Fetch All CustomersAccount Details List");
		}
		logger.debug("****Going To End CallGetAllCustomersAccountDetails Method****");
		logger.debug("");
		logger.debug("");
		return model;
	}
    
    @PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/edit-customer-account/{customerId}", method = RequestMethod.GET)
	public ModelAndView callGetCustomerAccountDetailsById(@PathVariable("customerId") String customerId) throws Exception {
		logger.debug("****Going To Start CallGetCustomerAccountDetailsById Method****");
		ModelAndView model = new ModelAndView();
		CustomerDTO editCustomerAccount = customerAccountDAO.getCustomerAccountDetailsById(customerId);
		if(editCustomerAccount != null) {
			model.addObject("values", editCustomerAccount);
			logger.debug("You Have Successfully Edit Customer Id "+customerId);
		}
		else {
			logger.debug("Unable To Edit Customer Id "+customerId);
		}
		model.setViewName("updateCustomerAccount");
		logger.debug("****Going To End CallGetCustomerAccountDetailsById Method****");
		logger.debug("");
		logger.debug("");
		return model;
	}
    
    @RequestMapping(value = "/update-customer-account", method = RequestMethod.POST)
	public ModelAndView callUpdateCustomerAccountDetails(@RequestParam("customerFirstName") String customerFirstName,
			@RequestParam("customerLastName") String customerLastName,
			@RequestParam("customerAddress") String customerAddress,
			@RequestParam("accountNumber") String accountNumber,
			@RequestParam("accountType") String accountType,
			@RequestParam("accountStatus") String accountStatus,
			@ModelAttribute() CustomerDTO customerDTO,
			@ModelAttribute() AccountDTO accountDTO) throws Exception {
    	logger.debug("****Going To Start CallUpdateCustomerAccountDetails Method****");
    	// for AccountDTO
    	accountDTO.setAccountNumber(accountNumber);
    	accountDTO.setAccountType(accountType);
    	accountDTO.setAccountStatus(accountStatus);
    	// for CustomerDTO
    	customerDTO.setCustomerFirstName(customerFirstName);
    	customerDTO.setCustomerLastName(customerLastName);
    	customerDTO.setCustomerAddress(customerAddress);
    	customerDTO.setCustomerAccount(accountDTO);
    	customerAccountDAO.updateCustomerAccountDetails(customerDTO);
    	if(customerAccountDAO != null) {
			logger.debug(customerFirstName.concat(customerLastName)+" Is Updated Successfully");
		}
		else {
			logger.debug("Unable To Update "+customerFirstName.concat(customerLastName));
		}
    	logger.debug("****Going To End CallUpdateCustomerAccountDetails Method****");
		logger.debug("");
		logger.debug("");
		return new ModelAndView("redirect:/fetch-customer-account");
    }
    
    @PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/delete-customer-account/{customerId}", method = RequestMethod.GET)
	public ModelAndView callDeleteCustomerAccountDetails(@PathVariable("customerId") String customerId) throws Exception {
		logger.debug("****Going To Start CallDeleteCustomerAccountDetails Method****");
		customerAccountDAO.deleteCustomerAccountDetails(customerId);
		if(customerAccountDAO != null) {
			logger.debug("You Have Successfully Delete Customer Id "+customerId);
		}
		else {
			logger.debug("Unable To Delete Customer Id "+customerId);
		}
		logger.debug("****Going To End CallDeleteCustomerAccountDetails Method****");
		logger.debug("");
		logger.debug("");
		return new ModelAndView("redirect:/fetch-customer-account");
	}
}
