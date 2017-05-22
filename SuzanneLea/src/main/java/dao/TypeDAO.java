package dao;

import javax.persistence.Query;

import bean.Personne;
import bean.Type;

public class TypeDAO implements ITypeDAO {

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

	ConnexionDAO connexion = new ConnexionDAO();

	/////// CRUD \\\\\\\

	/*
	 * Fonction pour CREER un nouveau type
	 */
	public Type createType(String type) {
		connexion.deconnexion();
		Type t = new Type();
		t.setType(type);
		connexion.getEm().persist(t);
		System.out.println(t);
		connexion.commit();
		connexion.deconnexion();
		return t;

	}

	/*
	 * Fonction pour LIRE une personne de la BDD
	 */
	@Override
	public Type readType(Integer id) {
		connexion.connexion();
		Type t = new Type();
		Query requete=connexion.getEm().createQuery("'SELECT t FROM Type t where id = " + id + "'");
		connexion.commit();
		connexion.deconnexion();
		return t;
	}
}
