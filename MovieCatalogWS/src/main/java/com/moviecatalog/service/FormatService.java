package com.moviecatalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviecatalog.entity.Format;
import com.moviecatalog.repository.FormatRepository;

@Service
public class FormatService implements IFormatService {

	@Autowired
	private FormatRepository formatRepository;
	
	@Override
	public Format getFormat(Long id){
		Format format = formatRepository.findOne(id);
		return format;
	}
	
	@Override
	public List<Format> getFormats() {
		List<Format> formats = formatRepository.findAll();
		return formats;
	}

	@Override
	public Format saveOrUpdate(Format format) {
		Format formatCrud = null;
		if (format.getId() != null) {
			// Update
			formatCrud = formatRepository.findOne(format.getId());
			formatCrud.setName(format.getName() != null? format.getName() : formatCrud.getName());
		} else {
			// Create
			formatCrud = format;
		}
		formatCrud = formatRepository.save(formatCrud);
		return formatCrud;
	}

	@Override
	public void removeFormat(Format format) {
		formatRepository.delete(format);
	}
	
}
