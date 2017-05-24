package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AidantService;
import service.PersonneService;


//@WebServlet("/CreateAidee")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public Inscription() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<?> liste = new ArrayList(AidantService.getInstance().allMedecins());
		request.setAttribute("medecins", liste);
		this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward (request, response);
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(PersonneService.getInstance().inscription(request, response)){
			//Pour rediriger vers la servlet Dashboard via l'url dashboard
			response.sendRedirect("login");
		}
		else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward (request, response);
		}
			
		
			
		
	}

}
