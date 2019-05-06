/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.mulesoft.connectors.caqhconnector.internal.auth;

import org.mule.runtime.http.api.client.auth.HttpAuthentication;
import org.mule.runtime.http.api.client.auth.HttpAuthenticationBuilder;

public class CreateAuthentication {

	private static HttpAuthenticationBuilder authBuilder;
	private static HttpAuthentication authentication;

	public static HttpAuthentication createAuth(String userName, String password){
		authBuilder = HttpAuthentication.basic(userName, password);
		authentication = authBuilder.build()  ;
		return authentication;
	}
}
