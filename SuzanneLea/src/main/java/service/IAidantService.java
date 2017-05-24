package service;

import java.util.List;

public interface IAidantService {
	
	public List<?> allMedecins();
	
	public List<?> allAidantsByType(Integer IDType);
	
	public List<?> allProchesByAidee(Integer IDAidee);
	
	

}
