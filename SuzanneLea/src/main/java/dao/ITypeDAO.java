package dao;

import bean.Type;

public interface ITypeDAO {
	/**
	 * 
	 * @param type
	 * @return un type de personne (proche, medecin, ...)
	 */
	public Type createType(String type);
	
	/**
	 * 
	 * @param id du type
	 * @return le type correspondant à l'id
	 */
	public Type readType(Integer id);
	
}