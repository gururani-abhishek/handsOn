package com.hsbc.service;

import java.util.List;

import com.hsbc.entity.ConceptualTraining;
import com.hsbc.entity.Employee;
import com.hsbc.entity.PracticalTraining;
import com.hsbc.exception.EmployeeAlreadyExists;
import com.hsbc.exception.TrainingAlreadyExists;
import com.hsbc.exception.TrainingNotAvailable;
import com.hsbc.repository.Repository;

public interface Service {
	
	void createEmployee(Employee e) throws EmployeeAlreadyExists;
	void createTraining(int trainingId, String nameOfCourse, List<String> skills, String startDate, String endDate) throws TrainingAlreadyExists;
	void createTraining(int trainingId, String nameOfCourse, List<String> skills, String startDate, String endDate, double duration) throws TrainingAlreadyExists;
	void registerForTraining(Employee e, int trainingId, boolean type) throws TrainingNotAvailable;

}
