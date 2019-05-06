/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.mulesoft.connectors.caqhconnector.internal.exception;

import com.mulesoft.connectors.caqhconnector.internal.error.ErrorDTO;
import com.mulesoft.connectors.caqhconnector.internal.error.ErrorTypes;
import org.mule.runtime.core.api.util.IOUtils;
import org.mule.runtime.http.api.domain.message.response.HttpResponse;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExceptionHandler {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

	public static void checkError(HttpResponse response) {
		ErrorDTO dto = new ErrorDTO();
		StringBuilder builder = new StringBuilder();
		if (!(response.getStatusCode() == 200 || response.getStatusCode() == 201 || response.getStatusCode() == 202 || response.getStatusCode() == 204)) {
			InputStream str= response.getEntity().getContent();
			String responseStr = IOUtils.toString(str, "UTF-8");
				dto.setStatusCode(response.getStatusCode());
				dto.setErrorType(response.getReasonPhrase());
				dto.setErrorMessage(responseStr);
				throw new CAQHConnectorException(builder.append(dto).toString(), getError(response.getStatusCode()));
			}
	}

	public static void checkErrorAsync(CompletableFuture<HttpResponse> response) {
		try {
			ErrorDTO dto = new ErrorDTO();
			StringBuilder builder = new StringBuilder();
			if (!(response.get().getStatusCode() == 200 || response.get().getStatusCode() == 201
					|| response.get().getStatusCode() == 202 || response.get().getStatusCode() == 204)) {
				InputStream str = response.get().getEntity().getContent();
				String responseStr = IOUtils.toString(str, "UTF-8");
				dto.setStatusCode(response.get().getStatusCode());
				dto.setErrorType(response.get().getReasonPhrase());
				dto.setErrorMessage(responseStr);
				throw new CAQHConnectorException(builder.append(dto).toString(), getError(response.get().getStatusCode()));
			}
		}catch (InterruptedException ex){
			logger.info("Error :", ex);
		}catch (ExecutionException ex){
			logger.info("Error :", ex);
		}catch (Exception ex){
			logger.info("Error :", ex);
		}
	}

	private static ErrorTypes getError(Integer status) {
		return ErrorTypes.valueOf(status);
	}
}

