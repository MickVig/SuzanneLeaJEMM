package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	
	
	/////// Autres Requetes \\\\\\\
	@Override
	public List<CompteRendu> comptesRendusAidee(Integer id) {
		List<CompteRendu> listeCR = new ArrayList<CompteRendu>();
		/* 
         * TODO
         * Code a finir pour récupérer la liste des CR ecrit sur l'aidee et les retourner
         * 
         * em.createQuery("select cr from compterendu where id_aidee = '" + id + "'"
                +");
         * 
         * 
         */
		return listeCR;
	}

	@Override
	public List<CompteRendu> comptesRendusAidant(Integer id) {
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
		return listeCR;
	}
	
	
	
	/////// CRUD \\\\\\\
	/* La modification et la suppression d'un compte rendu est interdite dans notre cas*/
	
	@Override
	public CompteRendu readCompteRendu(Integer id) {
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
		return cr;
	}

	
	@Override
	public void createCompteRendu(Date date, String commentaire, Integer iD_Aidant, Integer iD_Aidee) {
		/* 
         * TODO
         * Code a finir pour créer le CR 
         * 
         * em.createQuery(" INSERT INTO personne (nom_colonne_1, nom_colonne_2, ...
 				VALUES ('valeur 1', 'valeur 2', ...)");
         * 
         * 
         */
		
	}

}
