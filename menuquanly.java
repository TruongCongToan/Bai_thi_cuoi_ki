package quanly;
import java.util.Scanner;
import java.sql.*;
import java.io.*;

//import package
import muc.*;
class menuquanly {

// JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/quanly";

   //  Database credentials
   static final String USER = "toantc";
   static final String PASS = "1234567890";

    public static void main(String[] args) {
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

	    System.out.println("--MENU--\n1-Quan Ly Mon Hoc \n2-Quan Ly Giao Vien\n3-Quan Ly Sinh Vien\n4-Quan Ly Lop\n5-Quan Ly Diem\n6-Quan Ly He Thong\n");
            System.out.println("0. Quit");

            // handle user commands

            boolean quit = false;

            int menuItem;

            do {

                  System.out.print("Choose menu item for quan ly tong : ");

                  menuItem = in.nextInt();

                  switch (menuItem) {

                  case 1:
		      {
			 
			  System.out.println("\n1-Quan Ly Mon Hoc\n");
			new menumonhoc().mainMonHoc();
			  break;
		      }
		  case 2:
		      {
			  System.out.println("\n2-Quan Ly Giao Vien\n");
			  new menugiaovien().mainGiaoVien();
			  break;
			 
		      }
		  case 3:
		      {
			   System.out.println("\n3-Quan Ly Sinh Vien\n");
			   new menusinhvien().mainSinhVien();
			  break;
		      }
		  case 4:
		      {
			   System.out.println("\n4-Quan Ly Lop\n");
			   new menulop().mainLop();
			   break;
		      }
		  case 5:
		      {
			   System.out.println("\n5-Quan Ly Diem\n");
			   new menuDiem().mainDiem();
			   break;
			  
		      }

		  case 6:
		      {
			   System.out.println("\n6-Quan Ly He Thong\n");
			   new menuhethong().mainHeThong();
			  break;
		      }
		         case 0:

                        quit = true;

                        break;

                  default:

                        System.out.println("Invalid choice.");

                  }

} while (!quit);

            System.out.println("Ket thuc quan ly tong \nChao tam biet!");

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
