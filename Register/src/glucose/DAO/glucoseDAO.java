package glucose.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import glucose.Bean.*;
import glucose.DAO.*;;

public class glucoseDAO {

		
		public String registerUser(glucoseBean glucosebean)
		 {
			double bGlucose=glucosebean.getbGlucose();
		 Connection con = null;
		 Statement statement = null;
		 ResultSet resultSet = null;
		 String FirstName="";
		 PreparedStatement preparedStatement = null;
		 
		 try
		 {
		 con = glucoseConnection.createConnection();
		 statement = con.createStatement(); 
         resultSet = statement.executeQuery("select FirstName from patient_reg"); 
         while(resultSet.next()) 
         {
                         FirstName = resultSet.getString("FirstName"); 
         }
		 String query = "insert into glucosereading values(?,?,CURRENT_TIMESTAMP,?,?)"; //Insert user details into the table 'USERS'
		 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
		 preparedStatement.setString(1, "sfdgasd");
		 preparedStatement.setString(2, FirstName);
		 preparedStatement.setDouble(3, bGlucose);
		 preparedStatement.setString(4, null);
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