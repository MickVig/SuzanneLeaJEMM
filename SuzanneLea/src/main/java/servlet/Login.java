package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Personne;
import service.AidantService;


//@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public Login() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AidantService.getInstance().getListPersonne();
		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward (request, response);
		
		
		
	
		//Pour rediriger vers la servlet Dashboard via l'url dashboard
		//response.sendRedirect("dashboard");
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String redirection = "";
		String mail = request.getParameter("mail");
		String mdp = request.getParameter("mdp");
		
		HttpSession session = request.getSession();
		
		
		
		
		
		doGet(request, response);
	}

}
