package com.pluralsight.service;

import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;
import com.pluralsight.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("goalService")
public class GoalServiceImpl implements GoalService {

    @Autowired
    private GoalRepository goalRepository;

    @Override
    @Transactional
    public Goal save(Goal goal) {
        return goalRepository.save(goal);
    }

    @Override
    @Transactional
    public List<Goal> findAllGoals() {
        List<Goal> goals = goalRepository.loadAll();
        // Need to call a list method from getExercises() to trigger lazy load in transaction.
        goals.get(0).getExercises().size();

        return goals;
    }

    @Override
    public List<GoalReport> findAllGoalReports() {
        return goalRepository.findAllGoalReports();
    }

}
