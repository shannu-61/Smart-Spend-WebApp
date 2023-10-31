package com.smu.smartspend.service;

import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.smu.smartspend.model.Goal;
import com.smu.smartspend.repository.GoalRepository;

@RequiredArgsConstructor
@Service
public class GoalServiceImpl implements GoalService {
	private final GoalRepository goalRepository;

	@Override
	public void addEditGoal(Goal goal) {
		goalRepository.save(goal);
	}

	@Override
	public Goal findGoalById(Integer goalid) {
		return goalRepository.findGoalByGoalid(goalid);
	}

	@Override
	public void deleteById(Integer goalid) {
		goalRepository.deleteById(goalid);
	}

	@Override
	public Iterable<Goal> findAll() {
		return goalRepository.findAll();
	}

	@Override
	public void markCompleteById(Integer goalid) {
		Goal tempGoal=goalRepository.findGoalByGoalid(goalid);
		Goal goal=Goal.builder()
				.goalid(tempGoal.getGoalid())
				.goalname(tempGoal.getGoalname())
				.goaldeadline(tempGoal.getGoaldeadline())
				.goalcost(tempGoal.getGoalcost())
				.currentsavings(tempGoal.getCurrentsavings())
				.archive(tempGoal.isArchive())
				.status(true).build();

			goalRepository.save(goal);
	}

	@Override
	public void archiveById(Integer goalid) {
		Goal tempGoal=goalRepository.findGoalByGoalid(goalid);
		Goal goal=Goal.builder()
				.goalid(tempGoal.getGoalid())
				.goalname(tempGoal.getGoalname())
				.goaldeadline(tempGoal.getGoaldeadline())
				.goalcost(tempGoal.getGoalcost())
				.currentsavings(tempGoal.getCurrentsavings())
				.status(tempGoal.isStatus())
				.archive(true).build();

		goalRepository.save(goal);
	}
	@Override
	public void removeArchiveById(Integer goalid) {
		Goal tempGoal=goalRepository.findGoalByGoalid(goalid);
		Goal goal=Goal.builder()
				.goalid(tempGoal.getGoalid())
				.goalname(tempGoal.getGoalname())
				.goaldeadline(tempGoal.getGoaldeadline())
				.goalcost(tempGoal.getGoalcost())
				.currentsavings(tempGoal.getCurrentsavings())
				.status(tempGoal.isStatus())
				.archive(false).build();

		goalRepository.save(goal);
	}
	@Override
	public Iterable archivedGoals() {
		return goalRepository.findByArchiveTrue();
	}

}
