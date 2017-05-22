package bean;

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
@Table(name="aidees")
public class Aidee {
	@Id
	@Column(name="ID_Aidee", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
    protected Integer ID_Aidee;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Personne")
    private Personne personne;
	

	// Constructeur
	public Aidee() {
		super();
	}
	
	public Aidee(Personne personne) {
		super();
		this.personne = personne;
	}



	//Accesseurs
	public Integer getID_Aidee() {
		return ID_Aidee;
	}

	public void setID_Aidee(Integer iD_Aidee) {
		ID_Aidee = iD_Aidee;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

}
