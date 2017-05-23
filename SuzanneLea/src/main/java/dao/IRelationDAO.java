package dao;

import bean.Relation;

public interface IRelationDAO {

		
		/////// CRUD \\\\\\\
		
		/**
		 * Fonction pour CREER une nouvelle relation dans la BDD
		 * @param ID_Aidant		le num�ro unique de l'aidant r�f�rents
		 * @param ID_Aidee		le num�ro unique de l'aidee
		 */
		public void createRelation(Integer ID_Aidant, Integer ID_Aidee, Boolean Referent);
		
		/**
		 * Fonction pour LIRE un r�f�rent de l'aidee et selon le type d'aidant choisi
		 * @param ID_Aidee	Num�ro unique de l'aidee
		 * @param ID_Type	Num�ro unique selon le type de referent (m�decin ou proche)
		 */
		public Relation readRef(Integer ID_Aidee, Integer ID_Type);
		
		/**
		 * Fonction pour LIRE tout les r�f�rents de l'aidee dans la BDD
		 * @param ID_Aidee	Num�ro unique de l'aidee
		 */ 
		public Relation readAllRef(Integer ID_Aidee);
		
		/**
		 * Fonction pour LIRE tout les relations de l'aidee dans la BDD
		 * @param ID_Aidee	Num�ro unique de l'aidee
		 */
		public Relation readAllRelation(Integer ID_Aidee);
		
		/**
		 * Fonction pour SUPPRIMER un referent dans la BDD
		 * @param ID_Aidant		le num�ro unique de l'aidant r�f�rents
		 * @param ID_Aidee		le num�ro unique de l'aidee
		 */
		public void supprRelation(Integer ID_Aidant, Integer ID_Aidee);
	

}
