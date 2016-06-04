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
	String missionId;
	
	@NotNull
    @Column(name = "seed", nullable = false)
	int seed;
	
	public void setMissionId(String missionId) {
		this.missionId = missionId;
	}
	
	public String getMissionId() {
		return missionId;
	}
	
	public void setSeed(int seed) {
		this.seed = seed;
	}
	
	public int getSeed() {
		return seed;
	}
}
