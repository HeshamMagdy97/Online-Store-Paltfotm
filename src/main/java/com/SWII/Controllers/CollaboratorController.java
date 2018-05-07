package com.SWII.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SWII.Entity.CollaboratorsEntity;
import com.SWII.Services.CollaboratorSevices;

@RestController
@RequestMapping("/collaborator")
public class CollaboratorController {
	
	@Autowired
	CollaboratorSevices collaboratorSevice;
	
	@RequestMapping("/add")
	public boolean addCollaborator(@RequestBody CollaboratorsEntity collaborator) {
		return collaboratorSevice.saveCollaborator(collaborator);
	}
}
