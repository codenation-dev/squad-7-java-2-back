package com.codenation.centralerros.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;

import com.codenation.centralerros.model.LogError;
import com.codenation.centralerros.model.enums.Environment;
import com.codenation.centralerros.model.enums.Level;

public interface LogErrorRepository extends JpaRepository<LogError, Long>{
	
	List<LogError> findByEnvironment(Environment env);
	
	@Transactional(readOnly=true)
	@Query("SELECT d FROM LogError d where d.archived = false and "
			+ " ( coalesce(:ip, null) is null or UPPER(d.ip) LIKE %:ip% ) "
			+ " and ( coalesce(:detail, null) is null or UPPER(d.detail) LIKE %:detail% ) "
			+ " and ( coalesce(:level, null) is null or d.level = :level ) "
			+ " and ( coalesce(:environment, null) is null or d.environment = :environment ) ")
	Page<LogError> pesquisaLogErrorAvancada(
			  @Param("ip") @Nullable String ip
			, @Param("detail") @Nullable String detail
			, @Param("level") @Nullable Level level
			, @Param("environment") @Nullable Environment environment, 
			Pageable pageable);
}
