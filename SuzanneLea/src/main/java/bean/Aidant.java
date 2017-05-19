package bean;



public class Aidant extends Personne {
	protected Integer ID_Aidant;
	//récupérer ID et type de la personne aidante (pas de classe type)
	protected Integer ID_Type; 
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
