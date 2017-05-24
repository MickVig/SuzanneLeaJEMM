package service;

public interface IFormulaireService {

	/**
	 * verifier que le login est valide ou non
	 * @param mail : regarder si mail valide
	 * @param mdp : regarder si le mot de passe a au moins 5 caractères
	 * @return envoyé message selon login ok ou non
	 */
	public String verifLogin(String mail, String mdp);
	
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
	public String verifInscription(String nom, String prenom, String adresse, String tel, String mail, String mdp);
}