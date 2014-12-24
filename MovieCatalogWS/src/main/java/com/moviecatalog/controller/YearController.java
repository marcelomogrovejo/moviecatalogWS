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

import com.moviecatalog.entity.Year;
import com.moviecatalog.service.IYearService;

@RestController
@RequestMapping("/data/year")
public class YearController {

	@Autowired
	private IYearService yearService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Year getYear(@PathVariable long id) {
		Year y = yearService.getYear(id);
		return y;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Year> getYears() {
		List<Year> years = yearService.getYears();
		return years;
	}

	@RequestMapping(value = "", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Year add(@RequestBody Year year) {
		Year y = yearService.saveOrUpdate(year);
		return y;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable long id) {
		Year y = new Year();
		y.setId(id);
		yearService.removeYear(y);
	}
	
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateYear(@PathVariable long id, @RequestBody Year year) {
    	year.setId(id);
    	yearService.saveOrUpdate(year);
    }

}