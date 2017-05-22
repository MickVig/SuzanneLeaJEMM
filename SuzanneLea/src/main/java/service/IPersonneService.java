package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IPersonneService {

	public boolean connexion(HttpServletRequest request, HttpServletResponse response);
}
