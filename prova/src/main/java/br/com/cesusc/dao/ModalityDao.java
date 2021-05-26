package br.com.cesusc.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.cesusc.model.Client;
import br.com.cesusc.model.Modality;

public class ModalityDao extends Dao {

	public Client queryForId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Modality modality) {
		getEM().merge(modality);

	}

	@SuppressWarnings("unchecked")
	public List<Modality> listModalitys() {
		Query query = getEM().createQuery("From Modality", Modality.class);//
		return query.getResultList();
	}

}
