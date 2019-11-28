package com.pluralsight.repository;

import com.pluralsight.model.Exercise;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("exerciseRepoistory")
public class ExerciseRepositoryImpl implements ExerciseRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Exercise save(Exercise exercise) {
        entityManager.persist(exercise);
        entityManager.flush();

        return exercise;
    }

}
