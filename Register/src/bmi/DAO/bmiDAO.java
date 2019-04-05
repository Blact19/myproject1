package bmi.DAO;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;
import bmiBean.bmi;
import register.DAO.RegisterDAO;
import register.bean.RegisterBean;
import bmi.DAO.bmiconnection;
import Login.Bean.*;
import javax.servlet.http.HttpSession;;
public class bmiDAO {

		
		public String registerUser(bmi bmiBean)
		 {
			int Height=bmiBean.getHeight();
			double Weight=bmiBean.getWeight();
		 double height=Height*0.01;
			double BMIRate=Weight/(Math.pow(height,2));
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 
		 Login l=new Login();
		// int PatientId=l.getPatientId();
		 
		 try
		 {
		 con = bmiconnection.createConnection();
		 String query = "insert into bmi values(?,?,?,?,?)"; //Insert user details into the table 'USERS'
		 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
		 preparedStatement.setInt(1, bmiBean.getPatient_Id());
		 preparedStatement.setString(2, bmiBean.getFirstName());
		 preparedStatement.setInt(3,Height);
		 preparedStatement.setDouble(4, Weight);
		 preparedStatement.setDouble(5, BMIRate);
		// ResultSet rs=preparedStatement.executeQuery();
        /* if(rs.next()){
                   System.out.println("UserId  available");
            
             }
         else{
            
             System.out.println("UserName is not available");
           
         }
         rs.close();*/
       
      
		 
		 int i= preparedStatement.executeUpdate();
		 
		 if (i!=0) 
		 return "SUCCESS";
		 }
		 catch(SQLException e)
		 {
			 
			 e.printStackTrace();
		
		 }
		 
		  return "Oops.. Something went wrong there..!"; // On failure, send a message from here.
		 }
	}
