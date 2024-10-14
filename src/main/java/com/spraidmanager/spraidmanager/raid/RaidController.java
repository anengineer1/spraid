package com.spraidmanager.spraidmanager.raid;

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

import com.spraidmanager.spraidmanager.objective.Objective;
import com.spraidmanager.spraidmanager.objective.ObjectiveService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/raid")
public class RaidController {

	private RaidService raidService;
	private ObjectiveService objectiveService;

	@Autowired
	public RaidController(RaidService raidService, ObjectiveService objectiveService) {
		this.raidService = raidService;
		this.objectiveService = objectiveService;
	}

	@GetMapping("")
	public List<Raid> getAllRaids() {
		return this.raidService.getAllRaids();
	}

	@GetMapping("/{id}")
	public Raid getRaidByID(@PathVariable("id") int id) {
		return this.raidService.getRaidById(id);
	}

	@GetMapping("/name/{name}")
	public List<Raid> getRaidByName(@PathVariable("name") String name) {
		return this.raidService.getRaidByName(name);
	}

	@GetMapping("/lead/time/asc/{lead}")
	public List<Raid> getRaidByLeadOrderByExecutionAtTimeAsc(@PathVariable("lead") String lead) {
		return this.raidService.getRaidByLeadOrderByExecutionAtTimeAsc(lead);
	}

	@GetMapping("/lead/time/asc/{name}")
	public List<Raid> getRaidByLeadOrderByExecutionAtTimeDesc(@PathVariable("lead") String lead) {
		return this.raidService.getRaidByLeadOrderByExecutionAtTimeDesc(lead);
	}

	@GetMapping("/objective/id/{objectiveId}")
	public List<Raid> getRaidByObjectiveId(@PathVariable("objectiveId") int objectiveId) {
		return this.raidService.getRaidByObjectiveId(objectiveId);
	}

	@PutMapping("/{raidId}")
	public ResponseEntity<Raid> updateRaid(@PathVariable("raidId") int raidId,
			@RequestBody RaidUpdateDTO raidUpdateDTO) {
		System.out.println("Arrived id " + raidId);
		System.out.println("Payload " + raidUpdateDTO.toString());
		Raid storedRaid = this.raidService.getRaidById(raidId);

		if (storedRaid == null) {
			throw new EntityNotFoundException("Raid with id " + raidId + " not found");
		}

		Objective objective = this.objectiveService.getObjectiveById(raidId);

		if (objective == null) {
			throw new EntityNotFoundException(
					"Objective with id " + raidUpdateDTO.objectiveId() + " not found");
		}

		// Set the new instance to update the database
		storedRaid.setName(raidUpdateDTO.name());
		storedRaid.setExecutionAtTime(raidUpdateDTO.executionAtTime());
		storedRaid.setFinishedAtTime(raidUpdateDTO.finishedAtTime());
		storedRaid.setLead(raidUpdateDTO.lead());
		storedRaid.setObjective(objective);

		return ResponseEntity.ok(new Raid());
	}

}
