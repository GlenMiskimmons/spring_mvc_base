package com.pluralsight.controller;

import com.pluralsight.model.Activity;
import com.pluralsight.model.Exercise;
import com.pluralsight.service.ExerciseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;


@Controller
public class MinutesController {

	private static final Log LOGGER = LogFactory.getLog(MinutesController.class);
	private static final String MODEL_NAME_ADD_MINUTES = "addMinutes";

	@Autowired
	private ExerciseService exerciseService;
	
	@GetMapping("/addMinutes")
	public String getMinutes(@ModelAttribute ("exercise") Exercise exercise) {

		return MODEL_NAME_ADD_MINUTES;
	}
	
	@PostMapping("/addMinutes")
	public String addMinutes(@Valid @ModelAttribute ("exercise") Exercise exercise, BindingResult result) {
		
		LOGGER.info("exercise: " + exercise.getMinutes());
		LOGGER.info("exercise activity: " + exercise.getActivity());
		
		if(result.hasErrors()) {
			return MODEL_NAME_ADD_MINUTES;
		}
		
		return MODEL_NAME_ADD_MINUTES;
	}
	
	@GetMapping("/activities")
	public @ResponseBody List<Activity> findAllActivities() {
		return exerciseService.findAllActivities();
	}
	
}
