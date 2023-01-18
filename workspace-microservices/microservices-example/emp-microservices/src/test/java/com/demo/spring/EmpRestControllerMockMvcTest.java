package com.demo.spring;



import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import java.util.Optional;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;



import com.demo.spring.entity.Employee;
import com.demo.spring.repository.EmpRepository;
import com.fasterxml.jackson.databind.ObjectMapper;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class EmpRestControllerMockMvcTest {

   @Autowired
    MockMvc mvc;

   @MockBean
    EmpRepository empRepository;

   @Test
    public void testSave() throws Exception {
        Employee emp = new Employee(117, "SK", "Sirsi", 100000.0,10);
        ObjectMapper mapper = new ObjectMapper();
        String empJson = mapper.writeValueAsString(emp);

       when(empRepository.existsById(117)).thenReturn(false);

       mvc.perform(post("/employee/save").content(empJson).contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print())
                .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.status").value("Employee saved"));
    }
    
    @Test
    public void testFindSuccess() throws Exception{
        Employee emp = new Employee(117, "SK", "Sirsi", 100000.0,10);
        when(empRepository.findById(130)).thenReturn(Optional.of(emp));
        
        mvc.perform(get("/employee/117"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$.name").value("SK"));
        
    }



}