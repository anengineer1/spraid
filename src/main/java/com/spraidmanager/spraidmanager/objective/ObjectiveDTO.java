package com.spraidmanager.spraidmanager.objective;

import java.util.List;

import com.spraidmanager.spraidmanager.raid.Raid;

public record ObjectiveDTO (String name, List<Raid> raids) {}
