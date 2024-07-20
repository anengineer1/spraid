package com.spraidmanager.spraidmanager.objective;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/objective")
public class ObjectiveController {

	private ObjectiveService objectiveService;

	@Autowired
	public ObjectiveController(ObjectiveService objectiveService) {
		this.objectiveService = objectiveService;
	}

	@GetMapping("/{id}")
	public Objective getObjectiveById(@PathVariable("id") int id) {
		return this.objectiveService.getObjectiveById(id);
	}

	@GetMapping("/name/{name}")
	public List<Objective> getObjectiveByName(@PathVariable("name") String name) {
		return this.objectiveService.getObjectivesByName(name);
	}

	@PostMapping
	public void insertObjective(@RequestBody ObjectiveDTO objective) {
		this.objectiveService.insertObjective(new Objective(objective.name()));
	}

}
