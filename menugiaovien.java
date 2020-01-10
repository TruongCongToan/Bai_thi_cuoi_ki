package muc;
import java.util.Scanner;
import java.sql.*;
import java.util.Scanner;

public class menugiaovien {

// JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/quanly";

   //  Database credentials
   static final String USER = "toantc";
   static final String PASS = "1234567890";

    public void mainGiaoVien() {
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
      String MaGV=new String();
      String HoGV= new String();
      String TenGV= new String();
      String DonVi= new String();
      Scanner scan=new Scanner(System.in);
            //************************************************* print menu*********************************************

	    System.out.println("--MENU--\n1-Them ho so giao vien \n2-Sua thong tin giao vien\n3-In danh sach giao vien\n4-Tim Kiem Giao Vien\n");
            System.out.println("0. Quit");

            // handle user commands

            boolean quit = false;

            int menuItem;

            do {
		
                  System.out.print("Choose menu item for quan ly giao vien:\n");

                  menuItem = in.nextInt();

                  switch (menuItem) {

                  case 1:
		      { //Kiem tra co hay chua
		      System.out.println("Them ho so giao vien");
		      System.out.println();
	      
		      System.out.print("Nhap ma Giao Vien");
		      System.out.println();
		      MaGV=scan.nextLine();
		      
		      sql="select MaGV from GiaoVien where MaGV='"+MaGV+"'";
		      ResultSet rs =stmt.executeQuery(sql);
		      if(!rs.next())
		      {
		
			System.out.print("Ban hay nhap vao Ho Giao Vien ");
			System.out.println();
			HoGV=scan.nextLine();
			
			System.out.print("Ban hay nhap vao Ten Giao Vien ");
			System.out.println();
			TenGV=scan.nextLine();
			
			System.out.print("Ban hay nhap vao Don Vi Giao Vien ");
			System.out.println();
			DonVi=scan.nextLine();
			
			sql="insert into GiaoVien(MaGV,HoGV,TenGV,DonVi)"
			    +"values('"+MaGV+"','"+HoGV+"','"+TenGV+"','"+DonVi+"')";
			stmt.executeUpdate(sql);
			System.out.println("insert succes...");
		      }
		      else
			  {
			      System.out.println("Ban ghi da ton tai !");
			      System.out.println();
			  }
                        break;
		      }
                  case 2:
		      {
                        System.out.println("Sua thong tin giao vien");
			System.out.println();
	   
			
			String MaGVM= new String();
			String HoGVM= new String();
			String TenGVM=new String();
			String DonViM=new String();
			
			System.out.print("Nhap vao Ma giao vien muon sua thong tin.");
		       	System.out.println();
			MaGVM=scan.nextLine();
			//check xem co ton tai hay k
			sql="select MaGV from GiaoVien where MaGV='"+MaGVM+"'";
			ResultSet rs1=stmt.executeQuery(sql);
			
			if(!rs1.next()){
				    System.out.println("Khong co giao vien nay trong danh sach!");
				    System.out.println();
			}
			else
			    {
				String Hoi;
				System.out.println("Ban co muon update Ma giao vien hay khong ? Yes or No");
				Hoi=scan.nextLine();
				
		 		if(Hoi.equals("Yes"))		
				{
			     	System.out.print("Nhap vao ma se update thanh ");
				System.out.println();
				MaGV=scan.nextLine();
				sql="update GiaoVien set MaGV='"+MaGV+"' where MaGV='"+MaGVM+"'";
				stmt.executeUpdate(sql);
				MaGVM=MaGV;
			    	System.out.println("Update success...");
				System.out.println();
				}   
			       
				
				String Hoi1;
				System.out.println("Ban co muon update Ho Giao Vien  hay khong ? Yes or No");
				Hoi1=scan.nextLine();
				
				if(Hoi1.equals("Yes")){
				    System.out.print("Nhap vao Ho Giao Vien update thanh");
				    System.out.println();
				    HoGVM=scan.nextLine();
				    sql="update GiaoVien set HoGV='"+HoGVM+"' where MaGV='"+MaGVM+"'";
				    stmt.executeUpdate(sql);
				    System.out.println("Update success");
				    System.out.println();
				}
				
				String Hoi2;
				System.out.println("Ban co muon update Ten Giao Vien hay khong ? Yes or No");
				Hoi2=scan.nextLine();
				if(Hoi2.equals("Yes"))
				    {
					System.out.println("Nhap vao Ten giao vien update thanh");
					System.out.println();
					TenGVM=scan.nextLine();
					sql="update GiaoVien set TenGV='"+TenGVM+"' where MaGV='"+MaGVM+"'";
					stmt.executeUpdate(sql);
					System.out.println("Update success...");
				    }
				String Hoi3;
				System.out.println("Ban co muon update Don Vi hay khong ? Yes or No");
				Hoi3=scan.nextLine();
				if(Hoi3.equals("Yes"))
				    {
					System.out.println("Nhap vao Don Vi giao vien update thanh");
					System.out.println();
					DonViM=scan.nextLine();
					sql="update GiaoVien set DonVi='"+DonViM+"' where MaGV='"+MaGVM+"'";
					stmt.executeUpdate(sql);
					System.out.println("Update success...");
				    }
			    }
                        break;
		      }
                  case 3:
		      {
                        System.out.println("In danh sach giao vien");
			System.out.println();
			sql="select MaGV,HoGV,TenGV,DonVi from GiaoVien";
			ResultSet rs2=stmt.executeQuery(sql);
			while(rs2.next())
			    {
				//retrieve by columm name
				String MaGV1=rs2.getString("MaGV");
				String HoGV1=rs2.getString("HoGV");		
				String TenGV1=rs2.getString("TenGV");
				String DonVi1=rs2.getString("DonVi");

				//display values
				System.out.println("**********************************************");
				System.out.println("Ma Giao vien:" +MaGV1);
				System.out.println("Ho va ten Giao Vien:" +HoGV1+" "+TenGV1);
				System.out.println("Don Vi:" +DonVi1);
				System.out.println("**********************************************");
				
			    }
			//Clean up enviroment
			/*	rs2.close();
			stmt.close();
			conn.close();*/
                        break;
		      }
                  case 4:
		      {
                        System.out.println("You've chosen item #4");

                        System.out.println("Tim KieM Giao Vien");
                        System.out.println("Nhap Vao Ma Giao Vien Ban Muon tim Kiem");
			String MaGVT=scan.nextLine();
			sql="select MaGV,HoGV,TenGV,DonVi from GiaoVien where MaGV='"+MaGVT+"'";
			ResultSet rs3=stmt.executeQuery(sql);
				
			if(!rs3.next())
			    {
				System.out.println("Khong ton tai giao vien nay trong danh sach!");
			    }
			else
			    {
				
				String MaGV2=rs3.getString("MaGV");
				String HoGV2=rs3.getString("HoGV");
				String TenGV2=rs3.getString("TenGV");
				String DonVi2=rs3.getString("DonVi");
					System.out.println("Thong tin tim kiem duoc :");
				System.out.println("******************************************************");
				System.out.println("Ma giao vien :"+MaGV2);
				//System.out.println("Ho Giao Vien :"+HoGV2);
				//System.out.println("Ten giao vien :"+TenGV2);
				System.out.println("Ho va Ten giao vien :"+HoGV2+" "+TenGV2);
				System.out.println("Don Vi  :"+DonVi2);
				System.out.println("******************************************************");
				/*	rs3.close();
			stmt.close();
			conn.close();*/
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

            System.out.println("Ban da thoat che do quan ly giao vien\n Chao tam biet!");

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
   }//end	 try
//System.out.println("Goodbye!");
}//end main
}//end FirstExample
