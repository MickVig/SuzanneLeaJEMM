package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Personne;
import dao.AideeDAO;
import service.AideeService;



//@WebServlet("/Carnet")
public class Carnet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Carnet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("la redirection vers carnet est OK");
		
		HttpSession session = request.getSession();
		Integer IDAidee = (Integer) session.getAttribute("IDAidee");
		List <String> liste = new ArrayList<String>(AideeService.getInstance().allAidantsProches(IDAidee));
		request.setAttribute("aidantsProches", liste);
		this.getServletContext().getRequestDispatcher("/WEB-INF/carnet.jsp").forward (request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
