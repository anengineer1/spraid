package com.spraidmanager.spraidmanager.unit;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unit")
public class UnitController {

	private final UnitService unitService;

	@Autowired
	public UnitController(UnitService unitService) {
		this.unitService = unitService;
	}

	@GetMapping("/{id}")
	public Unit getUnitById(@PathVariable("id") int id) {
		return this.unitService.getUnitById(id);
	}

	@GetMapping("/hp/greater/{hp}")
	public List<Unit> getUnitswithHpGreaterThan(@PathVariable("hp") BigDecimal base_hp) {
		return this.unitService.getUnitsWithHpGreaterThan(base_hp);
	}

	@GetMapping("/hp/lower/{hp}")
	public List<Unit> getUnitswithHpLowerThank(@PathVariable("hp") BigDecimal base_hp) {
		return this.unitService.getUnitsWithHpLessThan(base_hp);
	}

	@GetMapping("/attack/greater/{attack}")
	public List<Unit> getUnitsWithAttackForceGreaterThan(@PathVariable("attack") BigDecimal attack) {
		return this.unitService.getUnitsWithAttackForceGreaterThan(attack);
	}

	@GetMapping("/attack/lower/{attack}")
	public List<Unit> getUnitsWithAttackForceLessThan(@PathVariable("attack") BigDecimal attack) {
		return this.unitService.getUnitsWithAttackForceLessThan(attack);
	}

}
