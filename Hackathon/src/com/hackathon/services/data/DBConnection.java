package com.hackathon.services.data;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection implements IDBConnection
{
    //private static final String server = "jdbc:derby:C:/Users/Trevor/SocialNormDB;user=user;password=derby";

    private Connection connection;


    public Connection dbConnect() 
    {
    	try 
    	{
    		// registering the JDBC Embedded Driver
    		// Class.forName("com.mysql.jdbc.Driver");
    		Class.forName("com.mysql.jdbc.Driver").newInstance();
    		// Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();

        	// opening a connection using the database url
    		// "jdbc:mysql://localhost:4306/activity2","root","root"
    		// socialnorm: "jdbc:mysql://aucxibl2dxeo01wa:hytrxvvxgrfx6e02@l9dwvv6j64hlhpul.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/n1euzrfjibaye0bl","aucxibl2dxeo01wa","hytrxvvxgrfx6e02"
    		// opportunityhack: "jdbc:mysql://y2fkufcdev0yjma3:t9ylcf9w4aapkdfl@tuy8t6uuvh43khkk.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/nod3eke2u33fhtk2","y2fkufcdev0yjma3","t9ylcf9w4aapkdfl"
        	connection = DriverManager.getConnection("jdbc:mysql://y2fkufcdev0yjma3:t9ylcf9w4aapkdfl@tuy8t6uuvh43khkk.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/nod3eke2u33fhtk2","y2fkufcdev0yjma3","t9ylcf9w4aapkdfl");

        	return connection;
    	}
        catch (Exception e) 
        {
        	e.printStackTrace();
        	return connection;
        }
    }

}
