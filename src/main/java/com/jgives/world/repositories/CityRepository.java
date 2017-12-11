package com.jgives.world.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jgives.world.models.City;

public interface CityRepository extends CrudRepository<City, Long> {
	public List<City> findAll();
	
}
