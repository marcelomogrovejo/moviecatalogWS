package com.moviecatalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviecatalog.entity.Year;
import com.moviecatalog.repository.YearRepository;

@Service
public class YearService implements IYearService {

	@Autowired
	private YearRepository yearRepository;
	
	@Override
	public Year getYear(Long id){
		Year year = yearRepository.findOne(id);
		return year;
	}
	
	@Override
	public List<Year> getYears() {
		List<Year> years = yearRepository.findAll();
		return years;
	}

	@Override
	public Year saveOrUpdate(Year year) {
		Year yearCrud = null;
		if (year.getId() != null) {
			// Update
			yearCrud = yearRepository.findOne(year.getId());
			yearCrud.setYear(year.getYear() != null? year.getYear() : yearCrud.getYear());
		} else {
			// Create
			yearCrud = year;
		}
		yearCrud = yearRepository.save(yearCrud);
		return yearCrud;
	}

	@Override
	public void removeYear(Year year) {
		yearRepository.delete(year);
	}
	
}
