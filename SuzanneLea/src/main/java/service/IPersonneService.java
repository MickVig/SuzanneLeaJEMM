package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IPersonneService {

	public boolean connexion(HttpServletRequest request, HttpServletResponse response);
	
	public Boolean inscription(HttpServletRequest request, HttpServletResponse response);
	
	//public void inscriptionAidant (HttpServletRequest request, HttpServletResponse response);
	
	
}
