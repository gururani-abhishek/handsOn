package com.hsbc.service;

import java.util.List;

import com.hsbc.entity.ConceptualTraining;
import com.hsbc.entity.Employee;
import com.hsbc.entity.PracticalTraining;
import com.hsbc.exception.EmployeeAlreadyExists;
import com.hsbc.exception.TrainingAlreadyExists;
import com.hsbc.exception.TrainingNotAvailable;
import com.hsbc.repository.Repository;

// service class that interacts with the repository class and the view. 
public class TrainingProviderService implements Service {

	Repository repo = null;
	
	public TrainingProviderService(Repository repo) {
		this.repo = repo;
	}
	
	// to create an employee using Employee object throws exception if employee already exists
	@Override
	public void createEmployee(Employee e) throws EmployeeAlreadyExists {
		repo.addEmployee(e);
	}

	// to create a training, we are using method overloading to differentiate between create training of type conceptual and practical 
	@Override
	public void createTraining(int trainingId, String nameOfCourse, List<String> skills, String startDate,
			String endDate) throws TrainingAlreadyExists {
		
		// create a conceptual training object 
		ConceptualTraining t = new ConceptualTraining(trainingId, nameOfCourse, skills, startDate, endDate);

		// pass it to create training in repository layer
		repo.addConceptualTraining(t);
		
	}

	@Override
	public void createTraining(int trainingId, String nameOfCourse, List<String> skills, String startDate,
			String endDate, double duration) throws TrainingAlreadyExists {
		
		// create a practical training object 
		PracticalTraining t = new PracticalTraining(trainingId, nameOfCourse, skills, startDate, endDate, duration);
		
		// pass it to create training in repository layer
		repo.addPracticalTraining(t);
	}

	@Override
	public void registerForTraining(Employee e, int trainingId, boolean type) throws TrainingNotAvailable {
		if(type) {
			// true -> registerForConceptualTraining
			repo.registerForConceptualTraining(e, trainingId);
		} else {
			// false -> registerForPracticalTraining
			repo.registerForPracticalTraining(e, trainingId);
		}
		
	}

}
