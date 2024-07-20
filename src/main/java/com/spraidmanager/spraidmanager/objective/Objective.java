package com.spraidmanager.spraidmanager.objective;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spraidmanager.spraidmanager.raid.Raid;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@JsonIgnoreProperties("raids")
public class Objective {

	@Id
	@SequenceGenerator(name = "objective_sequence", sequenceName = "objective_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "objective_sequence")
	private int id;

	@JsonIgnoreProperties("objective")
	@OneToMany(mappedBy = "objective")
	private List<Raid> raids;

	private String name;

	public Objective(String name) {
		this.name = name;
	}
}
