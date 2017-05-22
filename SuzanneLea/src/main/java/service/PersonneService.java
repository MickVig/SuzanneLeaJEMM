package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Personne;
import dao.AidantDAO;
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
	
	
	
	
	@SuppressWarnings("unused")
	public boolean inscription(HttpServletRequest request, HttpServletResponse response) {
		
		//Personne aidee
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String tel = request.getParameter("tel");
		String mail = request.getParameter("mail");
		String mdp = request.getParameter("mdp");
		
		
		//Personne aidant
		String nomref = request.getParameter("nomref");
		String prenomref = request.getParameter("prenomref");
		String adresseref = request.getParameter("adresseref");
		String telref = request.getParameter("telref");
		String mailref = request.getParameter("mailref");
		String mdpref = request.getParameter("mdpref");
		
		
		/*
		 * On créé les 2 personnes à partir des 2 méthodes create des classes DAO
		 */
		
		//Personne pAidant = PersonneDAO.getInstance().createPersonne(nomref, prenomref, mailref, adresseref, telref, mdpref);
		//Personne pAidee = PersonneDAO.getInstance().createPersonne(nom, prenom, mail, adresse, tel, mdp);
		
		
		//Attention : Dans Aidant DAO enlever la personne dans la méthode 
		
		//AidantDAO.getInstance().createAidant(pAidant.getID(), ID_Type(6)); 
		//AideeDAO.getInstance().createAidee(pAidee.getID(), p
		
		
		
		
		
		
		return false;
		
		
	}
	
	
}
