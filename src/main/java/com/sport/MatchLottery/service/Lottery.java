package com.sport.MatchLottery.service;

import com.sport.MatchLottery.model.MatchDay;

import java.util.List;

public interface Lottery {
    List<MatchDay> generateMatchCalendar();
    List<List<MatchDay>> generateGroupCalendar();
}
