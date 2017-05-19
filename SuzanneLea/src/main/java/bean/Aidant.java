package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Aidant extends Personne {
	@Id
	@Column(name="ID_Aidant", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
    protected Integer ID_Aidant;
    //récupérer ID et type de la personne aidante (pas de classe type)
    @Column(name="ID_Type", nullable=false)
	protected Integer ID_Type; 
	@Column(name="Type", nullable=false)
    protected String type;
	
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

	public Integer getID_Type() {
		return ID_Type;
	}

	public void setID_Type(Integer iD_Type) {
		ID_Type = iD_Type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
	
}
