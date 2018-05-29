package com.tutorialsdesk;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tutorialsdesk.grpc.proto.Student;
import com.tutorialsdesk.service.StudentClientService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GrpcClientAppIntegrationTests {

	@Autowired
	private StudentClientService studentClientService;

	@Test
	public void testGetStudent() {
	  
	  Student student = Student.newBuilder().setRollNumber(1).setName("Prakash").setDob("04/02/1986").setPercentage(92.50).build();
	  
	  assertThat(studentClientService.getStudent(1)).isEqualTo(student);
	}
  
}