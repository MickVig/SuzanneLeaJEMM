package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Agenda;
import bean.Personne;

public interface IAideeService {
	
	public Boolean inscriptionAidant (HttpServletRequest request, HttpServletResponse response);

	public List<Personne> allAidantsProches(Integer IDAidee);
	
	public List allRDV (Integer IDAidee);
	
	public List allCR (Integer IDAidee) ;
	
	public Personne procheReferent (Integer IDAidee);
	
	public Personne medecinReferent (Integer IDAidee);
	
	public void addEvent (HttpServletRequest request, HttpServletResponse response) ;
	
	public void addCR (HttpServletRequest request, HttpServletResponse response);
	
	public List lastCompteRendu(Integer Id_Aidee);
	
	public Agenda nextEvenement(Integer Id_Aidee);
	
}
