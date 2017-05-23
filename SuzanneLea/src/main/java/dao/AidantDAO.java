package dao;


import java.util.ArrayList;
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
	public List readAllAidantType(Integer ID_Type) {
		this.connexion();
		//On selectionne les aidant d'un certain type
		Query requete=this.getEm().createQuery("SELECT a FROM Aidant a WHERE a.type.ID_Type="+ID_Type);
    	
    	List liste = requete.getResultList();
    	List resultat = new ArrayList();
    	for (int i=0; i<liste.size(); i++) {
			Aidant a=(Aidant) liste.get(i);
			resultat.add(a.getID_Aidant());
			Personne p=a.getPersonne();
			resultat.add(p.getID());
			resultat.add(p.getNom());
			resultat.add(p.getPrenom());
    	}
    	System.out.println(resultat);
		this.deconnexion();
    	return resultat;
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
	public Aidant readAidant(Integer id) {
		this.connexion();
		Aidant a = this.getEm().find(Aidant.class, id);
		System.out.println(a);
		this.deconnexion();		
    	return a;
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
