package com.hackathon.services.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import com.hackathon.model.CredentialModel;
import com.hackathon.model.EmployeeModel;

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
			String query2 = "SELECT * FROM activity2.authemployee WHERE ID = ?";
			
			// prepared statement for the query, using injected dbconnection to connect to db
			PreparedStatement pt = dbconn.dbConnect().prepareStatement(query);
			PreparedStatement pt2 = dbconn.dbConnect().prepareStatement(query2);
			
			// setting the parameters for the prepared statement
			pt.setString(1, user.getUsername());
			pt.setString(2, user.getPassword());

            // executing it and grabbing and returning the resultset (will be true for duplicate record, false for no duplicate)
            pt.execute();
            ResultSet rs = pt.getResultSet();
            rs.next();
            String uid = rs.getString("USERSID");
            pt.close();
            
            pt2.setString(1, uid);
            pt2.execute();
            ResultSet rs2 = pt2.getResultSet();
            rs2.next();
            String active = rs2.getString("IS_ACTIVE");
            String term = rs2.getString("IS_TERMINATED");
            pt2.close();
    		System.out.println(active + " term: " + term);
            if(active.equals("0") || term.equals("1"))
            	return "false";
            else
            	return uid;
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
			String query = "SELECT IS_ADMIN FROM activity2.authemployee WHERE ID = ?";
			
			// prepared statement for the query, using injected dbconnection to connect to db
			PreparedStatement pt = dbconn.dbConnect().prepareStatement(query);
			
			// setting the parameters for the prepared statement
			pt.setString(1, usersID);

            // executing it and grabbing and returning the resultset (will be true for duplicate record, false for no duplicate)
            pt.execute();
            ResultSet rs = pt.getResultSet();
            rs.next();
            if(rs.getInt("IS_ADMIN") == 1)
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
            EmployeeModel em = new EmployeeModel(rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("PHONE"), rs.getString("EMAIL"), rs.getString("EMPLOYEEID"), rs.getString("IS_ADMIN"), rs.getString("IS_ACTIVE"), rs.getString("IS_TERMINATED"));
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
