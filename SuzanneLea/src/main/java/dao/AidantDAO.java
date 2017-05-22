package dao;


import bean.Personne;

public class AidantDAO extends ConnexionDAO implements IAidantDAO {
	
	/*private static IAidantDAO instance=null;
	private AidantDAO(){
	}
	public static synchronized IAidantDAO getInstance() {
		if (instance==null){
			instance=new AidantDAO();
		}
		return instance;
	}*/
	
	/////// Autres Requetes \\\\\\\
	
	
	/////// CRUD \\\\\\\
	
	@Override
	public void createAidant(Integer ID_pers, Integer ID_Type) {
		// TODO Auto-generated method stub
		/*
		 * Si la personne n'existe pas la créer avant de le mettre aidant
		 */
		
	}
	@Override
	public Personne readAidant(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateAidant(Personne p, Integer ID_Type) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void supprAidant(Integer id) {
		// TODO Auto-generated method stub
		
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
