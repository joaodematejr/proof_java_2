package br.com.cesusc.rn;

import java.util.List;

import br.com.cesusc.dao.Dao;
import br.com.cesusc.dao.ModalityDao;
import br.com.cesusc.model.Modality;

public class ModalityRn extends Dao {

	private ModalityDao dao;

	public ModalityRn() {
		dao = new ModalityDao();
	}


	public void salvar(Modality modality) {
		dao.save(modality);
	}

	public List<Modality> listModalitys() {
		return dao.listModalitys();
	}

	public void delete(Long idModality) {
		dao.delete(idModality);

	}

	public Modality queryId(Long updateId) {
		return dao.queryForId(updateId);
	}

}
