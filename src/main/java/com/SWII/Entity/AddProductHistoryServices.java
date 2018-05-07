package com.SWII.Entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SWII.Repositories.AddProductHistoryRepository;

@Service
public class AddProductHistoryServices {

	@Autowired
	AddProductHistoryRepository addHistoryrepo;

	public boolean save(AddProductHistory addHistory) {
		return addHistoryrepo.save(addHistory) != null;
	}

	public boolean delete(AddProductHistory addHistory) {
		if (!addHistoryrepo.existsById(addHistory.getAddProductId()))
			return false;
		addHistoryrepo.deleteById(addHistory.getAddProductId());
		return true;
	}

	public List<AddProductHistory> getActions(CollaboratorsEntity collaboratorsEntity) {
		return addHistoryrepo.findByCollaborato(collaboratorsEntity);
	}

}
