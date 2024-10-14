package com.spraidmanager.spraidmanager.raid;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spraidmanager.spraidmanager.objective.Objective;
import com.spraidmanager.spraidmanager.squad.Squad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@JsonIgnoreProperties("squads")
@NoArgsConstructor
public class Raid {

	@Id
	@SequenceGenerator(name = "raid_sequence", sequenceName = "raid_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "raid_sequence")
	private int id;

	@OneToMany(mappedBy = "raid")
	private List<Squad> squads;

	@Nullable
	@ManyToOne
	@JoinColumn(name = "raid_id")
	//@JsonIgnoreProperties({"raids", "hibernateLazyInitializer", "handler"})
	@JsonIgnoreProperties({"raids"})
	private Objective objective;

	private String name;
	private OffsetDateTime executionAtTime;
	private OffsetDateTime finishedAtTime;
	private String lead;


	public Raid(String name, String lead, Objective objective, OffsetDateTime executionAtTime,
			OffsetDateTime finishedAtTime) {
		this.name = name;
		this.executionAtTime = executionAtTime;
		this.finishedAtTime = finishedAtTime;
		this.lead = lead;
		this.objective = objective;
	}
}
