package com.moviecatalog.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIE")
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MOVIE_ID")
	private Long id;
	
	@Column(name = "TITLE")
	private String title;

	@Column(name = "OVERVIEW", columnDefinition = "text")
	private String overview;
	
	@Column(name = "PICTURE", columnDefinition = "text")
	private String picture;
	
	@Column(name = "TRAILER", columnDefinition = "text")
	private String trailer;
	
	@Column(name = "RANKING")
	private BigDecimal ranking;
	
	@Column(name = "DATE")
	private Date date;
	
	@OneToOne(fetch = FetchType.EAGER)  // FIXME: why not LAZY
//	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "YEAR_ID")
	private Year year;
	
	@OneToOne(fetch = FetchType.EAGER)  // FIXME: why not LAZY
//	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COUNTRY_ID")
	private Country country;

	@OneToOne(fetch = FetchType.EAGER)  // FIXME: why not LAZY
//	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DIRECTOR_ID")
	private Director director;

	@OneToOne(fetch = FetchType.EAGER)  // FIXME: why not LAZY
//	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FORMAT_ID")
	private Format format;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public BigDecimal getRanking() {
		return ranking;
	}

	public void setRanking(BigDecimal ranking) {
		this.ranking = ranking;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}
	
}
