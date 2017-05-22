package dao;


import java.util.List;

import javax.persistence.Query;

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
	
	/////// Autres Requetes \\\\\\\
	@Override
	public List<Personne> readAllAidantType(Integer ID_Type) {
		this.connexion();
		
    	Query requete=this.getEm().createQuery("SELECT p FROM Personne p INNER JOIN Aidants a WHERE p.ID=a.personne AND ID_Type = 2");
    	
    	List liste = requete.getResultList();
    	System.out.println(liste);
		this.commit();
		this.deconnexion();
    	return liste;
	}
	
	
	
	
	/////// CRUD \\\\\\\
	
	@Override
	public Aidant createAidant(Integer ID_Pers, Integer ID_Type) {
		Aidant aidant=new Aidant();
		this.connexion();
		aidant.setPersonne(PersonneDAO.getInstance().readPersonne(ID_Pers));
		aidant.setType(TypeDAO.getInstance().readType(ID_Type));
		this.getEm().persist(aidant);
		this.commit();
		this.deconnexion();
		return aidant;
	}
	
	@Override
	public Personne readAidant(Integer id) {
		this.connexion();
		// TODO Auto-generated method stub
		this.commit();
		this.deconnexion();
		return null;
	}
	
	@Override
	public void updateAidant(Personne p, Integer ID_Type) {
		this.connexion();
		// TODO Auto-generated method stub
		this.commit();
		this.deconnexion();
	}
	
	@Override
	public void supprAidant(Integer id) {
		this.connexion();
		// TODO Auto-generated method stub
		this.commit();
		this.deconnexion();
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
