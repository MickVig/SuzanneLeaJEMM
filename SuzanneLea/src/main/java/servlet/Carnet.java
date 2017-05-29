package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Personne;
import service.AideeService;



//@WebServlet("/Carnet")
public class Carnet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Carnet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer IDAidee = (Integer) session.getAttribute("IDAidee");
		List<Personne> liste = new ArrayList<Personne>(AideeService.getInstance().allAidantsProches(IDAidee));
		request.setAttribute("aidantsProches", liste);
		this.getServletContext().getRequestDispatcher("/WEB-INF/carnet.jsp").forward (request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
