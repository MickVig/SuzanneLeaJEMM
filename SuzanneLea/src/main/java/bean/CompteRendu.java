package bean;

import java.util.Date;


public class CompteRendu {
	
	protected Integer ID;
	protected Date date;
	protected String commentaire;
	//si non null : aidant = auteur du CR sinon auteur = aidee
	protected Aidant aidant;
	protected Aidee aidee;

		
	
	
	
	//Constructeur
	public CompteRendu() {
		
	}
	
	//Accesseurs

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Aidant getAidant() {
		return aidant;
	}

	public void setAidant(Aidant aidant) {
		this.aidant = aidant;
	}

	public Aidee getAidee() {
		return aidee;
	}

	public void setAidee(Aidee aidee) {
		this.aidee = aidee;
	}
	
	
	
	
}
