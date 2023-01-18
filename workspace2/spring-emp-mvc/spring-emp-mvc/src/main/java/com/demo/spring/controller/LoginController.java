package com.demo.spring.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.spring.entity.Emp;

@Controller
public class LoginController {
	
	static Map<Integer, Emp> db=new ConcurrentHashMap<>();
	
	@RequestMapping(path="/index", method = RequestMethod.GET)
	public String getPage() {
		return "index";
	}
	
	@RequestMapping(path="/register", method = RequestMethod.GET)
	public String getregister() {
		return "register";
	}
	
	@RequestMapping(path="/register", method = RequestMethod.POST)
	public ModelAndView register(
			@RequestParam("empId") Integer id, 
			@RequestParam("name") String name,
			@RequestParam("city") String city,
			@RequestParam("salary") Double salary
			) {
		ModelAndView mv1 = new ModelAndView();

		db.put(id, new Emp(id, name, city, salary));
		mv1.setViewName("index");
		return mv1;
	}
	
	@RequestMapping(path="/list", method = RequestMethod.GET)
	public ModelAndView getList() {
		
		ModelAndView mv2 = new ModelAndView();
		
		Collection<Emp> data=db.values();
		List<Emp> empList=new ArrayList<>(data);
		
	
		
		mv2.setViewName("list");
		mv2.addObject("eList", data);
		return mv2;
	}
	
	@RequestMapping(path="/finder",method=RequestMethod.GET)
    public String findEmpDetails()
    {
        return "finder";
    }
    
    @RequestMapping(path="/finder",method=RequestMethod.POST)
    public ModelAndView findEmp(@RequestParam("empId") Integer empId)
    {
        ModelAndView mv = new ModelAndView();
        
        Emp emp=db.get(empId);
        
        System.out.println(emp);
        
        mv.addObject("e", emp);
        
        return mv;
    }
}
