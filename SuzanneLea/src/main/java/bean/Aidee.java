package bean;

import java.util.ArrayList;
import java.util.List;



public class Aidee extends Personne {
	protected Integer ID_Aidee;
	protected List<Aidant> listeAidant = new ArrayList<Aidant>();
	protected Aidant refMedecin;
	protected Aidant refProche;

	// Constructeur
	public Aidee() {
		super();
	}

	
	
	//Accesseurs
	
	public Integer getID_Aidee() {
		return ID_Aidee;
	}

	public void setID_Aidee(Integer iD_Aidee) {
		ID_Aidee = iD_Aidee;
	}

	public List<Aidant> getListeAidant() {
		return listeAidant;
	}

	public void setListeAidant(List<Aidant> listeAidant) {
		this.listeAidant = listeAidant;
	}

	public Aidant getRefMedecin() {
		return refMedecin;
	}

	public void setRefMedecin(Aidant refMedecin) {
		this.refMedecin = refMedecin;
	}

	public Aidant getRefProche() {
		return refProche;
	}

	public void setRefProche(Aidant refProche) {
		this.refProche = refProche;
	}

	
	
	
	
	
	

}
