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
@Table(name="referents")
public class Referent {
	@Id
	@Column(name="ID_Ref", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
    protected Integer ID_Ref;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Aidee")
    private Aidee aidee;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Aidant")
    private Aidant aidant;
	
	public Referent() {
	}
	
	public Referent(Aidee aidee, Aidant aidant) {
		super();
		this.aidee = aidee;
		this.aidant = aidant;
	}



	//accesseurs
	public Integer getID_Ref() {
		return ID_Ref;
	}

	public void setID_Ref(Integer iD_Ref) {
		ID_Ref = iD_Ref;
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
