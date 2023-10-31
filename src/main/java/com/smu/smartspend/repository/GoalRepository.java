package com.smu.smartspend.repository;

import com.smu.smartspend.model.Goal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal, Integer> {


    Goal findGoalByGoalid(Integer goalid);

    Iterable findByArchiveTrue();
}
