package com.moviecatalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.moviecatalog.entity.Country;
import com.moviecatalog.service.ICountryService;

@RestController
@RequestMapping("/data/country")
public class CountryController {

	@Autowired
	private ICountryService countryService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Country getCountry(@PathVariable long id) {
		Country c = countryService.getCountry(id);
		return c;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Country> getCountries() {
		List<Country> countries = countryService.getCountries();
		return countries;
	}

	@RequestMapping(value = "", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Country add(@RequestBody Country country) {
		Country c = countryService.saveOrUpdate(country);
		return c;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable long id) {
		Country c = new Country();
		c.setId(id);
		countryService.removeCountry(c);
	}
	
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateCountry(@PathVariable long id, @RequestBody Country country) {
    	country.setId(id);
    	countryService.saveOrUpdate(country);
    }

}