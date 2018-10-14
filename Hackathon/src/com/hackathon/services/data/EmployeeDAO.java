package com.hackathon.services.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.hackathon.model.EmployeeModel;

/**
 * Trevor Moore
 * CST-341
 * 10/10/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * TopicDAO concrete implementation class of ITopicDAO
 * @author Trevor
 *
 */
public class EmployeeDAO implements IEmployeeDAO
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
	 * Overridden method for inserting a new post into the posts table
	 * 
	 * @param model type TopicModel
	 * @param user type CredentialModel (to get the users ID who posted it)
	 * @return boolean object type
	 */
	@Override
	public boolean addEmployee(EmployeeModel employee) 
	{
		// try catch for catching exceptions
		try 
		{
			// defining all our queries
			// n1euzrfjibaye0bl
			// second query for inserting the topic into the posts table
			String query = "INSERT INTO nod3eke2u33fhtk2.authemployee (FIRSTNAME, LASTNAME, PHONE, EMAIL, EMPLOYEEID, IS_ADMIN, IS_ACTIVE, IS_TERMINATED) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			// prepared statements for each query, using injected dbconnection to connect to db
			PreparedStatement pt = dbconn.dbConnect().prepareStatement(query);
			
			System.out.println("Admin:" + employee.getAdmin() + " Active:" + employee.getActive() + " Term:" + employee.getTerminated());
			// setting the parameters for the 1st prepared statement
			pt.setString(1, employee.getFirstName());
			pt.setString(2, employee.getLastName());
			pt.setString(3, employee.getPhone());
			pt.setString(4, employee.getEmail());
			pt.setString(5, employee.getEmployeeid());
			pt.setString(6, employee.getAdmin());
			pt.setString(7, employee.getActive());
			pt.setString(8, employee.getTerminated());
			
			// executing the 2nd prepared statement and storing the number of affected rows
            int result = pt.executeUpdate();

            // closing the 2nd prepared statement
            pt.close();
            
            // returning true if the result is greater than 0 (successful insert into posts table) else false (insert failure)
            return (result > 0);
		}
		//catching exceptions and printing failure
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in TopicDAO.");
			return false;
		}
	}
	
	/**
	 * Overridden method for inserting a new post into the posts table
	 * 
	 * @param model type TopicModel
	 * @param user type CredentialModel (to get the users ID who posted it)
	 * @return boolean object type
	 */
	@Override
	public EmployeeModel getEmployee(String employeeID) 
	{
		// try catch for catching exceptions
		try 
		{
			// defining all our queries
			// n1euzrfjibaye0bl
			// first query for grabbing the ID of the user who is posting the topic from the users table
			String query = "SELECT * FROM nod3eke2u33fhtk2.authemployee WHERE EMPLOYEEID = ?";
			
			// prepared statements for each query, using injected dbconnection to connect to db
			PreparedStatement pt = dbconn.dbConnect().prepareStatement(query);
			
			pt.setString(1, employeeID);
			
			// executing the first prepared statement, getting the resultset and grabbing the ID column returned and storing it in a string
			pt.execute();
			ResultSet rs = pt.getResultSet();
			rs.next();
			EmployeeModel employee = new EmployeeModel(rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("EMAIL"), rs.getString("PHONE"), rs.getString("EMPLOYEEID"), rs.getString("IS_ADMIN"), rs.getString("IS_ACTIVE"), rs.getString("IS_TERMINATED"));
			
        	// closing the 1st prepared statement
        	pt.close();
            
            // returning true if the result is greater than 0 (successful insert into posts table) else false (insert failure)
            return employee;
		}
		//catching exceptions and printing failure
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in TopicDAO.");
			return null;
		}
	}
	
	
	/**
	 * Overridden method for inserting a new post into the posts table
	 * 
	 * @param model type TopicModel
	 * @param user type CredentialModel (to get the users ID who posted it)
	 * @return boolean object type
	 */
	@Override
	public List<EmployeeModel> getEmployees() 
	{
		// try catch for catching exceptions
		try 
		{
			// defining all our queries
			// n1euzrfjibaye0bl
			// first query for grabbing the ID of the user who is posting the topic from the users table
			String query = "SELECT * FROM nod3eke2u33fhtk2.authemployee";
			
			// prepared statements for each query, using injected dbconnection to connect to db
			PreparedStatement pt = dbconn.dbConnect().prepareStatement(query);
			
			// executing the first prepared statement, getting the resultset and grabbing the ID column returned and storing it in a string
			pt.execute();
			ResultSet rs = pt.getResultSet();
			
			List<EmployeeModel> employees = new ArrayList<EmployeeModel>();
			
			while(rs.next())
			{
				EmployeeModel employee = new EmployeeModel(rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("EMAIL"), rs.getString("PHONE"), rs.getString("EMPLOYEEID"), rs.getString("IS_ADMIN"), rs.getString("IS_ACTIVE"), rs.getString("IS_TERMINATED"));
				employees.add(employee);
			}
			
        	// closing the 1st prepared statement
        	pt.close();
            
            // returning true if the result is greater than 0 (successful insert into posts table) else false (insert failure)
            return employees;
		}
		//catching exceptions and printing failure
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in TopicDAO.");
			return null;
		}
	}
	
	
	/**
	 * Overridden method for inserting a new post into the posts table
	 * 
	 * @param model type TopicModel
	 * @param user type CredentialModel (to get the users ID who posted it)
	 * @return boolean object type
	 */
	@Override
	public boolean updateEmployees(List<EmployeeModel> employees) 
	{
		// try catch for catching exceptions
		try 
		{
			int i = 0;
			while(i < employees.size())
			{
				// defining all our queries
				// n1euzrfjibaye0bl
				// second query for inserting the topic into the posts table
				String query = "UPDATE nod3eke2u33fhtk2.authemployee SET IS_ADMIN = ?, IS_ACTIVE = ?, IS_TERMINATED = ? WHERE EMPLOYEEID = ?";
				
				// prepared statements for each query, using injected dbconnection to connect to db
				PreparedStatement pt = dbconn.dbConnect().prepareStatement(query);
				
				// setting the parameters for the 1st prepared statement
				pt.setString(1, employees.get(i).getAdmin());
				pt.setString(2, employees.get(i).getActive());
				pt.setString(3, employees.get(i).getTerminated());
				pt.setString(4, employees.get(i).getEmployeeid());
				
				System.out.println("admin:" + employees.get(i).getAdmin() + " active:" + employees.get(i).getActive() + " Term:" + employees.get(i).getTerminated() + " id:" + employees.get(i).getEmployeeid());
				
				// executing the 2nd prepared statement and storing the number of affected rows
	            pt.executeUpdate();

	            // closing the 2nd prepared statement
	            pt.close();
	            i++;
			}

            // returning true if the result is greater than 0 (successful insert into posts table) else false (insert failure)
            return true;
		}
		//catching exceptions and printing failure
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in TopicDAO.");
			return false;
		}
	}
	
	/**
	 * Overridden method for inserting a new post into the posts table
	 * 
	 * @param model type TopicModel
	 * @param user type CredentialModel (to get the users ID who posted it)
	 * @return boolean object type
	 */
	@Override
	public boolean deleteEmployee(String employeeID) 
	{
		// try catch for catching exceptions
		try 
		{
			// defining all our queries
			// n1euzrfjibaye0bl
			// second query for inserting the topic into the posts table
			//String query1 = "DELETE FROM activity2.authusers WHERE USERSID = ?";
			String query2 = "DELETE FROM nod3eke2u33fhtk2.authemployee WHERE EMPLOYEEID = ?";
			
			// prepared statements for each query, using injected dbconnection to connect to db
			//PreparedStatement pt1 = dbconn.dbConnect().prepareStatement(query1);
			PreparedStatement pt2 = dbconn.dbConnect().prepareStatement(query2);
			
			System.out.println(employeeID);
			// setting the parameters for the 1st prepared statement
			//pt1.setString(1, employeeID);
			pt2.setString(1, employeeID);
			
			// executing the 2nd prepared statement and storing the number of affected rows
           // pt1.executeUpdate();
           // pt1.close();
            
            int result = pt2.executeUpdate();
            pt2.close();

            
            // returning true if the result is greater than 0 (successful insert into posts table) else false (insert failure)
            return (result > 0);
		}
		//catching exceptions and printing failure
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in TopicDAO.");
			return false;
		}
	}
}
