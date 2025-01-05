package com.sport.MatchLottery.serviceImpl;

import com.sport.MatchLottery.model.FootballClub;
import com.sport.MatchLottery.repository.FootballClubRepository;
import com.sport.MatchLottery.service.FootballClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FootballClubServiceImpl implements FootballClubService {
    @Autowired
    private FootballClubRepository footballClubRepository;
    @Override
    public FootballClub getFootballClub(Long id) {
        return footballClubRepository.getReferenceById(id);
    }

    @Override
    public List<FootballClub> getFootballClubs() {
        return footballClubRepository.findAll();
    }

    @Override
    public FootballClub saveFootballClub(FootballClub club) {
        return footballClubRepository.save(club);
    }

    @Override
    public List<FootballClub> saveFootballClubs(List<FootballClub> clubs) {
        List<FootballClub> saved = new ArrayList<>();
        for (FootballClub club: clubs){
            saved.add(footballClubRepository.save(club));
        }
        return saved;
    }

    @Override
    public FootballClub updateFootballClub(FootballClub club) {
        FootballClub existed = footballClubRepository.getReferenceById(club.getId());
        existed.setName(club.getName());
        existed.setCountry(club.getCountry());
        footballClubRepository.save(existed);
        return existed;
    }

    @Override
    public FootballClub removeFootballClub(FootballClub club) {
        footballClubRepository.delete(club);
        return club;
    }

    @Override
    public FootballClub removeFootballClub(Long id) {
        try{
            FootballClub club = footballClubRepository.findById(id).get();
            footballClubRepository.delete(club);
            return club;
        }catch (Exception e ){
            return null;
        }
    }
}
