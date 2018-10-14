package com.socialnorm.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.socialnorm.model.EmployeeModel;
import com.socialnorm.model.SearchModel;
import com.socialnorm.services.business.IEmployeeService;

/**
 * Trevor Moore
 * CST-341
 * 10/8/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * CreateController Class for creating our product module.
 * @author Trevor
 * 
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController 
{
	// Topic Service that is being injected and used to insert new topics into the database
	IEmployeeService employeeService;

	/**
	 * Autowired method for setting the injected Topic Post Service
	 * @param service type ITopicPostService
	 */
	@Autowired
	public void setEmployeeService(IEmployeeService service)
	{
		this.employeeService = service;
	}
	/**
	 * Simple method that returns a ModelAndView object with a Search and Topic model added.
	 * Only available for logged in users.
	 * Invoke using "/create/socialize" URI.
	 * 
	 * @return ModelAndView object type ModelAndView
	 */
	@RequestMapping(path="/employees", method=RequestMethod.GET)
	public ModelAndView getEmployeesView() 
	{
		// instantiating ModelAndView object and specifying to return the "createTopic" view
		ModelAndView mav = new ModelAndView("viewEmployees");
		
		List<EmployeeModel> employees = new ArrayList<EmployeeModel>();
		
		employees = employeeService.getEmployees();
		
		// adding a Search and Topic model objects to the ModelAndView
		mav.addObject("search", new SearchModel());
		mav.addObject("employees", employees);
		
		// returning ModelAndView object with all models needed attached
		return mav;
	}
	
	/**
	 * Simple method that returns a ModelAndView object with a Search and Topic model added.
	 * Only available for logged in users.
	 * Invoke using "/create/socialize" URI.
	 * 
	 * @return ModelAndView object type ModelAndView
	 */
	@RequestMapping(path="/addemployee", method=RequestMethod.GET)
	public ModelAndView getAddEmployeeView() 
	{
		// instantiating ModelAndView object and specifying to return the "createTopic" view
		ModelAndView mav = new ModelAndView("addEmployee");
		
		// adding a Search and Topic model objects to the ModelAndView
		mav.addObject("search", new SearchModel());
		mav.addObject("employee", new EmployeeModel());
		
		// returning ModelAndView object with all models needed attached
		return mav;
	}
	
	/**
	 * Simple method that returns a ModelAndView object with a Search and Topic model added.
	 * Only available for logged in users.
	 * Invoke using "/create/posttopic" URI.
	 * 
	 * @param topic of type TopicModel
	 * @param result of type BindingResult
	 * @param session of type HttpSession
	 * @return ModelAndView object type ModelAndView
	 */
	@RequestMapping(path="/addemployee", method=RequestMethod.POST)
	public ModelAndView addEmployee(@Valid @ModelAttribute("topic") EmployeeModel employee, BindingResult result, HttpSession session)
	{
		// USE THIS TO GET OBJECTS IN THE SESSION:
		// (CredentialModel) session.getAttribute("user")
		
		// check if the model has data validation errors
		if(result.hasErrors())
		{
			// if it has errors:
			// instantiating ModelAndView object and specifying to return the "createTopic" view
			ModelAndView mav = new ModelAndView("addEmployee");
			
			// adding a Search and Topic model object to the ModelAndView
			mav.addObject("search", new SearchModel());
			mav.addObject("topic", employee);
			
			// returning ModelAndView object with all models needed attached
			return mav;
		}
		
		// Try Catch block for catching db exceptions
		try
		{
			// if what is returned is true (meaning the post was successfully inserted)
			if(employeeService.addEmployee(employee))
			{
				// instantiating ModelAndView object and specifying to return the "createTopic" view
				ModelAndView mav = new ModelAndView("viewEmployees");
				
				List<EmployeeModel> employees = new ArrayList<EmployeeModel>();
				
				employees = employeeService.getEmployees();
				
				// adding a Search and Topic model objects to the ModelAndView
				mav.addObject("search", new SearchModel());
				mav.addObject("employees", employees);
				
				// returning ModelAndView object with all models needed attached
				return mav;
			}
			// if false, meaning the post was not inserted
			else
			{
				// instantiating ModelAndView object and specifying to return the "secureError" view for logged in errors
				ModelAndView mav = new ModelAndView("secureError");
				
				// adding a Search model objects to the ModelAndView
				mav.addObject("search", new SearchModel());

				// returning ModelAndView object with all models needed attached
				return mav;
			}
			
		}
		// catching any exceptions so that the user will always see a nice error page
		catch(Exception e)
		{
			System.out.println("Database Exception. Caught in Create Controller.");
			
			// instantiating ModelAndView object and specifying to return the "secureError" view
			ModelAndView mav = new ModelAndView("secureError");
			
			// adding a Search model objects to the ModelAndView
			mav.addObject("search", new SearchModel());
			
			// returning ModelAndView object with all models needed attached
			return mav;
		}
	}
	
	/**
	 * Simple method that returns a ModelAndView object with a Search and Topic model added.
	 * Only available for logged in users.
	 * Invoke using "/create/posttopic" URI.
	 * 
	 * @param topic of type TopicModel
	 * @param result of type BindingResult
	 * @param session of type HttpSession
	 * @return ModelAndView object type ModelAndView
	 */
	@RequestMapping(path="/updateemployee", method=RequestMethod.POST)
	public ModelAndView updateEmployee(List<EmployeeModel> employees, HttpSession session)
	{
		// USE THIS TO GET OBJECTS IN THE SESSION:
		// (CredentialModel) session.getAttribute("user")

		// Try Catch block for catching db exceptions
		try
		{
			// if what is returned is true (meaning the post was successfully inserted)
			if(employeeService.updateEmployees(employees))
			{
				// instantiating ModelAndView object and specifying to return the "createTopic" view
				ModelAndView mav = new ModelAndView("viewEmployees");
				
				List<EmployeeModel> updatedEmployees = new ArrayList<EmployeeModel>();
				
				employees = employeeService.getEmployees();
				
				// adding a Search and Topic model objects to the ModelAndView
				mav.addObject("search", new SearchModel());
				mav.addObject("employees", updatedEmployees);
				
				// returning ModelAndView object with all models needed attached
				return mav;
			}
			// if false, meaning the post was not inserted
			else
			{
				// instantiating ModelAndView object and specifying to return the "secureError" view for logged in errors
				ModelAndView mav = new ModelAndView("secureError");
				
				// adding a Search model objects to the ModelAndView
				mav.addObject("search", new SearchModel());

				// returning ModelAndView object with all models needed attached
				return mav;
			}
			
		}
		// catching any exceptions so that the user will always see a nice error page
		catch(Exception e)
		{
			System.out.println("Database Exception. Caught in Create Controller.");
			
			// instantiating ModelAndView object and specifying to return the "secureError" view
			ModelAndView mav = new ModelAndView("secureError");
			
			// adding a Search model objects to the ModelAndView
			mav.addObject("search", new SearchModel());
			
			// returning ModelAndView object with all models needed attached
			return mav;
		}
	}
	
}