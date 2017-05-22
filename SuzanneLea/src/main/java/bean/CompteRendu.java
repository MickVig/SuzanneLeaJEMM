package bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="compterendus")
public class CompteRendu {
	@Id
	@Column(name="ID_CompteRendu", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
    protected Integer ID_CR;
	@Column(name="DateCR", nullable=false)
    protected Date date;
	@Column(name="Commentaire", length=225, nullable=false)
    protected String commentaire;
    //si non null : aidant = auteur du CR sinon auteur = aidee
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Aidee")
    private Aidee aidee;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Aidant")
    private Aidant aidant;
		
	
	//Constructeur
	public CompteRendu() {
		
	}
	
	public CompteRendu(Date date, String commentaire, Aidee aidee, Aidant aidant) {
		super();
		this.date = date;
		this.commentaire = commentaire;
		this.aidee = aidee;
		this.aidant = aidant;
	}

	//Accesseurs
	public Integer getID_CR() {
		return ID_CR;
	}

	public void setID_CR(Integer iD_CR) {
		ID_CR = iD_CR;
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

	public Aidee getAidee() {
		return aidee;
	}

	public void setAidee(Aidee aidee) {
		this.aidee = aidee;
	}

	public Aidant getAidant() {
		return aidant;
	}

	public void setAidant(Aidant aidant) {
		this.aidant = aidant;
	}







	
	
	
	
	
	
}
