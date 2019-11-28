package com.pluralsight.service;

import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;

import java.util.List;

public interface GoalService {

    Goal save(Goal goal);

    List<Goal> findAllGoals();

    List<GoalReport> findAllGoalReports();

}
