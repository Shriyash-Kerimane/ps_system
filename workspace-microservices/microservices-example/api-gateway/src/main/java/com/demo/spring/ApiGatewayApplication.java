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
//@EnableEurekaClient
@EnableDiscoveryClient
@EnableConfigurationProperties(MyServerConfiguration.class)
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);

	}
	
	@Bean
	public RouteLocator appRoutes(RouteLocatorBuilder routeBuilder, MyServerConfiguration config) {
		String empServer = config.getEmpServer();
		String deptServer = config.getDeptServer();
		String hrServer = config.getHrServer();
		return routeBuilder
				.routes()
				.route(p ->
						p.path("/hr/**")
						.uri(hrServer))
				.route(p ->
						p.path("/employee/**")
						.uri(empServer))
				.route(p ->
						p.path("/dept/**")
						.uri(deptServer))
				.build();
		
	}

}

@ConfigurationProperties
class MyServerConfiguration{
	private String empServer="http://ec2-34-207-187-198.compute-1.amazonaws.com:8181";
	private String deptServer="http://localhost:8184";
	private String hrServer="http://localhost:8091";
	public String getEmpServer() {
		return empServer;
	}
	public void setEmpServer(String empServer) {
		this.empServer = empServer;
	}
	public String getDeptServer() {
		return deptServer;
	}
	public void setDeptServer(String deptServer) {
		this.deptServer = deptServer;
	}
	public String getHrServer() {
		return hrServer;
	}
	public void setHrServer(String hrServer) {
		this.hrServer = hrServer;
	}
}
