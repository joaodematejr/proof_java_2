package br.com.cesusc.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

import br.com.cesusc.model.Client;
import br.com.cesusc.rn.ClientRn;

@ViewScoped
@ManagedBean
public class ClientMb {
	private Client client;
	private ClientRn clientRn;
	private List<Client> listClients;
	private Long updateId;
	
	
	public String salvar() {
		
		return null; 
		
	}

}
