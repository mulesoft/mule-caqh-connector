/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.mulesoft.connectors.caqhconnector.internal.error;

import org.mule.runtime.extension.api.annotation.error.ErrorTypeProvider;
import org.mule.runtime.extension.api.error.ErrorTypeDefinition;

import java.util.HashSet;
import java.util.Set;


public class ErrorProvider implements ErrorTypeProvider {

	@Override
	public Set<ErrorTypeDefinition> getErrorTypes() {
		HashSet<ErrorTypeDefinition> errors = new HashSet<>();
		errors.add(ErrorTypes.BAD_REQUEST);
		errors.add(ErrorTypes.UNAUTHORIZED);
		errors.add(ErrorTypes.FORBIDDEN);
		errors.add(ErrorTypes.NOT_FOUND);
		errors.add(ErrorTypes.METHOD_NOT_ALLOWED);
		errors.add(ErrorTypes.NOT_ACCEPTABLE);
		errors.add(ErrorTypes.REQUEST_TIMEOUT);
		errors.add(ErrorTypes.CONFLICT);
		errors.add(ErrorTypes.INTERNAL_SERVER_ERROR);
		errors.add(ErrorTypes.NOT_IMPLEMENTED);
		errors.add(ErrorTypes.BAD_GATEWAY);
		errors.add(ErrorTypes.SERVICE_UNAVAILABLE);
		errors.add(ErrorTypes.EMPTY_HEAD_COUNT);
		errors.add(ErrorTypes.DEAD_TOKEN);
		errors.add(ErrorTypes.GENERIC_EXCEPTION);
		return errors;
	}
}
