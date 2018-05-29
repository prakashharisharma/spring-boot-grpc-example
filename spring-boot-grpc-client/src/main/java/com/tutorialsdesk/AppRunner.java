package com.tutorialsdesk;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tutorialsdesk.grpc.proto.Student;
import com.tutorialsdesk.service.StudentClientService;


@Component
public class AppRunner implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppRunner.class);

	@Autowired
	private StudentClientService studentClientService;

	public void run(String... arg0) throws Exception {

		Student student = studentClientService.getStudent(1);
		
		LOGGER.info("RETRIEVED STUDENT BY ROLL_NUMBER :\n ");
		
		LOGGER.info(student.toString());

		List<Student> studentList = studentClientService.getAllStudents();

		LOGGER.info("RETRIEVED ALL STUDETS\n");
		
		for (Student stud : studentList) {
			LOGGER.info(stud.toString());
		}
	}

}
