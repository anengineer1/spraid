package com.spraidmanager.spraidmanager.raid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaidService {

	private RaidRepository raidRepository;

	@Autowired
	public RaidService(RaidRepository raidRepository) {
		this.raidRepository = raidRepository;
	}

	public Raid getRaidById(int id) {
		return this.raidRepository.findById(id);
	}

	public List<Raid> getAllRaids() {
		return this.raidRepository.findAll();
	}

	public List<Raid> getRaidByName(String name) {
		return this.raidRepository.findByName(name);
	}

	public List<Raid> getRaidByLeadOrderByExecutionAtTimeAsc(String lead) {
		return this.raidRepository.findByLeadOrderByExecutionAtTime(lead);
	}

	public List<Raid> getRaidByLeadOrderByExecutionAtTimeDesc(String lead) {
		return this.raidRepository.findByLeadOrderByExecutionAtTimeDesc(lead);
	}

}
