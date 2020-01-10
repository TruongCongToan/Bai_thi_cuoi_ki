]package muc;

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

		switch(choiceCase2)
		    {
		    case 1:
			File fileCase1= new File("BackUp_sqlFile/DB/MonHoc.csv");
			try (FileReader FR = new FileReader(fileCase1)){
				
			    BufferedReader BR = new BufferedReader(FR);
			    String MaMH=new String();
			    String TenMH=new String();
			    int SoTC=0;

			    while ((sql = BR.readLine()) != null){
				int pointer=0;

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
			break;
		    case 3:
			break;
		    case 4:
			break;
		    case 5:
			break;
		    case 6:
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
