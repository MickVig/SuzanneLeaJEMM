package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.IPersonneDAO;
import dao.PersonneDAO;

public class PersonneService implements IPersonneService {
	/////// SINGLETON \\\\\\\
	private static IPersonneService instance=null;
	private PersonneService(){
	}
	public static synchronized IPersonneService getInstance() {
		if (instance==null){
			instance=new PersonneService();
		}
		return instance;
	}
	
	
	@Override
	public boolean connexion(HttpServletRequest request, HttpServletResponse response) {
		
		String mail = request.getParameter("mail");
		String mdp = request.getParameter("mdp");
		
		System.out.println(mail);
		System.out.println(mdp);
		
		/*
		 * envoi vers PersonneDAO pour récupérer la personne 
		 * si personne existe : la mettre en session et renvoyer true
		 * sinon retourner false
		 */
		
		if((mail.equals("mick@neuf.fr"))&&(mdp.equals("1234"))){
			HttpSession session = request.getSession();
			session.setAttribute("mail", mail);
			session.setAttribute("mdp", mdp);
			
			System.out.println(session.getAttribute("mail"));
			System.out.println(session.getAttribute("mdp"));
			
			return true;
			
		}else{
			return false;
		}

	}
	
	
}
