package com.spraidmanager.spraidmanager.objective;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/objective")
public class ObjectiveController {

	private ObjectiveService objectiveService;

	@Autowired
	public ObjectiveController(ObjectiveService objectiveService) {
		this.objectiveService = objectiveService;
	}

	@GetMapping("")
	public List<Objective> getAllObjectives() {
		return this.objectiveService.getAllObjectives();
	}

	@GetMapping("/{id}")
	public Objective getObjectiveById(@PathVariable("id") int id) {
		return this.objectiveService.getObjectiveById(id);
	}

	@GetMapping("/name/{name}")
	public List<Objective> getObjectiveByName(@PathVariable("name") String name) {
		return this.objectiveService.getObjectivesByName(name);
	}

	@PostMapping("")
	public void insertObjective(@RequestBody Objective objective) {
		this.objectiveService.insertObjective(objective);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Objective> updateObjective(@RequestBody ObjectiveUpdateDTO objectiveDTO,
			@PathVariable("id") int id) {
		Objective objectiveToSave = this.objectiveService.getObjectiveById(id);
		System.out.println("Arrived id " + id);
		System.out.println("Payload " + objectiveDTO.toString());
		if (objectiveToSave == null) {
			throw new EntityNotFoundException("Objective with id: " + id + " not found");
		}
		objectiveToSave.setName(objectiveDTO.name());
		return ResponseEntity.ok(this.objectiveService.modifyObjective(objectiveToSave));
	}
}
