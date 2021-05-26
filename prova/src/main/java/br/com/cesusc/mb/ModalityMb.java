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
	private Long updateId;
	public String count = "0";

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
		return "listModalities.xhtml";

	}

	public List<Modality> getListModalitys() {
		if (listModalitys == null) {
			listModalitys = modalityRn.listModalitys();
		}
		return listModalitys;
	}

	public void setListModalitys(List<Modality> listModalitys) {
		this.listModalitys = listModalitys;
	}

	public String handleDelete(String id) {
		Long idModalityRn = Long.parseLong(id);
		modalityRn.delete(idModalityRn);
		return "listModalities.xhtml";

	}

	public Long getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Long updateId) {
		this.updateId = updateId;
	}

	public void uploadEdition() {
		if (updateId != null && !FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()) {
			modality = modalityRn.queryId(updateId);
		}
	}

	public String getCount() {
		if (listModalitys == null) {
			listModalitys = modalityRn.listModalitys();
		}
		return Integer.toString(listModalitys.size());
	}

	public void setCount(String count) {
		this.count = count;
	}

	public void setModality(Modality modality) {
		this.modality = modality;
	}

}
