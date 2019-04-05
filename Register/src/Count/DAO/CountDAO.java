package Count.DAO;
import java.sql.*;
import Count.Bean.*;
import Count.DAO.*;
public class CountDAO {
		public String registerUser(Count countBean)
		 {
		
		 int RBC = countBean.getRBC();
		 int WBC = countBean.getWBC();
		 int Platelet = countBean.getPlatelet();
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 
		 try
		 {
		 con = CountConnection.createConnection();
		 String query = "insert into bcount values(CURRENT_TIMESTAMP,?,?,?,?)";
		 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
		 preparedStatement.setInt(1, RBC);
		 preparedStatement.setInt(2, WBC);
		 preparedStatement.setInt(3, Platelet);
		 preparedStatement.setString(4,"m");
		
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
