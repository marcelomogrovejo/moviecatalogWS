package com.moviecatalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviecatalog.entity.Country;
import com.moviecatalog.repository.CountryRepository;

@Service
public class CountryService implements ICountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	@Override
	public Country getCountry(Long id){
		Country country = countryRepository.findOne(id);
		return country;
	}
	
	@Override
	public List<Country> getCountries() {
		List<Country> countries = countryRepository.findAll();
		return countries;
	}

	@Override
	public Country saveOrUpdate(Country country) {
		Country countryCrud = null;
		if (country.getId() != null) {
			// Update
			countryCrud = countryRepository.findOne(country.getId());
			countryCrud.setName(country.getName() != null? country.getName() : countryCrud.getName());
		} else {
			// Create
			countryCrud = country;
		}
		countryCrud = countryRepository.save(countryCrud);
		return countryCrud;
	}

	@Override
	public void removeCountry(Country country) {
		countryRepository.delete(country);
	}
	
}
