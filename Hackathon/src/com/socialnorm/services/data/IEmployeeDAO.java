package com.socialnorm.services.data;

import java.util.List;
import com.socialnorm.model.EmployeeModel;

/**
 * Trevor Moore
 * CST-341
 * 10/10/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * ITopicDAO interface for the TopicDAO
 * @author Trevor
 *
 */
public interface IEmployeeDAO 
{
	/**
	 * Method for inserting a new post into the posts table
	 * 
	 * @param model type TopicModel
	 * @param user type CredentialModel (to get the users ID who posted it)
	 * @return boolean object type
	 */
	public boolean addEmployee(EmployeeModel employee);
	public List<EmployeeModel> getEmployees();
	public boolean updateEmployees(List<EmployeeModel> employees);
}
