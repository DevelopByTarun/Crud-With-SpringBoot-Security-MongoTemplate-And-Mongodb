package com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import java.util.Date;

@Configuration
@Aspect
public class CustomerAccountAspects {

    private Logger logger = Logger.getLogger(CustomerAccountAspects.class);

    private long startTime;

    private long endTime;

    @Pointcut("execution(* com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.dao.ICustomerAccountDAO.*(..))")
    public void applyPointcutDate() {
    }

    @Before("applyPointcutDate()")
    public void showExecutionDate() {
        System.out.println("");
        logger.debug("");
        System.out.println("Method Is Calling On :: "+ new Date());
        logger.debug("Method Is Calling On :: "+ new Date());
        logger.debug("");
    }

    @Before("execution(public * com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.dao.ICustomerAccountDAO.saveCustomerAccountDetails(..))")
    public void showStartTimeOfSaveCustomerAccountDetails(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        int hashCode = jp.getSignature().hashCode();
        startTime = System.currentTimeMillis();
        System.out.println("Method Name Is :: "+methodName);
        System.out.println("Method Storing Memory Location Code Is :: "+hashCode);
        System.out.println("Method Start Time Is :: "+startTime);
        logger.debug("Method Name Is :: "+methodName);
        logger.debug("Method Storing Memory Location Code Is :: "+hashCode);
        logger.debug("Method Start Time Is :: "+startTime);
        logger.debug("");
        logger.debug("");
    }

    @After("execution(public * com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.dao.ICustomerAccountDAO.saveCustomerAccountDetails(..))")
    public void showEndTimeOfSaveCustomerAccountDetails(JoinPoint jp) {
        endTime = System.currentTimeMillis();
        System.out.println("Method Declaring Type Is :: "+jp.getSignature().getDeclaringType());
        System.out.println("Method End Time Is :: "+endTime);
        System.out.println("Method Total Time Taken Is :: "+(endTime - startTime)+" MilliSeconds");
        System.out.println("");
        logger.debug("Method Declaring Type Is :: "+jp.getSignature().getDeclaringType());
        logger.debug("Method End Time Is :: "+endTime);
        logger.debug("Method Total Time Taken Is :: "+(endTime - startTime)+" MilliSeconds");
        logger.debug("");
        logger.debug("");
    }

    @Before("execution(public * com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.dao.ICustomerAccountDAO.updateCustomerAccountDetails(..))")
    public void showStartTimeOfUpdateCustomerAccountDetails(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        int hashCode = jp.getSignature().hashCode();
        startTime = System.currentTimeMillis();
        System.out.println("Method Name Is :: "+methodName);
        System.out.println("Method Storing Memory Location Code Is :: "+hashCode);
        System.out.println("Method Start Time Is :: "+startTime);
        logger.debug("Method Name Is :: "+methodName);
        logger.debug("Method Storing Memory Location Code Is :: "+hashCode);
        logger.debug("Method Start Time Is :: "+startTime);
        logger.debug("");
        logger.debug("");
    }

    @After("execution(public * com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.dao.ICustomerAccountDAO.updateCustomerAccountDetails(..))")
    public void showEndTimeOfUpdateCustomerAccountDetails(JoinPoint jp) {
        endTime = System.currentTimeMillis();
        System.out.println("Method Declaring Type Is :: "+jp.getSignature().getDeclaringType());
        System.out.println("Method End Time Is :: "+endTime);
        System.out.println("Method Total Time Taken Is :: "+(endTime - startTime)+" MilliSeconds");
        System.out.println("");
        logger.debug("Method Declaring Type Is :: "+jp.getSignature().getDeclaringType());
        logger.debug("Method End Time Is :: "+endTime);
        logger.debug("Method Total Time Taken Is :: "+(endTime - startTime)+" MilliSeconds");
        logger.debug("");
        logger.debug("");
    }

    @Before("execution(public * com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.dao.ICustomerAccountDAO.deleteCustomerAccountDetails(..))")
    public void showStartTimeOfDeleteCustomerAccountDetails(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        int hashCode = jp.getSignature().hashCode();
        startTime = System.currentTimeMillis();
        System.out.println("Method Name Is :: "+methodName);
        System.out.println("Method Storing Memory Location Code Is :: "+hashCode);
        System.out.println("Method Start Time Is :: "+startTime);
        logger.debug("Method Name Is :: "+methodName);
        logger.debug("Method Storing Memory Location Code Is :: "+hashCode);
        logger.debug("Method Start Time Is :: "+startTime);
        logger.debug("");
        logger.debug("");
    }

    @After("execution(public * com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.dao.ICustomerAccountDAO.deleteCustomerAccountDetails(..))")
    public void showEndTimeOfDeleteCustomerAccountDetails(JoinPoint jp) {
        endTime = System.currentTimeMillis();
        System.out.println("Method Declaring Type Is :: "+jp.getSignature().getDeclaringType());
        System.out.println("Method End Time Is :: "+endTime);
        System.out.println("Method Total Time Taken Is :: "+(endTime - startTime)+" MilliSeconds");
        System.out.println("");
        logger.debug("Method Declaring Type Is :: "+jp.getSignature().getDeclaringType());
        logger.debug("Method End Time Is :: "+endTime);
        logger.debug("Method Total Time Taken Is :: "+(endTime - startTime)+" MilliSeconds");
        logger.debug("");
        logger.debug("");
    }

    @Before("execution(public * com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.dao.ICustomerAccountDAO.getCustomerAccountDetailsById(..))")
    public void showStartTimeOfGetCustomerAccountDetailsById(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        int hashCode = jp.getSignature().hashCode();
        startTime = System.currentTimeMillis();
        System.out.println("Method Name Is :: "+methodName);
        System.out.println("Method Storing Memory Location Code Is :: "+hashCode);
        System.out.println("Method Start Time Is :: "+startTime);
        logger.debug("Method Name Is :: "+methodName);
        logger.debug("Method Storing Memory Location Code Is :: "+hashCode);
        logger.debug("Method Start Time Is :: "+startTime);
        logger.debug("");
        logger.debug("");
    }

    @After("execution(public * com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.dao.ICustomerAccountDAO.getCustomerAccountDetailsById(..))")
    public void showEndTimeOfGetCustomerAccountDetailsById(JoinPoint jp) {
        endTime = System.currentTimeMillis();
        System.out.println("Method Declaring Type Is :: "+jp.getSignature().getDeclaringType());
        System.out.println("Method End Time Is :: "+endTime);
        System.out.println("Method Total Time Taken Is :: "+(endTime - startTime)+" MilliSeconds");
        System.out.println("");
        logger.debug("Method Declaring Type Is :: "+jp.getSignature().getDeclaringType());
        logger.debug("Method End Time Is :: "+endTime);
        logger.debug("Method Total Time Taken Is :: "+(endTime - startTime)+" MilliSeconds");
        logger.debug("");
        logger.debug("");
    }

    @Before("execution(public * com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.dao.ICustomerAccountDAO.getAllCustomersAccountDetails(..))")
    public void showStartTimeOfGetAllCustomersAccountDetails(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        int hashCode = jp.getSignature().hashCode();
        startTime = System.currentTimeMillis();
        System.out.println("Method Name Is :: "+methodName);
        System.out.println("Method Storing Memory Location Code Is :: "+hashCode);
        System.out.println("Method Start Time Is :: "+startTime);
        logger.debug("Method Name Is :: "+methodName);
        logger.debug("Method Storing Memory Location Code Is :: "+hashCode);
        logger.debug("Method Start Time Is :: "+startTime);
        logger.debug("");
        logger.debug("");
    }

    @After("execution(public * com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoTemplateAndMongodb.dao.ICustomerAccountDAO.getAllCustomersAccountDetails(..))")
    public void showEndTimeOfGetAllCustomersAccountDetails(JoinPoint jp) {
        endTime = System.currentTimeMillis();
        System.out.println("Method Declaring Type Is :: "+jp.getSignature().getDeclaringType());
        System.out.println("Method End Time Is :: "+endTime);
        System.out.println("Method Total Time Taken Is :: "+(endTime - startTime)+" MilliSeconds");
        System.out.println("");
        logger.debug("Method Declaring Type Is :: "+jp.getSignature().getDeclaringType());
        logger.debug("Method End Time Is :: "+endTime);
        logger.debug("Method Total Time Taken Is :: "+(endTime - startTime)+" MilliSeconds");
        logger.debug("");
        logger.debug("");
    }
}
