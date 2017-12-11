package com.jgives.world.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jgives.world.models.Country;

public interface CountryRepository extends CrudRepository<Country, Long>{
	public List<Country> findAll();
	
	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.language =?1 ORDER BY l.percentage DESC")
	public List<Object[]> findCountryAndLanguageByLanguage(String language);
	
	@Query("SELECT l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.percentage >?1 ORDER BY l.percentage DESC")
	public List<Object[]> findLanguagesPerCountryGreaterThanPercent(Double percentage);
	
	@Query("SELECT c FROM Country c WHERE c.surface_area <?1 AND c.population >?2")
	public List<Country> findCountriesSALTPopGT(Double surface_area, Integer population);
	
	@Query("SELECT c FROM Country c WHERE c.government_form =?1 AND c.capital >?2 AND c.life_expectancy >?3")
	public List<Country> findCountriesWGovCapGTLEGT(String government, Integer capital, Double life_expectancy);
	
	
	
	
}
