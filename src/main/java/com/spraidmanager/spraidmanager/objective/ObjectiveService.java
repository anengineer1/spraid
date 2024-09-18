package com.spraidmanager.spraidmanager.objective;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjectiveService {

	private ObjectiveRepository objectiveRepository;

	@Autowired
	public ObjectiveService(ObjectiveRepository objectiveRepository) {
		this.objectiveRepository = objectiveRepository;
	}

	public List<Objective> getAllObjectives() {
		return this.objectiveRepository.findAll();
	}

	public Objective getObjectiveById(int id) {
		return this.objectiveRepository.findById(id);
	}

	public List<Objective> getObjectivesByName(String name) {
		return this.objectiveRepository.findByName(name);
	}

	public void insertObjective(Objective objective) {
		this.objectiveRepository.save(objective);
	}
}
