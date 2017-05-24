package dao;

import java.util.List;

import javax.persistence.Query;

import bean.Type;

public class TypeDAO extends ConnexionDAO implements ITypeDAO {

	/////// SINGLETON \\\\\\\
	private static ITypeDAO instance = null;

	private TypeDAO() {
	}

	public static synchronized ITypeDAO getInstance() {
		if (instance == null) {
			instance = new TypeDAO();
		}
		return instance;
	}

	/////// CRUD \\\\\\\

	/*
	 * Fonction pour CREER un nouveau type
	 */
	public Type createType(String type) {
		this.connexion();
		Type t = new Type();
		try {
			t.setType(type);
			this.getEm().persist(t);
			System.out.println(t);
			this.commit();
		} catch (Exception e) {
			throw new ExceptionDAO("Anomalie lors de l'execution de la requete");
		}
		this.deconnexion();
		return t;

	}

	/*
	 * Fonction pour LIRE une personne de la BDD
	 */
	@Override
	public Type readType(Integer id) {
		this.connexion();
		Type t = new Type();
		try {
			Query requete = this.getEm().createQuery("SELECT t FROM Type t where t.ID_Type =" + id);
			List<?> liste = requete.getResultList();
			t = (Type) liste.get(0);
			this.commit();
		} catch (Exception e) {
			throw new ExceptionDAO("Anomalie lors de l'execution de la requete");
		}
		this.deconnexion();
		return t;
	}
}
