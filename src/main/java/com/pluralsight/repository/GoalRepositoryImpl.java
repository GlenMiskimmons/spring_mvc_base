package com.pluralsight.repository;

import com.pluralsight.model.Goal;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

@Repository("goalRepository")
public class GoalRepositoryImpl implements GoalRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Goal save(Goal goal) {
        entityManager.flush();
        entityManager.persist(goal);

        return goal;
    }

    @Override
    public List<Goal> loadAll() {
        Query query = entityManager.createQuery("Select g from Goal g");

        return query.getResultList();
    }

}
