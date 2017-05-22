package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Personne;
import service.AidantService;
import service.PersonneService;


//@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public Login() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward (request, response);
		
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(PersonneService.getInstance().connexion(request, response)){
			//Pour rediriger vers la servlet Dashboard via l'url dashboard
			response.sendRedirect("dashboard");
		}else{
			this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward (request, response);
		}
		
		
	}

}
