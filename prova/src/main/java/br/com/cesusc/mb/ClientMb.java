package br.com.cesusc.mb;

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
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nome Vazio Burro !!!", ""));
		}
		else if (client.getRegistration().length() == 0) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Matrícula Vazio Burro !!!", ""));
		}else {
			clientRn.salvar(client);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Parabéns!!! Você conseguiu chegar até aqui, Salvou", ""));
			client = new Client();
		}
		System.out.println(client.getModality());
		return null;

	}

}
