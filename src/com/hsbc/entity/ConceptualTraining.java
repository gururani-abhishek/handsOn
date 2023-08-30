package com.hsbc.entity;

import java.util.List;

// entity data class for ConceptualTraining objects
public class ConceptualTraining {

	private int trainingId;
	private String nameOfCourse;
	private List<String> skillsAccquired;
	private String startDate;
	private String endDate;
	
	public ConceptualTraining(int trainingId, String nameOfCourse, List<String> skillsAccquired, String startDate,
			String endDate) {
		super();
		this.trainingId = trainingId;
		this.nameOfCourse = nameOfCourse;
		this.skillsAccquired = skillsAccquired;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public String getNameOfCourse() {
		return nameOfCourse;
	}

	public void setNameOfCourse(String nameOfCourse) {
		this.nameOfCourse = nameOfCourse;
	}

	public List<String> getSkillsAccquired() {
		return skillsAccquired;
	}

	public void setSkillsAccquired(List<String> skillsAccquired) {
		this.skillsAccquired = skillsAccquired;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
}
