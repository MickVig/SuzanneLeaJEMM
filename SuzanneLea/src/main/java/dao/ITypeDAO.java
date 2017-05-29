package dao;

import bean.Type;

public interface ITypeDAO {
	/**
	 * creer un nouveau type dans la BDD
	 * @param type
	 * @return un type de personne (proche, medecin, ...)
	 */
	public Type createType(String type);
	
	/**
	 * Lire un type selon son ID
	 * @param id du type
	 * @return le type correspondant à l'id
	 */
	public Type readType(Integer id);
	
}