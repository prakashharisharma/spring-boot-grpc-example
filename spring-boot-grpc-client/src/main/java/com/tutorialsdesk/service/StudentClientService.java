package com.tutorialsdesk.service;

import java.util.List;

import com.tutorialsdesk.grpc.proto.Student;

public interface StudentClientService {

	public Student getStudent(int rollNumber);
	public List<Student> getAllStudents();
}
