package dao;

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
	
	ConnexionDAO connexion=new ConnexionDAO();
	

	public List<CompteRendu> getListCompteRendu(){
		connexion.connexion();
		CompteRendu cr = new CompteRendu();
		em.persist(cr);
		return (List<CompteRendu>) cr;	
	}	

	
	/////// Autres Requetes \\\\\\\
	@Override
	public List<CompteRendu> comptesRendusAidee(Integer id) {
		connexion.connexion();
		List<CompteRendu> listeCR = new ArrayList<CompteRendu>();
		
		CompteRendu cr = new CompteRendu();
		
		//String requete = "INSERT INTO COMPTERENDUS (date, commentaire, ID_aidant, ID_aidee)" + "VALUES (?,?,?,?)"; 
		//Query requete = em.createQuery("select cr from compterendu where id_aidee = '1'" + id + "'" +"");
		/* 
         * TODO
         * Code a finir pour récupérer la liste des CR ecrit sur l'aidee et les retourner
         * 
         * em.createQuery("select cr from compterendu where id_aidee = '" + id + "'"
                +");
         * 
         * 
         */
		connexion.commit();
		connexion.deconnexion();
		return listeCR;
	}

	@Override
	public List<CompteRendu> comptesRendusAidant(Integer id) {
		connexion.connexion();
		List<CompteRendu> listeCR = new ArrayList<CompteRendu>();
		/* 
         * TODO
         * Code a finir pour récupérer la liste des CR ecrit par l'aidant et les retourner
         * 
         * em.createQuery("select cr from compterendu where id_aidant = '" + id + "'"
                +");
         * 
         * 
         */
		connexion.commit();
		connexion.deconnexion();
		return listeCR;
	}
	
	
	
	/////// CRUD \\\\\\\
	/* La modification et la suppression d'un compte rendu est interdite dans notre cas*/
	
	@Override
	public CompteRendu readCompteRendu(Integer id) {
		connexion.connexion();
		CompteRendu cr = new CompteRendu();
		/* 
         * TODO
         * Code a finir pour récupérer le CR et le retourner
         * 
         * em.createQuery("select cr from compterendu where id = '" + id + "'"
                +");
         * 
         * 
         */
		//return cr;
		connexion.commit();
		connexion.deconnexion();
		return (CompteRendu) em.createQuery("select cr from CompteRendu where (id ='" +id+ "').getResultList()");
	}

	
	@Override
	public void createCompteRendu(Date date, String commentaire, Integer iD_Aidant, Integer iD_Aidee) {
		connexion.connexion();
		CompteRendu cr = new CompteRendu();
		/* 
         * TODO
         * Code a finir pour créer le CR 
         * 
         * em.createQuery(" INSERT INTO personne (nom_colonne_1, nom_colonne_2, ...
 				VALUES ('valeur 1', 'valeur 2', ...)");
         * 
         * 
         */
		connexion.commit();
		connexion.deconnexion();
	}

}

