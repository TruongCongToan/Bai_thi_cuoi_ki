package muc;
import java.util.Scanner;
import java.sql.*;
import java.util.Scanner;

public class menumonhoc {

// JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/quanly";

   //  Database credentials
   static final String USER = "toantc";
   static final String PASS = "1234567890";

    public void mainMonHoc() {
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
      String sql= new String();
      String MaMH=new String();
      String TenMH= new String();
      String SoTC= new String();
       Scanner scan=new Scanner(System.in);
            //************************************************* print menu*********************************************

	    System.out.println("--MENU--\n1-Insert \n2-Update\n3-In danh sach\n");
            System.out.println("0. Quit");

            // handle user commands

            boolean quit = false;

            int menuItem;

            do {

                  System.out.print("Choose menu item for lua chon quan ly mon hoc: ");

                  menuItem = in.nextInt();

                  switch (menuItem) {

                  case 1:
		      
			  { //Kiem tra co hay chua
			      System.out.println("Them Mon Hoc");
			      System.out.println();
			      
			      System.out.print("Nhap ma Mon Hoc:");
			      System.out.println();
			      MaMH =scan.nextLine();
			      
			      sql="select MaMH from MonHoc where MaMH='"+MaMH+"'";
			      ResultSet rs =stmt.executeQuery(sql);
			      if(!rs.next())
				  {
				      
				      System.out.print("Ban hay nhap vao Ten mon hoc ");
				      System.out.println();
				      TenMH=scan.nextLine();
			
				      System.out.print("Ban hay nhap vao so Tin chi cua mon hoc ");
				      System.out.println();
				      SoTC=scan.nextLine();
				     
				      sql="insert into MonHoc(MaMH,TenMH,SoTC)"
					  +"values('"+MaMH+"','"+TenMH+"','"+SoTC+"')";
				      stmt.executeUpdate(sql);
				      System.out.println("insert succes...");
				  }
			      else
				  {
				      System.out.println("Da co Mon Hoc nay trong danh sach cac mon hoc !");
				      System.out.println();
				  }
			      
			  }break;
			  
                  case 2:
		      {
                        System.out.println("Sua thong tin mon hoc");
			System.out.println();
			String MaMHM= new String();
			String TenMHM= new String();
			String SoTCM= new String();
			System.out.print("Nhap vao Ma Mon Hoc ban muon update.");
		       	System.out.println();
			MaMHM=scan.nextLine();
			//check xem co ton tai hay k
			sql="select MaMH from MonHoc where MaMH='"+MaMHM+"'";
			ResultSet rs1=stmt.executeQuery(sql);
			
			if(!rs1.next()){
			    System.out.println("Khong co ma mon hoc nay trong danh sach cac mon hoc");
			    System.out.println();
			}
			else
			    {
				String Hoi;
				System.out.println("Ban co muon update MaMH hay khong ? Yes or No");
				Hoi=scan.nextLine();
				
		 		if(Hoi.equals("Yes"))		
				{
			     	System.out.print("Nhap vao ma se update thanh ");
				System.out.println();
				MaMH=scan.nextLine();
				sql="update MonHoc set MaMH='"+MaMH+"' where MaMH='"+MaMHM+"'";
				stmt.executeUpdate(sql);
				MaMHM=MaMH;
			    	System.out.println("Update success");
				System.out.println();
				}   
			       
				
				String Hoi1;
				System.out.println("Ban co muon update TenMH hay khong ? Yes or No");
				Hoi1=scan.nextLine();
				if(Hoi1.equals("Yes")){
				    System.out.print("Nhap vao Ten Mon Hoc update");
				    System.out.println();
				    TenMHM=scan.nextLine();
				    sql="update MonHoc set TenMH='"+TenMHM+"' where MaMH='"+MaMHM+"'";
				    stmt.executeUpdate(sql);
				    System.out.println("Update success");
				    System.out.println();
				}
				
				String Hoi2;
				System.out.println("Ban co muon update SoTC hay khong ? Yes or No");
				Hoi2=scan.nextLine();
				if(Hoi2.equals("Yes"))
				    {
					System.out.println("Nhap vao so TC update");
					System.out.println();
					SoTCM=scan.nextLine();
					System.out.println("Update success");
				    }
			    }
                        break;
		      }
                  case 3:
		      {
                        System.out.println("In danh sach mon hoc\n");
			sql="select MaMH,TenMH,SoTC from MonHoc";
			ResultSet rs2=stmt.executeQuery(sql);
			while(rs2.next())
			    {
				//retrieve by columm name
				String MaMH1=rs2.getString("MaMH");
				String TenMH1=rs2.getString("TenMH");
				String SoTC1=rs2.getString("SoTC");

				//display values
				System.out.println("Ma Mon Hoc:" +MaMH1);
				System.out.println("Ten Mon Hoc:" +TenMH1);
				System.out.println("So Tin Chi:" +SoTC1);
				System.out.println("**************************");
			    }
			//Clean up enviroment
	    
                        break;
		      }
             

                  case 0:

                        quit = true;

                        break;

                  default:

                        System.out.println("Invalid choice.");

                  }

} while (!quit);

            System.out.println("Ban da thoat che do quan ly mon hoc\n Chao tam biet\n!");

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

