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
@Table(name="agenda")
public class Agenda {
	@Id
	@Column(name="ID_Agenda", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
    protected Integer ID_Agenda;
	@Column(name="DateEvenement", nullable=false)
    protected Date date;
	@Column(name="TitreEvenement", length=50, nullable=false)
    protected String titre;
	@Column(name="ContenuEvenement", length=50, nullable=false)
    protected String contenu;
	
    //si non null : aidant = accompagnateur
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Aidee")
    private Aidee aidee;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Aidant")
    private Aidant aidant;
	
	//Constructeur
	
	public Agenda() {
	}

	public Agenda(Date date, String titre, String contenu, Aidee aidee, Aidant aidant) {
		super();
		this.date = date;
		this.titre = titre;
		this.contenu = contenu;
		this.aidee = aidee;
		this.aidant = aidant;
	}

	
	
	//Accesseurs
	public Integer getID_Agenda() {
		return ID_Agenda;
	}

	public void setID_Agenda(Integer iD_Agenda) {
		ID_Agenda = iD_Agenda;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
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
