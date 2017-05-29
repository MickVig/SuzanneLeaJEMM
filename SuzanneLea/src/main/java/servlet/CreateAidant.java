package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AideeService;
import service.PersonneService;


//@WebServlet("/CreateAidant")
public class CreateAidant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CreateAidant() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/createAidant.jsp").forward (request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (AideeService.getInstance().inscriptionAidant(request, response)) {
			response.sendRedirect("carnet");
		}
		else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/createAidant.jsp").forward (request, response);
		}

	}

}
