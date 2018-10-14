package com.socialnorm.services.business;

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
	IEmployeeDAO topicDAO;

	/**
	 * Autowired method for setting the injected Topic DAO
	 * @param dao type ITopicDAO
	 */
	@Autowired
	public void setTopicDAO(IEmployeeDAO dao)
	{
		this.topicDAO = dao;
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
			return topicDAO.addEmployee(employee);
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
	public List<EmployeeModel> getEmployees() 
	{
		// try catch for catching database exceptions
		try
		{
			// returning the result of the create post method called on the topic dao
			return topicDAO.getEmployees();
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
			return topicDAO.updateEmployees(employees);
		}
		// catch exceptions
		catch(Exception e)
		{
			System.out.println("Database Exception. Caught in Topic Post Business Service.");
			return false;
		}
	}
}
