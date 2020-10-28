package br.com.asv.model.entities.history;

import java.util.List;

public interface IBaseHistoryListEntity<H> extends IBaseHistoryEntity{

	H createHistories();
	List<H> getHistories();
	void setHistories(List<H> histories);
	void processHistories();
}