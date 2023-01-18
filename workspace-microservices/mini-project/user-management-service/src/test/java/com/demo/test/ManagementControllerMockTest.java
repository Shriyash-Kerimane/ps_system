package com.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ManagementControllerMockTest {
	
	@Autowired
	MockMvc mvc;
	
	@MockBean
	RestTemplate restTemplate1;
	
	@MockBean
	@Qualifier("restTemplate2")
	RestTemplate restTemplate2;
	
	void testGetContactInUser() throws Exception{
		
	}

}
