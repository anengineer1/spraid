package com.spraidmanager.spraidmanager.unit;

import java.math.BigDecimal;

import com.spraidmanager.spraidmanager.squad.Squad;

public record UnitDTO (Squad squad, String name, String build_type, BigDecimal hp, BigDecimal attack_force) {}
