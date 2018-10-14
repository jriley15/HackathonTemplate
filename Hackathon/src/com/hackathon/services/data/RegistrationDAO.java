package com.hackathon.services.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import com.hackathon.model.RegisterModel;

/**
 * Trevor Moore
 * CST-341
 * 10/10/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * RegistrationDAO concrete implementation class of IRegistrationDAO
 * @author Trevor
 *
 */
public class RegistrationDAO implements IRegistrationDAO
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
	 * Overridden method for registering a user into the database
	 * 
	 * @param user of type RegisterModel
	 * @return type String
	 */
	@Override
	public String registerUser(RegisterModel user) 
	{
		// try catch for catching exceptions
		try 
		{
			// define all of our queries
			// n1euzrfjibaye0bl
			// check if user is an actual employee
			String query1 = "SELECT * FROM activity2.authemployee WHERE FIRSTNAME = ? AND LASTNAME = ? AND EMPLOYEEID = ?";
			// for checking if a username is already in the database
			String query2 = "SELECT * FROM activity2.authusers WHERE USERNAME = ?";
			// for inserting the new username and password into the users table
			String query3 = "INSERT INTO activity2.authusers (USERSID, USERNAME, PASSWORD) VALUES(?, ?, ?)";
			
			// prepared statements for each query, using injected dbconnection to connect to db
			PreparedStatement pt1 = dbconn.dbConnect().prepareStatement(query1);
			PreparedStatement pt2 = dbconn.dbConnect().prepareStatement(query2);
			PreparedStatement pt3 = dbconn.dbConnect().prepareStatement(query3);
			
			// setting the parameters for each prepared statement
			pt1.setString(1, user.getFirstName());
			pt1.setString(2, user.getLastName());
			pt1.setString(3, user.getEmployeeid());
			
			pt2.setString(1, user.getUsername());
			
			// executing the username check query
			pt1.execute();
            ResultSet rs1 = pt1.getResultSet();
            
            int result;
            
            // if user is an actual employee
            if(rs1.next())
            {
            	String employeeID = rs1.getString("ID");
            	// close 1st prepared statement, execute the insert and then close it
            	pt1.close();
            	
            	pt2.execute();
                ResultSet rs2 = pt2.getResultSet();
                
                // if username is not already taken
                if(!rs2.next())
                {
                	// close 1st prepared statement, execute the insert and then close it
                	pt2.close();
                	
        			pt3.setString(1, employeeID);
        			pt3.setString(2, user.getUsername());
        			pt3.setString(3, user.getPassword());
                	
                	result = pt3.executeUpdate();
                	pt3.close();
                }
                // if the query returned something, theres a duplicate
                else
                	return "duplicate";
                
                
                if(result > 0)
                {
    				System.out.println("Registration Successful.");
    				return "success";
    			}
                // else the 2nd query failed to insert into users table
                else
                {
                	System.out.println("authusers insert failed.");
                	return "failure";
                }

            }
            else
            	return "failure";
		}
		//catching exceptions and printing failure
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in RegistrationDAO.");
			return "failure";
		}
	}
	

}
