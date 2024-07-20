package com.spraidmanager.spraidmanager.raid;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RaidRepository extends JpaRepository<Raid, Integer> {

	public Raid findById(int id);

	public List<Raid> findByName(String name);

	public List<Raid> findByLeadOrderByExecutionAtTime(String lead);

	public List<Raid> findByLeadOrderByExecutionAtTimeDesc(String lead);

}
