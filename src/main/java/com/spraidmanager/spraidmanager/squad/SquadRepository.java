package com.spraidmanager.spraidmanager.squad;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SquadRepository extends JpaRepository<Squad, Integer> {

	Squad findById(int id);

	List<Squad> findByName(String name);

	List<Squad> findByOwner(String name);

	List<Squad> findByAttackForceGreaterThan(BigDecimal attack);

	List<Squad> findByAttackForceLessThan(BigDecimal attack);

}
