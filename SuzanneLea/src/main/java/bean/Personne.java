package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Personne {
	
	@Id
	@Column(name="ID_Personne", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
    protected Integer ID;
	@Column(name="Nom", length=25, nullable=false)
    protected String nom;
	@Column(name="Prenom", length=25, nullable=false)
    protected String prenom;
	@Column(name="Email", length=50, nullable=false)
    protected String email;
	@Column(name="Adresse", length=225, nullable=false)
    protected String adresse;
	@Column(name="Telephone", length=12, nullable=false)
    protected String tel;
	@Column(name="Password", length=25, nullable=false)
    protected String mdp;
	
	
	//Constructeur	
	public Personne() {
		
	}

	public Personne(String nom, String prenom, String email, String adresse, String tel, String mdp) {
		
		setNom(nom);
		setPrenom(prenom);
		setEmail(email);
		setTel(tel);
		setMdp(mdp);
		
	}



	//Accesseurs
	
	public Integer getID() {
		return ID;
	}


	public void setID(Integer iD) {
		ID = iD;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getMdp() {
		return mdp;
	}


	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	
	
	

}
