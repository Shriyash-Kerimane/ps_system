package com.demo.spring;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.spring.entity.User;
import com.demo.spring.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class UserControllerMockTest {
	
	@Autowired
    MockMvc mvc;

	@MockBean
	UserRepository userRepository;
	
	@Test
	void testSaveUserPass() throws Exception {
		User user = new User(111,"Shriyash");
		ObjectMapper mapper = new ObjectMapper();
		String userJson = mapper.writeValueAsString(user);

		when(userRepository.existsById(111)).thenReturn(false);
		mvc.perform(post("/user/save")
				.content(userJson).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.status").value("User saved"));
	}
	
	@Test
	void testSaveUserFail() throws Exception {
		User user = new User(111,"Shriyash");
		ObjectMapper mapper = new ObjectMapper();
		String userJson = mapper.writeValueAsString(user);

		when(userRepository.existsById(111)).thenReturn(true);
		mvc.perform(post("/user/save")
				.content(userJson).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.status").value("User already exists"));
	}
	
	@Test
	void testFindUserPass() throws Exception {
		User user = new User(222,"Shriyash");
		when(userRepository.findById(222)).thenReturn(Optional.of(user));
		mvc.perform(get("/user/find/222"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
			    .andExpect(content().json("{'userId': 222,'userName': 'Shriyash'}"));
	}
	
	@Test
	void testFindUserFail() throws Exception {
		when(userRepository.findById(222)).thenReturn(Optional.empty());
		mvc.perform(get("/user/find/222"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.status").value("User not found"));
	}
	
	@Test
	 void testListAllUsers() throws Exception {
	     List<User> list = new ArrayList<>();
	     list.add(new User(333,"Shriyash"));
	     when(userRepository.findAll()).thenReturn(list);
	     mvc.perform(get("/user/listall"))
	     .andDo(print())
	     .andExpect(status().isOk())
	     .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
	     .andExpect(content().json("[{'userId': 333,'userName': 'Shriyash'}]"));
	 }
	
	@Test
	void testDeleteUserPass() throws Exception {

		when(userRepository.existsById(444)).thenReturn(true);
		
		mvc.perform(delete("/user/delete/444").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.status").value("User deleted"));
	}
	
	@Test
	void testDeleteUserFail() throws Exception {

		when(userRepository.existsById(444)).thenReturn(false);
		
		mvc.perform(delete("/user/delete/444").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.status").value("User not found"));
	}

	@Test
	void testUpdateUserPass() throws Exception {

		User user = new User(555,"Shriyash");
		ObjectMapper mapper = new ObjectMapper();
		String userJson = mapper.writeValueAsString(user);
		when(userRepository.existsById(555)).thenReturn(true);
		
		mvc.perform(patch("/user/update/555/Pratamesh").content(userJson).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.status").value("User updated"));
	}
	
	@Test
	void testUpdateUserFail() throws Exception {

		User user = new User(555,"Shriyash");
		ObjectMapper mapper = new ObjectMapper();
		String userJson = mapper.writeValueAsString(user);
		when(userRepository.existsById(555)).thenReturn(false);
		
		mvc.perform(patch("/user/update/555/Pratamesh").content(userJson).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.status").value("User not found"));
	}

}
