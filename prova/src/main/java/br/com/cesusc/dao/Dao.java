package br.com.cesusc.dao;

import javax.persistence.EntityManager;

import br.com.cesusc.commons.JpaUtils;

public abstract class Dao {
	private EntityManager entityManager = null;

	public Dao() {
		super();
	}

	public Dao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	protected EntityManager getEM() {
		if (this.entityManager == null) {
			return JpaUtils.EntityManager();
		}
		return this.entityManager;

	}
}