package com.hsbc.application;

import java.util.Arrays;
import java.util.List;

import com.hsbc.entity.Employee;
import com.hsbc.exception.EmployeeAlreadyExists;
import com.hsbc.exception.TrainingAlreadyExists;
import com.hsbc.exception.TrainingNotAvailable;
import com.hsbc.repository.Repository;
import com.hsbc.repository.RepositoryImpl;
import com.hsbc.service.*;

public class Application {
	public static void main(String[] args) {
		
		
		Repository repository = new RepositoryImpl();
		Service service = new TrainingProviderService(repository);
		try {
		
		// testing creating an employee 
		Employee employee1 = new Employee(1, "employee1");
		service.createEmployee(employee1);
		
		Employee employee2 = new Employee(2, "employee2");
		service.createEmployee(employee2);
		
		Employee employee3 = new Employee(3, "employee3");
		service.createEmployee(employee3);
		
		
		// this will throw EmployeeAlreadyExitsException
//		service.createEmployee(employee1);
		
		// testing creating a training 
		List<String> skillCt1 = Arrays.asList("skill1", "skill2", "skill3");
		service.createTraining(1, "conceptualTraining1", skillCt1, "startDate", "endDate");
		
		List<String> skillCt2 = Arrays.asList("skill5", "skill6");
		service.createTraining(2, "conceptualTraining2", skillCt2, "startDate", "endDate");
		
		List<String> skillCt3 = Arrays.asList("skill5", "skill1");
		service.createTraining(3, "conceptualTraining3", skillCt3, "startDate", "endDate");
		
		
		// this will throw TrainingAlreadyExistsException
//		service.createTraining(1, "conceptualTraining1", skillCt, "startDate", "endDate");

		
		// testing registering an employee to a training 
		// true -> conceptualTraining
		// false -> practicalTraining
		
		service.registerForTraining(employee1, 1, true);
		service.registerForTraining(employee2, 2, true);
		service.registerForTraining(employee3, 3, true);
		
		// this will throw TraininngNotFoundException
//		service.registerForTraining(employee3, 5, true);
		
		// testing registering an employee to a training 
		List<String> skillPt1 = Arrays.asList("skill1", "skill2","skill3");
		service.createTraining(1, "practicalTraining1", skillPt1, "startDate", "endDate", 1000);
		
		List<String> skillPt2 = Arrays.asList("skill1", "skill2","skill3");
		service.createTraining(2, "practicalTraining2", skillPt2, "startDate", "endDate", 1000);
		
		List<String> skillPt3 = Arrays.asList("skill1", "skill2","skill3");
		service.createTraining(3, "practicalTraining3", skillPt3, "startDate", "endDate", 1000);
		
		service.registerForTraining(employee3, 1, false);
		service.registerForTraining(employee1, 2, false);
		service.registerForTraining(employee3, 3, false);
		
		
		// this will throw TrainingNotFoundException 
//		service.registerForTraining(employee3, 9, false);
		
		} catch(EmployeeAlreadyExists eObject) {
			eObject.printStackTrace();
		} catch(TrainingAlreadyExists eObject) {
			eObject.printStackTrace();
		} catch(TrainingNotAvailable eObject) {
			eObject.printStackTrace();
		}
		
	}

}
