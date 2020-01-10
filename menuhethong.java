package muc;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.*;
import java.util.Scanner;

public class menuhethong {

// JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/quanly";

   //  Database credentials
   static final String USER = "toantc";
   static final String PASS = "1234567890";

    public void mainHeThong() {
	  Connection conn = null;
	  Statement stmt = null;
          Scanner in = new Scanner(System.in);
try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");
      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      //Step 4 Execute Query
      stmt=conn.createStatement();
     
      Scanner scan=new Scanner(System.in);
            //************************************************* print menu*********************************************

	    System.out.println("--MENU--\n1-Sao Luu Du Lieu \n2-Phuc Hoi Du Lieu\n");
            System.out.println("0. Quit");

            // handle user commands
	    
            boolean quit = false;

            int menuItem;

            do {

		System.out.print("Choose menu item for quan ly he thong: ");
		
		menuItem = in.nextInt();

		switch (menuItem) {
		    
		case 1:
		    {
			System.out.println("Phuc Hoi Du Lieu");
			System.out.println();
			
			String dbName = "quanly";
			String dbUser = "toantc";
			String dbPass = "1234567890";
	    
			/***********************************************************/
			// Execute Shell Command
			/***********************************************************/
			String executeCmd = "";
			executeCmd = "mysqldump -u "+dbUser+" -p"+dbPass+" "+dbName+" -r backup.sql";
			
			Process runtimeProcess =Runtime.getRuntime().exec(executeCmd);
			int processComplete = runtimeProcess.waitFor();
			if(processComplete == 0){
			    System.out.println("Backup taken successfully");
			} else {
			    System.out.println("Could not take mysql backup");
			}
			
			
			break;
		    }
		case 2:
		    {
			System.out.println("Phuc Hoi Du Lieu");
			System.out.println();
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
			break;
		    }
		case 0:
		    
		    quit = true;
		    
		    break;
		    
                  default:
		      
		      System.out.println("Invalid choice.");
		      
		}
		
	    } while (!quit);
	    
            System.out.println("Ban da thoat che do quan ly he thong\nChao tam biet!");
	    
}catch(SQLException se){
    //Handle errors for JDBC
    se.printStackTrace();
}catch(Exception e){
    //Handle errors for Class.forName
    e.printStackTrace();
   }finally{
    //finally block used to close resources
    try{
	if(stmt!=null)
            stmt.close();
    }catch(SQLException se2){
    }// nothing we can do
    try{
	if(conn!=null)
            conn.close();
    }catch(SQLException se){
	se.printStackTrace();
    }//end finally try
}//end try
//System.out.println("Goodbye!");
    }//end main
}//end FirstExample
