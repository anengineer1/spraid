package com.spraidmanager.spraidmanager.raid;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;

import com.spraidmanager.spraidmanager.objective.Objective;
import com.spraidmanager.spraidmanager.objective.ObjectiveRepository;

@Configuration
public class RaidConfig {

	@Bean("insertRaids")
	@DependsOn("insertObjectives")
	@Order(2)
	@Autowired
	CommandLineRunner insertSomeRaids(RaidRepository raidRepository, ObjectiveRepository objectiveRepository) {
		return args -> {
			List<Objective> objectives = objectiveRepository.findAll();
			Raid OlhiRaid = new Raid("0lhis's raid", "Olhi", objectives.get(0),
					OffsetDateTime.of(2024, 12, 25, 12, 12, 12, 0, ZoneOffset.UTC),
					OffsetDateTime.of(2024, 12, 25, 12, 12, 12, 0, ZoneOffset.UTC));

			Raid deavidRaid = new Raid("Deavid's Raid", "Deavid", objectives.get(1),
					OffsetDateTime.now(),
					null);

			Raid futureRaid = new Raid("Franzo's Raid", "Franzo", objectives.get(2),
					OffsetDateTime.of(2025, 7, 1, 9, 0, 0, 0, ZoneOffset.UTC),
					null);

			Raid pastRaid = new Raid("Past Raid", "Wolfy", objectives.get(1),
					OffsetDateTime.of(2023, 3, 15, 14, 30, 0, 0, ZoneOffset.UTC),
					OffsetDateTime.of(2023, 3, 16, 2, 45, 0, 0, ZoneOffset.UTC));
			List<Raid> savedRaids = raidRepository
					.saveAll(List.of(OlhiRaid, deavidRaid, futureRaid, pastRaid));
			System.out.println("Saved raids: " + savedRaids.size());
		};
	}
}
