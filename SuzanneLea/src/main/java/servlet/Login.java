package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// Si la fonction connexion() renvois true
		if(PersonneService.getInstance().connexion(request, response)){
			// Alors on redirige vers la servlet Dashboard via l'url /dashboard
			response.sendRedirect("dashboard");
		}else{
			// Sinon on reste sur la page login avec affichage d'un message d'erreur 
			this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward (request, response);
		}
		
	}

}
