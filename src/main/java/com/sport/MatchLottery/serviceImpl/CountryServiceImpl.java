package com.sport.MatchLottery.serviceImpl;

import com.sport.MatchLottery.model.Country;
import com.sport.MatchLottery.repository.CountryRepository;
import com.sport.MatchLottery.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country getCountryByID(Long id) {
        return countryRepository.findById(id).get();
    }

    @Override
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country removeCountry(Country country) {
        countryRepository.delete(country);
        return country;
    }

    @Override
    public List<Country> saveCountry(List<Country> countries) {
        List<Country> saved = new ArrayList<>();
        for (Country country : countries) {
            saved.add(countryRepository.save(country));
        }

        return saved;
    }

    @Override
    public Country updateCountry(Country country, Long id) {
        Country existed = countryRepository.findById(id).get();
        existed.setName(country.getName());
        countryRepository.save(existed);

        return existed;
    }

    @Override
    public String deleteCountry(Long id) {
        try {
            countryRepository.findById(id).get();
            countryRepository.deleteById(id);
            return "Country Deleted";
        }catch (Exception e){
            return "Country Not Found;";
        }

    }
}
