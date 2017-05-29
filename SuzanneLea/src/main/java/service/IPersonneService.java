package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IPersonneService {

	/**
	 * verifier si une personne peut se connecter grace à son mail et mot de passe
	 * @param request
	 * @param response
	 * @return
	 */
	public boolean connexion(HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * verifier si le formulaire d'inscription a ses champs rempli
	 * @param request
	 * @param response
	 * @return
	 */
	public Boolean inscription(HttpServletRequest request, HttpServletResponse response);
	
	//public void inscriptionAidant (HttpServletRequest request, HttpServletResponse response);
	
	
}
