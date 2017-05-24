package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Personne;

public interface IAideeService {
	
	public void inscriptionAidant (HttpServletRequest request, HttpServletResponse response);

	public List<Personne> allAidantsProches(Integer IDAidee);
	
	public Personne procheReferent (Integer IDAidee);
	
	public Personne medecinReferent (Integer IDAidee);
	
	
}
