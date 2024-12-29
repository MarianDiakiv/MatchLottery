package com.sport.MatchLottery.controller;

import com.sport.MatchLottery.model.Country;
import com.sport.MatchLottery.repository.CountryRepository;
import com.sport.MatchLottery.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CountryService countryService;


    @GetMapping
    public List<Country> getAll(){
//        List<Country> list = countryRepository.findAll();
//        System.out.println(list.size());
//        System.out.println(list.get(0).toString());
//        System.out.println(list.toString());

//        return countryRepository.findAll();
        return countryService.getCountries();
    }

    @GetMapping("/{id}")
    public Country getById(@PathVariable Long id){
Country country = countryService.getCountryByID(id);
        //System.out.println(country.getId());
        //Country country = countryRepository.getReferenceById(id);

        System.out.println(country.getName());
        return country;
    }
    @PostMapping
    public Country createCountry(@RequestBody Country country){
       return  countryService.saveCountry(country);
    }
    @PostMapping("/list")
    public List<Country> createCountries(@RequestBody List<Country> countries){
        return  countryService.saveCountry(countries);
    }

    @PutMapping("/{id}")
    public Country updateCountry(@PathVariable Long id, @RequestBody Country country){
      return  countryService.updateCountry(country, id);
    }
@DeleteMapping("/{id}")
    public String deleteCountry(@PathVariable Long id){
       return countryService.deleteCountry(id);

}

}
