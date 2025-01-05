package com.sport.MatchLottery.service;

import com.sport.MatchLottery.model.FootballClub;

import java.util.List;

public interface FootballClubService {

    FootballClub getFootballClub(Long id);
    List<FootballClub> getFootballClubs();

    FootballClub saveFootballClub(FootballClub club);
    List<FootballClub> saveFootballClubs(List<FootballClub> clubs);

    FootballClub updateFootballClub(FootballClub club);

    FootballClub removeFootballClub(FootballClub club);
    FootballClub removeFootballClub(Long id);



}
