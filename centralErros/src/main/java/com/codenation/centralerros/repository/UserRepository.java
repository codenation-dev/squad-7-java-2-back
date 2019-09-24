package com.codenation.centralerros.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.codenation.centralerros.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public Page<User> findByName(String name, Pageable pageable);

}
