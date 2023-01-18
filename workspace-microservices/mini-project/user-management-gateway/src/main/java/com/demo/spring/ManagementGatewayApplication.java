package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties(MyServerConfiguration.class)
public class ManagementGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(ManagementGatewayApplication.class, args);
	}
	
	@Bean
	public RouteLocator appRoutes(RouteLocatorBuilder routeBuilder, MyServerConfiguration config) {
		String contactServer = config.getContactServer();
		String userServer = config.getUserServer();
		String managementServer = config.getManagementServer();
		return routeBuilder
				.routes()
				.route(p ->
						p.path("/contact/**")
						.uri(contactServer))
				.route(p ->
						p.path("/user/**")
						.uri(userServer))
				.route(p ->
						p.path("/management/**")
						.uri(managementServer))
				.build();
	}
}

@ConfigurationProperties
class MyServerConfiguration{
	private String contactServer="http://localhost:8181";
	private String userServer="http://localhost:8186";
	private String managementServer="http://localhost:8091";
	public String getContactServer() {
		return contactServer;
	}
	public void setContactServer(String contactServer) {
		this.contactServer = contactServer;
	}
	public String getUserServer() {
		return userServer;
	}
	public void setUserServer(String userServer) {
		this.userServer = userServer;
	}
	public String getManagementServer() {
		return managementServer;
	}
	public void setManagementServer(String managementServer) {
		this.managementServer = managementServer;
	}
}