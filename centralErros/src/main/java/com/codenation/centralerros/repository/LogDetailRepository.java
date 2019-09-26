package com.codenation.centralerros.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.codenation.centralerros.model.Environment;
import com.codenation.centralerros.model.LogDetail;

public interface LogDetailRepository extends JpaRepository<LogDetail, Long>{
	
	List<LogDetail> findByOriginEnvironment(Environment env);
	
}
