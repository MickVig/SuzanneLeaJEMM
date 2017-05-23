package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import bean.CompteRendu;

public class CompteRenduDAO extends ConnexionDAO implements ICompteRenduDAO {
	
	/////// SINGLETON \\\\\\\
	private static ICompteRenduDAO instance=null;
	private CompteRenduDAO(){
	}
	public static synchronized ICompteRenduDAO getInstance() {
		if (instance==null){
			instance=new CompteRenduDAO();
		}
		return instance;
	}
	
	
	public List<CompteRendu> getListCompteRendu(){
		this.connexion();
		CompteRendu cr = new CompteRendu();
		em.persist(cr);
		return (List<CompteRendu>) cr;	
	}	

	
	/////// Autres Requetes \\\\\\\
	@Override
	public List<CompteRendu> comptesRendusAidee(Integer id) {
		this.connexion();
		List<CompteRendu> listeCR = new ArrayList<CompteRendu>();
		CompteRendu cr = new CompteRendu();
		Query requete = this.getEm().createQuery("SELECT cr FROM CompteRendu cr WHERE cr.ID_Aidee =" +id);
		listeCR = requete.getResultList();
		
		this.commit();
		this.deconnexion();
		return listeCR;
	}

	
	@Override
	public List<CompteRendu> comptesRendusAidant(Integer id) {
		this.connexion();
		List<CompteRendu> listeCR = new ArrayList<CompteRendu>();
		CompteRendu cr = new CompteRendu();
		Query requete = this.getEm().createQuery("SELECT cr FROM CompteRendu cr WHERE cr.ID_Aidant =" +id);
		listeCR = requete.getResultList();
		System.out.println(listeCR);
		this.commit();
		this.deconnexion();
		return listeCR;
	}
	
	
	
	/////// CRUD \\\\\\\
	/* La modification et la suppression d'un compte rendu est interdite dans notre cas*/
	
	@Override
	public CompteRendu readCompteRendu(Integer id) {
		this.connexion();
		CompteRendu cr = this.getEm().find(CompteRendu.class, id);
		
		this.deconnexion();
		return cr;
	}

	
	
	@Override
	public void createCompteRendu(Date date, String commentaire, Integer ID_Aidant, Integer ID_Aidee) {
		this.connexion();
		CompteRendu cr = new CompteRendu();
		
//		SimpleDateFormat formater = null;
//		Date aujourdhui = new Date();
//		formater = new SimpleDateFormat("dd-MM-yyyy");
//		System.out.println(formater.format(aujourdhui));
		
		cr.setDate(date);
		cr.setCommentaire(commentaire);
		cr.setAidant(AidantDAO.getInstance().readAidant(ID_Aidant));
		cr.setAidee(AideeDAO.getInstance().readAidee(ID_Aidee));
		this.getEm().persist(cr);
		
		this.commit();
		this.deconnexion();
	}

}

