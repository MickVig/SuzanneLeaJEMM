package dao;

import java.util.Date;
import java.util.List;

import bean.CompteRendu;

public interface ICompteRenduDAO {


	/////// Autres Requetes \\\\\\\
	
	/**
	 * Fonction pour RECUPERER tous les CR écrit sur l'aidee sélectionner
	 * @param id		le numéro unique de l'aidee
	 * @return			la liste des comptes rendus
	 */
	public List<CompteRendu> comptesRendusAidee(Integer id);
	
	/**
	 * Fonction pour RECUPERER tous les CR écrit par l'aidant sélectionner
	 * @param id		le numéro unique de l'aidant
	 * @return			la liste des comptes rendus
	 */
	public List<CompteRendu> comptesRendusAidant(Integer id);


	/////// CRUD \\\\\\\
	/* La modification et la suppression d'un compte rendu est interdite dans notre cas*/
	
	/**
	 * Fonction pour CREER un nouveau compte rendu dans la BDD
	 * @param date			la date de la saisie du CR
	 * @param commentaire	le message saisie dans le CR
	 * @param iD_Aidant		l'auteur du CR
	 * @param iD_Aidee		l'aidee conserné par le CR
	 */
	public void createCompteRendu(Date date, String commentaire, Integer iD_Aidant, Integer iD_Aidee);
	
	/**
	 * Fonction pour LIRE un compte rendu dans la BDD
	 * @param id		le numéro unique du compte rendu à lire
	 * @return			le compte rendu souhaité
	 */
	public CompteRendu readCompteRendu(Integer id);

	/**
	 * Afficher le dernier compte rendu concernant un aidee
	 * @param Id_Aidee
	 * @return
	 */
	public List lastCompteRendu(Integer Id_Aidee);

}
