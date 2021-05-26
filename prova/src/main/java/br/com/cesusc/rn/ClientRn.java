package br.com.cesusc.rn;

import java.util.List;

import br.com.cesusc.dao.ClientDao;
import br.com.cesusc.model.Client;

public class ClientRn {

	private ClientDao dao;

	public ClientRn() {
		dao = new ClientDao();
	}

	public void salvar(Client client) {
		dao.save(client);
	}

	public Client queryForRegistration(String registration) {
		return dao.queryForRegistration(registration);
	}

	public List<Client> listClients() {
		return dao.listClients();
	}

	public void delete(Long idClient) {
		dao.delete(idClient);

	}

	public Client queryId(Long updateId) {
		return dao.queryForId(updateId);
	}

}
