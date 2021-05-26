package br.com.cesusc.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.cesusc.model.Modality;
import br.com.cesusc.rn.ModalityRn;

@ViewScoped
@ManagedBean
public class ModalityMb {
	private Modality modality;
	private ModalityRn modalityRn;
	private List<Modality> listModalitys;

	@PostConstruct
	public void init() {
		modality = new Modality();
		modalityRn = new ModalityRn();
	}

	public Modality getModality() {
		return modality;
	}

	public void setClient(Modality modality) {
		this.modality = modality;
	}

	public ModalityRn getModalityRn() {
		return modalityRn;
	}

	public void setModalityRn(ModalityRn modalityRn) {
		this.modalityRn = modalityRn;
	}

	public String salvar() {
		if (modality.getDescription().length() == 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Descrição Vazia Burro !!!", ""));
		} else {
			modalityRn.salvar(modality);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Parabéns!!! Você conseguiu chegar até aqui, Salvou", ""));
			modality = new Modality();
		}
		return null;

	}

	public List<Modality> getListModalitys() {
		if (listModalitys == null) {
			listModalitys = modalityRn.listModalitys();
		}
		System.out.println(listModalitys);
		return listModalitys;
	}

	public void setListModalitys(List<Modality> listModalitys) {
		this.listModalitys = listModalitys;
	}

}
