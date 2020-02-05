package com.berserk.commons.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

	public enum ErrorType {
		INVALID, WARN, ERROR, FATAL;
	}

	@ApiModelProperty(dataType = "string",
			value = "Invalid - Request did not confirm to the specification ")
	private ErrorType type;

	@ApiModelProperty(dataType = "string", value = "Error code")
	private String code;

	@ApiModelProperty(dataType = "string",
			value = "Error description")
	private String details;

	@ApiModelProperty(dataType = "string",
			value = "Error name field")
	private String location;
}
