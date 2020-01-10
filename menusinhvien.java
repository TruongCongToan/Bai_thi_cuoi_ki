package muc;
import java.util.Scanner;
import java.sql.*;
import java.util.Scanner;
public class menusinhvien{

// JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/quanly";

   //  Database credentials
   static final String USER = "toantc";
   static final String PASS = "1234567890";

    public void mainSinhVien() {
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
      String MaSV=new String();
      String HoSV=new String();
      String TenSV= new String();
      String NgaySinh= new String();
      String NoiSinh=new String();
      
      Scanner scan=new Scanner(System.in);
            //************************************************* print menu*********************************************

      System.out.println("--MENU--\n1-Them ho so sinh vien  \n2-Sua thong tin sinh vien\n3-Tim Kiem Sinh Vien\n4-Tim Sinh Vien Theo ten\n");
      System.out.println("0. Quit");
      
      // handle user commands
      
      boolean quit = false;
      
      int menuItem;

      do {
	  
	  System.out.print("Choose menu item for quan ly sinh vien:\n ");
	  
	  menuItem = in.nextInt();
	  
	  switch (menuItem) {
	      
                  case 1:
		      { //Kiem tra co hay chua
			  System.out.println("Them ho so sinh vien");
			  System.out.println();
			  System.out.print("Nhap ma Sinh vien ");
			  System.out.println();
			  MaSV=scan.nextLine();
		      
		      sql="select MaSV from SinhVien  where MaSV='"+MaSV+"'";
		      ResultSet rs =stmt.executeQuery(sql);
		      if(!rs.next())
			  {

			      System.out.print("Ban hay nhap vao HoSV ");
			      System.out.println();
			      HoSV=scan.nextLine();
			
			      System.out.print("Ban hay nhap vao TenSV ");
			      System.out.println();
			      TenSV=scan.nextLine();
			      
			      System.out.print("Ban Nhap Ngay Sinh Cua Sinh Vien");
			      System.out.println();
			      NgaySinh=scan.nextLine();
			      
			      System.out.print("Ban hay nhap vao Noi Sinh cua Sinh Vien ");
			      System.out.println();
			      NoiSinh=scan.nextLine();
			      
			      sql="insert into SinhVien(MaSV,HoSV,TenSV,NgaySinh,NoiSinh)"
				  +"values('"+MaSV+"','"+HoSV+"','"+TenSV+"','"+NgaySinh+"','"+NoiSinh+"')";
			      stmt.executeUpdate(sql);
			      System.out.println("insert succes...");
			  }
		      else
			  {
			      System.out.println("Ban ghi da ton tai trong danh sach cac sinh vien !");
			      System.out.println();
			  }
                        break;
		      }
                  case 2:
		      {
                        System.out.println("Sua thong tin sinh vien");
			System.out.println();
			String MaSVM= new String();
			String HoSVM= new String();
			String TenSVM= new String();
		       	String NgaySinhM=new String();
			String NoiSinhM= new String();
			
			System.out.print("Nhap vao Ma SV ban muon chinh sua ");
		       	System.out.println();
			MaSVM=scan.nextLine();
			//check xem co ton tai hay k
			sql="select MaSV from SinhVien where MaSV='"+MaSVM+"'";
			ResultSet rs1=stmt.executeQuery(sql);
			
			if(!rs1.next()){
			    System.out.println("Khong ton tai sinh vien nay trong danh sach!");
			    System.out.println();
			}
			else
			    {
				String Hoi;
				System.out.println("Ban co muon update MaSV hay khong ? Yes or No");
				Hoi=scan.nextLine();
				
		 		if(Hoi.equals("Yes"))		
				{
			     	System.out.print("Nhap vao ma SV se update thanh ");
				System.out.println();
				MaSV=scan.nextLine();
				sql="update SinhVien set MaSV='"+MaSV+"' where MaSV='"+MaSVM+"'";
				stmt.executeUpdate(sql);
				MaSVM=MaSV;
			    	System.out.println("Update success...");
				System.out.println();
				}   
			       
				
				String Hoi1;
				System.out.println("Ban co muon update Ho SV hay khong ? Yes or No");
				Hoi1=scan.nextLine();
				if(Hoi1.equals("Yes")){
				    System.out.print("Nhap vao Ho Sinh Vien update");
				    System.out.println();
				    HoSVM=scan.nextLine();
				    sql="update SinhVien set HoSV='"+HoSVM+"' where MaSV='"+MaSVM+"'";
				    stmt.executeUpdate(sql);
				    System.out.println("Update success");
				    System.out.println();
				}
				
				String Hoi2;
				System.out.println("Ban co muon update Ten SV hay khong ? Yes or No");
				Hoi2=scan.nextLine();
				if(Hoi2.equals("Yes"))
				    {
					System.out.print("Nhap vao Ten Sinh Vien update");
					System.out.println();
					TenSVM=scan.nextLine();
					sql="update SinhVien set TenSV='"+TenSVM+"' where MaSV='"+MaSVM+"'";
					stmt.executeUpdate(sql);
					System.out.println("Update success....");
					System.out.println();
				    }

				String Hoi3;
				System.out.println("Ban co muon update Ngay Sinh hay khong ? Yes or No");
				Hoi3=scan.nextLine();
				if(Hoi3.equals("Yes"))
				    {
					System.out.print("Nhap vao Ngay Sinh update");
					System.out.println();
					NgaySinhM=scan.nextLine();
					sql="update SinhVien set NgaySinh='"+NgaySinhM+"' where MaSV='"+MaSVM+"'";
					stmt.executeUpdate(sql);
					System.out.println("Update success...");
					System.out.println();
				    }
				
				String Hoi4;
				System.out.println("Ban co muon Noi Sinh hay khong ? Yes or No");
				Hoi4=scan.nextLine();
				if(Hoi4.equals("Yes"))
				    {
					System.out.print("Nhap vao Noi Sinh update");
					System.out.println();
					NoiSinhM=scan.nextLine();
					sql="update SinhVien set NoiSinh='"+NoiSinhM+"' where MaSV='"+MaSVM+"'";
					stmt.executeUpdate(sql);
					System.out.println("Update success...");
					System.out.println();
				    }
				
			    }
			break;
		      }
                  case 3:
		      {
                       

                        System.out.println("Tim Kiem Sinh Vien ");
                        System.out.println("Nhap Vao Ma Sinh Vien Ban Muon tim Kiem");
			String MaSVT=scan.nextLine();
			sql="select MaSV,HoSV,TenSV,NgaySinh,NoiSinh from SinhVien where MaSV='"+MaSVT+"'";
			ResultSet rs3=stmt.executeQuery(sql);
				
			if(!rs3.next())
			    {
				System.out.println("Khong ton tai Sinh vien nay trong danh sach!");
			    }
			else
			    {
				
				String MaSV2=rs3.getString("MaSV");
				String HoSV2=rs3.getString("HoSV");
				String TenSV2=rs3.getString("TenSV");
				String NgaySinh2=rs3.getString("NgaySinh");
				String NoiSinh2=rs3.getString("NoiSinh");
				
				System.out.println("Thong tin tim kiem duoc :");
				System.out.println("*****************************************************");
				System.out.println("Ma sinh vien : "+MaSV2);
				//System.out.println("Ho Giao Vien :"+HoGV2);
				//System.out.println("Ten giao vien :"+TenGV2);
				System.out.println("Ho va Ten sinh vien : "+HoSV2+" "+TenSV2);
				System.out.println("Ngay Sinh  : "+NgaySinh2);
				System.out.println("Noi Sinh  : "+NoiSinh2);
				System.out.println("*****************************************************");
				/*	rs3.close();
			stmt.close();
			conn.close();*/
			    }
			break;
		      }             

	  case 4:
	      {

		  System.out.println("Nhap chu cai bat dau ma ban muon tim Ho");
		  System.out.println();
		  String HoSVT=scan.nextLine();
		  sql="select MaSV,HoSV,TenSV,NgaySinh,NoiSinh from SinhVien where HoSV like '"+HoSVT+"%'";
		  ResultSet rs3=stmt.executeQuery(sql);
		  while(rs3.next())
		      {
		  String MaSV2=rs3.getString("MaSV");
		  String HoSV2=rs3.getString("HoSV");
		  String TenSV2=rs3.getString("TenSV");
		  String NgaySinh2=rs3.getString("NgaySinh");
		  String NoiSinh2=rs3.getString("NoiSinh");
		  
		  System.out.println("Thong tin tim kiem duoc :");
		  System.out.println("*****************************************************");
		  System.out.println("Ma sinh vien : "+MaSV2);
		  //System.out.println("Ho Giao Vien :"+HoGV2);
		  //System.out.println("Ten giao vien :"+TenGV2);
		  System.out.println("Ho va Ten sinh vien : "+HoSV2+" "+TenSV2);
		  System.out.println("Ngay Sinh  : "+NgaySinh2);
		  System.out.println("Noi Sinh  : "+NoiSinh2);
		  System.out.println("*****************************************************");
		  System.out.println();
		      }
	      }
	  case 0:

                        quit = true;

                        break;

                  default:

                        System.out.println("Invalid choice.");

                  }

} while (!quit);

            System.out.println("Ban da thoat che do quan ly sinh vien\nChao tam biet!");

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
