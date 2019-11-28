package com.pluralsight.repository;

import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;

import java.util.List;

public interface GoalRepository {

    Goal save(Goal goal);

    List<Goal> loadAll();

    List<GoalReport> findAllGoalReports();

}
