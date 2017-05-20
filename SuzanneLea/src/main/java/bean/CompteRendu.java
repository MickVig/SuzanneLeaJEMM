package bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CompteRendu {
	@Id
	@Column(name="ID_CompteRendu", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
    protected Integer ID;
	@Column(name="DateCR", nullable=false)
    protected Date date;
	@Column(name="Commentaire", length=225, nullable=false)
    protected String commentaire;
    //si non null : aidant = auteur du CR sinon auteur = aidee
	@Column(name="ID_Aidant", nullable=false)
    protected Integer ID_Aidant;
	@Column(name="ID_Aidee", nullable=false)
    protected Integer ID_Aidee;
		
	
	//Constructeur
	public CompteRendu() {
		
	}
	
	public CompteRendu(Date date, String commentaire, Integer iD_Aidant, Integer iD_Aidee) {
		setDate(date);
		setCommentaire(commentaire);
		setID_Aidant(iD_Aidant);
		setID_Aidee(iD_Aidee);
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

	public Integer getID_Aidant() {
		return ID_Aidant;
	}

	public void setID_Aidant(Integer iD_Aidant) {
		ID_Aidant = iD_Aidant;
	}

	public Integer getID_Aidee() {
		return ID_Aidee;
	}

	public void setID_Aidee(Integer iD_Aidee) {
		ID_Aidee = iD_Aidee;
	}

	
	
	
	
	
}
