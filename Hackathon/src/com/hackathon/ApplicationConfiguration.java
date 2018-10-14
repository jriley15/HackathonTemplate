package com.hackathon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import com.hackathon.controller.EmployeeController;
import com.hackathon.controller.HomeController;
import com.hackathon.controller.LoginController;
import com.hackathon.controller.RegisterController;
import com.hackathon.controller.SearchController;
import com.hackathon.services.business.ILoginService;
import com.hackathon.services.business.IRegisterService;
import com.hackathon.services.business.IEmployeeService;
import com.hackathon.services.business.LoginService;
import com.hackathon.services.business.RegisterService;
import com.hackathon.services.business.EmployeeService;
import com.hackathon.services.data.DBConnection;
import com.hackathon.services.data.IDBConnection;
import com.hackathon.services.data.IRegistrationDAO;
import com.hackathon.services.data.ISecurityDAO;
import com.hackathon.services.data.IEmployeeDAO;
import com.hackathon.services.data.RegistrationDAO;
import com.hackathon.services.data.SecurityDAO;
import com.hackathon.services.data.EmployeeDAO;

/**
 * Trevor Moore
 * CST-341
 * 10/10/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * ApplicationConfiguration class for defining all our SpringBeans
 * @author Trevor
 *
 */
@Configuration
public class ApplicationConfiguration 
{
	/// CONTROLLERS ///
	/**
	 * Getter for the HomeController SpringBean
	 * @return type HomeController
	 */
	@Bean(name="homeController")
	public HomeController getHomeController()
	{
		return new HomeController();
	}
	/**
	 * Getter for the LoginController SpringBean
	 * @return type LoginController
	 */
	@Bean(name="loginController")
	public LoginController getLoginController()
	{
		return new LoginController();
	}
	/**
	 * Getter for the RegisterController SpringBean
	 * @return type RegisterController
	 */
	@Bean(name="registerController")
	public RegisterController getRegisterController()
	{
		return new RegisterController();
	}
	/**
	 * Getter for the SearchController SpringBean
	 * @return type SearchController
	 */
	@Bean(name="searchController")
	public SearchController getSearchController()
	{
		return new SearchController();
	}
	/**
	 * Getter for the CreateController SpringBean
	 * @return type CreateController
	 */
	@Bean(name="employeeController")
	public EmployeeController getEmployeeController()
	{
		return new EmployeeController();
	}
	
	/// BUSINESS SERVICES ///
	/**
	 * Getter for LoginService SpringBean (request scoped)
	 * @return type ILoginService
	 */
	@Bean(name="loginService")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public ILoginService getLoginService()
	{
		return new LoginService();
	}
	/**
	 * Getter for RegisterService SpringBean (request scoped)
	 * @return type IRegisterService
	 */
	@Bean(name="registerService")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public IRegisterService getRegisterService()
	{
		return new RegisterService();
	}
	/**
	 * Getter for TopicPostService SpringBean (request scoped)
	 * @return type ITopicPostService
	 */
	@Bean(name="employeeService")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public IEmployeeService getEmployeeService()
	{
		return new EmployeeService();
	}
	
	/// DATA SERVICES ///
	/**
	 * Getter for SecurityDAO SpringBean (request scoped)
	 * @return type ISecurityDAO
	 */
	@Bean(name="securityDAO")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public ISecurityDAO getSecurityDAO()
	{
		return new SecurityDAO();
	}
	/**
	 * Getter for RegistrationDAO SpringBean (request scoped)
	 * @return type IRegistrationDAO
	 */
	@Bean(name="registrationDAO")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public IRegistrationDAO getRegistrationDAO()
	{
		return new RegistrationDAO();
	}
	/**
	 * Getter for TopicDAO SpringBean (request scoped)
	 * @return type ITopicDAO
	 */
	@Bean(name="employeeDAO")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public IEmployeeDAO getEmployeeDAO()
	{
		return new EmployeeDAO();
	}
	/**
	 * Getter for DBConnection SpringBean (request scoped)
	 * @return type IDBConnection
	 */
	@Bean(name="dBConnection")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public IDBConnection getDBConnection()
	{
		return new DBConnection();
	}
	
}
