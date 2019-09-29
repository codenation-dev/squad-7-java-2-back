
package com.codenation.centralerros.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogOriginDTO {
	
	private Long id;
	private String host;
	private String ip;
	private String name;
	private String environment;
	private String createdDate;

}