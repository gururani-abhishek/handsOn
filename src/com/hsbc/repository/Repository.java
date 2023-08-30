package com.hsbc.repository;

import com.hsbc.entity.ConceptualTraining;
import com.hsbc.entity.Employee;
import com.hsbc.entity.PracticalTraining;
import com.hsbc.exception.EmployeeAlreadyExists;
import com.hsbc.exception.TrainingAlreadyExists;
import com.hsbc.exception.TrainingNotAvailable;

public interface Repository {
	
	void addEmployee(Employee e) throws EmployeeAlreadyExists;
	void addPracticalTraining(PracticalTraining t) throws TrainingAlreadyExists;
	void addConceptualTraining(ConceptualTraining t) throws TrainingAlreadyExists;
	void registerForPracticalTraining(Employee e, int trainingId) throws TrainingNotAvailable;
	void registerForConceptualTraining(Employee e, int trainingId) throws TrainingNotAvailable;
	
}
