package com.sport.MatchLottery.service;

import com.sport.MatchLottery.model.Country;

import java.util.List;

public interface CountryService {
    Country getCountryByID(Long id);
    List<Country> getCountries();

    Country saveCountry( Country country);
    List<Country> saveCountry(List<Country> countries);
    Country removeCountry(Country country);
    Country updateCountry(Country country, Long id);
    String deleteCountry(Long id);
}
