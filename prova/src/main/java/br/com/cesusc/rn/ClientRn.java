package br.com.cesusc.rn;

import java.util.List;

import br.com.cesusc.dao.ClientDao;
import br.com.cesusc.model.Client;

public class ClientRn {

	private ClientDao dao;

	public ClientRn() {
		dao = new ClientDao();
	}

	public Client buscarPorId(Long id) {
		return dao.queryForId(id);
	}
	
	public void salvar(Client client) {
		dao.save(client);
	}
	
	public Client queryForRegistration(String registration) {
		return dao.queryForRegistration(registration);
	}
	

	public List<Client> listClients() {
		// TODO Auto-generated method stub
		return dao.listClients();
	}

}
