package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import bean.CompteRendu;

public class CompteRenduDAO extends ConnexionDAO implements ICompteRenduDAO {

	/////// SINGLETON \\\\\\\
	private static ICompteRenduDAO instance = null;

	private CompteRenduDAO() {
	}

	public static synchronized ICompteRenduDAO getInstance() {
		if (instance == null) {
			instance = new CompteRenduDAO();
		}
		return instance;
	}

	public List<CompteRendu> getListCompteRendu() {
		this.connexion();
		CompteRendu cr = new CompteRendu();
		em.persist(cr);
		return (List<CompteRendu>) cr;
	}

	/////// Autres Requetes \\\\\\\
	@Override
	public List<CompteRendu> comptesRendusAidee(Integer id) {
		this.connexion();
		List ComptesRendus = new ArrayList();
		try {
			List<CompteRendu> listeCR = new ArrayList<CompteRendu>();
			Query requete = this.getEm().createQuery("SELECT cr FROM CompteRendu cr WHERE ID_Aidee =" + id);
			listeCR = requete.getResultList();
			System.out.println(listeCR);
			// Cr�ation liste CR tout r�cup�rer dans les CR (date, commentaire,
			// ID_aidee, ID_aidant)
			for (int i = 0; i < listeCR.size(); i++) {
				List CompteRenduListe = new ArrayList();
				CompteRendu cr = listeCR.get(i);
				CompteRenduListe.add(cr.getDate());
				CompteRenduListe.add(cr.getCommentaire());
				if(cr.getAidant()!=null) {
					CompteRenduListe.add(cr.getAidant().getPersonne());
				}
				CompteRenduListe.add(cr.getAidee().getPersonne());
				ComptesRendus.add(CompteRenduListe);
			}
			System.out.println(ComptesRendus);
		} catch (Exception e) {
			throw new ExceptionDAO("Anomalie lors de l'execution de la requete");
		}
		this.deconnexion();
		return ComptesRendus;
	}

	@Override
	public List<CompteRendu> comptesRendusAidant(Integer id) {
		this.connexion();
		List ComptesRendus = new ArrayList();
		List<CompteRendu> listeCR = new ArrayList<CompteRendu>();
		try {
			Query requete = this.getEm().createQuery("SELECT cr FROM CompteRendu cr WHERE ID_Aidant =" + id);
			listeCR = requete.getResultList();
			System.out.println(listeCR);
			// Cr�ation liste CR tout r�cup�rer dans les CR (date, commentaire,
			// ID_aidee, ID_aidant)

			for (int i = 0; i < listeCR.size(); i++) {
				List CompteRenduListe = new ArrayList();
				CompteRendu cr = listeCR.get(i);
				CompteRenduListe.add(cr.getDate());
				CompteRenduListe.add(cr.getCommentaire());
				if(cr.getAidant()!=null) {
					CompteRenduListe.add(cr.getAidant().getPersonne());
				}
				CompteRenduListe.add(cr.getAidee().getPersonne());
				ComptesRendus.add(CompteRenduListe);
			}
		} catch (Exception e) {
			throw new ExceptionDAO("Anomalie lors de l'execution de la requete");
		}
		this.deconnexion();
		return ComptesRendus;
	}
	
	@Override
	public List lastCompteRendu(Integer Id_Aidee) {
		this.connexion();
		//List ComptesRendus = new ArrayList();
		List<CompteRendu> listeCR = new ArrayList<CompteRendu>();
		List CompteRenduListe = new ArrayList();
		try {
			Query requete = this.getEm().createQuery("SELECT cr FROM CompteRendu cr WHERE ID_Aidee ="+Id_Aidee+"AND cr.date<CURRENT_DATE ORDER BY cr.date desc");
			listeCR = requete.getResultList();
			
			for (int i = 0; i < 1; i++) {
				
				CompteRendu cr = listeCR.get(i);
				CompteRenduListe.add(cr.getDate());
				System.out.println(cr.getDate());
				CompteRenduListe.add(cr.getCommentaire());
				if(cr.getAidant()!=null) {
					CompteRenduListe.add(cr.getAidant().getPersonne());
				}
				
				CompteRenduListe.add(cr.getAidee().getPersonne());	
				System.out.println(CompteRenduListe);
			}
		} catch (Exception e) {
			throw new ExceptionDAO("Anomalie lors de l'execution de la requete");
		}
		this.deconnexion();
		System.out.println("CR : "+ CompteRenduListe);
		return CompteRenduListe;
	}

	/////// CRUD \\\\\\\
	/*
	 * La modification et la suppression d'un compte rendu est interdite dans
	 * notre cas
	 */

	@Override
	public CompteRendu readCompteRendu(Integer id) {
		this.connexion();
		CompteRendu cr = new CompteRendu();
		try {
			cr = this.getEm().find(CompteRendu.class, id);
		} catch (Exception e) {
			throw new ExceptionDAO("Anomalie lors de l'execution de la requete");
		}
		this.deconnexion();
		return cr;
	}

	@Override
	public void createCompteRendu(Date date, String commentaire, Integer ID_Aidant, Integer ID_Aidee) {
		this.connexion();
		CompteRendu cr = new CompteRendu();

		// SimpleDateFormat formater = null;
		// Date aujourdhui = new Date();
		// formater = new SimpleDateFormat("dd-MM-yyyy");
		// System.out.println(formater.format(aujourdhui));
		try {
			cr.setDate(date);
			cr.setCommentaire(commentaire);
			cr.setAidant(AidantDAO.getInstance().readAidant(ID_Aidant));
			cr.setAidee(AideeDAO.getInstance().readAidee(ID_Aidee));
			this.getEm().persist(cr);

			this.commit();
		} catch (Exception e) {
			throw new ExceptionDAO("Anomalie lors de l'execution de la requete");
		}
		this.deconnexion();
	}

}
