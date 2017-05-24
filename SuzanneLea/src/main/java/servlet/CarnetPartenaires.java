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
		System.out.println("la redirection vers carnet est OK");
		
//		HttpSession session = request.getSession();
//		Integer ID = (Integer) session.getAttribute("ID_Aidee");
//		List<CompteRendu> listeCR = new ArrayList<CompteRendu>(CompteRenduDAO.getInstance().comptesRendusAidee(1));
//		request.setAttribute("comptesRendus", listeCR);
//		System.out.println(listeCR);
		
		HttpSession session = request.getSession();
		Integer IDAidee = (Integer) session.getAttribute("IDAidee");
		List listeMed = new ArrayList(AidantService.getInstance().allAidantsByType(2));
//		List<Personne> listeInf = new ArrayList<Personne>(AidantService.getInstance().allAidantsByType(3));
//		List<Personne> listeTax = new ArrayList<Personne>(AidantService.getInstance().allAidantsByType(4));
//		List<Personne> listePlo = new ArrayList<Personne>(AidantService.getInstance().allAidantsByType(5));
//		List<Personne> listeEle = new ArrayList<Personne>(AidantService.getInstance().allAidantsByType(6));
//		List<Personne> listeSer = new ArrayList<Personne>(AidantService.getInstance().allAidantsByType(7));

		request.setAttribute("partenaires", listeMed);
//		request.setAttribute("partenaires", listeInf);
//		request.setAttribute("partenaires", listeTax);
//		request.setAttribute("partenaires", listePlo);
//		request.setAttribute("partenaires", listeEle);
//		request.setAttribute("partenaires", listeSer);

		this.getServletContext().getRequestDispatcher("/WEB-INF/carnetPart.jsp").forward (request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
