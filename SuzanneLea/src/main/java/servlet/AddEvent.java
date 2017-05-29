package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ExceptionDAO;
import service.AidantService;
import service.AideeService;


//@WebServlet("/AddEvent")
public class AddEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddEvent() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer IDAidee = (Integer) session.getAttribute("IDAidee");
		List<?> liste = new ArrayList(AidantService.getInstance().allProchesByAidee(IDAidee));
		request.setAttribute("proches", liste);
		this.getServletContext().getRequestDispatcher("/WEB-INF/addEvent.jsp").forward (request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			AideeService.getInstance().addEvent(request,response);
		} catch (ParseException e) {
			throw new ExceptionDAO("Arreur dans le parse");
		}
		response.sendRedirect("agenda");
	}

}
