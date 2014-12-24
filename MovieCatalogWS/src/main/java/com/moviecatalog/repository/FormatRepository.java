package com.moviecatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moviecatalog.entity.Format;

public interface FormatRepository extends JpaRepository<Format, Long>{

}
