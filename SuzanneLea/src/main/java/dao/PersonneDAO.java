package dao;

import java.util.List;

import javax.persistence.Query;

import bean.Personne;

public class PersonneDAO extends ConnexionDAO implements IPersonneDAO {

	/////// SINGLETON \\\\\\\
	private static IPersonneDAO instance = null;

	private PersonneDAO() {
	}

	public static synchronized IPersonneDAO getInstance() {
		if (instance == null) {
			instance = new PersonneDAO();
		}
		return instance;
	}

	/////// Autres Requetes \\\\\\\

	/*
	 * La fonction renvoie la personne si celle-ci existe dans la BDD
	 */
	@Override
	public Personne personneExiste(String mail, String mdp) {
		//ouverture de la connexion
		this.connexion();
		//on créer une nouvelle personne pour sauvegarder les informations
		Personne p = new Personne();
		try {
			//on récupère la personne grâce à mail et mot de passe si elle existe
			Query requete = this.getEm()
					.createQuery("SELECT p FROM Personne p WHERE p.email='" + mail + "' AND p.mdp='" + mdp + "'");
			//on récupère la personne dans une liste qui contient un élément
			List<?> liste = requete.getResultList();
			//Si la liste est non vide, on récupère la personne
			if (liste.size() != 0) {
				//une seule personne dans la liste donc on récupère la première
				p = (Personne) liste.get(0);
			}
			this.commit();
		} catch (Exception e) {
			throw new ExceptionDAO("Anomalie lors de l'execution de la requete");
		}
		//fermeture de la connexion
		this.deconnexion();
		return p;
	}

	/////// CRUD \\\\\\\

	/*
	 * Fonction pour CREER une nouvelle personne dans la BDD
	 */
	public Personne createPersonne(String nom, String prenom, String email, String adresse, String tel, String mdp) {
		this.connexion();
		Personne p = new Personne();
		try {
			p.setAdresse(adresse);
			p.setEmail(email);
			p.setMdp(mdp);
			p.setNom(nom);
			p.setPrenom(prenom);
			p.setTel(tel);
			System.out.println(p);
			this.getEm().persist(p);
			this.commit();
		} catch (Exception e) {
			throw new ExceptionDAO("Anomalie lors de l'execution de la requete");
		}
		this.deconnexion();
		return p;

	}

	/*
	 * Fonction pour LIRE une personne de la BDD
	 */
	@Override
	public Personne readPersonne(Integer id) {
		this.connexion();
		Personne p=new Personne();
		try {
			p = this.getEm().find(Personne.class, id);
			System.out.println(p);
		} catch (Exception e) {
			throw new ExceptionDAO("Anomalie lors de l'execution de la requete");
		}
		this.deconnexion();

		return p;
	}

	/*
	 * Fonction pour MODIFIER une nouvelle personne dans la BDD
	 */
	@Override
	public void updatePersonne(Integer id, String nom, String prenom, String email, String adresse, String tel,
			String mdp) {
		this.connexion();
		/*
		 * TODO Code a finir récupérer la personne du résultat
		 * 
		 * em.createQuery(" UPDATE table SET nom = 'nom', prenom = 'prenom',
		 * email = 'email' WHERE id = id");
		 * 
		 * 
		 */
		this.commit();
		this.deconnexion();
	}

	/*
	 * Fonction pour SUPPRIMER une personne de la BDD
	 */
	@Override
	public void supprPersonne(Integer id) {
		this.connexion();

		/*
		 * TODO Code a finir récupérer la personne du résultat
		 * 
		 * em.createQuery("delete from personne where id = '" + id + "'" +");
		 * 
		 * 
		 */
		this.commit();
		this.deconnexion();

	}

}
