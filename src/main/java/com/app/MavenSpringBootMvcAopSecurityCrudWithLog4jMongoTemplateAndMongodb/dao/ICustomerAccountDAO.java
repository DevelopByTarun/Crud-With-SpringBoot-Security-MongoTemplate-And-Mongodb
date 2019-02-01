package com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.dao;

import org.springframework.stereotype.Repository;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.modal.CustomerDTO;
import java.util.List;

@Repository
public interface ICustomerAccountDAO {

    public void saveCustomerAccountDetails(CustomerDTO customeraccountDTO) throws Exception;

    public void updateCustomerAccountDetails(CustomerDTO customeraccountDTO) throws Exception;

    public void deleteCustomerAccountDetails(String customerId) throws Exception;

    public CustomerDTO getCustomerAccountDetailsById(String customerId) throws Exception;

    public List<CustomerDTO> getAllCustomersAccountDetails() throws Exception;
}
