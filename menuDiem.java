package muc;
import java.util.Scanner;
import java.sql.*;
import java.util.Scanner;

public class menuDiem {

// JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/quanly";

   //  Database credentials
   static final String USER = "toantc";
   static final String PASS = "1234567890";

    public void mainDiem() {
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
      String MaLop= new String();
      double Diem;
      Scanner scan=new Scanner(System.in);
            //************************************************* print menu*********************************************

	    System.out.println("--MENU--\n1-Nhap Diem \n2-Sua Diem \n3-In Diem cho lop \n4-In Diem cho sinh vien\n");
            System.out.println("0. Quit");

            // handle user commands

            boolean quit = false;

            int menuItem;

            do {

                  System.out.print("Choose menu item for quan ly Diem:\n ");

                  menuItem = in.nextInt();

                  switch (menuItem) {

                  case 1:
		      { //Kiem tra co hay chua
			  System.out.println("Nhap Diem ");
			  System.out.println();
			  
			  
			  String MaSVM=new String();
			  String MaLopM=new String();
			  double DiemM;
			  System.out.print("Nhap vao Ma Lop de nhap diem");
			  System.out.println();
			  MaLopM=scan.nextLine();
			  //check exist
			  sql="select MaLop from Lop where MaLop='"+MaLopM+"'";
			  ResultSet rs1=stmt.executeQuery(sql);
			  if(!rs1.next())
			      {
				  System.out.println("Khong ton tai lop nay trong danh sach lop\n");
				  System.out.println();

			      }else{
			      System.out.print("Ban hay nhap vao Ma Sinh vien can de nhap diem ");
			      System.out.println();
			      MaSVM=scan.nextLine();
			      sql="select MaSV from SinhVienLop where MaSV='"+MaSVM+"'";
			      ResultSet rs=stmt.executeQuery(sql);
			      if(!rs.next())
			    {
				System.out.println("Khong co Ma Sinh Vien nay trong danh sach sinh vien cua lop.\n");
				System.out.println();
				
			    }else{
				  System.out.print("Ban hay nhap vao diem cua sinh vien");
				  System.out.println();
				  DiemM=scan.nextDouble();
				  sql="update SinhVienLop set Diem ='"+DiemM+"' where MaLop='"+MaLopM+"' and MaSV='"+MaSVM+"'";
				   stmt.executeUpdate(sql);
				  System.out.println("Success....\n");
				      }
			  }
                        break;
		      }
                  case 2:
		      { 
                        { //Kiem tra co hay chua
			  System.out.println("Sua Diem ");
			  System.out.println();
			  
			  
			  String MaSVM=new String();
			  String MaLopM=new String();
			  double DiemM;
			  System.out.print("Nhap vao Ma Lop de sua diem");
			  System.out.println();
			  MaLopM=scan.nextLine();
			  //check exist
			  sql="select MaLop from Lop where MaLop='"+MaLopM+"'";
			  ResultSet rs1=stmt.executeQuery(sql);
			  if(!rs1.next())
			      {
				  System.out.println("Khong ton tai lop nay trong danh sach lop\n");
				  System.out.println();

			      }else{
			      System.out.print("Ban hay nhap vao Ma Sinh vien can de sua diem ");
			      System.out.println();
			      MaSVM=scan.nextLine();
			      sql="select MaSV from SinhVienLop where MaSV='"+MaSVM+"'";
			      ResultSet rs=stmt.executeQuery(sql);
			      if(!rs.next())
			    {
				System.out.println("Khong co Ma Sinh Vien nay trong danh sach Sinh Vien.\n");
				System.out.println();
				
			    }else{
				  System.out.print("Ban hay nhap vao diem se sua thanh ");
				  System.out.println();
				  DiemM=scan.nextDouble();
				  sql="update SinhVienLop set Diem ='"+DiemM+"' where MaLop='"+MaLopM+"' and MaSV='"+MaSVM+"'";
				   stmt.executeUpdate(sql);
				  System.out.println("Success....\n");
				      }
			  }
                        break;
			}
		      }
		      
                  case 3:
		      {
			  String MaLopM=new String();
			  
			  System.out.println("In bang diem cho lop");
			  System.out.println();
			
			  System.out.print("Nhap vao Ma Lop ma ban muon in ra bang diem");
			  System.out.println();
			  MaLopM=scan.nextLine();
			  //check exist
			 sql="select MaLop from Lop where MaLop='"+MaLopM+"'";
			  ResultSet rs=stmt.executeQuery(sql);
			  if(!rs.next())
			      {

				  System.out.println("Khong ton tai lop nay trong danh sach lop\n");
				  System.out.println();
				  
			      }else{
			      
			      System.out.println("\nThong tin ve diem cua lop co ma so : "+MaLopM+"\n");
			      
			      sql="select "
				  +"SinhVienLop.MaSV,SinhVien.HoSV,SinhVien.TenSV,SinhVien.NgaySinh,SinhVien.NoiSinh,SinhVienLop.Diem "
				  +"from "
				  +"Lop inner join SinhVienLop on Lop.MaLop=SinhVienLop.MaLop "
				  +"inner join SinhVien on SinhVien.MaSV=SinhVienLop.MaSV "
				  +"where "
				  +"SinhVienLop.MaLop='"+MaLopM+"'";
			      
			      
			      ////Extract data from result set
			      ResultSet rs4=stmt.executeQuery(sql);
			      while(rs4.next()){
				  //retrieve by column name
				  String MaSV1 = rs4.getString("MaSV");
				  String HoSV1 = rs4.getString("HoSV");
				  String TenSV1 = rs4.getString("TenSV");
				  String NgaySinh1 = rs4.getString("NgaySinh");
				  String NoiSinh1 = rs4.getString("NoiSinh");
				  double Diem1 = rs4.getDouble("Diem");

				  //display values
				  System.out.print("Ma SV : "+MaSV1);
				  System.out.print(", Ho va ten : "+HoSV1+" "+TenSV1);
				 
				  System.out.print(", Ngay Sinh : "+NgaySinh1);
				  System.out.print(", Noi Sinh : "+NoiSinh1);
				  System.out.println(", Diem : "+Diem1);
				  System.out.println();
			      }	  
				  
			      
			  }
		     
			  break;
		      }
                  case 4:
		      {
                        
		      
			  {
			  String MaSVM=new String();
			  
			  System.out.println("In bang diem cho sinh vien");
			  System.out.println();
			
			  System.out.print("Nhap vao Ma Sinh Vien ma ban muon in ra bang diem");
			  System.out.println();
			  MaSVM=scan.nextLine();
			  //check exist
			 sql="select MaSV from SinhVienLop where MaSV='"+MaSVM+"'";
			  ResultSet rs=stmt.executeQuery(sql);
			  if(!rs.next())
			      {

				  System.out.println("Khong ton tai sinh vien nay trong danh sach lop\n");
				  System.out.println();
				  
			      }else{
			      
			      System.out.println("\n Thong tin ve diem cua sinh vien co ma so: "+MaSVM+"\n");
			      
			      sql="select "
				  +"Lop.MaLop,MonHoc.MaMH,MonHoc.TenMH,SinhVienLop.Diem "
				  +"from "
				  +"SinhVienLop inner join Lop on Lop.MaLop=SinhVienLop.MaLop "
				  +"inner join MonHoc on MonHoc.MaMH=Lop.MaMH "
				  +"where "
				  +"SinhVienLop.MaSV='"+MaSVM+"'";
			      
			      
			      ////Extract data from result set
			      ResultSet rs4=stmt.executeQuery(sql);
			      while(rs4.next()){
				  //retrieve by column name
				  String MaLop1 = rs4.getString("MaLop");
				  String MaMH1 = rs4.getString("MaMH");
				  String TenMH1 = rs4.getString("TenMH");
				  double Diem1 = rs4.getDouble("Diem");

				  //display values
				  System.out.print("Ma Lop : "+MaLop1);
				  System.out.print(", Ma Mon Hoc : "+MaMH1);
				  System.out.print(", Ten Mon Hoc : "+TenMH1);
				 
				  System.out.println(", Diem : "+Diem1);
				  System.out.println();
			      }	  
				  
			      
			  }
		     
			  break;
		      
			  }
		      }


                  case 0:

                        quit = true;

                        break;

                  default:

                        System.out.println("Invalid choice.");

                  }

} while (!quit);

            System.out.println("Ban da thoat che do quan ly diem\nChao tam biet!");

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
