package com.sport.MatchLottery.model;

public class MatchDay {

    private FootballClub homeClub;
    private FootballClub awayClub;

    public MatchDay() {
    }

    public MatchDay(FootballClub homeClub, FootballClub awayClub) {
        this.homeClub = homeClub;
        this.awayClub = awayClub;
    }

    public FootballClub getHomeClub() {
        return homeClub;
    }

    public void setHomeClub(FootballClub homeClub) {
        this.homeClub = homeClub;
    }

    public FootballClub getAwayClub() {
        return awayClub;
    }

    public void setAwayClub(FootballClub awayClub) {
        this.awayClub = awayClub;
    }

}
