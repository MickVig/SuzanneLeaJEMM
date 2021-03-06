package service;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class FormulaireService implements IFormulaireService {
	/////// SINGLETON \\\\\\\
	private static IFormulaireService instance = null;

	private FormulaireService() {
	}

	public static synchronized IFormulaireService getInstance() {
		if (instance == null) {
			instance = new FormulaireService();
		}
		return instance;
	}

	//Methodes
	
	/*
	 * M�thode qui permet de verifier le format de saisie de l'adrese mail lors de la connexion
	 * et la longueur du mot de passe qui doit �tre d'au moins 4 caracteres
	 */
	
	public Boolean verifLogin(String mail, String mdp, HttpServletRequest request) {
		/* On cr�e d'un bool�an qui sera retourn�
 		*  on r�cup�re la session
 		*  on initialise le message d'erreur login
 		*/
		Boolean b=true;
		HttpSession session = request.getSession();
		session.setAttribute("messageLogin", "");
		
		// Si le mail pass� en argument n'est pas un mail 
		if (Pattern.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$", mail) != true) {
			// Alors le boolean �gale false
			b = false;
			
		} else if (mdp.length() < 4) {	// Si le mot de passe fait moins de 4 caract�res
			// Alors le boolean �gale false
			b = false;
		}
		// Si le bool�an �gale false
		if(!b){
			// Alors on enregistre un message d'erreur dans la session
			session.setAttribute("messageLogin", "Erreur de saisie : v�rifier le mail et le mot de passe");
		}
		return b;
	}
	

	//Verifier que les champs du formulaire inscription sont rempli
	public Boolean verifInscription(String nom, String prenom, String adresse, String tel, String mail, String mdp,HttpServletRequest request) {
		Boolean b=true;
		HttpSession session = request.getSession();
		String message="";
		session.setAttribute("messageinscription", message);
		if (nom.length()<3) {
			b = false;
			message="Le nom doit avoir au moins 3 caract�res";
		} else if (prenom.length()<3) {
			b=false;
			message="Le prenom doit avoir au moins 3 caract�res";
		} else if (adresse.length()<10) {
			b=false;
			message="Remplir le champ adresse";
		}else if (tel.length()<10) {
			b=false;
			message="Remplir le champ telephone";
		} else if (Pattern.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$", mail) != true) {
			b=false;
			message="L'adresse mail ou le mot de passe ne correspondent pas";
		} else if (mdp.length() < 4) {
			b = false;
			message="L'adresse mail ou le mot de passe ne correspondent pas";
		}
		session.setAttribute("messageinscription", message);
		return b;
	}
}
