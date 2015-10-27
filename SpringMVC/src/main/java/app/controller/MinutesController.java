package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import app.model.Exercise;

@Controller
public class MinutesController {

	@RequestMapping(value="/addMinutes")
	public String addMinutes(@ModelAttribute ("exercise") Exercise exercise){
		
		System.out.println("Exercise" + exercise.getMinutes());
		
		//return "forward:addMoreMinutes.html";
		return "addMinutes";
	}
	
//	@RequestMapping(value="/addMoreMinutes")
//	public String addMoreMinutes(@ModelAttribute ("exercise") Exercise exercise){
//		
//		System.out.println("Exercise" + exercise.getMinutes());
//		
//		return "addMinutes";
//	}
	
	
}
