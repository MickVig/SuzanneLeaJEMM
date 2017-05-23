package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Personne;
import service.AideeService;


//@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Dashboard() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("la redirection vers dashboard est OK");
		
		HttpSession session = request.getSession();
		Integer IDAidee = (Integer) session.getAttribute("IDAidee");
		Personne p = AideeService.getInstance().procheReferent(IDAidee);
		Personne p2 = AideeService.getInstance().medecinReferent(IDAidee);
		request.setAttribute("procheReferent", p);
		request.setAttribute("medecinReferent", p2);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/dashboard.jsp").forward (request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
