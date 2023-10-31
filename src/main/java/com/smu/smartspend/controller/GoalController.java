package com.smu.smartspend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.smu.smartspend.model.Goal;
import com.smu.smartspend.service.GoalService;

@Slf4j
@Controller

public class GoalController {


    private final GoalService goalService;

    @Autowired
    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }


    @GetMapping("/add-goal")
    public String addGoal(Model model){
        model.addAttribute("goal",new Goal());
        return "add-edit-goal";
    }

   @PostMapping("/create-update-goal")
    public String createUpdateGoal(Goal goal){
        goalService.addEditGoal(goal);
        return "redirect:/goals";
   }
    @GetMapping("/delete-goal/{id}")
    public String deleteGoal(@PathVariable("id") Integer goalid){goalService.deleteById(goalid);
        return "redirect:/goals";
    }
    @GetMapping("/edit-goal/{id}")
    public String editGoal(@PathVariable("id") Integer id,Model model){
        model.addAttribute("goal",goalService.findGoalById(id));
        return "add-edit-goal";
    }
    @GetMapping("/goals")
    public String goalsList(Model model){
        model.addAttribute("goals",goalService.findAll());
        return "goals";
    }
    @GetMapping("/mark-complete-goal/{id}")
    public String markCompleteGoal(@PathVariable("id") Integer id){
        goalService.markCompleteById(id);
        return "redirect:/goals";
    }
    @GetMapping("/archive-goal/{id}")
    public String archiveGoal(@PathVariable("id") Integer id){
        goalService.archiveById(id);
        return "redirect:/goals";
    }
    @GetMapping("/goals-archive")
    public String goalArchive(Model model){
        model.addAttribute("goals",goalService.archivedGoals());
        return "goals-archive";
    }
    @GetMapping("/remove-archive-goal/{id}")
    public String removeArchiveGoal(@PathVariable("id") Integer id){
        goalService.removeArchiveById(id);
        return "redirect:/goals";
    }
}

   

