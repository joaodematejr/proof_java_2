package br.com.cesusc.commons;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public class JpaUtils {
	private static final String ENTITY_MANAGER = "ENTITY_MANAGER";
	private static EntityManagerFactory EMF;

	public static void init() {
		if (EMF == null) {
			EMF = Persistence.createEntityManagerFactory("gym_db");
		}
	}

	public static void destroy() {
		EMF.close();
	}

	public static EntityManager EntityManager(ServletRequest req) {
		EntityManager em = EMF.createEntityManager();
		HttpServletRequest request = (HttpServletRequest) req;
		request.setAttribute(ENTITY_MANAGER, em);
		return em;
	}

	public static EntityManager EntityManager() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		EntityManager entityManager = (EntityManager) request.getAttribute(ENTITY_MANAGER);
		return entityManager;
	}

}