package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PersonneService;


//@WebServlet("/CreateAidee")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public Inscription() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward (request, response);
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonneService.getInstance().inscription(request, response);
			//Pour rediriger vers la servlet Dashboard via l'url dashboard
			response.sendRedirect("dashboard");
		
			
		
	}

}
