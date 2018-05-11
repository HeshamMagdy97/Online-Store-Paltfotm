package com.SWII.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SWII.Entity.AddProductHistory;
import com.SWII.Entity.CollaboratorsEntity;

public interface AddProductHistoryRepository extends CrudRepository<AddProductHistory, Integer> {
	public List<AddProductHistory> findByCollaborato(CollaboratorsEntity collaborato);
}
