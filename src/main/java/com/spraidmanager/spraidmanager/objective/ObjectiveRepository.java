package com.spraidmanager.spraidmanager.objective;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjectiveRepository extends JpaRepository<Objective, Integer> {

	public Objective findById(int id);

	public List<Objective> findByName(String name);

}
