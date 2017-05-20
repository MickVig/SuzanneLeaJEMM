package dao;

import bean.Personne;

public interface IPersonneDAO {
	
	// CRUD
	public void createPersonne(String nom, String prenom, String email, String adresse, String tel, String mdp);
	public Personne readPersonne(Integer id);
	public void updatePersonne(Integer id, String nom, String prenom, String email, String adresse, String tel, String mdp);
	public void supprPersonne(Integer id);
	
	// Autres Requetes
	public Personne personneExiste(String mail, String mdp);
	
}
