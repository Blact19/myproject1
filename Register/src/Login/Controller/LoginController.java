package Login.Controller;


	import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
	import javax.servlet.http.*;

	import Login.Bean.Login;
import Login.DAO.LoginConnection;
import Login.DAO.LoginDAO;
import register.DAO.RegisterDAO;
import register.bean.RegisterBean;
	public class LoginController extends HttpServlet {

	                              protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	                                String UserId = request.getParameter("UserId");
	                                String Password = request.getParameter("Password");

	                                Login login = new Login(); 

	                                login.setUserId(UserId); 
	                                login.setPassword(Password);

	                              
	                                LoginDAO loginDao = new LoginDAO(); 
	                                HttpSession session=request.getSession(true);
	                                String userValidate = loginDao.authenticateUser(login); 
	                                if(userValidate.equals("SUCCESS")) 
	                                {                //session.setAttribute("key1", UserId);
	                       		                     //session.setAttribute("key2", Password);
	                       		                     //session.setMaxInactiveInterval(600);
	                                                request.setAttribute("UserId", UserId); 
	                                                request.getRequestDispatcher("New.html").include(request, response);
	                                //response.sendRedirect("New.html");
	                                }
	                                else
	                                {
	                                                request.setAttribute("errMessage", userValidate); 
	                                                request.getRequestDispatcher("home.jsp").forward(request, response);
	                                }
	                                
	                }


}
	
