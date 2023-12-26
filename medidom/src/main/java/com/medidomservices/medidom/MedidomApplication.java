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
import com.medidomservices.medidom.Entity.Service;
import com.medidomservices.medidom.Entity.User.Employee;
import com.medidomservices.medidom.Entity.User.Patient;
import com.medidomservices.medidom.Entity.User.Role;
import com.medidomservices.medidom.Repositories.EmployeeRepository;
import com.medidomservices.medidom.Repositories.PatientRepository;

@SpringBootApplication
public class MedidomApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedidomApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository, PatientRepository patientRepository){
		return runner -> {
			ConsultationRequest request = new ConsultationRequest(new Date(0), Service.first, null);
			ConsultationRequest request2 = new ConsultationRequest(new Date(0), Service.second, null);
			
			Patient temPatient = new Patient("John","Doe",new Date(0),(long)54557, "john@gmail.com","{noop}johndoe", Role.USER, 0, "sugar", "cookies");
			Employee tempEmployee = new Employee("Zitouni", "Zerhouni",new Date(0), (long)58516, "zerhouni@gmail.com", "{noop}zerhouni", Role.DOCTOR, 20,"Bab ezzouar", null,1);
			Feedback feedback = new Feedback(3, 3);
			Report report = new Report("instable","sport", "finish him");
			
			request.setFeedback(feedback);
			request2.setReport(report);
			temPatient.addRequest(request);
			temPatient.addRequest(request2);
			
			patientRepository.save(temPatient);
			employeeRepository.save(tempEmployee);
			
			List<Employee> listEmployee = employeeRepository.findAll();
			System.out.println(listEmployee);

			List<Patient> listPatient = patientRepository.findAll();
			System.out.println(listPatient + "Patient Requests" + listPatient.get(0).getRequests());
			
			request = listPatient.get(0).getRequests().get(0);
			System.out.println(request.getFeedback());
			
			request2 = listPatient.get(0).getRequests().get(1);
			System.out.println(request2.getReport());
		};
	}
	
}
