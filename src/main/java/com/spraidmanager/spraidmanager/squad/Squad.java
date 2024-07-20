package com.spraidmanager.spraidmanager.squad;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spraidmanager.spraidmanager.raid.Raid;
import com.spraidmanager.spraidmanager.unit.Unit;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
@JsonIgnoreProperties("units")
public class Squad {

	@Id
	@SequenceGenerator(name = "squad_sequence", sequenceName = "squad_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "squad_sequence")
	private int id;

	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name = "squad_id")
	@JsonIgnoreProperties({"squads"})
	private Raid raid;

	@OneToMany(mappedBy = "squad")
	private List<Unit> units;

	private String name;
	private String owner;
	private BigDecimal attackForce;

	public Squad() {

	}

	public Squad(String name, String owner, BigDecimal attackForce) {
		this.name = name;
		this.owner = owner;
		this.attackForce = attackForce;
	}

	public Squad(String name, String owner, Raid raid, BigDecimal attackForce) {
		this.name = name;
		this.owner = owner;
		this.attackForce = attackForce;
		this.raid = raid;
	}

}
