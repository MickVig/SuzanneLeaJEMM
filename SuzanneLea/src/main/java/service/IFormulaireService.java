package service;

import javax.servlet.http.HttpServletRequest;

public interface IFormulaireService {

	/**
	 * verifier que le login est valide ou non
	 * @param mail : regarder si mail valide
	 * @param mdp : regarder si le mot de passe a au moins 5 caractères
	 * @return envoyé message selon login ok ou non
	 */
	public Boolean verifLogin(String mail, String mdp, HttpServletRequest request);
	
	/**
	 * verifier que le formulaire inscription a ses champs bien rempli
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param tel
	 * @param mail
	 * @param mdp
	 * @return
	 */
	public Boolean verifInscription(String nom, String prenom, String adresse, String tel, String mail, String mdp,HttpServletRequest request);
}