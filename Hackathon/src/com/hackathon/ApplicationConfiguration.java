package com.hackathon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import com.socialnorm.controller.EmployeeController;
import com.socialnorm.controller.HomeController;
import com.socialnorm.controller.LoginController;
import com.socialnorm.controller.RegisterController;
import com.socialnorm.controller.SearchController;
import com.socialnorm.services.business.ILoginService;
import com.socialnorm.services.business.IRegisterService;
import com.socialnorm.services.business.IEmployeeService;
import com.socialnorm.services.business.LoginService;
import com.socialnorm.services.business.RegisterService;
import com.socialnorm.services.business.EmployeeService;
import com.socialnorm.services.data.DBConnection;
import com.socialnorm.services.data.IDBConnection;
import com.socialnorm.services.data.IRegistrationDAO;
import com.socialnorm.services.data.ISecurityDAO;
import com.socialnorm.services.data.IEmployeeDAO;
import com.socialnorm.services.data.RegistrationDAO;
import com.socialnorm.services.data.SecurityDAO;
import com.socialnorm.services.data.EmployeeDAO;

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
