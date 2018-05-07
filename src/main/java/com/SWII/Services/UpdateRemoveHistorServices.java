package com.SWII.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SWII.Repositories.UpdateRemoveHistoryRepository;

@Service
public class UpdateRemoveHistorServices {

	@Autowired
	UpdateRemoveHistoryRepository historyRepository;
	
	
	
}
