package com.tutorialsdesk.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorialsdesk.grpc.proto.Student;
import com.tutorialsdesk.grpc.proto.StudentList;
import com.tutorialsdesk.grpc.proto.StudentServiceGrpc;

@Service
public class StudentClientServiceImpl implements StudentClientService{

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentClientServiceImpl.class);
	
	@Autowired
	private StudentServiceGrpc.StudentServiceBlockingStub studentServiceBlockingStub;
	
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
