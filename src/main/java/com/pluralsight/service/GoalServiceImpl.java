package com.pluralsight.service;

import com.pluralsight.model.Goal;
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
        return goalRepository.loadAll();
    }

}
