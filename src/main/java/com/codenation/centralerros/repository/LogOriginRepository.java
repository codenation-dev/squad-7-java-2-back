package com.codenation.centralerros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codenation.centralerros.model.LogOrigin;

public interface LogOriginRepository extends JpaRepository<LogOrigin, Long>{

}
