package com.sport.MatchLottery.controller;

import com.sport.MatchLottery.model.Country;
import com.sport.MatchLottery.model.FootballClub;
import com.sport.MatchLottery.service.FootballClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/football-club")
public class FootballClubController {
    @Autowired
    private FootballClubService footballClubService;

    @GetMapping
    public List<FootballClub> getAll(){
        return footballClubService.getFootballClubs();
    }
    @GetMapping("/{id}")
    public FootballClub getById(@PathVariable Long id){
        return footballClubService.getFootballClub(id);
    }
    @PostMapping
    public FootballClub createFootballClub(@RequestBody FootballClub club){
        return  footballClubService.saveFootballClub(club);
    }

}
