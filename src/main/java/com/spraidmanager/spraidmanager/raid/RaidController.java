package com.spraidmanager.spraidmanager.raid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/raid")
public class RaidController {

	private RaidService raidService;

	@Autowired
	public RaidController(RaidService raidService) {
		this.raidService = raidService;
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

}
