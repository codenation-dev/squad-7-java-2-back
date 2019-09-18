package com.codenation.centralerros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codenation.centralerros.model.LogDetail;

public interface LogDetailRepository extends JpaRepository<LogDetail, Long>{

}
