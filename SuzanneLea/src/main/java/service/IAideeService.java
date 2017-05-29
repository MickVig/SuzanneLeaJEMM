package service;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Agenda;
import bean.Personne;

public interface IAideeService {
	
	/**
	 * verifier l'inscription d'un aidant
	 * @param request
	 * @param response
	 * @return
	 */
	public Boolean inscriptionAidant (HttpServletRequest request, HttpServletResponse response);

	/**
	 * Lister les aidants proches d'une personne aidee
	 * @param IDAidee
	 * @return
	 */
	public List<Personne> allAidantsProches(Integer IDAidee);
	
	
	/**
	 * Retourne tous les evenement d'un aidee
	 * @param IDAidee
	 * @return
	 */
	public List allRDV (Integer IDAidee);
	
	/**
	 * Retourne tous les Compte rendu d'un aidee
	 * @param IDAidee
	 * @return
	 */	
	public List allCR (Integer IDAidee) ;
	
	/**
	 * recupere la personne proche referente
	 * @param IDAidee
	 * @return recupere la personne proche referente
	 */
	public Personne procheReferent (Integer IDAidee);
	
	/**
	 * recupere la personne medecin referente
	 * @param IDAidee
	 * @return la personne medecin referente
	 */
	public Personne medecinReferent (Integer IDAidee);
	
	/**
	 * ajouter un evenement en base de donnees
	 * @param request
	 * @param response
	 * @throws ParseException
	 */
	public void addEvent(HttpServletRequest request, HttpServletResponse response) throws ParseException;
	
	/**
	 * Ajouter un compte rendu en BDD
	 * @param request
	 * @param response
	 */
	public void addCR (HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * Recuperer le dernier compte rendu d'une personne aidee
	 * @param Id_Aidee
	 * @return
	 */
	public List lastCompteRendu(Integer Id_Aidee);
	
	/**
	 * recuperer le prochain evenement d'une personne aidee
	 * @param Id_Aidee
	 * @return
	 */
	public Agenda nextEvenement(Integer Id_Aidee);
	
}
