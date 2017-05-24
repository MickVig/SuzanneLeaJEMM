package dao;

import java.util.Date;
import java.util.List;

import bean.Agenda;
import bean.Aidant;
import bean.Aidee;

public interface IAgendaDAO {

	
	/**
	 * Creer un evenement dans l'agenda
	 * @param date de l'evenement
	 * @param titre de l'evenement
	 * @param contenu de l'evenement
	 * @param aidee : personne aidee concernée par l'evenement
	 * @param aidant : Si non null, c'est l'accompagnateur
	 * @return
	 */
	public Agenda createEvenement(Date date, String titre, String contenu, Integer ID_Aidee, Integer ID_Aidant);

	/**
	 * Lire l'evenement d'un agenda
	 * @param ID_Agenda
	 * @return
	 */
	public Agenda readEvenement(Integer ID_Agenda);
	
	/**
	 * Liste de tous les évenement à venir pour une personne aidee
	 * @param ID_Aidee
	 * @return
	 */
	public List<Agenda> nextAllEvenement(Integer ID_Aidee);

	/**
	 * Retourne le prochain evenement à venir pour une personne aidee
	 * @param ID_Aidee
	 * @return
	 */
	public Agenda nextEvenement (Integer ID_Aidee);
	/**
	 * retourne tous les evenements concernant une personne aidee
	 * @param ID_Aidee
	 * @return
	 */
	public List<Agenda> readAllEvenement(Integer ID_Aidee);
	
	/**
	 * Modifier un evenement de l'agenda
	 * @param date
	 * @param titre
	 * @param contenu
	 * @param aidee
	 * @param aidant
	 */
	public void updateEvenement(Date date, String titre, String contenu, Aidee aidee, Aidant aidant);

	/**
	 * Supprimer un evenement de l'agenda
	 * @param id
	 */
	public void supprEvenement(Integer id);

}