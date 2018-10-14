package com.socialnorm.services.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import com.socialnorm.model.CredentialModel;
import com.socialnorm.model.EmployeeModel;

/**
 * Trevor Moore
 * CST-341
 * 10/10/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * SecurityDAO concrete implementation class of ISecurityDAO
 * @author Trevor
 *
 */
public class SecurityDAO implements ISecurityDAO
{
	// IDBConnection for injecting our database connection class
	IDBConnection dbconn;

	/**
	 * Autowired method for setting the injected DBConnection
	 * @param dbconn type IDBConnection
	 */
	@Autowired
	public void setDBConnection(IDBConnection dbconn)
	{
		this.dbconn = dbconn;
	}
	
	/**
	 * Overridden method for checking if a user is in the users table
	 * 
	 * @param user type CredentialModel
	 * @return boolean object type
	 */
	@Override
	public String checkUser(CredentialModel user) 
	{
		// try catch for catching exceptions
		try 
		{
			// n1euzrfjibaye0bl
			// defining query for checking if there is a row that matches the username and password passed in
			String query = "SELECT * FROM activity2.authusers WHERE USERNAME = ? AND PASSWORD = ?";
			
			// prepared statement for the query, using injected dbconnection to connect to db
			PreparedStatement pt = dbconn.dbConnect().prepareStatement(query);
			
			// setting the parameters for the prepared statement
			pt.setString(1, user.getUsername());
			pt.setString(2, user.getPassword());

            // executing it and grabbing and returning the resultset (will be true for duplicate record, false for no duplicate)
            pt.execute();
            ResultSet rs = pt.getResultSet();
            if(rs.next())
            	return rs.getString("USERSID");
            else
            	return "false";
            
		}
		//catching exceptions and printing failure
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in SecurityDAO.");
			return "false";
		}
	}
	
	/**
	 * Overridden method for checking if a user is in the users table
	 * 
	 * @param user type CredentialModel
	 * @return boolean object type
	 */
	@Override
	public boolean checkAdmin(String usersID) 
	{
		// try catch for catching exceptions
		try 
		{
			// n1euzrfjibaye0bl
			// defining query for checking if there is a row that matches the username and password passed in
			String query = "SELECT ADMIN FROM activity2.authemployee WHERE ID = ?";
			
			// prepared statement for the query, using injected dbconnection to connect to db
			PreparedStatement pt = dbconn.dbConnect().prepareStatement(query);
			
			// setting the parameters for the prepared statement
			pt.setString(1, usersID);

            // executing it and grabbing and returning the resultset (will be true for duplicate record, false for no duplicate)
            pt.execute();
            ResultSet rs = pt.getResultSet();
            rs.next();
            if(rs.getInt("ADMIN") == 1)
            	return true;
            else
            	return false;
            
		}
		//catching exceptions and printing failure
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in SecurityDAO.");
			return false;
		}
	}
	
	/**
	 * Overridden method for checking if a user is in the users table
	 * 
	 * @param user type CredentialModel
	 * @return boolean object type
	 */
	@Override
	public EmployeeModel getAdmin(String usersID) 
	{
		// try catch for catching exceptions
		try 
		{
			// n1euzrfjibaye0bl
			// defining query for checking if there is a row that matches the username and password passed in
			String query = "SELECT * FROM activity2.authemployee WHERE ID = ?";
			
			// prepared statement for the query, using injected dbconnection to connect to db
			PreparedStatement pt = dbconn.dbConnect().prepareStatement(query);
			
			// setting the parameters for the prepared statement
			pt.setString(1, usersID);

            // executing it and grabbing and returning the resultset (will be true for duplicate record, false for no duplicate)
            pt.execute();
            ResultSet rs = pt.getResultSet();
            rs.next();
            EmployeeModel em = new EmployeeModel(rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("PHONE"), rs.getString("EMAIL"), rs.getString("EMPLOYEEID"), rs.getString("ADMIN"), rs.getString("ACTIVE"), rs.getString("TERMINATED"));
            return em;
            
		}
		//catching exceptions and printing failure
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in SecurityDAO.");
			return null;
		}
	}
}
