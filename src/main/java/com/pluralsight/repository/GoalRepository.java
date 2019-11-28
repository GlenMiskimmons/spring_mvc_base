package com.pluralsight.repository;

import com.pluralsight.model.Goal;

import java.util.List;

public interface GoalRepository {

    Goal save(Goal goal);

    List<Goal> loadAll();

}
