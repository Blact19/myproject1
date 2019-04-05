package Login.DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Login.Bean.Login;
import Login.DAO.LoginConnection;
import register.DAO.*;
import register.bean.RegisterBean;

public class LoginDAO {
	
	public String authenticateUser(Login loginBean)
    {
                    String UserId = loginBean.getUserId(); //Keeping user entered values in temporary variables.
                    String Password = loginBean.getPassword();
                    Connection con = null;
                    Statement statement = null;
                    ResultSet resultSet = null;
                    String userNameDB = "";
                    String passwordDB = "";
                    try
                    {
                                    con = LoginConnection.createConnection(); 
                                    statement = con.createStatement(); 
                                    resultSet = statement.executeQuery("select userId,Password from patient_reg"); 
                                    while(resultSet.next()) 
                                    {
                                                    userNameDB = resultSet.getString("userId"); 
                                                    passwordDB = resultSet.getString("Password");
                                                    if(UserId.equals(userNameDB) && Password.equals(passwordDB))
                                                    {
                                                                    return "SUCCESS"; 
                                                    }
                                                    else
                                                    {
                                                    	return "Incorrect";
                                                    }
                                    }
                    }
                                    catch(SQLException e)
                                    {
                                                    e.printStackTrace();
                                    }
                                    return "Invalid user credentials"; 
                    
    }
	
	
	
}

	                

