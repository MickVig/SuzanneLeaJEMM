package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet("/Deconnexion")
public class Deconnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Deconnexion() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		System.out.println("Deconnexion OK");
		
		this.getServletContext().getRequestDispatcher("/index.jsp").forward (request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
