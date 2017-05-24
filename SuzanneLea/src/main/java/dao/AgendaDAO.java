package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import bean.Agenda;
import bean.Aidant;
import bean.Aidee;

public class AgendaDAO extends ConnexionDAO implements IAgendaDAO {

	private static IAgendaDAO instance = null;

	private AgendaDAO() {
	}

	public static synchronized IAgendaDAO getInstance() {
		if (instance == null) {
			instance = new AgendaDAO();
		}
		return instance;
	}

	/////// Autres Requetes \\\\\\\
	// Recuperer tous les evenement d'une personne aidee
	public List<Agenda> readAllEvenement(Integer ID_Aidee) {
		this.connexion();
		// On selectionne les aidants d'un certain type
		Query requete = this.getEm().createQuery("SELECT a FROM Agenda a WHERE a.aidee.ID_Aidee=" + ID_Aidee);
		List<Agenda> liste = requete.getResultList();

		// on cree une nouvelle liste avec les informations qui nous intéresse
		List<Agenda> listeAgenda = new ArrayList<Agenda>();
		for (int i = 0; i < liste.size(); i++) {
			Agenda a = (Agenda) liste.get(i);
			listeAgenda.add(a);
			// System.out.println(a.getTitre()+" : "+a.getContenu());
		}
		this.deconnexion();
		return listeAgenda;
	}

	//Retourne tous les évenement à venir
	public List<Agenda> nextAllEvenement(Integer ID_Aidee) {
		this.connexion();
		// On selectionne les aidants d'un certain type
		Query requete = this.getEm()
				.createQuery("SELECT a FROM Agenda a WHERE a.aidee.ID_Aidee=" + ID_Aidee + "AND a.date>CURRENT_DATE ORDER BY a.date");
		List<Agenda> liste = requete.getResultList();

		// on cree une nouvelle liste avec les informations qui nous intéresse
		List<Agenda> listeAgenda = new ArrayList<Agenda>();
		for (int i = 0; i < liste.size(); i++) {
			Agenda a = (Agenda) liste.get(i);
			listeAgenda.add(a);
			System.out.println(a.getTitre() + " : " + a.getContenu() + " (" + a.getDate() + ")");
		}
		this.deconnexion();
		return listeAgenda;
	}

	//Retourne le prochain evenement
	public Agenda nextEvenement (Integer ID_Aidee) {
		Agenda a=new Agenda();
		if (nextAllEvenement(ID_Aidee).size()!=0) {
			a=nextAllEvenement(ID_Aidee).get(0);
		}
		System.out.println(a.getTitre() + " : " + a.getContenu() + " (" + a.getDate() + ")");
		return a;
	}
	/////// CRUD \\\\\\\

	@Override
	public Agenda createEvenement(Date date, String titre, String contenu, Integer ID_Aidee, Integer ID_Aidant) {
		Agenda agenda = new Agenda();
		this.connexion();
		agenda.setAidant(AidantDAO.getInstance().readAidant(ID_Aidant));
		agenda.setAidee(AideeDAO.getInstance().readAidee(ID_Aidee));
		agenda.setContenu(contenu);
		agenda.setDate(date);
		agenda.setTitre(titre);
		this.getEm().persist(agenda);
		this.commit();
		this.deconnexion();
		return agenda;
	}

	@Override
	public Agenda readEvenement(Integer ID_Agenda) {
		this.connexion();
		Agenda a = this.getEm().find(Agenda.class, ID_Agenda);
		System.out.println(a);
		this.deconnexion();
		return a;
	}

	@Override
	public void updateEvenement(Date date, String titre, String contenu, Aidee aidee, Aidant aidant) {
		this.connexion();
		// TODO Auto-generated method stub
		this.commit();
		this.deconnexion();
	}

	@Override
	public void supprEvenement(Integer id) {
		this.connexion();

		this.commit();
		this.deconnexion();
	}
}
