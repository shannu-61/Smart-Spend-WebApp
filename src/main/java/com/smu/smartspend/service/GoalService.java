package com.smu.smartspend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smu.smartspend.model.Goal;

public interface GoalService {
	void addEditGoal(Goal goal);
	Goal findGoalById(Integer goalid);

	void deleteById(Integer goalid);

	Iterable<Goal> findAll();
	void markCompleteById(Integer goalid);

    void archiveById(Integer id);
    void removeArchiveById(Integer id);
	Iterable archivedGoals();
}
