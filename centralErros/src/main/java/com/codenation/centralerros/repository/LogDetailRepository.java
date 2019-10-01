package com.codenation.centralerros.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;

import com.codenation.centralerros.model.LogDetail;
import com.codenation.centralerros.model.enums.Environment;

public interface LogDetailRepository extends JpaRepository<LogDetail, Long>{
	
	List<LogDetail> findByOriginEnvironment(Environment env);
	
	@Transactional(readOnly=true)
	@Query("SELECT d FROM LogDetail d where "
			+ " ( coalesce(:title, null) is null or UPPER(d.title) LIKE %:title% ) "
			+ " and ( coalesce(:detail, null) is null or UPPER(d.detail) LIKE %:detail% ) "
			+ " and ( coalesce(:level, null) is null or d.level = %:level% ) "
			+ " and ( coalesce(:archived, null) is null or d.archived = :archived ) ")
	Page<LogDetail> pesquisaLogDetailAvancada(
			  @Param("title") @Nullable String title
			, @Param("detail") @Nullable String detail
			, @Param("level") @Nullable String level
			, @Param("archived") @Nullable Boolean archived, 
			Pageable pageable);
}
