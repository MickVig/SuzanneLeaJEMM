package Presentation;

import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import bean.Agenda;
import dao.AgendaDAO;


public class Exec {

	public static void main(String[] args) {
		List<Agenda> listeAgenda = AgendaDAO.getInstance().readAllEvenement(1);
		for (Agenda agenda : listeAgenda) {
			System.out.println(agenda.getTitre()+" : "+agenda.getContenu());
		}
		System.out.println("fait");
		

	}

}
