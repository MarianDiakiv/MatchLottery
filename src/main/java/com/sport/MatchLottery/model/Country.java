package com.sport.MatchLottery.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name="country")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@ToString
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "country")
    private Set<FootballClub> footballClubs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}