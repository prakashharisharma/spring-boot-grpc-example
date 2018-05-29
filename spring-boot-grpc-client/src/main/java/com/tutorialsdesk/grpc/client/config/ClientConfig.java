package com.tutorialsdesk.grpc.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tutorialsdesk.grpc.proto.StudentServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@Configuration
public class ClientConfig {

	@Value("${grpc.server.host}")
	private String grpcServerHost;
	
	@Value("${grpc.server.port}")
	private int grpcServerPort;
	
	@Bean
	public StudentServiceGrpc.StudentServiceBlockingStub studentServiceBlockingStub() {
		  
		ManagedChannel managedChannel = ManagedChannelBuilder.forAddress(grpcServerHost, grpcServerPort).usePlaintext().build();

	    return StudentServiceGrpc.newBlockingStub(managedChannel);
	}
	
}
