package com.spraidmanager.spraidmanager.squad;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;

import com.spraidmanager.spraidmanager.raid.Raid;
import com.spraidmanager.spraidmanager.raid.RaidRepository;

@Configuration
public class SquadConfig {

	@Bean("insertSquads")
	@DependsOn("insertRaids")
	@Order(3)
	@Autowired
	CommandLineRunner insertSomeSquads(SquadRepository squadRepository, RaidRepository raidRepository) {
		return args -> {
			List<Raid> some_raids = raidRepository.findAll();
			Squad olhiSquad = new Squad("0lhi's Squad", "0lhi", some_raids.get(0), new BigDecimal(22));
			Squad deavidSquad = new Squad("Deavid Squad", "Deavid", some_raids.get(1), new BigDecimal(22));
			Squad franzoSquad = new Squad("Franzo Squad", "Franzo", some_raids.get(2), new BigDecimal(22));
			Squad wolfySquad = new Squad("Wolfy Squad", "Wolfy", some_raids.get(3), new BigDecimal(22));
			List<Squad> savedSquads = squadRepository
					.saveAll(List.of(olhiSquad, deavidSquad, franzoSquad, wolfySquad));
			System.out.println("Saved squads: " + savedSquads.size());
		};
	}
}
