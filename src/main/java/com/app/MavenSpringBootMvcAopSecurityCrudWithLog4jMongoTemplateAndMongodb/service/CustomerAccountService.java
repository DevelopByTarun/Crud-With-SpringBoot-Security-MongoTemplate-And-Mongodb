package com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.dao.ICustomerAccountDAO;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.modal.CustomerDTO;
import java.util.List;

@Service
public class CustomerAccountService implements ICustomerAccountDAO {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveCustomerAccountDetails(CustomerDTO customeraccountDTO) throws Exception {
        // TODO Auto-generated method stub
        mongoTemplate.save(customeraccountDTO);
    }

    @Override
    public void updateCustomerAccountDetails(CustomerDTO customeraccountDTO) throws Exception {
        // TODO Auto-generated method stub
        CustomerDTO getCustomerAccount = mongoTemplate.findById(customeraccountDTO.getCustomerId(), CustomerDTO.class);
        getCustomerAccount.setCustomerFirstName(customeraccountDTO.getCustomerFirstName());
        getCustomerAccount.setCustomerLastName(customeraccountDTO.getCustomerLastName());
        getCustomerAccount.setCustomerAddress(customeraccountDTO.getCustomerAddress());
        getCustomerAccount.setCustomerAccount(customeraccountDTO.getCustomerAccount());
        mongoTemplate.save(getCustomerAccount);
    }

    @Override
    public void deleteCustomerAccountDetails(String customerId) throws Exception {
        // TODO Auto-generated method stub
        Query query = new Query();
        query.addCriteria(Criteria.where("customerId").is(customerId));
        mongoTemplate.findAndRemove(query, CustomerDTO.class);
    }

    @Override
    public CustomerDTO getCustomerAccountDetailsById(String customerId) throws Exception {
        // TODO Auto-generated method stub
        CustomerDTO getCustomerAccount = mongoTemplate.findById(customerId, CustomerDTO.class);
        return getCustomerAccount;
    }

    @Override
    public List<CustomerDTO> getAllCustomersAccountDetails() throws Exception {
        // TODO Auto-generated method stub
        return mongoTemplate.findAll(CustomerDTO.class);
    } 
}
