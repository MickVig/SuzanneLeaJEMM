package Presentation;

import java.util.List;

import bean.Agenda;
import dao.AgendaDAO;


public class Exec {

	public static void main(String[] args) {
		List<Agenda> listeAgenda = AgendaDAO.getInstance().nextAllEvenement(1);
		/*for (Agenda agenda : listeAgenda) {
			System.out.println(agenda.getTitre()+" : "+agenda.getContenu());
		}*/
		
		AgendaDAO.getInstance().nextEvenement(1);
		System.out.println("fait");
		

	}

}
