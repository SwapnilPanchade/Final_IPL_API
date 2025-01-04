package com.tka.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.PeriodUnit;
import org.springframework.web.bind.annotation.*;

import com.tka.entity.Team;
import com.tka.service.TeamService;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable Long id) {
        return teamService.getTeamById(id);
    }

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable int id, @RequestBody Team team){
        return teamService.updateTeam(id, team);
    }

    @DeleteMapping("/{id}")
    public Team deleteTeam(@PathVariable int id){
        return teamService.deleteTeam(id);
    }

}
