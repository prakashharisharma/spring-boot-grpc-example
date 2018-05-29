package com.tutorialsdesk.repo;

import java.util.List;

import com.tutorialsdesk.grpc.proto.Student;

public interface StudentRepo {

	public Student getStudent(int rollNumber);
	
	public List<Student> getAllStudents();
}
