package com.pluralsight.service;

import com.pluralsight.model.Goal;

import java.util.List;

public interface GoalService {

    Goal save(Goal goal);

    List<Goal> findAllGoals();

}
