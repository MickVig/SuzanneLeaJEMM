package dao;

import bean.Relation;

public class RelationDAO extends ConnexionDAO implements IRelationDAO {

	/////// SINGLETON \\\\\\\
	private static IRelationDAO instance=null;
	private RelationDAO(){
	}
	public static synchronized IRelationDAO getInstance() {
		if (instance==null){
			instance=new RelationDAO();
		}
		return instance;
	}
	
	@Override
	public void createRelation(Integer ID_Aidant, Integer ID_Aidee, Boolean Referent) {
		this.connexion();
		Relation r = new Relation();
		r.setAidant(AidantDAO.getInstance().readAidant(ID_Aidant));
		r.setAidee(AideeDAO.getInstance().readAidee(ID_Aidee));
		// Mettre le boolean dans la relation
		this.getEm().persist(p);
    	this.commit();
		this.deconnexion();
	}

	@Override
	public Relation readRef(Integer ID_Aidee, Integer ID_Type) {
		// TODO Auto-generated method stub
		Boolean Referent = true; //True pour trouver les réferents 
		return null;
	}

	@Override
	public Relation readAllRef(Integer ID_Aidee) {
		// TODO Auto-generated method stub
		Boolean Referent = true; //True pour trouver les 2 réferents (médecin et proche)
		return null;
	}

	@Override
	public Relation readAllRelation(Integer ID_Aidee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprRelation(Integer ID_Aidant, Integer ID_Aidee) {
		// TODO Auto-generated method stub
		
	}

}
