package service;

import java.util.List;

import bean.Personne;

public interface IAideeService {

	public List allAidantsProches(Integer IDAidee);
	
	public Personne procheReferent (Integer IDAidee);
	
	public Personne medecinReferent (Integer IDAidee);
	
	
}
