package com.spraidmanager.spraidmanager.unit;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Try if component also works
public class UnitService {

	private final UnitRepository unitRepository;

	@Autowired // not necessary on newere versions of spring
	public UnitService(UnitRepository unitRepository) {
		this.unitRepository = unitRepository;
	}

	public Unit getUnitById(int id) {
		return this.unitRepository.findById(id);
	}

	public List<Unit> getUnitsWithHpGreaterThan(BigDecimal base_hp) {
		return this.unitRepository.findByHpGreaterThan(base_hp);
	}

	public List<Unit> getUnitsWithHpLessThan(BigDecimal base_hp) {
		return this.unitRepository.findByHpLessThan(base_hp);
	}

	public List<Unit> getUnitsWithAttackForceGreaterThan(BigDecimal attack) {
		return this.unitRepository.findByAttackForceGreaterThan(attack);
	}

	public List<Unit> getUnitsWithAttackForceLessThan(BigDecimal attack) {
		return this.unitRepository.findByAttackForceLessThan(attack);
	}

}
