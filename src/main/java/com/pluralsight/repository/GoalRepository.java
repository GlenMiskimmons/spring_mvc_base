package com.pluralsight.repository;

import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import java.util.List;

@Repository("goalRepository")
public interface GoalRepository extends JpaRepository<Goal, Long> {

//    Goal save(Goal goal);

//    List<Goal> loadAll();

    @Query("Select new com.pluralsight.model.GoalReport(g.minutes, e.minutes, e.activity) " +
            "from Goal g, Exercise e where g.id = e.goal.id")
    List<GoalReport> findAllGoalReports();

}
