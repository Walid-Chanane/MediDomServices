package com.medidomservices.medidom;

import java.sql.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.medidomservices.medidom.Entity.ConsultationRequest;
import com.medidomservices.medidom.Entity.Feedback;
import com.medidomservices.medidom.Entity.Report;
import com.medidomservices.medidom.Entity.User.Employee;
import com.medidomservices.medidom.Entity.User.Patient;
import com.medidomservices.medidom.Entity.User.Role;
import com.medidomservices.medidom.Entity.User.Specialty;
import com.medidomservices.medidom.Entity.User.User;
import com.medidomservices.medidom.Repositories.EmployeeRepository;
import com.medidomservices.medidom.Repositories.PatientRepository;
import com.medidomservices.medidom.Repositories.UserRepository;
import com.medidomservices.medidom.Service.PatientService;

@SpringBootApplication
public class MedidomApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedidomApplication.class, args);
	}

	// @Bean
	// public CommandLineRunner commandLineRunner(PatientService userService, UserRepository userRepository,EmployeeRepository employeeRepository, PatientRepository patientRepository){
	// 	return runner -> {
	// 		ConsultationRequest request = new ConsultationRequest(new Date(222222222222000L), Specialty.PEDIATRICS, null);
	// 		ConsultationRequest request2 = new ConsultationRequest(new Date(222222222222000L), Specialty.PEDIATRICS, null);
	// 		ConsultationRequest request3 = new ConsultationRequest(new Date(222222222222000L), Specialty.PEDIATRICS, null);
			
	// 		Patient temPatient = new Patient("John","Doe",new Date(0),54557L, "john@gmail.com","{noop}johndoe", Role.PATIENT, 0, "sugar", "cookies", "bab ezzouar");
	// 		Employee tempEmployee = new Employee("Zitouni", "Zerhouni",new Date(0), 5851L, "zerhouni@gmail.com", "{noop}zerhouni", Role.DOCTOR, 20,"Bab ezzouar", Specialty.PEDIATRICS,1);
	// 		Feedback feedback = new Feedback(3, 3);
	// 		Report report = new Report("instable","sport", "finish him");
	// 		ConsultationRequest request4 = new ConsultationRequest(new Date(222222222222000L), Specialty.PEDIATRICS, null);

	// 		patientRepository.save(temPatient);

	// 		List<Patient> listPatient = patientRepository.findAll();
	// 		System.out.println(listPatient + "Patient Requests" + listPatient.get(0).getRequests());

	// 		request.setFeedback(feedback);
	// 		request2.setReport(report);
	// 		listPatient.get(0).addRequest(request);
	// 		listPatient.get(0).addRequest(request2);
			
	// 		patientRepository.save(listPatient.get(0));
	// 		// tempEmployee.addRequest(request4);
	// 		employeeRepository.save(tempEmployee);
			
	// 		List<Employee> listEmployee = employeeRepository.findAll();
	// 		System.out.println(listEmployee.get(0).getRequests());

	// 		ConsultationRequest r1 = userService.assignEmployeeToRequest("john@gmail.com",request);
	// 		ConsultationRequest r2 = userService.assignEmployeeToRequest("john@gmail.com",request2);
	// 		ConsultationRequest r3 = userService.assignEmployeeToRequest("john@gmail.com",request3);
	// 		ConsultationRequest r4 = userService.assignEmployeeToRequest("john@gmail.com",request4);

	// 		List<Employee> listEmployee3 = employeeRepository.findAll();
	// 		System.out.println(listEmployee3.get(0).getRequests());

	// 		System.out.println(r1 + " // " + r2 + "//" + r3 + "//" + r4);
	// 		List<Patient> listPatient2 = patientRepository.findAll();
	// 		System.out.println(listPatient + "Patient Requests" + listPatient2.get(0).getRequests());
			
	// 		request = listPatient2.get(0).getRequests().get(0);
	// 		System.out.println(request.getFeedback());
			
	// 		request2 = listPatient2.get(0).getRequests().get(1);
	// 		System.out.println(request2.getReport());

	// 		List<User> userList = userRepository.findAll();
	// 		int patientNumber = 0;
	// 		int employeeNumber = 0;
	// 		for (User user : userList) {
	// 			if (user instanceof Patient) patientNumber++;
	// 			if (user instanceof Employee) employeeNumber++;
	// 		}
	// 		System.out.println("patients=" + patientNumber + "  employees=" + employeeNumber);
	// 	};
	// }
	
}
