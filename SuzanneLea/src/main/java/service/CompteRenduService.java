package service;

import java.util.List;

import bean.CompteRendu;

public class CompteRenduService implements ICompteRenduService {

	
	// Singleton
		private static ICompteRenduService instance = null;

		private CompteRenduService() {
		}

		public static synchronized ICompteRenduService getInstance() {
			if (instance == null) {
				instance = new CompteRenduService();
			}
			return instance;
		}
	
		public List<CompteRendu> getListCompteRendu(){
			return null;
			
		}

}
