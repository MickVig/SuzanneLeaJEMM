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
@Table(name="relations")
public class Relation {
	
	@Id
	@Column(name="ID_Relation", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
    protected Integer ID_Relation;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Aidee")
    private Aidee aidee;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Aidant")
    private Aidant aidant;
	
	@Column(name="Referent")
	private Boolean referent;
	
	public Relation() {
	}
	
	public Relation(Aidee aidee, Aidant aidant, Boolean referent) {
		super();
		this.aidee = aidee;
		this.aidant = aidant;
		this.referent=referent;
	}



	//accesseurs
	public Integer getID_Relation() {
		return ID_Relation;
	}

	public void setID_Relation(Integer iD_Relation) {
		ID_Relation = iD_Relation;
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

	public Boolean getReferent() {
		return referent;
	}

	public void setReferent(Boolean referent) {
		this.referent = referent;
	}
	
	
	
	
	
}
