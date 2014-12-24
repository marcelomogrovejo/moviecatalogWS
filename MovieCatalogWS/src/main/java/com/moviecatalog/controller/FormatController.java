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

import com.moviecatalog.entity.Format;
import com.moviecatalog.service.IFormatService;

@RestController
@RequestMapping("/data/format")
public class FormatController {

	@Autowired
	private IFormatService formatService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Format getFormat(@PathVariable long id) {
		Format f = formatService.getFormat(id);
		return f;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Format> getFormats() {
		List<Format> formats = formatService.getFormats();
		return formats;
	}

	@RequestMapping(value = "", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Format add(@RequestBody Format format) {
		Format f = formatService.saveOrUpdate(format);
		return f;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable long id) {
		Format f = new Format();
		f.setId(id);
		formatService.removeFormat(f);
	}
	
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateFormat(@PathVariable long id, @RequestBody Format format) {
    	format.setId(id);
    	formatService.saveOrUpdate(format);
    }

}