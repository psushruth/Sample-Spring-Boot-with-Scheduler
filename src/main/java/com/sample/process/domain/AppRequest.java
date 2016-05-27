package com.sample.process.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class AppRequest {
	
	@Id
    @NotNull
    @Column(name = "id", nullable = false, updatable = false)
	String id;
	
	@NotNull
    @Column(name = "seed", nullable = false)
	int seed;
	
	public void setId(String missionId) {
		this.id = missionId;
	}
	
	public String getId() {
		return id;
	}
	
	public void setSeed(int seed) {
		this.seed = seed;
	}
	
	public int getSeed() {
		return seed;
	}
}
