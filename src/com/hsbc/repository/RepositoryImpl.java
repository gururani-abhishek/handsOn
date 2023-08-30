package com.hsbc.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hsbc.entity.ConceptualTraining;
import com.hsbc.entity.Employee;
import com.hsbc.entity.PracticalTraining;
import com.hsbc.exception.EmployeeAlreadyExists;
import com.hsbc.exception.TrainingAlreadyExists;
import com.hsbc.exception.TrainingNotAvailable;

// implementation of repository class that directly interacts with the database(here collections)
public class RepositoryImpl implements Repository {

	Map<Integer, Employee> employees = new HashMap<>();
	Map<Integer, PracticalTraining> pTrainings = new HashMap<>();
	Map<Integer, ConceptualTraining> cTrainings = new HashMap<>();
	List<Employee> pTEmployees = new ArrayList<>();
	List<Employee> cTEmployees = new ArrayList<>();
	
	@Override
	public void addEmployee(Employee e) throws EmployeeAlreadyExists {

		// first search for the employee
			// if found throw exception
			// else 
			// add employee
		if(employees.containsKey(e.getEmpId())) {
			throw new EmployeeAlreadyExists("employee already exists -> " + e);
		} else {
			employees.put(e.getEmpId(), e);
		}
		
	}

	@Override
	public void addPracticalTraining(PracticalTraining t) throws TrainingAlreadyExists {

		// first search for the training 
			// if found throw exception 
			// else 
			// add training 
		if(pTrainings.containsKey(t.getTrainingId())) {
			throw new TrainingAlreadyExists("training already exits -> " + t.getTrainingId());
		} else {
			pTrainings.put(t.getTrainingId(), t);
		}
	}

	@Override
	public void addConceptualTraining(ConceptualTraining t) throws TrainingAlreadyExists {
		
		// check if training is available in the database 
			// if found throws exception
			// else add the training to database(here collection)
		if(cTrainings.containsKey(t.getTrainingId())) {
			throw new TrainingAlreadyExists("training already exits -> " + t.getTrainingId());
		} else {
			cTrainings.put(t.getTrainingId(), t);
		}
		
	}

	@Override
	public void registerForPracticalTraining(Employee e, int trainingId) throws TrainingNotAvailable {
		// first search for trainingId 
			// if not found throw exception
			// else 
			// register
		
		if(!pTrainings.containsKey(trainingId)) {
			throw new TrainingNotAvailable("training not availabe -> " + trainingId);
		} else {
			pTEmployees.add(e);
		}
		
	}

	@Override
	public void registerForConceptualTraining(Employee e, int trainingId) throws TrainingNotAvailable {
		// first search for trainingId 
					// if not found throw exception
					// else 
					// register
				
				if(!cTrainings.containsKey(trainingId)) {
					throw new TrainingNotAvailable("training not availabe -> " + trainingId);
				} else {
					cTEmployees.add(e);
				}
		
	}

}
