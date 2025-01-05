package com.sport.MatchLottery.repository;

import com.sport.MatchLottery.model.FootballClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballClubRepository extends JpaRepository<FootballClub, Long> {
}
