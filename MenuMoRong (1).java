package muc;

import java.util.Scanner;
import java.sql.*;
import java.io.*;

//my package
import db_choose.*;
import check_exists.*;
import menu.*;
import sqlPerforment.*;

public class MenuMoRong{

    Statement stmt;
    public MenuMoRong(Statement stmt){
	this.stmt=stmt;
    }
    
    public void exec() throws  SQLException, Exception{

	String[] fieldsNameToPrint;
	Scanner scan=new Scanner(System.in);

	System.out.println();
	int choice;
	do{
	    choice=new Menu().getChoice(Menu.menuMoRong);

	    String sql=new String();
	    
	    switch(choice) {
	    case 1:
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
		break;
			    
			    
	    case 2:
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
                 scan.nextLine();
                 System.out.print("Ban nhap duong dan: ");
               String duongDan=new String();
               duongDan=scan.nextLine();

		switch(choiceCase2)
		    {
		    case 1:
			File fileCase1= new File(duongDan+"MonHoc.csv");
			try (FileReader FR = new FileReader(fileCase1)){
				
			    BufferedReader BR = new BufferedReader(FR);
			   

			    while ((sql = BR.readLine()) != null){
				int pointer=0;
				
                                String MaMH=new String();
			        String TenMH=new String();
			        int SoTC=0;

				while(sql.charAt(pointer)!=',')
				    {
					MaMH=MaMH+sql.charAt(pointer);
					pointer=pointer+1;
				    }
				System.out.println(MaMH);
				 
				pointer=pointer+1;
				 
				while(sql.charAt(pointer)!=',')
				    {
					TenMH=TenMH+sql.charAt(pointer);
					pointer=pointer+1;
				    }
				System.out.println(TenMH);

				pointer=pointer+1;
				 
				String SoTCTMP=new String();
				while(pointer<sql.length())
				    {
					SoTCTMP=SoTCTMP+sql.charAt(pointer);
					pointer=pointer+1;
				    }
				System.out.println(SoTCTMP);
				SoTC = Integer.parseInt(SoTCTMP.trim());

				if(new CheckExists(stmt).checkExists("MonHoc","MaMH='"+MaMH+"'")==1){
				    sql="delete from MonHoc where MaMH='"+MaMH+"'";

				    try{
					stmt.executeUpdate(sql);
				    }catch(SQLException se){
					se.printStackTrace();
				    }
				}

				sql="insert into MonHoc "
				    +"values('"+MaMH+"','"+TenMH+"',"+SoTC+")";

				try{
				    stmt.executeUpdate(sql);
				}catch(SQLException se){
				    se.printStackTrace();
				}
			    }
			    
			    System.out.println("Restore successfully");
			    scan.nextLine();
			}catch (Exception e){
			    e.printStackTrace();
			} scan.nextLine();

			break;



			
		    case 2:

			File fileCase2= new File(duongDan+"GiaoVien.csv");
			try (FileReader FR = new FileReader(fileCase2)){
				
			    BufferedReader BR = new BufferedReader(FR);
			   

			    while ((sql = BR.readLine()) != null){
				int pointer=0;
				
                                String MaGV=new String();
				String HoGV=new String();
				String TenGV=new String();
				String DonVi=new String();

				while(sql.charAt(pointer)!=',')
				    {
					MaGV=MaGV+sql.charAt(pointer);
					pointer=pointer+1;
				    }
				System.out.println(MaGV);
				 
				pointer=pointer+1;
				 
				while(sql.charAt(pointer)!=',')
				    {
					TenGV=TenGV+sql.charAt(pointer);
					pointer=pointer+1;
				    }
				System.out.println(TenGV);

				pointer=pointer+1;
				
				while(sql.charAt(pointer)!=',')
				    {
					HoGV=HoGV+sql.charAt(pointer);
					pointer=pointer+1;
				    }
				System.out.println(HoGV);

				pointer=pointer+1;
				 
				while(pointer<sql.length())
				    {
					DonVi=DonVi+sql.charAt(pointer);
					pointer=pointer+1;
				    }
				System.out.println(DonVi);

				if(new CheckExists(stmt).checkExists("GiaoVien","MaGV='"+MaGV+"'")==1){
				    sql="delete from GiaoVien where MaGV='"+MaGV+"'";
				

				    try{
					stmt.executeUpdate(sql);
				    }catch(SQLException se){
					se.printStackTrace();
				    }
				}

				sql="insert into GiaoVien "
				    +"values('"+MaGV+"','"+HoGV+"','"+TenGV+"','"+DonVi+"')";

				try{
				    stmt.executeUpdate(sql);
				}catch(SQLException se){
				    se.printStackTrace();
				}
			    }
			    
			    System.out.println("Restore successfully");
			    scan.nextLine();
			}catch (Exception e){
			    e.printStackTrace();
			} scan.nextLine();

			break;
			
		    case 3:
			File fileCase3= new File(duongDan+"SinhVien.csv");
			try (FileReader FR = new FileReader(fileCase3)){
				
			    BufferedReader BR = new BufferedReader(FR);
			   

			    while ((sql = BR.readLine()) != null){
				int pointer=0;
				
				String MaSV=new String();
				String HoSV=new String();
				String TenSV=new String();
				String NgaySinh=new String();
				String NoiSinh=new String();

				while(sql.charAt(pointer)!=',')
				    {
					MaSV=MaSV+sql.charAt(pointer);
					pointer=pointer+1;
				    }
				System.out.println(MaSV);
				 
				pointer=pointer+1;
				 
				while(sql.charAt(pointer)!=',')
				    {
					HoSV=HoSV+sql.charAt(pointer);
					pointer=pointer+1;
				    }
				System.out.println(HoSV);

				pointer=pointer+1;
				
				while(sql.charAt(pointer)!=',')
				    {
					TenSV=TenSV+sql.charAt(pointer);
					pointer=pointer+1;
				    }
				System.out.println(TenSV);

				pointer=pointer+1;

				while(sql.charAt(pointer)!=',')
				    {
					NgaySinh=NgaySinh+sql.charAt(pointer);
					pointer=pointer+1;
				    }
				System.out.println(NgaySinh);
				String NgaySinhtmp=NgaySinh;
				NgaySinh=new String();
				NgaySinh=NgaySinhtmp.charAt(6)+NgaySinhtmp.charAt(7)+NgaySinhtmp.charAt(8)+NgaySinhtmp.charAt(9)+"-"+NgaySinhtmp.charAt(3)+NgaySinhtmp.charAt(4)+"-"+NgaySinhtmp.charAt(0)+NgaySinhtmp.charAt(1);

				pointer=pointer+1;
				 
				while(pointer<sql.length())
				    {
					NoiSinh=NoiSinh+sql.charAt(pointer);
					pointer=pointer+1;
				    }
				System.out.println(NoiSinh);
				if(new CheckExists(stmt).checkExists("SinhVien","MaSV='"+MaSV+"'")==1){
				    sql="delete from SinhVien where MaSV='"+MaSV+"'";
				

				    try{
					stmt.executeUpdate(sql);
				    }catch(SQLException se){
					se.printStackTrace();
				    }
				}

				sql="insert into SinhVien "
				+"values('"+MaSV+"','"+HoSV+"','"+TenSV+"','"+NgaySinh+"','"+NoiSinh+"')";

				try{
				    stmt.executeUpdate(sql);
				}catch(SQLException se){
				    se.printStackTrace();
				}
			    }
			    
			    System.out.println("Restore successfully");
			    scan.nextLine();
			}catch (Exception e){
			    e.printStackTrace();
			} scan.nextLine();
			break;
			
		    case 4:
				File fileCase4= new File(duongDan+"Lop.csv");
			try (FileReader FR = new FileReader(fileCase4)){
				
			    BufferedReader BR = new BufferedReader(FR);
			   

			    while ((sql = BR.readLine()) != null){
				int pointer=0;
				
				String MaLop=new String();
				String MaMH=new String();
				String NamHoc=new String();
				int HocKy;
				String MaGV=new String();

				while(sql.charAt(pointer)!=',')
				    {
					MaLop=MaLop+sql.charAt(pointer);
					pointer=pointer+1;
				    }
				System.out.println(MaLop);
				 
				pointer=pointer+1;
				 
				while(sql.charAt(pointer)!=',')
				    {
					MaMH=MaMH+sql.charAt(pointer);
					pointer=pointer+1;
				    }
				System.out.println(MaMH);

				pointer=pointer+1;
				
				while(sql.charAt(pointer)!=',')
				    {
					NamHoc=NamHoc+sql.charAt(pointer);
					pointer=pointer+1;
				    }
				System.out.println(NamHoc);

				pointer=pointer+1;

				

		        	String HocKyTMP=new String();
				while(sql.charAt(pointer)!=',')
				    {
					HocKyTMP=HocKyTMP+sql.charAt(pointer);
					pointer=pointer+1;
				    }
				System.out.println(HocKyTMP);
				HocKy = Integer.parseInt(HocKyTMP.trim());

pointer=pointer+1;

				 
				while(pointer<sql.length())
				    {
					MaGV=MaGV+sql.charAt(pointer);
					pointer=pointer+1;
				    }
				System.out.println(MaGV);


				if(new CheckExists(stmt).checkExists("Lop","MaLop='"+MaLop+"'")==1){
				    sql="delete from Lop where MaLop='"+MaLop+"'";
				

				    try{
					stmt.executeUpdate(sql);
				    }catch(SQLException se){
					se.printStackTrace();
				    }
				}

				sql="insert into Lop "
					+"values('"+MaLop+"','"+MaMH+"','"+NamHoc+"',"+HocKy+",'"+MaGV+"')";

				try{
				    stmt.executeUpdate(sql);
				}catch(SQLException se){
				    se.printStackTrace();
				}
			    }
			    
			    System.out.println("Restore successfully");
			    scan.nextLine();
			}catch (Exception e){
			    e.printStackTrace();
			} scan.nextLine();
			break;
			
		    case 5:
			File fileCase5= new File(duongDan+"SinhVienLop.csv");
			try (FileReader FR = new FileReader(fileCase5)){
				
			    BufferedReader BR = new BufferedReader(FR);
			   

			    while ((sql = BR.readLine()) != null){
				int pointer=0;
				
				String MaSV=new String();
				String MaLop=new String();
				double Diem;

				while(sql.charAt(pointer)!=',')
				    {
					MaSV=MaSV+sql.charAt(pointer);
					pointer=pointer+1;
				    }
				System.out.println(MaSV);
				 
				pointer=pointer+1;
				 
				while(sql.charAt(pointer)!=',')
				    {
					MaLop=MaLop+sql.charAt(pointer);
					pointer=pointer+1;
				    }
				System.out.println(MaLop);
pointer=pointer+1;


		        	String DiemTMP=new String();
				while(pointer<sql.length())
				    {
					DiemTMP=DiemTMP+sql.charAt(pointer);
					pointer=pointer+1;
				    }
				System.out.println(DiemTMP);
				Diem = Double.parseDouble(DiemTMP.trim());




			if(new CheckExists(stmt).checkExists("SinhVienLop","MaLop='"+MaLop+"' and MaSV='"+MaSV+"'")==1){
				    sql="delete from Lop where MaLop='"+MaLop+"' and MaSV='"+MaSV+"'";
				

				    try{
					stmt.executeUpdate(sql);
				    }catch(SQLException se){
					se.printStackTrace();
				    }
				}
					sql="insert into SinhVienLop "
					    +"values('"+MaSV+"','"+MaLop+"',"+Diem+")";

				try{
				    stmt.executeUpdate(sql);
				}catch(SQLException se){
				    se.printStackTrace();
				}
			    }
			    
			    System.out.println("Restore successfully");
			    scan.nextLine();
			}catch (Exception e){
			    e.printStackTrace();
			} scan.nextLine();
			break;





		    case 6:
                        File fileCase16= new File(duongDan+"MonHoc.csv");
			try (FileReader FR = new FileReader(fileCase16)){
				
			    BufferedReader BR = new BufferedReader(FR);
			   

			    while ((sql = BR.readLine()) != null){
				int pointer=0;
				
                                String MaMH=new String();
			        String TenMH=new String();
			        int SoTC=0;

				while(sql.charAt(pointer)!=',')
				    {
					MaMH=MaMH+sql.charAt(pointer);
					pointer=pointer+1;
				    }
				System.out.println(MaMH);
				 
				pointer=pointer+1;
				 
				while(sql.charAt(pointer)!=',')
				    {
					TenMH=TenMH+sql.charAt(pointer);
					pointer=pointer+1;
				    }
				System.out.println(TenMH);

				pointer=pointer+1;
				 
				String SoTCTMP=new String();
				while(pointer<sql.length())
				    {
					SoTCTMP=SoTCTMP+sql.charAt(pointer);
					pointer=pointer+1;
				    }
				System.out.println(SoTCTMP);
				SoTC = Integer.parseInt(SoTCTMP.trim());

				if(new CheckExists(stmt).checkExists("MonHoc","MaMH='"+MaMH+"'")==1){
				    sql="delete from MonHoc where MaMH='"+MaMH+"'";

				    try{
					stmt.executeUpdate(sql);
				    }catch(SQLException se){
					se.printStackTrace();
				    }
				}

				sql="insert into MonHoc "
				    +"values('"+MaMH+"','"+TenMH+"',"+SoTC+")";

				try{
				    stmt.executeUpdate(sql);
				}catch(SQLException se){
				    se.printStackTrace();
				}
			    }
			    
			    System.out.println("Restore successfully");
			    scan.nextLine();
			}catch (Exception e){
			   //
			} scan.nextLine();


			break;
		    }
		
		break;
		    
		    
	    case 3:
	
		break;


	    case 4:
		System.out.println("Quit\n**************************************\n");
		break;
	    }
	}while(choice!=4);
    }
}
