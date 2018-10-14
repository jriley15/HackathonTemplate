package com.hackathon.services.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.socialnorm.model.EmployeeModel;
import com.socialnorm.services.data.IEmployeeDAO;

/**
 * Trevor Moore
 * CST-341
 * 10/10/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * Concrete implementation class of ITopicPostService interface
 * @author Trevor
 *
 */
public class EmployeeService implements IEmployeeService
{
	// ITopicDAO for injecting our TopicDAO
	IEmployeeDAO employeeDAO;

	/**
	 * Autowired method for setting the injected Topic DAO
	 * @param dao type ITopicDAO
	 */
	@Autowired
	public void setEmployeeDAO(IEmployeeDAO dao)
	{
		this.employeeDAO = dao;
	}
	
	/**
	 * Overridden method for inserting a user's topic into the database
	 * 
	 * @param topic of type TopicModel
	 * @param user of type CredentialModel
	 * @return boolean object type
	 */
	@Override
	public boolean addEmployee(EmployeeModel employee) 
	{
		// try catch for catching database exceptions
		try
		{
			// returning the result of the create post method called on the topic dao
			return employeeDAO.addEmployee(employee);
		}
		// catch exceptions
		catch(Exception e)
		{
			System.out.println("Database Exception. Caught in Topic Post Business Service.");
			return false;
		}
	}
	
	
	/**
	 * Overridden method for inserting a user's topic into the database
	 * 
	 * @param topic of type TopicModel
	 * @param user of type CredentialModel
	 * @return boolean object type
	 */
	@Override
	public EmployeeModel getEmployee(String employeeID)
	{
		// try catch for catching database exceptions
		try
		{
			// returning the result of the create post method called on the topic dao
			return employeeDAO.getEmployee(employeeID);
		}
		// catch exceptions
		catch(Exception e)
		{
			System.out.println("Database Exception. Caught in Topic Post Business Service.");
			return null;
		}
	}
	
	/**
	 * Overridden method for inserting a user's topic into the database
	 * 
	 * @param topic of type TopicModel
	 * @param user of type CredentialModel
	 * @return boolean object type
	 */
	@Override
	public List<EmployeeModel> getEmployees() 
	{
		// try catch for catching database exceptions
		try
		{
			// returning the result of the create post method called on the topic dao
			return employeeDAO.getEmployees();
		}
		// catch exceptions
		catch(Exception e)
		{
			System.out.println("Database Exception. Caught in Topic Post Business Service.");
			return null;
		}
	}
	
	/**
	 * Overridden method for inserting a user's topic into the database
	 * 
	 * @param topic of type TopicModel
	 * @param user of type CredentialModel
	 * @return boolean object type
	 */
	@Override
	public boolean updateEmployees(List<EmployeeModel> employees) 
	{
		// try catch for catching database exceptions
		try
		{
			// returning the result of the create post method called on the topic dao
			return employeeDAO.updateEmployees(employees);
		}
		// catch exceptions
		catch(Exception e)
		{
			System.out.println("Database Exception. Caught in Topic Post Business Service.");
			return false;
		}
	}
	
	/**
	 * Overridden method for inserting a user's topic into the database
	 * 
	 * @param topic of type TopicModel
	 * @param user of type CredentialModel
	 * @return boolean object type
	 */
	@Override
	public boolean deleteEmployee(String employeeID) 
	{
		// try catch for catching database exceptions
		try
		{
			// returning the result of the create post method called on the topic dao
			return employeeDAO.deleteEmployee(employeeID);
		}
		// catch exceptions
		catch(Exception e)
		{
			System.out.println("Database Exception. Caught in Topic Post Business Service.");
			return false;
		}
	}
}
