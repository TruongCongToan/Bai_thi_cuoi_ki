//package muc;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

class import{
    public static void main(String ... args){
	String dbUrl = "jdbc:mysql://localhost:3306/toandb";
	String user ="toantc";
	String password="1234567890";
	try{
	    //Step 1: get connection
	    Connection myConnection = DriverManager.getConnection(dbUrl , user , password);
	    //Step 2 : create a statement object
	    Statement myStatement=myConnection.createStatement();

	    //Database Properties
	    
	    String dbName = "toan";
	    String dbUser = "toantc";
	    String dbPass = "1234567890";

	     String[] executeCmd = new String[]{"/bin/sh", "-c", "mysql -u" + dbUser+ " -p"+dbPass+" " + dbName+ " < backup.sql"};
		
	    Process runtimeProcess =Runtime.getRuntime().exec(executeCmd);
	int processComplete = runtimeProcess.waitFor();
	if(processComplete == 0){
	    System.out.println("success");
	} else {
	    System.out.println("restore failure");
	
	}
	}catch(Exception e)
	    {
		System.out.println(e.getMessage());
	    }
    }
}
