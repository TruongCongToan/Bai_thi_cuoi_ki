package muc;
import java.util.Scanner;
import java.sql.*;
import java.util.Scanner;
import java.io.IOException;  
public class menulop{

// JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/quanly";

   //  Database credentials
   static final String USER = "toantc";
   static final String PASS = "1234567890";

    public void mainLop() {
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
      String MaLop=new String();
      String MaMH=new String();
      String NamHoc=new String();
      String HocKy=new String();
      String MaGV=new String();
      
      Scanner scan=new Scanner(System.in);
            //************************************************* print menu*********************************************

      System.out.println("--MENU--\n1-Tao lop moi \n2-Sua doi thong tin lop \n3-Bo sung sinh vien vao lop\n4-Loai bo sinh vien khoi lop\n5-Huy Lop\n6-In danh sach lop\n");
      System.out.println("0. Quit");
      
      // handle user commands
      
      boolean quit = false;
      
      int menuItem;

      do {
	  
	  System.out.print("Choose menu item for quan ly lop:\n ");
	  
	  menuItem = in.nextInt();
	  
	  switch (menuItem) {
     
	  case 1:
	      {
		  { //Kiem tra co hay chua
		      System.out.println("Tao Lop Moi");
		      System.out.println();
	      
		      System.out.print("Nhap ma Lop");
		      System.out.println();
		      MaLop=scan.nextLine();
		      
		      sql="select MaLop from Lop where MaLop='"+MaLop+"'";
		      ResultSet rs =stmt.executeQuery(sql);
		      if(!rs.next())
		      {
			  
			System.out.print("Ban hay nhap vao Ma Mon Hoc ");
			System.out.println();
			MaMH=scan.nextLine();
			sql="select MaMH from MonHoc where MaMH='"+MaMH+"'";
			ResultSet rs1=stmt.executeQuery(sql);
			if(!rs1.next())
			    {
				System.out.println("Khong co Ma mon hoc nay trong danh sach!");
			    }else
			    {
				System.out.print("Ban hay nhap vao MaGV cua lop ");
				System.out.println();
				MaGV=scan.nextLine();

				sql="select MaGV from GiaoVien where MaGV='"+MaGV+"'";
				ResultSet rs2=stmt.executeQuery(sql);
				if(!rs2.next())
			    {
				System.out.println("Khong co Ma giao vien nay trong danh sach!");
			    }else
				    {
				
					System.out.print("Ban hay nhap vao Nam Hoc(Co dang ****-****) ");
					System.out.println();
					NamHoc=scan.nextLine();
				
					
					System.out.print("Ban hay nhap vao hoc ky mo lop ");
					System.out.println();
					HocKy=scan.nextLine();
					sql="insert into Lop(MaLop,MaMH,NamHoc,HocKy,MaGV)"
					    +"values('"+MaLop+"','"+MaMH+"','"+NamHoc+"','"+HocKy+"','"+MaGV+"')";
					stmt.executeUpdate(sql);
					System.out.println("insert succes...");
				    }
				
			    }
		      }
		      else
			  {
			      System.out.println("Ban ghi da ton tai !");
			      System.out.println();
			  }
                        break;
		  }
		      
	      }
		  
	  case 2:
	      {
		  System.out.println("Sua Doi Thong Tin Lop");

		  String NamHocM=new String();
		  int HocKyM;
		  String MaGVM=new String();

		  System.out.print("Nhap vao Ma Lop ban muon update");
		  System.out.println();
		  MaLop=scan.nextLine();
		  //check exist
		  sql="select MaLop from Lop where MaLop='"+MaLop+"'";
		  ResultSet rs1=stmt.executeQuery(sql);
		  
		  if(!rs1.next()){
		      System.out.println("Khong co lop nay trong danh sach!");
		      System.out.println();
		  }else
		      {


			  String Hoi2;
			  System.out.println("Ban co muon chinh sua Ma Giao Vien hay khong ? Yes or No");
			  Hoi2=scan.nextLine();
			  if(Hoi2.equals("Yes"))
			      {
				  System.out.print("Nhap vao Ma Giao Vien ma ban chinh sua thanh");
				  System.out.println();
				  MaGVM=scan.nextLine();
				  sql="select MaGV from GiaoVien where MaGV='"+MaGVM+"'";
				  ResultSet rs=stmt.executeQuery(sql);
				  if(!rs.next())
				      {
					  System.out.println("Khong co ma giao vien nay trong danh sach giao vien\n");
				      }else{
				      sql="update Lop set MaGV='"+MaGVM+"' where MaLop='"+MaLop+"'";
				      stmt.executeUpdate(sql);
				      System.out.println("Update success"); 
				  }
			      }
				      String Hoi;
				      System.out.println("Ban co muon chinh sua Nam Hoc hay khong ? Yes or No");
				      Hoi=scan.nextLine();
				      if(Hoi.equals("Yes"))
					  {
					      System.out.print("Nhap vao Nam Hoc ma ban chinh sua thanh");
					      System.out.println();
					      NamHocM=scan.nextLine();
					      sql="update Lop set NamHoc='"+NamHocM+"' where MaLop='"+MaLop+"'";
					      stmt.executeUpdate(sql);
					      System.out.println("Update success..");
					      System.out.println();
					  }
				      String Hoi1;
				      System.out.println("Ban co muon chinh sua Hoc Ky hay khong ? Yes or No");
				      Hoi1=scan.nextLine();
				      if(Hoi1.equals("Yes"))
					  {
					      System.out.print("Nhap vao Hoc Ky ma ban chinh sua thanh");
					      System.out.println();
					      HocKyM=scan.nextInt();
					      sql="update Lop set HocKy='"+HocKyM+"' where MaLop='"+MaLop+"'";
					      stmt.executeUpdate(sql);
					      System.out.println("Update success...");
					      System.out.println();
					  }
				  
			      
			      
		      }
		  break;
	      }
	      case 3:
		  {
		      System.out.println("Bo Sung sinh vien vao lop.\n");

		      String MaSVM=new String();
		      String MaLopM=new String();
		      double DiemM;

		      System.out.print("Nhap vao Ma Lop ban muon them vao ban ghi");
		      System.out.println();
		      MaLopM=scan.nextLine();
		      //check exist
		      sql="select MaLop from Lop where MaLop='"+MaLopM+"'";
		      ResultSet rs1=stmt.executeQuery(sql);
		  
		      if(!rs1.next()){
			  System.out.println("Khong co lop nay trong danh sach Lop!");
			  System.out.println();
		      }else
			  {
			   	  
			System.out.print("Ban hay nhap vao Ma Sinh vien muon bo sung vao lop ");
			System.out.println();
			MaSVM=scan.nextLine();
			sql="select MaSV from SinhVien where MaSV='"+MaSVM+"'";
			ResultSet rs=stmt.executeQuery(sql);
			if(!rs.next())
			    {
				System.out.println("Khong co Ma Sinh Vien nay trong danh sach Sinh Vien!\n");
			    }else
			    {
				sql="select MaSV,MaLop from SinhVienLop where MaSV='"+MaSVM+"'and MaLop='"+MaLopM+"' ";
				ResultSet rs2=stmt.executeQuery(sql);
				if(rs2.next())
				    {
					System.out.println("Ban ghi ve Sinh Vien Lop nay da co roi ! \n");
				    }else{
				   	sql="insert into SinhVienLop(MaSV,MaLop)"
					    +"values('"+MaSVM+"','"+MaLopM+"')";
				    	stmt.executeUpdate(sql);
					System.out.println("insert succes...");
				}
			    }
			  }
			      break;
		  }
		      case 4:
		      {
			  System.out.println("Loai bo sinh vien khoi lop \n");

			  String MaSVM=new String();
			  String MaLopM=new String();

			  System.out.print("Nhap vao Ma Lop ban muon xoa sinh vien khoi lop");
			  System.out.println();
			  MaLopM=scan.nextLine();
			  //check exist
			  sql="select MaLop from Lop where MaLop='"+MaLopM+"'";
			  ResultSet rs1=stmt.executeQuery(sql);
			  if(!rs1.next())
			      {
				  System.out.println("Khong ton tai lop nay trong danh sach\n");
			      }else
			  {
			   	  
			System.out.print("Ban hay nhap vao Ma Sinh vien muon xoa khoi lop ");
			System.out.println();
			MaSVM=scan.nextLine();
			sql="select MaSV from SinhVien where MaSV='"+MaSVM+"'";
			ResultSet rs=stmt.executeQuery(sql);
			if(!rs.next())
			    {
				System.out.println("Khong co Ma Sinh Vien nay trong danh sach Sinh Vien.\n");
			    }else{
			    sql="delete from SinhVienLop where MaSV='"+MaSVM+"'";
			    stmt.executeUpdate(sql);
			    System.out.println("Da Xoa thanh cong sinh vien khoi lop\n");			}
			  }
		      
			  break;
		      }
		      case 5:
			  {
			    System.out.println("Huy lop  \n");
			    
			    String MaSVM=new String();
			    String MaLopM=new String();   

			    System.out.print("Nhap vao Ma Lop ban muon huy lop");
			    System.out.println();
			    MaLopM=scan.nextLine();
			    //check exist
			    sql="select MaLop from Lop where MaLop='"+MaLopM+"'";
			    ResultSet rs1=stmt.executeQuery(sql);
			    if(!rs1.next())
				{
				    System.out.println("Khong ton tai lop nay trong danh sach\n");
				    System.out.println();
				    
				}else
				{
				    sql="delete from Lop where MaLop='"+MaLopM+"'";
				    stmt.executeUpdate(sql);
				    System.out.println("Da huy thanh cong lop\n");
				}
			    
				    break;
				}
			    case 6:
				{
				    System.out.println("In Danh Sach Lop\n");
				    
				    sql="select MaLop,MaMH,NamHoc,HocKy,MaGV from Lop";
				    ResultSet rs=stmt.executeQuery(sql);

				    while(rs.next())
					{
					    //Retrieve by column name
					    MaLop=rs.getString("MaLop");
					    MaMH=rs.getString("MaMH");
					    NamHoc=rs.getString("NamHoc");
					    HocKy=rs.getString("HocKy");
					    MaGV=rs.getString("MaGV");

					    //Display values
					    System.out.print("**************************\n");
					    System.out.println("Ma Lop : "+MaLop);
					    System.out.println("Ma Mon Hoc : "+MaMH);
					    System.out.println("Nam Hoc : "+NamHoc);
					    System.out.println("Hoc Ky : "+HocKy);
					    System.out.println("Ma Giao Vien : "+MaGV);
					    System.out.print("**************************\n");
					    
					    
					}
				   
							   
				    break;
				}
				
				case 0:
				    {
					quit = true;
					break;
				    }
				    default:
					
					System.out.println("Invalid choice.");
					
			  }
			  
	  } while (!quit);
	  
	  System.out.println("Ban da thoat che do quan ly lop\nChao tam biet!");
	  
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
    
