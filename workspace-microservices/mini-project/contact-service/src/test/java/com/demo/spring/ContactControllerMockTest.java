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

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.spring.entity.Contact;
import com.demo.spring.repository.ContactRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ContactControllerMockTest {
	
	@Autowired
	MockMvc mvc;
	
	@MockBean
	ContactRepository contactRepository;
	
	@Test
	void testSaveContactSavePass() throws Exception{
		Contact contact = new Contact(101, "home", "Sirsi", "581402", "shriyashkerimane@everywhere.com", 111);
		ObjectMapper mapper = new ObjectMapper();
		String contactJson = mapper.writeValueAsString(contact);
		
		when(contactRepository.existsById(101)).thenReturn(false);
		
		mvc.perform(post("/contact/save")
				.content(contactJson).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.status").value("Contact saved"));
	}
	
	@Test
	void testSaveContactSaveFail() throws Exception{
		Contact contact = new Contact(101, "home", "Sirsi", "581402", "shriyashkerimane@everywhere.com", 111);
		
		//account -- exiting account
		//accountInput -- accountNO,amount
		
		ObjectMapper mapper = new ObjectMapper();
		String contactJson = mapper.writeValueAsString(contact);
		
		when(contactRepository.existsById(101)).thenReturn(true);
		
		mvc.perform(post("/contact/save")
				.content(contactJson).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.status").value("Contact already exists"));
	}
	
	@Test
	 void testListAllContacts() throws Exception {
	     List<Contact> list = new ArrayList<>();
	     list.add(new Contact(102, "home", "Sirsi", "581402", "shriyashkerimane@everywhere.com", 111));
	     when(contactRepository.findAll()).thenReturn(list);
	     
	     mvc.perform(get("/contact/listall"))
	     .andDo(print())
	     .andExpect(status().isOk())
	     .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
	     .andExpect(content().json("[ {'contactId': 102,'contactTag': 'home','city': 'Sirsi','pinCode': '581402','email':'shriyashkerimane@everywhere.com','userId': 111}]"));
	 }
	
	@Test
    void testDeleteContactSuccess() throws Exception {
        when(contactRepository.existsById(103)).thenReturn(true);
        
        mvc.perform(delete("/contact/delete/103"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.status").value("Contact deleted"));
    }
	
	@Test
    void testDeleteContactFail() throws Exception {
        when(contactRepository.existsById(103)).thenReturn(false);
        mvc.perform(delete("/contact/delete/103"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.status").value("Contact not found"));
    }
	
	@Test
	void testUpdateSuccess() throws Exception {
	     Contact contact = new Contact(104, "home", "Sirsi", "581402", "shriyashkerimane@everywhere.com", 111);
	     ObjectMapper mapper = new ObjectMapper();
	     String contactJson = mapper.writeValueAsString(contact);
	     when(contactRepository.existsById(104)).thenReturn(true);
	     
	     mvc.perform(patch("/contact/update").content(contactJson).contentType(MediaType.APPLICATION_JSON_VALUE))
	             .andDo(print())
	             .andExpect(status().isOk())
	             .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
	             .andExpect(jsonPath("$.status").value("Contact email updated"));
	 }
	
	@Test
	void testUpdateFail() throws Exception {
	     Contact contact = new Contact(104, "home", "Sirsi", "581402", "shriyashkerimane@everywhere.com", 111);
	     ObjectMapper mapper = new ObjectMapper();
	     String contactJson = mapper.writeValueAsString(contact);
	     when(contactRepository.existsById(104)).thenReturn(false);
	     
	     mvc.perform(patch("/contact/update").content(contactJson).contentType(MediaType.APPLICATION_JSON_VALUE))
	             .andDo(print())
	             .andExpect(status().isOk())
	             .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
	             .andExpect(jsonPath("$.status").value("Contact not found"));
	 }
	
	@Test
	 void testDeleteAllByUserIdPass() throws Exception{
	 when(contactRepository.existsByUserId(555)).thenReturn(true);
	     mvc.perform(delete("/contact/deleteall/555"))
	     .andDo(print())
	     .andExpect(status().isOk())
	     .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
	     .andExpect(jsonPath("$.status").value("Contacts deleted"));	    
	 }
	
	@Test
	 void testDeleteAllByUserIdFail() throws Exception{
	 when(contactRepository.existsByUserId(555)).thenReturn(false);
	     mvc.perform(delete("/contact/deleteall/555"))
	     .andDo(print())
	     .andExpect(status().isOk())
	     .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
	     .andExpect(jsonPath("$.status").value("User not found"));	    
	 }
	
	 @Test
	 void testListAllContactsByUserIdPass() throws Exception {
	     List<Contact> list = new ArrayList<>();
	     list.add(new Contact(106, "home", "Sirsi", "581402", "shriyashkerimane@everywhere.com", 111));
	     when(contactRepository.findAllByUserId(111)).thenReturn(list);
	     mvc.perform(get("/contact/list/111"))
	     .andDo(print())
	     .andExpect(status().isOk())
	     .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
	     .andExpect(content().json("[ {'contactId': 106,'contactTag': 'home','city': 'Sirsi','pinCode': '581402','email':'shriyashkerimane@everywhere.com','userId': 111}]"));
	 }
	 
	 @Test
	 void testListByUserIdAndContactTagPass() throws Exception {
	     List<Contact> list = new ArrayList<>();
	     list.add(new Contact(107, "home", "Sirsi", "581402", "shriyashkerimane@everywhere.com", 111));
	     when(contactRepository.findContactsOfUserByTag("home",111)).thenReturn(list);
	     mvc.perform(get("/contact/list/home/111"))
	     .andDo(print())
	     .andExpect(status().isOk())
	     .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
	     .andExpect(content().json("[ {'contactId': 107,'contactTag': 'home','city': 'Sirsi','pinCode': '581402','email':'shriyashkerimane@everywhere.com','userId': 111}]"));
	 }
}
