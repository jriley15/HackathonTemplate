package com.hackathon.services.business;

import java.util.List;
import com.socialnorm.model.EmployeeModel;

/**
 * Trevor Moore
 * CST-341
 * 10/10/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * ITopicPostService interface for the TopicPostService
 * @author Trevor
 *
 */
public interface IEmployeeService 
{
	/**
	 * Method for inserting a user's topic into the database
	 * 
	 * @param topic of type TopicModel
	 * @param user of type CredentialModel
	 * @return boolean object type
	 */
	public boolean addEmployee(EmployeeModel employee);
	public EmployeeModel getEmployee(String employeeID);
	public List<EmployeeModel> getEmployees();
	public boolean updateEmployees(List<EmployeeModel> employees);
	public boolean deleteEmployee(String employeeID);
}
