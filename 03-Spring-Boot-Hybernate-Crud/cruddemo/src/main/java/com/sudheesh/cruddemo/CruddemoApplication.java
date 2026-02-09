package com.sudheesh.cruddemo;

import com.sudheesh.cruddemo.dao.StudentDAO;
import com.sudheesh.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			 //createStudent(studentDAO);
			 //createMultipleStudents(studentDAO);
			 readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating a new student object...");

		Student tempStudent = new Student("Ramesh", "babu", "ramesh@email.com");

		System.out.println("Saving student object...");
		studentDAO.save(tempStudent);

		int theId = tempStudent.getId();

		System.out.println("Saved Student ID" + theId);

		System.out.println("Retrieving student object...");
		Student myStudent = studentDAO.findById(theId);

		System.out.println("Retrieved Student ID" + myStudent);

	}


	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 Student object");

		Student tempstudent1 = new Student( "Rita", "Pandit",  "rita@email.com");
		Student tempstudent2 = new Student( "Savita", "Ramesh",  "Savita@email.com");
		Student tempstudent3 = new Student( "Shoki", "Satisha",  "satisha@email.com");

		System.out.println("Saving 3 Student object");
		studentDAO.save(tempstudent1);
		studentDAO.save(tempstudent2);
		studentDAO.save(tempstudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new Student object");

		Student tempstudent = new Student( "Paul", "Parker",  "paul@email.com");

		System.out.println("Saving Student object");
		studentDAO.save(tempstudent);

		System.out.println("Saved Student object. Generated ID: " + tempstudent.getId());
	}

}
