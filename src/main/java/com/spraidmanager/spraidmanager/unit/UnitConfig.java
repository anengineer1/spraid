package com.spraidmanager.spraidmanager.unit;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.spraidmanager.spraidmanager.squad.Squad;
import com.spraidmanager.spraidmanager.squad.SquadRepository;

@Configuration
public class UnitConfig {

	@Bean
	@Order(4)
	public CommandLineRunner insertSomeUnits(UnitRepository unitRepository, SquadRepository squadRepository) {
		return args -> {
			List<Squad> squads = squadRepository.findAll();
			Unit person1 = new Unit("Unit1", "Attacker", BigDecimal.valueOf(100), squads.get(1),
					BigDecimal.valueOf(100));

			Unit person2 = new Unit("Unit2", "Defender", BigDecimal.valueOf(150), squads.get(0),
					BigDecimal.valueOf(120));

			Unit person3 = new Unit("Unit3", "Support", BigDecimal.valueOf(80), squads.get(2),
					BigDecimal.valueOf(90));

			Unit person4 = new Unit("Unit4", "Healer", BigDecimal.valueOf(70), squads.get(3),
					BigDecimal.valueOf(110));

			Unit person5 = new Unit("Unit5", "Tank", BigDecimal.valueOf(200), squads.get(1),
					BigDecimal.valueOf(80));

			Unit person6 = new Unit("Unit6", "Sniper", BigDecimal.valueOf(90), squads.get(0),
					BigDecimal.valueOf(130));

			Unit person7 = new Unit("Unit7", "Mage", BigDecimal.valueOf(60), squads.get(3),
					BigDecimal.valueOf(150));

			Unit person8 = new Unit("Unit8", "Assassin", BigDecimal.valueOf(85), squads.get(3),
					BigDecimal.valueOf(140));

			Unit person9 = new Unit("Unit9", "Engineer", BigDecimal.valueOf(95), squads.get(0),
					BigDecimal.valueOf(105));

			Unit person10 = new Unit("Unit10", "Scout", BigDecimal.valueOf(75), squads.get(2),
					BigDecimal.valueOf(135));
			List<Unit> savedUnits = unitRepository.saveAll(List.of(person1, person2, person3, person4,
					person5, person6, person7, person8, person9, person10));
			System.out.println("Saved units: " + savedUnits.size());

		};
	}
}
