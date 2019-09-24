package com.codenation.centralerros.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.codenation.centralerros.dto.LogDetailDTO;
import com.codenation.centralerros.dto.LogOriginDTO;
import com.codenation.centralerros.model.LogDetail;
import com.codenation.centralerros.model.LogOrigin;

@Mapper(componentModel = "spring")
public interface LogDetailMapper {

	@Mappings({@Mapping(source = "createdDate", target = "createdDate", dateFormat = "yyyy-MM-dd HH:mm")})
	LogDetailDTO map(LogDetail logDetail);
	
	@Mappings({@Mapping(source = "createdDate", target = "createdDate", dateFormat = "yyyy-MM-dd HH:mm")})
	LogOriginDTO map(LogOrigin logOrigin);
	
	@Mappings({@Mapping(source = "createdDate", target = "createdDate", dateFormat = "yyyy-MM-dd HH:mm")})
	LogDetail map(LogDetailDTO logDetailDTO);
	
	@Mappings({@Mapping(source = "createdDate", target = "createdDate", dateFormat = "yyyy-MM-dd HH:mm")})
	LogOrigin map(LogOriginDTO logOriginDTO);

	List<LogDetailDTO> map(List<LogDetail> logDetail);
	

}
