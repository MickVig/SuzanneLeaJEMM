package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import bean.Aidant;
import bean.Aidee;
import bean.Personne;
import bean.Relation;

public class AideeDAO extends ConnexionDAO implements IAideeDAO {

	/////// SINGLETON \\\\\\\
	private static IAideeDAO instance = null;

	private AideeDAO() {
	}

	public static synchronized IAideeDAO getInstance() {
		if (instance == null) {
			instance = new AideeDAO();
		}
		return instance;
	}

	/////// Autres Requetes \\\\\\\

	// Recuperer tous les proches d'un aidee
	@Override
	public List<Personne> allAidant(Integer ID_Aidee) {
		this.connexion();
		List<Personne> resultat = new ArrayList<Personne>();
		// On selectionne les aidants d'un certain type
		try {
			Query requete = this.getEm().createQuery("SELECT r FROM Relation r WHERE r.aidee.ID_Aidee=" + ID_Aidee+"AND r.aidant.type.ID_Type=1");
			List<?> liste = requete.getResultList();

			// on cree une nouvelle liste avec les personnes aidantes
			for (int i = 0; i < liste.size(); i++) {
				Personne p = new Personne();
				Relation r = (Relation) liste.get(i);
				Aidant a = r.getAidant();
				p = a.getPersonne();
				System.out.println(p);
				resultat.add(p);
			}
		} catch (Exception e) {
			throw new ExceptionDAO("Anomalie lors de l'execution de la requete");
		}
		this.deconnexion();
		return resultat;
	}

	// Recuperer la personne proche referente
	public Personne readProcheRef(Integer ID_Aidee) {
		this.connexion();
		Personne p = new Personne();
		try {
			// On selectionne les aidants d'un certain type
			Query requete = this.getEm().createQuery("SELECT r FROM Relation r WHERE r.aidee.ID_Aidee=" + ID_Aidee
					+ "AND r.referent=1 AND r.aidant.type.ID_Type=1");
			List<?> liste = requete.getResultList();

			// on cree une nouvelle liste avec les personnes aidantes

			Relation r = (Relation) liste.get(0);
			Aidant a = r.getAidant();
			p = a.getPersonne();
			System.out.println(p);
		} catch (Exception e) {
			throw new ExceptionDAO("Anomalie lors de l'execution de la requete");
		}
		this.deconnexion();
		return p;
	}

	// Recuperer la personne medecin referent
	public Personne readMedecinRef(Integer ID_Aidee) {
		this.connexion();
		Personne p = new Personne();
		try {
			// On selectionne les aidants d'un certain type
			Query requete = this.getEm().createQuery("SELECT r FROM Relation r WHERE r.aidee.ID_Aidee=" + ID_Aidee
					+ "AND r.referent=1 AND r.aidant.type.ID_Type=2");
			List<?> liste = requete.getResultList();

			// on cree une nouvelle liste avec les personnes aidantes
			if (liste.size() != 0) {
				Relation r = (Relation) liste.get(0);
				Aidant a = r.getAidant();
				p = a.getPersonne();
				System.out.println(p);
			}
		} catch (Exception e) {
			throw new ExceptionDAO("Anomalie lors de l'execution de la requete");
		}
		this.deconnexion();
		return p;
	}

	// Lire un aidee � partir d'un personne
	public Integer readAideeByPersonne(Integer ID_Personne) {
		this.connexion();
		Aidee a = new Aidee();
		try {
			Query requete = this.getEm().createQuery("SELECT a FROM Aidee a WHERE a.personne.ID=" + ID_Personne);
			if (requete.getResultList().size() != 0) {
				a = (Aidee) requete.getResultList().get(0);
			}
		} catch (Exception e) {
			throw new ExceptionDAO("Anomalie lors de l'execution de la requete");
		}
		this.deconnexion();
		return a.getID_Aidee();
	}

	/////// CRUD \\\\\\\
	@Override
	public Aidee createAidee(Integer ID_Pers) {
		Aidee aidee = new Aidee();
		this.connexion();
		try {
			aidee.setPersonne(PersonneDAO.getInstance().readPersonne(ID_Pers));
			this.em.persist(aidee);
			this.commit();
		} catch (Exception e) {
			throw new ExceptionDAO("Anomalie lors de l'execution de la requete");
		}
		this.deconnexion();
		return aidee;
	}

	@Override
	public Aidee readAidee(Integer id) {
		this.connexion();
		Aidee a = new Aidee();
		try {
			a = this.getEm().find(Aidee.class, id);
			System.out.println(a);
		} catch (Exception e) {
			throw new ExceptionDAO("Anomalie lors de l'execution de la requete");
		}
		this.deconnexion();
		return a;
	}

	@Override
	public void updateAidee(Personne p, Integer iD_MedecinRef, Integer iD_ProcheRef) {
		this.connexion();
		// TODO Auto-generated method stub
		this.commit();
		this.deconnexion();
	}

	@Override
	public void supprAidee(Integer id) {
		this.connexion();
		// TODO Auto-generated method stub
		this.commit();
		this.deconnexion();
	}
}
