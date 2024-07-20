package com.spraidmanager.spraidmanager.unit;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spraidmanager.spraidmanager.squad.Squad;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;

@Entity
@Table
@Data
@SuppressWarnings("unused")
// @JsonIgnoreProperties({"squad"})
public class Unit {

	@Id
	@SequenceGenerator(name = "unit_sequence", sequenceName = "unit_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_sequence")
	private int id;

	@Nullable
	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name = "unit_id")
	@JsonIgnoreProperties({"units"})
	private Squad squad;

	private String name;
	private String build_type;
	private BigDecimal hp;
	private BigDecimal attackForce;

	public Unit() {

	}

	public Unit(String name, String build_type, BigDecimal hp, BigDecimal attackForce) {
		this.name = name;
		this.build_type = build_type;
		this.hp = hp;
		this.attackForce = attackForce;
	}

	public Unit(String name, String build_type, BigDecimal hp, Squad squad, BigDecimal attackForce) {
		this.name = name;
		this.build_type = build_type;
		this.hp = hp;
		this.attackForce = attackForce;
		this.squad = squad;
	}
}
