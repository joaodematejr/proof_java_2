package br.com.cesusc.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.cesusc.model.Client;
import br.com.cesusc.rn.ClientRn;

@ViewScoped
@ManagedBean
public class ClientMb {
	private Client client;
	private ClientRn clientRn;
	private List<Client> listClients;
	public String count = "0";
	private Long updateId;

	@PostConstruct
	public void init() {
		client = new Client();
		clientRn = new ClientRn();
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ClientRn getClientRn() {
		return clientRn;
	}

	public void setClientRn(ClientRn clientRn) {
		this.clientRn = clientRn;
	}

	public String salvar() {
		if (client.getName().length() == 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Nome Vazio Burro !!!", ""));
		} else if (client.getRegistration().length() == 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Matrícula Vazio Burro !!!", ""));
		} else {
			clientRn.salvar(client);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Parabéns!!! Você conseguiu chegar até aqui, Salvou", ""));
			client = new Client();
		}
		System.out.println(client.getModality());
		return "listClients.xhtml";

	}

	public List<Client> getListClients() {
		if (listClients == null) {
			listClients = clientRn.listClients();
		}
		return listClients;
	}

	public void setListClients(List<Client> listClients) {
		this.listClients = listClients;
	}

	public String getCount() {
		if (listClients == null) {
			listClients = clientRn.listClients();
		}
		return Integer.toString(listClients.size());
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String handleDelete(String id) {
		Long idClient = Long.parseLong(id);
		clientRn.delete(idClient);
		return "listClients.xhtml";

	}

	public Long getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Long updateId) {
		this.updateId = updateId;
	}
	
	public void uploadEdition() {
		if (updateId != null && !FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()) {
			client = clientRn.queryId(updateId);
		}
	}

}
