package bean;

import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.Set;


@Entity
public class Aidee extends Personne {
	@Id
	@Column(name="ID_Aidee", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
    protected Integer ID_Aidee;
	@OneToMany(mappedBy = "Aidee", cascade = { CascadeType.ALL })
    protected Set<Aidant> listeAidant = new HashSet<Aidant>();
	@Column(name="ID_Aidant", nullable=false)
	protected Integer ID_MedecinRef;
	@Column(name="ID_Aidant", nullable=false)
    protected Integer ID_ProcheRef;

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


	public Integer getID_MedecinRef() {
		return ID_MedecinRef;
	}



	public void setID_MedecinRef(Integer iD_MedecinRef) {
		ID_MedecinRef = iD_MedecinRef;
	}



	public Integer getID_ProcheRef() {
		return ID_ProcheRef;
	}



	public void setID_ProcheRef(Integer iD_ProcheRef) {
		ID_ProcheRef = iD_ProcheRef;
	}



	public void setListeAidant(Set<Aidant> listeAidant) {
		this.listeAidant = listeAidant;
	}

	
	
	
	
	
	
	

}
