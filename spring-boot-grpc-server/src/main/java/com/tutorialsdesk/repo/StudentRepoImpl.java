package com.tutorialsdesk.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tutorialsdesk.grpc.proto.Student;

@Repository
public class StudentRepoImpl implements StudentRepo {

	private static List<Student> studentList = new ArrayList<>();
	
	static{
		studentList.add(Student.newBuilder().setRollNumber(1).setName("Prakash").setDob("04/02/1986").setPercentage(92.50).build());
		studentList.add(Student.newBuilder().setRollNumber(2).setName("Nitin").setDob("01/02/1982").setPercentage(91.50).build());
		studentList.add(Student.newBuilder().setRollNumber(3).setName("Joseph").setDob("05/03/1978").setPercentage(82.50).build());
		studentList.add(Student.newBuilder().setRollNumber(4).setName("Rambir").setDob("06/08/1981").setPercentage(88.50).build());
		studentList.add(Student.newBuilder().setRollNumber(5).setName("Martin").setDob("02/10/1984").setPercentage(89.50).build());
	}
	
	@Override
	public Student getStudent(int rollNumber) {
		
		Student student = null;
		
		student = studentList.stream().filter( (s) -> s.getRollNumber() == rollNumber).findFirst().orElse(null);
		
		return student;
	}
	
	@Override
	public List<Student> getAllStudents(){
		
		return studentList;
	}
	
}
