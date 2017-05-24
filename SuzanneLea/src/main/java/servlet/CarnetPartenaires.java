package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CompteRendu;
import bean.Personne;
import dao.CompteRenduDAO;
import service.AidantService;
import service.AideeService;



//@WebServlet("/CarnetPartenaires")
public class CarnetPartenaires extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CarnetPartenaires() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("la redirection vers carnetPart est OK");
		
		HttpSession session = request.getSession();
		Integer IDAidee = (Integer) session.getAttribute("IDAidee");
		List listeMed = new ArrayList(AidantService.getInstance().allAidantsByType(2));
		/*List listeMed = new ArrayList(AidantService.getInstance().allAidantsByType(3));
		List listeMed = new ArrayList(AidantService.getInstance().allAidantsByType(4));
		List listeMed = new ArrayList(AidantService.getInstance().allAidantsByType(5));
		List listeMed = new ArrayList(AidantService.getInstance().allAidantsByType(6));*/
		request.setAttribute("partenaires", listeMed);

		this.getServletContext().getRequestDispatcher("/WEB-INF/carnetPart.jsp").forward (request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
