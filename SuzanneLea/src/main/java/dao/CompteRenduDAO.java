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
			// Création liste CR tout récupérer dans les CR (date, commentaire,
			// ID_aidee, ID_aidant)
			System.out.println(listeCR.size());
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
			this.commit();
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
			// Création liste CR tout récupérer dans les CR (date, commentaire,
			// ID_aidee, ID_aidant)

			for (int i = 0; i < listeCR.size(); i++) {
				List CompteRendu = new ArrayList();
				CompteRendu cr = listeCR.get(i);
				CompteRendu.add(cr.getDate());
				CompteRendu.add(cr.getCommentaire());
				CompteRendu.add(cr.getAidant());
				CompteRendu.add(cr.getAidee());

				ComptesRendus.add(CompteRendu);
			}
			this.commit();
		} catch (Exception e) {
			throw new ExceptionDAO("Anomalie lors de l'execution de la requete");
		}
		this.deconnexion();
		return ComptesRendus;
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
