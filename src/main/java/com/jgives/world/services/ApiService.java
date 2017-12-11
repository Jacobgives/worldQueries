package com.jgives.world.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jgives.world.models.Country;
import com.jgives.world.repositories.CityRepository;
import com.jgives.world.repositories.CountryRepository;

@Service
public class ApiService {
	
	private CountryRepository countryRepo;
	private CityRepository cityRepo;
	
	public ApiService(CountryRepository countryRepository, CityRepository cityRepository) {
		countryRepo=countryRepository;
		cityRepo=cityRepository;
	}
	public List<Object[]> findCountryAndLanguageByLanguage(String language){
		return countryRepo.findCountryAndLanguageByLanguage(language);
	}
	public List<Object[]> findLanguagesPerCountryGreaterThanPercent(Double percentage){
		return countryRepo.findLanguagesPerCountryGreaterThanPercent(percentage);
	}
	public List<Country> findCountriesSALTPopGT(Double surface_area, Integer population){
		return countryRepo.findCountriesSALTPopGT(surface_area, population);
	}
	public List<Country> findCountriesWGovCapGTLEGT(String government, Integer capital, Double life_expectancy){
		return countryRepo.findCountriesWGovCapGTLEGT(government, capital, life_expectancy);
	}
}
