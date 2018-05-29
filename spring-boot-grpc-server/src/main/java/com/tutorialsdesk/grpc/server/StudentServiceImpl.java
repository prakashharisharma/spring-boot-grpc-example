package com.tutorialsdesk.grpc.server;

import java.util.List;

import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tutorialsdesk.grpc.proto.Empty;
import com.tutorialsdesk.grpc.proto.Student;
import com.tutorialsdesk.grpc.proto.StudentList;
import com.tutorialsdesk.grpc.proto.StudentServiceGrpc;
import com.tutorialsdesk.repo.StudentRepo;

import io.grpc.stub.StreamObserver;

@GRpcService
public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase{

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	@Autowired
	private StudentRepo studentRepo;
	
	  @Override
	  public void getStudent(Student request, StreamObserver<Student> responseObserver) {
		  
	    LOGGER.info("server received {}", request);
	    
	    Student student =  studentRepo.getStudent(request.getRollNumber());
  
	    LOGGER.info("server responded {}", student);

	    responseObserver.onNext(student);
	    
	    responseObserver.onCompleted();
	    
	  }
	  
	  @Override
	  public void getAllStudents(Empty request,StreamObserver<StudentList> responseObserver) {
		  
		  LOGGER.info("server received {}", request);
	
		  List<Student> studentList = studentRepo.getAllStudents();

		  StudentList studentListResult = StudentList.newBuilder().addAllStudents(studentList).build();
				  
		  LOGGER.info("server responded {}", studentListResult);

		  responseObserver.onNext(studentListResult);
		    
		  responseObserver.onCompleted();
	  }
}
