package com.sport.MatchLottery.controller;

import com.sport.MatchLottery.model.MatchDay;
import com.sport.MatchLottery.service.Lottery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/lottery")
public class LotteryController {
    @Autowired private Lottery lottery;

    @GetMapping
    public List<MatchDay> getMatchDay(){
        return lottery.generateMatchCalendar();
    }
    @GetMapping("/calendar")
    public List<List<MatchDay>> getMatchCalendar(){
        return lottery.generateGroupCalendar();
    }
}
