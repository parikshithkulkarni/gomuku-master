package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.five.beans.Login;

public class LoginController extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException
	{
				HttpSession session = request.getSession();
				
		        String username=request.getParameter("nm");
			    String password=request.getParameter("pass");
		    	
				Login log = new Login();
			    log.setUsername(username);
			    log.setPassword(password);
			    session.setAttribute("user", log.getUsername());
			      int checkStatus  = 1;
	             RequestDispatcher rd;
					   	if(checkStatus==1)
						{
							 rd=request.getRequestDispatcher("jsp/game.jsp");
												   	
							try {
								rd.forward(request, response);
							}  catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					   	
					   	
					   	else if(checkStatus==0)
					   	{
					   		 rd=request.getRequestDispatcher("jsp/game.jsp");
											   	
							try {
								response.sendRedirect("jsp/game.jsp");
							}  catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					   	}
					   		
					   	}


}
