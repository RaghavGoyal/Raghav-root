package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Session;
import com.service.ITrainingService;

@Controller
public class viewSessionController {
	
	@Autowired
	private ITrainingService trainingService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listSessions(ModelMap map) 
	{
		map.addAttribute("session", new Session());
		map.addAttribute("sessionList", trainingService.getAllSessions());
		
		return "viewSessionList";
	}

//	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	public String addEmployee(@ModelAttribute(value="employee") EmployeeEntity employee, BindingResult result) 
//	{
//		employeeManager.addEmployee(employee);
//		return "redirect:/";
//	}

	@RequestMapping("/success/{sessionId}")
	public String viewSession(@PathVariable("sessionId") Integer sessionId,ModelMap map)
	{
		map.addAttribute("session", new Session());
		map.addAttribute("sessionName", trainingService.getSessionName(sessionId));
		
		return "success";
//		return "redirect:/";
	}

//	public void setEmployeeManager(EmployeeManager employeeManager) {
//		this.employeeManager = employeeManager;
//	}
}
