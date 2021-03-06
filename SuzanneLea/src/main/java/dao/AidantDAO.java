package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import bean.Aidant;
import bean.Personne;

public class AidantDAO extends ConnexionDAO implements IAidantDAO {

	private static IAidantDAO instance = null;

	private AidantDAO() {
	}

	public static synchronized IAidantDAO getInstance() {
		if (instance == null) {
			instance = new AidantDAO();
		}
		return instance;
	}

	/////// Autres Requetes \\\\\\\

	@Override
	public List<Personne> readAllAidantType(Integer ID_Type) {
		this.connexion();
		List<Personne> listePersonne = new ArrayList<Personne>();
		try {
			// On selectionne les aidants d'un certain type
			Query requete = this.getEm().createQuery("SELECT a FROM Aidant a WHERE a.type.ID_Type=" + ID_Type);
			List<?> liste = requete.getResultList();

			// on cree une nouvelle liste de personne

			for (int i = 0; i < liste.size(); i++) {
				//� partir de l'aidant n recupere la personne
				Aidant a = (Aidant) liste.get(i);
				Personne p = a.getPersonne();
				System.out.println(p);
				listePersonne.add(p);
			}
		} catch (Exception e) {
			throw new ExceptionDAO("Anomalie lors de l'execution de la requete");
		}
		this.deconnexion();
		return listePersonne;
	}

	//recuperer ID d'un aidant � partir de l'id de la personne
	public Integer readAidantByPersonne(Integer ID_Personne) {
		this.connexion();
		Aidant a = new Aidant();
		try {
			Query requete = this.getEm().createQuery("SELECT a FROM Aidant a WHERE a.personne.ID=" + ID_Personne);
			a = (Aidant) requete.getResultList().get(0);
			System.out.println(a);
		} catch (Exception e) {
			throw new ExceptionDAO("Anomalie lors de l'execution de la requete");
		}
		this.deconnexion();
		return a.getID_Aidant();
	}

	/////// CRUD \\\\\\\

	@Override
	public Aidant createAidant(Integer ID_Pers, Integer ID_Type) {
		Aidant aidant = new Aidant();
		this.connexion();
		try {
			aidant.setPersonne(PersonneDAO.getInstance().readPersonne(ID_Pers));
			aidant.setType(TypeDAO.getInstance().readType(ID_Type));
			this.getEm().persist(aidant);
			this.commit();
		} catch (Exception e) {
			throw new ExceptionDAO("Anomalie lors de l'execution de la requete");
		}
		this.deconnexion();
		return aidant;
	}

	@Override
	public Aidant readAidant(Integer id) {
		this.connexion();
		Aidant a = new Aidant();
		try {
			a = this.getEm().find(Aidant.class, id);
			System.out.println(a);
		} catch (Exception e) {
			throw new ExceptionDAO("Anomalie lors de l'execution de la requete");
		}
		this.deconnexion();
		return a;
	}

	@Override
	public void updateAidant(Personne p, Integer ID_Type) {
		this.connexion();
		// TODO Auto-generated method stub
		this.commit();
		this.deconnexion();
	}

	@Override
	public void supprAidant(Integer id) {
		this.connexion();
		// TODO Auto-generated method stub
		this.commit();
		this.deconnexion();
	}

}
