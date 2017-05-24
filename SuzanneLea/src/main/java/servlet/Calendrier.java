package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Agenda;
import service.AideeService;


//@WebServlet("/Agenda")
public class Calendrier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Calendrier() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("la redirection vers agenda est OK");
		
		HttpSession session = request.getSession();
		Integer IDAidee = (Integer) session.getAttribute("IDAidee");
		System.out.println(IDAidee);
		
		List liste = AideeService.getInstance().allRDV(IDAidee);
		
		request.setAttribute("allRDV", liste);
	
		this.getServletContext().getRequestDispatcher("/WEB-INF/agenda.jsp").forward (request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
