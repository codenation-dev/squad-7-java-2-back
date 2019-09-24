package com.codenation.centralerros.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.codenation.centralerros.model.Environment;
import com.codenation.centralerros.model.LogDetail;

public interface LogDetailRepository extends JpaRepository<LogDetail, Long>{
	
	public Page<LogDetail> findByOriginEnvironment(Environment env, Pageable pageable);
	
}
