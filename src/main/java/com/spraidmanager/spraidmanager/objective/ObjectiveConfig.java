package com.spraidmanager.spraidmanager.objective;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class ObjectiveConfig {

	@Bean("insertObjectives")
	@Order(1)
	@Autowired
	CommandLineRunner insertSomeObjectives(ObjectiveRepository repository) {
		return args -> {
			Objective firstBoss = new Objective("First boss");
			Objective secondBoss = new Objective("Second boss");
			Objective takeSword = new Objective("Take legendary sword");
			List<Objective> savedObjectives = repository.saveAll(List.of(firstBoss, secondBoss, takeSword));
			System.out.println("Saved objectives: " + savedObjectives.size());
		};
	}
}
