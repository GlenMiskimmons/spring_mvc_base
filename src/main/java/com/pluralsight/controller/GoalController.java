package com.pluralsight.controller;

import com.pluralsight.model.Goal;
import com.pluralsight.service.GoalService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes("goal")
public class GoalController {

	@Autowired
	private GoalService goalService;

	private static final Log LOGGER = LogFactory.getLog(GoalController.class);

	@GetMapping("addGoal")
	public String addGoal(Model model) {
		Goal goal = new Goal();
		goal.setMinutes(10);
		model.addAttribute("goal", goal);
		
		return "addGoal";
	}
	
	@PostMapping("addGoal")
	public String updateGoal(@Valid @ModelAttribute("goal") Goal goal, BindingResult result) {
		
		LOGGER.info("result has errors: " + result.hasErrors());

		LOGGER.info("Goal set: " + goal.getMinutes());
		
		if(result.hasErrors()) {
			return "addGoal";
		} else {
			goalService.save(goal);
		}
		
		return "redirect:index.jsp";
	}

	@PostMapping("/endSession")
	public String endSession(SessionStatus sessionStatus) {
		sessionStatus.setComplete();

		return "redirect:index.jsp";
	}

	@GetMapping("/getGoals")
	public String getGoals(Model model) {
		List<Goal> goals = goalService.findAllGoals();
		model.addAttribute("goals", goals);

		return "getGoals";
	}
	
}
