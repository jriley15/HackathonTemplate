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

@Configuration
public class ApplicationConfiguration 
{
	/// CONTROLLERS ///
	@Bean(name="homeController")
	public HomeController getHomeController()
	{
		return new HomeController();
	}
	@Bean(name="loginController")
	public LoginController getLoginController()
	{
		return new LoginController();
	}
	@Bean(name="registerController")
	public RegisterController getRegisterController()
	{
		return new RegisterController();
	}
	@Bean(name="searchController")
	public SearchController getSearchController()
	{
		return new SearchController();
	}
	@Bean(name="employeeController")
	public EmployeeController getEmployeeController()
	{
		return new EmployeeController();
	}
	
	
	
	
	/// BUSINESS SERVICES ///
	@Bean(name="loginService")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public ILoginService getLoginService()
	{
		return new LoginService();
	}
	@Bean(name="registerService")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public IRegisterService getRegisterService()
	{
		return new RegisterService();
	}
	@Bean(name="employeeService")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public IEmployeeService getEmployeeService()
	{
		return new EmployeeService();
	}
	
	
	
	
	
	
	
	/// DATA SERVICES ///
	@Bean(name="securityDAO")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public ISecurityDAO getSecurityDAO()
	{
		return new SecurityDAO();
	}
	@Bean(name="registrationDAO")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public IRegistrationDAO getRegistrationDAO()
	{
		return new RegistrationDAO();
	}
	@Bean(name="employeeDAO")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public IEmployeeDAO getEmployeeDAO()
	{
		return new EmployeeDAO();
	}
	@Bean(name="dBConnection")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public IDBConnection getDBConnection()
	{
		return new DBConnection();
	}
	
}
