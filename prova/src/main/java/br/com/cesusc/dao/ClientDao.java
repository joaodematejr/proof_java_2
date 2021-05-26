package br.com.cesusc.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.cesusc.model.Client;

public class ClientDao extends Dao {

	public Client queryForId(Long id) {
		return getEM().find(Client.class, id);
	}

	public void save(Client client) {
		getEM().merge(client);

	}

	public Client queryForRegistration(String registration) {
		// TODO Auto-generated method stub
		return null;
	}


	@SuppressWarnings("unchecked")
	public List<Client> listClients() {
		// TODO Auto-generated method stub
		Query query = getEM().createQuery("From Client", Client.class);//
		return query.getResultList();
	}

	public void delete(Long idClient) {
		Client client = getEM().getReference(Client.class, idClient);
		getEM().remove(client);
		
	}

}
