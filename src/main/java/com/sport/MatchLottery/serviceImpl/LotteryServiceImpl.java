package com.sport.MatchLottery.serviceImpl;

import com.sport.MatchLottery.model.FootballClub;
import com.sport.MatchLottery.model.MatchDay;
import com.sport.MatchLottery.service.FootballClubService;
import com.sport.MatchLottery.service.Lottery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class LotteryServiceImpl implements Lottery {
    @Autowired
    private FootballClubService footballClubService;

    @Override
    public List<MatchDay> generateMatchCalendar() {
        // TEST ONLY
        List<MatchDay> matchDay = new ArrayList<>();
        List<FootballClub> clubs = footballClubService.getFootballClubs();
// жеребкування на 1 ігровий день
        while (clubs.size() != 0) {
            getMatchDay(clubs, matchDay);
        }

        return matchDay;
    }

    @Override
    public List<List<MatchDay>> generateGroupCalendar() {
        List<List<MatchDay>> callendar = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            List<MatchDay> matchDay = new ArrayList<>();
            List<FootballClub> clubs = footballClubService.getFootballClubs();
// жеребкування на 1 ігровий день
            while (clubs.size() != 0) {
                getMatchDay(clubs, matchDay);
            }
            callendar.add(matchDay);
        }
        return callendar;
    }

    private MatchDay getMatchDay(List<FootballClub> clubs, List<MatchDay> matchDays) {
        // рекурсивний метод для визначення ігрових пар дім та виїзд із урахуванням країни на 1 день.
        // є команди що попадають більше разів
        //Розробити аналогчно календар із 8 ігор
        //Iterator<FootballClub> iterator = clubs.iterator();
        System.out.println("----------------------");
        System.out.println("Clubs Size: " + clubs.size());
        Random random = new Random();
        int homeClubIndex = random.nextInt(clubs.size() - 1);
        MatchDay day = new MatchDay();
        System.out.println("Home Club Index: " + homeClubIndex);
        day.setHomeClub(clubs.get(homeClubIndex));
        System.out.println(" Selected Home Club: " + day.getHomeClub().getName());
        clubs.remove(homeClubIndex);

        List<FootballClub> possiblyAwayClubs = getClubsListWithoutHomeClubCountry(day.getHomeClub(), clubs);
        int awayClubIndex = 0;
        //
        if (possiblyAwayClubs.size() != 1) {
            awayClubIndex = random.nextInt(possiblyAwayClubs.size() - 1);
        }
        System.out.println("Away Clu Index: " + awayClubIndex);

        //
        if (possiblyAwayClubs.isEmpty()) {
            System.out.println("EEEEEEEEEEEEEEEEEEE  Club: " + day.getHomeClub().getName() + " Country: " + day.getHomeClub().getCountry().getName());
        }

        day.setAwayClub(possiblyAwayClubs.get(awayClubIndex));
        System.out.println("Away Club: " + day.getAwayClub().getName());
        clubs.remove(day.getAwayClub());
        matchDays.add(day);

        System.out.println(" Home Club Name: " + day.getHomeClub().getName() + " Away Club Name: " + day.getAwayClub().getName());

        return day;
    }

    private List<FootballClub> getClubsListWithoutHomeClubCountry(FootballClub homeClub, List<FootballClub> list) {
        List<FootballClub> newClubList = new ArrayList<>();
        for (FootballClub club : list) {
            if (club.getCountry().getId() != homeClub.getCountry().getId()) {
                newClubList.add(club);
            }
        }
        System.out.println("TMP Clubs List Size:" + newClubList.size());
        return newClubList;
    }

}
