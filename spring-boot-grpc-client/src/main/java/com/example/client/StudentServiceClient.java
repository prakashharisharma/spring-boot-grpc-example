package com.example.client;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.studentservice.Student;
import com.example.studentservice.StudentList;
import com.example.studentservice.StudentServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@Component
public class StudentServiceClient {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceClient.class);

	private StudentServiceGrpc.StudentServiceBlockingStub studentServiceBlockingStub;

	  
	  @PostConstruct
	  private void init() {
		  
	    ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();

	    studentServiceBlockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);
	    
	  }
	  
	  public Student getStudent(int rollNumber) {
		  
		    Student student = Student.newBuilder().setRollNumber(rollNumber).build();
		    
		    LOGGER.info("client sending {}", student);

		    Student studentResult = studentServiceBlockingStub.getStudent(student);
		    
		    LOGGER.info("client received {}", studentResult);

		    return studentResult;
	  }
	  
	  public List<Student> getAllStudents(){
		  
		  StudentList studentList = studentServiceBlockingStub.getAllStudents(null);
		  
		  return studentList.getStudentsList();
	  }
	  
}
