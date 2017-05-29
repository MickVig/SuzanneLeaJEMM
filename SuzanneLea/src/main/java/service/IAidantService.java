package service;

import java.util.List;

public interface IAidantService {
	
	/**
	 * Lister tous les medecins
	 * @return
	 */
	public List<?> allMedecins();
	
	/**
	 * Lister les aidants selon le type
	 * @param IDType
	 * @return
	 */
	public List<?> allAidantsByType(Integer IDType);
	
	/**
	 * Lister les aidant d'un aidee
	 * @param IDAidee
	 * @return
	 */
	public List<?> allProchesByAidee(Integer IDAidee);
	
	

}
