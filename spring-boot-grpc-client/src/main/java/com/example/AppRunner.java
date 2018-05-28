package com.example;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.client.StudentServiceClient;
import com.example.studentservice.Student;

@Component
public class AppRunner implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppRunner.class);
	
	@Autowired
	StudentServiceClient studentServiceClient;

	public void run(String... arg0) throws Exception {

		Student student = studentServiceClient.getStudent(1);
		
		LOGGER.info("RETRIEVED STUDENT BY ROLL_NUMBER : "+student);

		List<Student> studentList = studentServiceClient.getAllStudents();

		LOGGER.info("RETRIEVED ALL STUDETS\n");
		
		for (Student stud : studentList) {
			LOGGER.info(stud.toString());
		}
	}

}
