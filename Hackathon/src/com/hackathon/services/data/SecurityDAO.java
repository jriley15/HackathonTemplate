package com.hackathon.services.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import com.hackathon.model.CredentialModel;
import com.hackathon.model.EmployeeModel;


public class SecurityDAO implements ISecurityDAO
{
	IDBConnection dbconn;

	@Autowired
	public void setDBConnection(IDBConnection dbconn)
	{
		this.dbconn = dbconn;
	}

	@Override
	public String checkUser(CredentialModel user) 
	{
		try 
		{
			// n1euzrfjibaye0bl
			// opp hack: nod3eke2u33fhtk2
			String query = "SELECT * FROM nod3eke2u33fhtk2.authusers WHERE USERNAME = ? AND PASSWORD = ?";
			String query2 = "SELECT * FROM nod3eke2u33fhtk2.authemployee WHERE ID = ?";
			
			PreparedStatement pt = dbconn.dbConnect().prepareStatement(query);
			PreparedStatement pt2 = dbconn.dbConnect().prepareStatement(query2);

			pt.setString(1, user.getUsername());
			pt.setString(2, user.getPassword());

            pt.execute();
            ResultSet rs = pt.getResultSet();
            String uid;
            
            if(!rs.next())
            {
            	pt.close();
            	return "false";
            }
            else
            	uid = rs.getString("USERSID");
            
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
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in SecurityDAO.");
			return "false";
		}
	}
	
	@Override
	public boolean checkAdmin(String usersID) 
	{
		try 
		{
			// n1euzrfjibaye0bl
			// opp hack: nod3eke2u33fhtk2
			String query = "SELECT IS_ADMIN FROM nod3eke2u33fhtk2.authemployee WHERE ID = ?";

			PreparedStatement pt = dbconn.dbConnect().prepareStatement(query);

			pt.setString(1, usersID);

            pt.execute();
            ResultSet rs = pt.getResultSet();
            rs.next();
            if(rs.getInt("IS_ADMIN") == 1)
            	return true;
            else
            	return false;
            
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in SecurityDAO.");
			return false;
		}
	}
	
	@Override
	public EmployeeModel getAdmin(String usersID) 
	{
		try 
		{
			// n1euzrfjibaye0bl
			// opp hack: nod3eke2u33fhtk2
			String query = "SELECT * FROM nod3eke2u33fhtk2.authemployee WHERE ID = ?";

			PreparedStatement pt = dbconn.dbConnect().prepareStatement(query);

			pt.setString(1, usersID);

            pt.execute();
            ResultSet rs = pt.getResultSet();
            rs.next();
            EmployeeModel em = new EmployeeModel(rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("PHONE"), rs.getString("EMAIL"), rs.getString("EMPLOYEEID"), rs.getString("IS_ADMIN"), rs.getString("IS_ACTIVE"), rs.getString("IS_TERMINATED"));
            return em;
            
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in SecurityDAO.");
			return null;
		}
	}
}
