package com.spraidmanager.spraidmanager.squad;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SquadService {

	private SquadRepository squadRepository;

	@Autowired
	public SquadService(SquadRepository squadRepository) {
		this.squadRepository = squadRepository;
	}

	public Squad getSquadFromId(int id) {
		return this.squadRepository.findById(id);
	}

	public List<Squad> getAllSquads() {
		return this.squadRepository.findAll();
	}

	public List<Squad> getSquadsByOwner(String name) {
		return this.squadRepository.findByOwner(name);
	}

	public List<Squad> getSquadsByName(String name) {
		return this.squadRepository.findByName(name);
	}

	public List<Squad> getSquadsByAttackForceGreaterThan(BigDecimal attack) {
		return this.squadRepository.findByAttackForceGreaterThan(attack);
	}

	public List<Squad> getSquadsByAttackForceLessThan(BigDecimal attack) {
		return this.squadRepository.findByAttackForceLessThan(attack);
	}

}
