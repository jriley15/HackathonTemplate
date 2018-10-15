package com.hackathon.services.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.hackathon.model.EmployeeModel;
import com.hackathon.model.SearchModel;

public class EmployeeDAO implements IEmployeeDAO
{
	IDBConnection dbconn;

	@Autowired
	public void setDBConnection(IDBConnection dbconn)
	{
		this.dbconn = dbconn;
	}
	
	@Override
	public boolean addEmployee(EmployeeModel employee) 
	{
		try 
		{
			// n1euzrfjibaye0bl
			// opp hack: nod3eke2u33fhtk2
			String query = "INSERT INTO nod3eke2u33fhtk2.authemployee (FIRSTNAME, LASTNAME, PHONE, EMAIL, EMPLOYEEID, IS_ADMIN, IS_ACTIVE, IS_TERMINATED) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pt = dbconn.dbConnect().prepareStatement(query);
			
			System.out.println("Admin:" + employee.getAdmin() + " Active:" + employee.getActive() + " Term:" + employee.getTerminated());

			pt.setString(1, employee.getFirstName());
			pt.setString(2, employee.getLastName());
			pt.setString(3, employee.getPhone());
			pt.setString(4, employee.getEmail());
			pt.setString(5, employee.getEmployeeid());
			pt.setString(6, employee.getAdmin());
			pt.setString(7, employee.getActive());
			pt.setString(8, employee.getTerminated());
			
            int result = pt.executeUpdate();

            pt.close();
            
            return (result > 0);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in EmployeeDAO.");
			return false;
		}
	}
	
	@Override
	public EmployeeModel getEmployee(String employeeID) 
	{
		try 
		{
			// n1euzrfjibaye0bl
			// opp hack: nod3eke2u33fhtk2
			String query = "SELECT * FROM nod3eke2u33fhtk2.authemployee WHERE EMPLOYEEID = ?";

			PreparedStatement pt = dbconn.dbConnect().prepareStatement(query);
			
			pt.setString(1, employeeID);

			pt.execute();
			ResultSet rs = pt.getResultSet();
			rs.next();
			EmployeeModel employee = new EmployeeModel(rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("EMAIL"), rs.getString("PHONE"), rs.getString("EMPLOYEEID"), rs.getString("IS_ADMIN"), rs.getString("IS_ACTIVE"), rs.getString("IS_TERMINATED"));

        	pt.close();

            return employee;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in EmployeeDAO.");
			return null;
		}
	}
	
	@Override
	public List<EmployeeModel> getEmployees() 
	{
		try 
		{
			// n1euzrfjibaye0bl
			// opp hack: nod3eke2u33fhtk2
			String query = "SELECT * FROM nod3eke2u33fhtk2.authemployee";
			
			PreparedStatement pt = dbconn.dbConnect().prepareStatement(query);
			
			pt.execute();
			ResultSet rs = pt.getResultSet();
			
			List<EmployeeModel> employees = new ArrayList<EmployeeModel>();
			
			while(rs.next())
			{
				EmployeeModel employee = new EmployeeModel(rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("EMAIL"), rs.getString("PHONE"), rs.getString("EMPLOYEEID"), rs.getString("IS_ADMIN"), rs.getString("IS_ACTIVE"), rs.getString("IS_TERMINATED"));
				employees.add(employee);
			}

        	pt.close();

            return employees;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in EmployeeDAO.");
			return null;
		}
	}
	
	@Override
	public List<EmployeeModel> searchEmployees(SearchModel search) 
	{
		try 
		{
			// n1euzrfjibaye0bl
			// opp hack: nod3eke2u33fhtk2
			// "SELECT * FROM products WHERE PRODUCT_NAME LIKE '%$pattern%' OR PRODUCT_DESCRIPTION LIKE '%$pattern%'"
			String query = "SELECT * FROM nod3eke2u33fhtk2.authemployee WHERE UPPER(FIRSTNAME) LIKE ? OR UPPER(LASTNAME) LIKE ? OR UPPER(EMPLOYEEID) LIKE ?";
			
			PreparedStatement pt = dbconn.dbConnect().prepareStatement(query);
			
			pt.setString(1, "%" + search.getSearch().toUpperCase() + "%");
			pt.setString(2, "%" + search.getSearch().toUpperCase() + "%");
			pt.setString(3, "%" + search.getSearch().toUpperCase() + "%");
			
			pt.execute();
			ResultSet rs = pt.getResultSet();
			
			List<EmployeeModel> employees = new ArrayList<EmployeeModel>();
			
			while(rs.next())
			{
				EmployeeModel employee = new EmployeeModel(rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("EMAIL"), rs.getString("PHONE"), rs.getString("EMPLOYEEID"), rs.getString("IS_ADMIN"), rs.getString("IS_ACTIVE"), rs.getString("IS_TERMINATED"));
				employees.add(employee);
			}

        	pt.close();

            return employees;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in EmployeeDAO.");
			return null;
		}
	}
	
	
	@Override
	public boolean updateEmployees(List<EmployeeModel> employees) 
	{
		try 
		{
			int i = 0;
			while(i < employees.size())
			{
				// n1euzrfjibaye0bl
				// opp hack: nod3eke2u33fhtk2
				String query = "UPDATE nod3eke2u33fhtk2.authemployee SET IS_ADMIN = ?, IS_ACTIVE = ?, IS_TERMINATED = ? WHERE EMPLOYEEID = ?";
				
				PreparedStatement pt = dbconn.dbConnect().prepareStatement(query);
				
				pt.setString(1, employees.get(i).getAdmin());
				pt.setString(2, employees.get(i).getActive());
				pt.setString(3, employees.get(i).getTerminated());
				pt.setString(4, employees.get(i).getEmployeeid());
				
				System.out.println("admin:" + employees.get(i).getAdmin() + " active:" + employees.get(i).getActive() + " Term:" + employees.get(i).getTerminated() + " id:" + employees.get(i).getEmployeeid());
				
	            pt.executeUpdate();

	            pt.close();
	            i++;
			}

            return true;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in EmployeeDAO.");
			return false;
		}
	}

	@Override
	public boolean deleteEmployee(String employeeID) 
	{
		try 
		{
			// n1euzrfjibaye0bl
			// opp hack: nod3eke2u33fhtk2
			String query2 = "DELETE FROM nod3eke2u33fhtk2.authemployee WHERE EMPLOYEEID = ?";
			
			PreparedStatement pt2 = dbconn.dbConnect().prepareStatement(query2);
			
			System.out.println(employeeID);
			pt2.setString(1, employeeID);
            
            int result = pt2.executeUpdate();
            pt2.close();

            return (result > 0);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in EmployeeDAO.");
			return false;
		}
	}
}
