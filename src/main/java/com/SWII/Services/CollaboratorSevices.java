package com.SWII.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SWII.Entity.CollaboratorsEntity;
import com.SWII.Repositories.CollaboratorRepository;

@Service
public class CollaboratorSevices {

	@Autowired
	CollaboratorRepository collaboratorRepo;

	public boolean saveCollaborator(CollaboratorsEntity collaborator) {
		return collaboratorRepo.save(collaborator) != null;
	}

	public CollaboratorsEntity load(int id) {
		return collaboratorRepo.findById(id).get();
	}
}
