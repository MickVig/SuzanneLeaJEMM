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

	/////// M�thodes \\\\\\\
	public Boolean verifLogin(String mail, String mdp, HttpServletRequest request) {
		Boolean b=true;
		HttpSession session = request.getSession();
		if (Pattern.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$", mail) != true) {
			b = false;
			
		} else if (mdp.length() < 4) {
			b = false;
		}
		if(!b){
			session.setAttribute("messageLogin", "Erreur de saisie : v�rifier le mail et le mot de passe");
		}
		return b;
	}

	//verifier que les champs du formulaire inscription est rempli
	public Boolean verifInscription(String nom, String prenom, String adresse, String tel, String mail, String mdp,HttpServletRequest request) {
		Boolean b=true;
		HttpSession session = request.getSession();
		String message="";
		if (nom.length()<3) {
			b = false;
			message="Le nom doit avoir au moins 3 carcat�res";
		} else if (prenom.length()<3) {
			b=false;
			message="Le prennom doit avoir au moins 3 carcat�res";
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
		System.out.println(message);
		return b;
	}
}