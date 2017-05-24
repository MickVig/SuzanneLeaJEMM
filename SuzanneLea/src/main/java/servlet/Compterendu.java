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
import dao.CompteRenduDAO;
import service.AideeService;


//@WebServlet("/Compterendu")
public class Compterendu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Compterendu() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Integer IDAidee = (Integer) session.getAttribute("IDAidee");
		
		List listeCR = AideeService.getInstance().allCR(IDAidee);
		request.setAttribute("allCR", listeCR);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/compterendu.jsp").forward (request, response);
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
