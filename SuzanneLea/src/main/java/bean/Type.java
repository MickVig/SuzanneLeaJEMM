package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="types")
public class Type {
	@Id
	@Column(name="ID_Type", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
    protected Integer ID_Type;
	@Column(name="Type", nullable=false)
	protected String Type; 
	
	public Type() {
	}

	public Integer getID_Type() {
		return ID_Type;
	}

	public void setID_Type(Integer iD_Type) {
		ID_Type = iD_Type;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}
	
	

}
