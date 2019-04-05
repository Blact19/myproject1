package register.DAO;

	import java.sql.*;
	import java.util.*;
	import register.bean.RegisterBean;
	import register.DAO.DBConnection;
	public class RegisterDAO {

		
		public String registerUser(RegisterBean registerBean)
		 {
		 String FirstName = registerBean.getFirstName();
		 String LastName = registerBean.getLastName();
		 int Age = registerBean.getAge();
		 String Gender = registerBean.getGender();
		 long ContactNumber = registerBean.getContactNumber();
		 String city = registerBean.getCity();
		 String state = registerBean.getState();
		 String EmailAddress = registerBean.getEmailAddress();
		 String UserId = registerBean.getUserId();
		 String Password = registerBean.getPassword();
		 
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 
		 try
		 {
		 con = DBConnection.createConnection();
		 String query = "insert into patient_reg(FirstName,LastName,Age,Gender,ContactNumber,EmailAddress,city,state,userId,Password) values (?,?,?,?,?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
		 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
		 preparedStatement.setString(1, FirstName);
		 preparedStatement.setString(2, LastName);
		 preparedStatement.setInt(3, Age);
		 preparedStatement.setString(4, Gender);
		 preparedStatement.setLong(5, ContactNumber);
		 preparedStatement.setString(6, EmailAddress);
		 preparedStatement.setString(7, city);
		 preparedStatement.setString(8, state);
		 preparedStatement.setString(9, UserId);
		 preparedStatement.setString(10, Password);
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
		
		public List<RegisterBean> getUser()
		{List<RegisterBean> l=new ArrayList<RegisterBean>();
			try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/patient?autoReconnect=true&useSSL=false","root","root");
			PreparedStatement ps=con.prepareStatement("select * from patient_reg");
					ResultSet rs=ps.executeQuery();
					
					while(rs.next())
					{RegisterBean r=new RegisterBean();
						r.setPatient_id(rs.getInt("Patient_Id"));
						r.setUserId(rs.getString("userId"));
						r.setPassword(rs.getString("Password"));
						r.setFirstName(rs.getString("FirstName"));
						l.add(r);
					}
		}
		catch(Exception e)
		{System.out.print(e);}
		return l;
			
		}
	}



