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
	// Recuperer tous les evenements d'une personne aidee
	public List readAllEvenement(Integer ID_Aidee) {
		this.connexion();
		List listeAgenda = new ArrayList<Agenda>();
		try {
			// On selectionne les aidants d'un certain type
			Query requete = this.getEm().createQuery("SELECT a FROM Agenda a WHERE a.aidee.ID_Aidee=" + ID_Aidee);
			List<Agenda> liste = requete.getResultList();

			// on cree une nouvelle liste avec les informations qui nous
			// int�resse

			for (int i = 0; i < liste.size(); i++) {
				List l=new ArrayList();
				Agenda a = (Agenda) liste.get(i);
				a.getAidant();
				l.add(a);
				if(a.getAidant()!=null){
					l.add(a.getAidant().getPersonne());
				}
				System.out.println(l);
				listeAgenda.add(l);
			}
		} catch (Exception e) {
			throw new ExceptionDAO("Anomalie lors de l'execution de la requete");
		}
		this.deconnexion();
		return listeAgenda;
	}

	// Retourne tous les �venement � venir
	public List<Agenda> nextAllEvenement(Integer ID_Aidee) {
		this.connexion();
		List<Agenda> listeAgenda = new ArrayList<Agenda>();
		try {
			// On selectionne les aidants d'un certain type
			Query requete = this.getEm().createQuery("SELECT a FROM Agenda a WHERE a.aidee.ID_Aidee=" + ID_Aidee
					+ "AND a.date>CURRENT_DATE ORDER BY a.date");
			List<Agenda> liste = requete.getResultList();
			
			// on cree une liste d'agenda
			for (int i = 0; i < liste.size(); i++) {
				Agenda a = (Agenda) liste.get(i);
				System.out.println(a);
				listeAgenda.add(a);
			}
		} catch (Exception e) {
			throw new ExceptionDAO("Anomalie lors de l'execution de la requete");
		}
		this.deconnexion();
		return listeAgenda;
	}

	// Retourne le prochain evenement
	public Agenda nextEvenement(Integer ID_Aidee) {
		Agenda a = new Agenda();
		try {
			if (nextAllEvenement(ID_Aidee).size() != 0) {
				a = nextAllEvenement(ID_Aidee).get(0);
				System.out.println(a);
			}
		} catch (Exception e) {
			throw new ExceptionDAO("Anomalie lors de l'execution de la requete");
		}
		return a;
	}
	
	/////// CRUD \\\\\\\

	@Override
	public Agenda createEvenement(Date date, String titre, String contenu, Integer ID_Aidee, Integer ID_Aidant) {
		Agenda agenda = new Agenda();
		this.connexion();
		try {
			agenda.setAidant(AidantDAO.getInstance().readAidant(ID_Aidant));
			agenda.setAidee(AideeDAO.getInstance().readAidee(ID_Aidee));
			agenda.setContenu(contenu);
			agenda.setDate(date);
			agenda.setTitre(titre);
			this.getEm().persist(agenda);
			this.commit();
		} catch (Exception e) {
			throw new ExceptionDAO("Anomalie lors de l'execution de la requete");
		}
		this.deconnexion();
		return agenda;
	}

	@Override
	public Agenda readEvenement(Integer ID_Agenda) {
		this.connexion();
		Agenda a = new Agenda();
		try {
			a = this.getEm().find(Agenda.class, ID_Agenda);
			System.out.println(a);
		} catch (Exception e) {
			throw new ExceptionDAO("Anomalie lors de l'execution de la requete");
		}
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
