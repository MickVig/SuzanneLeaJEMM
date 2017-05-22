package dao;


import bean.Aidant;
import bean.Personne;

public class AidantDAO extends ConnexionDAO implements IAidantDAO {
	
	private static IAidantDAO instance=null;
	private AidantDAO(){
	}
	public static synchronized IAidantDAO getInstance() {
		if (instance==null){
			instance=new AidantDAO();
		}
		return instance;
	}
	
	ConnexionDAO connexion=new ConnexionDAO();
	/////// Autres Requetes \\\\\\\
	
	
	/////// CRUD \\\\\\\
	
	@Override
	public Aidant createAidant(Integer ID_Pers, Integer ID_Type) {
		Aidant aidant=new Aidant();
		connexion.connexion();
		aidant.setPersonne(PersonneDAO.getInstance().readPersonne(ID_Pers));
		aidant.setType(TypeDAO.getInstance().readType(ID_Type));
		connexion.commit();
		connexion.deconnexion();
		return aidant;
	}
	
	@Override
	public Personne readAidant(Integer id) {
		connexion.connexion();
		// TODO Auto-generated method stub
		connexion.commit();
		connexion.deconnexion();
		return null;
	}
	
	@Override
	public void updateAidant(Personne p, Integer ID_Type) {
		connexion.connexion();
		// TODO Auto-generated method stub
		connexion.commit();
		connexion.deconnexion();
	}
	
	@Override
	public void supprAidant(Integer id) {
		connexion.connexion();
		// TODO Auto-generated method stub
		connexion.commit();
		connexion.deconnexion();
	}
	
	
	
	
	
	
	/* 
	public List<Personne> getListPersonne() {
		System.out.println("bonjour!");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();       
        tx.begin();
		List<Personne> liste=em.createQuery("select p from Personne p order by p.nom asc").getResultList();
		for (Personne p : liste) {
            System.out.println(p);
        }
        return liste;
	}
	*/
	
	

}
