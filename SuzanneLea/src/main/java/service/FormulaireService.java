package service;

import java.util.regex.Pattern;

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

	/////// Méthodes \\\\\\\
	public String verifLogin(String mail, String mdp) {
		Boolean b=true;
		String message;
		if (Pattern.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$", mail) != true) {
			b = false;
		} else if (mdp.length() < 4) {
			b = false;
		}
		
		if(b) {
			message="connexion réussie";
		}
		else {
			message="L'adresse mail ou le mot de passe ne correspondent pas";
		}
		return message;
	}

	//verifier que les champs du formulaire inscription est rempli
	public String verifInscription(String nom, String prenom, String adresse, String tel, String mail, String mdp) {
		Boolean b=true;
		String message="formulaire correctement rempli";
		if (Pattern.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$", mail) != true) {
			b = false;
			message="L'adresse mail ou le mot de passe ne correspondent pas";
		} else if (mdp.length() < 4) {
			b = false;
			message="L'adresse mail ou le mot de passe ne correspondent pas";
		} else if (nom.length()<3) {
			b=false;
			message="Le nom doit avoir au moins 3 carcatères";
		} else if (prenom.length()<3) {
			b=false;
			message="Le prennom doit avoir au moins 3 carcatères";
		} else if (adresse.length()<10) {
			b=false;
			message="Remplir le champ adresse";
		}else if (tel.length()<10) {
			b=false;
			message="Remplir le champ telephone";
		}		
		System.out.println(message);
		return message;
	}
}
