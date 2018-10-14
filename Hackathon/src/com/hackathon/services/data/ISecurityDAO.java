package com.hackathon.services.data;

import com.hackathon.model.CredentialModel;
import com.hackathon.model.EmployeeModel;

/**
 * Trevor Moore
 * CST-341
 * 10/10/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * ISecurityDAO interface for the SecurityDAO
 * @author Trevor
 *
 */
public interface ISecurityDAO 
{
	/**
	 * Method for checking if a user is in the users table
	 * 
	 * @param user type CredentialModel
	 * @return boolean object type
	 */
	public String checkUser(CredentialModel user);
	public boolean checkAdmin(String usersID);
	public EmployeeModel getAdmin(String usersID);
}
