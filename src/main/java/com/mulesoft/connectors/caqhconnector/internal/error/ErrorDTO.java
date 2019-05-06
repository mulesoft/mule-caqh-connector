/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.mulesoft.connectors.caqhconnector.internal.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"status_code",
		"error",
		"error_type"
})

public class ErrorDTO {

	@JsonProperty("status_code")
	private int statusCode;

	@JsonProperty("error")
	private String errorMessage;

	@JsonProperty("error_type")
	private String errorType;

	@JsonProperty("status_code")
	public int getStatusCode() {
		return statusCode;
	}

	@JsonProperty("status_code")
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	@JsonProperty("error")
	public String getErrorMessage() {
		return errorMessage;
	}

	@JsonProperty("error")
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@JsonProperty("error_type")
	public String getErrorType() {
		return errorType;
	}

	@JsonProperty("error_type")
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	@Override
	public String toString(){
		String returnMsg = (statusCode != 0) ? "Error code : " + statusCode + "\n" : "";
		returnMsg = (errorType != null) ? returnMsg + "Error type : " + errorType + "\n" : returnMsg;
		returnMsg = (errorMessage != null) ? returnMsg + "Error cause : " + errorMessage + "\n" : returnMsg;
		return returnMsg;
	}
}

