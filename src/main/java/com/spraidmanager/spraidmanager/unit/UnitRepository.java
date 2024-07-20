package com.spraidmanager.spraidmanager.unit;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit, Integer> {

	Unit findById(int id);

	List<Unit> findByHpGreaterThan(BigDecimal hp);

	List<Unit> findByHpLessThan(BigDecimal hp);

	List<Unit> findByAttackForceGreaterThan(BigDecimal hp);

	List<Unit> findByAttackForceLessThan(BigDecimal hp);

}
