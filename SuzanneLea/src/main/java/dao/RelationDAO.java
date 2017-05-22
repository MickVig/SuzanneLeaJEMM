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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Relation readRef(Integer ID_Aidee, Integer ID_Type, Boolean Referent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Relation readAllRef(Integer ID_Aidee, Boolean Referent) {
		// TODO Auto-generated method stub
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
