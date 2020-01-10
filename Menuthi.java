import java.util.Scanner;
import java.sql.*;
import java.util.Scanner;
import java.sql.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
//my package

public class Menuthi{

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
      String sql=new String();
    
       Scanner scan=new Scanner(System.in);
            //************************************************* print menu*********************************************

	    System.out.println("--MENU--\n1-Xoa CSDL\n2-Nhap du lieu tu tep\n3-In danh sach \n");
            System.out.println("0. Quit");

            // handle user commands

            boolean quit = false;

            int menuItem;

            do {

                  System.out.print("Choose menu item: ");

                  menuItem = in.nextInt();

                  switch (menuItem) {

                  case 1:
		      {

			  System.out.println("Khoi tao lai CSDL\n");
		
		sql="delete  from MonHoc";
		try{
		   stmt.executeUpdate(sql);
		}catch(SQLException se){
		    se.printStackTrace();
		}

		sql="delete  from GiaoVien";
		try{
		    stmt.executeUpdate(sql);
		}catch(SQLException se){
		    se.printStackTrace();
		}

		sql="delete from SinhVien";
		try{
		    stmt.executeUpdate(sql);
		}catch(SQLException se){
		    se.printStackTrace();
		}

		sql="delete from Lop";
		try{
		    stmt.executeUpdate(sql);
		}catch(SQLException se){
		    se.printStackTrace();
		}

		sql="delete from SinhVienLop";
		try{
		    stmt.executeUpdate(sql);
		}catch(SQLException se){
		    se.printStackTrace();
		}
		
		System.out.println("Khoi tao lai thanh cong\n");
		scan.nextLine();
		
		      }break;
		  case 2:
		      {
			  System.out.println("Chon tep:\n");
		int type=0;
		System.out.println("1. MonHoc.csv");
	        System.out.println("2. GiaoVien.csv");
		System.out.println("3. SinhVIen.csv");
		System.out.println("4. Lop.csv");
		System.out.println("5. SinhVienLop.csv");
		System.out.println("6. Tat ca\n");

		int choiceCase2=0;
		System.out.print("Ban chon tep: ");
		choiceCase2=scan.nextInt();

		switch(choiceCase2)
		    {
		    case 1:
			{

			    String csvFile = "DB1/MonHoc.csv";
			    BufferedReader br = null;
			    String line = "";
			    String cvsSplitBy = ",";


			      try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] MonHoc = line.split(cvsSplitBy);	 
		sql="select MaMH from MonHoc where MaMH='"+MonHoc[0]+"'";
		ResultSet rs =stmt.executeQuery(sql);
		if(!rs.next())
		    {
			sql="insert into MonHoc(MaMH,TenMH,SoTC)"
			    +"values('"+MonHoc[0]+"','"+MonHoc[1]+"','"+MonHoc[2]+"')";
			stmt.executeUpdate(sql);
			System.out.println("insert succes...");
		    }
		else
		    {
			System.out.println("Da co Mon Hoc nay trong danh sach cac mon hoc !");
			System.out.println();
			
		    }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
			      }


			    
			}break;
			
		    case 2:
			{
   {
			 
			    String csvFile = "DB1/GiaoVien.csv";
			    BufferedReader br = null;
			    String line = "";
			    String cvsSplitBy = ",";


			      try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[]  GiaoVien= line.split(cvsSplitBy);	 
		sql="select MaGV from GiaoVien where MaGV='"+GiaoVien[0]+"'";
		ResultSet rs =stmt.executeQuery(sql);
		if(!rs.next())
		    {
			sql="insert into GiaoVien(MaGV,HoGV,TenGV,DonVi)"
			    +"values('"+GiaoVien[0]+"','"+GiaoVien[1]+"','"+GiaoVien[2]+"','"+GiaoVien[3]+"')";
			stmt.executeUpdate(sql);
			System.out.println("insert succes...");
		    }
		else
		    {
			System.out.println("Da co Giao Vien nay trong danh sach cac Giao Vien !");
			System.out.println();
			
		    }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
			      }   
   }
			
			
			    
			}break;
		    case 3:
			{
			       {
			 
			    String csvFile = "DB1/SinhVien.csv";
			    BufferedReader br = null;
			    String line = "";
			    String cvsSplitBy = ",";


			      try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[]  SinhVien= line.split(cvsSplitBy);	 
		sql="select MaSV from SinhVien where MaSV='"+SinhVien[0]+"'";
		ResultSet rs =stmt.executeQuery(sql);
		if(!rs.next())
		    {
			sql="insert into SinhVien(MaSV,HoSV,TenSV,NgaySinh,NoiSinh)"
			    +"values('"+SinhVien[0]+"','"+SinhVien[1]+"','"+SinhVien[2]+"','"+SinhVien[3]+"','"+SinhVien[4]+"')";
			stmt.executeUpdate(sql);
			System.out.println("insert succes...");
		    }
		else
		    {
			System.out.println("Da co Sinh Vien nay trong danh sach cac Sinh Vien !");
			System.out.println();
			
		    }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
			      }   
   }


			}break;
		    case 4:
			{
 {
			 
			    String csvFile = "DB1/Lop.csv";
			    BufferedReader br = null;
			    String line = "";
			    String cvsSplitBy = ",";


			      try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[]  Lop= line.split(cvsSplitBy);	 
		sql="select MaLop from Lop where MaLop='"+Lop[0]+"'";
		ResultSet rs =stmt.executeQuery(sql);
		if(!rs.next())
		    {
			sql="select MaMH from MonHoc where MaMH='"+Lop[1]+"'";
			ResultSet rs1=stmt.executeQuery(sql);
			if(!rs1.next())
			    {
				System.out.println("Khong co Ma mon hoc nay trong danh sach!");
			    }else
			    {
				sql="select MaGV from GiaoVien where MaGV='"+Lop[4]+"'";
				ResultSet rs2=stmt.executeQuery(sql);
				if(!rs2.next())
			    {
				System.out.println("Khong co Ma giao vien nay trong danh sach!");
			    }else
				    {
					sql="insert into Lop(MaLop,MaMH,NamHoc,HocKy,MaGV)"
					    +"values('"+Lop[0]+"','"+Lop[1]+"','"+Lop[2]+"','"+Lop[3]+"','"+Lop[4]+"')";
					stmt.executeUpdate(sql);
					System.out.println("insert succes...");
				    }
			    }
		
		    }
		else
		    {
			System.out.println("Da co Lop nay trong danh sach cac Lop !");
			System.out.println();
			
		    }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
			      }   
   }
			}break;
		    case 5:
			{
			     {
			 
			    String csvFile = "DB1/SinhVienLop.csv";
			    BufferedReader br = null;
			    String line = "";
			    String cvsSplitBy = ",";


			      try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[]  SinhVienLop= line.split(cvsSplitBy);	 
		sql="select MaSV,MaLop from SinhVienLop where MaSV='"+SinhVienLop[0]+"'and MaLop='"+SinhVienLop[1]+"'";                                                                                   ;
		ResultSet rs =stmt.executeQuery(sql);
		if(!rs.next())
		    {
			sql="select MaSV from SinhVien where MaSV='"+SinhVienLop[0]+"'";                                                                                   ;
			ResultSet rs1 =stmt.executeQuery(sql);
			if(!rs1.next())
			    {
				System.out.println("Khong co sinh vien trong danh sach sinh vien");
				System.out.println();
			    }
			else
			    {
				sql="select MaLop from Lop where MaLop='"+SinhVienLop[1]+"'";                                                                                   ;
				ResultSet rs2 =stmt.executeQuery(sql);
				if(!rs2.next())
				    {
					System.out.println("Khong co Lop nay trong danh sach Lop ");
					System.out.println();
				    }
				else
				    {
					sql="insert into SinhVienLop(MaSV,MaLop,Diem)"
					    +"values('"+SinhVienLop[0]+"','"+SinhVienLop[1]+"','"+SinhVienLop[2]+"')";
					stmt.executeUpdate(sql);
					System.out.println("insert succes...");
				    }
			    }
		
		    }
	    }
			      } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
			      }   
   }
			}break;
		    case 6:
			{
			}break;
		    }
		      }break;
		  case 0:
                        quit = true;

                        break;

                  default:

                        System.out.println("Invalid choice.");

                  }

} while (!quit);

            System.out.println("Bye-bye!");

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


		      
