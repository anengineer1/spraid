package com.spraidmanager.spraidmanager.squad;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/squad")
public class SquadController {

	private SquadService squadService;

	@Autowired
	public SquadController(SquadService squadService) {
		this.squadService = squadService;
	}

	@GetMapping("")
	public List<Squad> getAllSquads() {
		return this.squadService.getAllSquads();
	}

	@GetMapping("/{id}")
	public Squad getSquadById(@PathVariable("id") int id) {
		return this.squadService.getSquadFromId(id);
	}

	@GetMapping("/owner/{name}")
	public List<Squad> getSquadsByOwner(@PathVariable("name") String name) {
		return this.squadService.getSquadsByOwner(name);
	}

	@GetMapping("/name/{name}")
	public List<Squad> getSquadsByName(@PathVariable("name") String name) {
		return this.squadService.getSquadsByName(name);
	}

	@GetMapping("/attack/greater/{attack}")
	public List<Squad> getSquadsByAttackForceGreaterThan(BigDecimal attack_force) {
		return this.squadService.getSquadsByAttackForceGreaterThan(attack_force);
	}

	@GetMapping("/attack/lower/{attack}")
	public List<Squad> getSquadsByAttackForceLowerThan(BigDecimal attack_force) {
		return this.squadService.getSquadsByAttackForceLessThan(attack_force);
	}
}
