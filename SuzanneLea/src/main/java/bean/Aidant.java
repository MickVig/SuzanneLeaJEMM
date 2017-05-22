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

@Table(name="aidants")
public class Aidant{
	@Id
	@Column(name="ID_Aidant", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
    protected Integer ID_Aidant;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_Type")
	private Type type;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Personne")
    private Personne personne;

	//Constructeur
	public Aidant() {
		super();
	}
	
	//Accesseurs
	
	public Integer getID_Aidant() {
		return ID_Aidant;
	}

	public void setID_Aidant(Integer iD_Aidant) {
		ID_Aidant = iD_Aidant;
	}




	public Type getType() {
		return type;
	}




	public void setType(Type type) {
		this.type = type;
	}




	public Personne getPersonne() {
		return personne;
	}




	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	

	
	
	
	
	
}