package com.example.service;

import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.studentservice.Empty;
import com.example.studentservice.Student;
import com.example.studentservice.StudentList;
import com.example.studentservice.StudentServiceGrpc;
import io.grpc.stub.StreamObserver;

@GRpcService
public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase{

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	  @Override
	  public void getStudent(Student request, StreamObserver<Student> responseObserver) {
		  
	    LOGGER.info("server received {}", request);

	    Student student = Student.newBuilder().setRollNumber(request.getRollNumber()).setName("Prakash").setDob("04/02/1986").setPercentage(98.25).build();
	    
	    LOGGER.info("server responded {}", student);

	    responseObserver.onNext(student);
	    
	    responseObserver.onCompleted();
	    
	  }
	  
	  @Override
	  public void getAllStudents(Empty request,StreamObserver<StudentList> responseObserver) {
		  
		  LOGGER.info("server received {}", request);
		  
		  Student student1 = Student.newBuilder().setRollNumber(1).setName("Prakash").setDob("04/02/1986").setPercentage(98.25).build();
		  
		  Student student2 = Student.newBuilder().setRollNumber(2).setName("Joseph").setDob("04/02/1980").setPercentage(98.25).build();
		  
		  Student student3 = Student.newBuilder().setRollNumber(3).setName("Nitin").setDob("04/02/1982").setPercentage(98.25).build();
		  
		  StudentList studentList = StudentList.newBuilder().addStudents(student1).addStudents(student2).addStudents(student3).build();
				  
		  LOGGER.info("server responded {}", studentList);

		  responseObserver.onNext(studentList);
		    
		  responseObserver.onCompleted();
	  }
}
