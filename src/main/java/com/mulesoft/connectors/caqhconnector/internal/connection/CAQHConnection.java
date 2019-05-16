/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.mulesoft.connectors.caqhconnector.internal.connection;


import org.mule.runtime.api.util.MultiMap;
import org.mule.runtime.http.api.HttpConstants;
import org.mule.runtime.http.api.client.HttpClient;
import org.mule.runtime.http.api.client.auth.HttpAuthentication;
import org.mule.runtime.http.api.client.auth.HttpAuthenticationBuilder;
import org.mule.runtime.http.api.domain.entity.ByteArrayHttpEntity;
import org.mule.runtime.http.api.domain.message.request.HttpRequest;
import org.mule.runtime.http.api.domain.message.request.HttpRequestBuilder;
import org.mule.runtime.http.api.domain.message.response.HttpResponse;
import org.mule.connectors.commons.template.connection.ConnectorConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

/**
 * This class represents an extension connection just as example (there is no real connection with anything here c:).
 */
public final class CAQHConnection implements ConnectorConnection {

    private static final Logger logger = LoggerFactory.getLogger(CAQHConnection.class);

    private HttpAuthentication authentication;
    private HttpClient httpClient;
    private HttpRequestBuilder httpRequestBuilder;
    private int apiTimeout;
    private HttpAuthenticationBuilder auth1;
    private HttpAuthentication auth;
    private String username;
    private String password;

    public CAQHConnection(HttpClient httpClient, int timeout, HttpAuthentication authentication, String username, String password){
        this.authentication = authentication;
        this.httpClient = httpClient;
        this.apiTimeout = timeout;
        this.httpRequestBuilder = HttpRequest.builder();
        this.username = username;
        this.password = password;
    }


    public CompletableFuture<HttpResponse> sendAsyncRequest(HttpConstants.Method method, String uri, MultiMap<String, String> parameterMap, byte[] httpEntity) {


        HttpRequestBuilder builder = HttpRequest.builder();
        auth1 = HttpAuthentication.basic(username, password);
        auth = auth1.build()  ;

        if (httpEntity != null) {
            builder.entity(new ByteArrayHttpEntity(httpEntity));
        }

        return httpClient.sendAsync(builder
                .method(method)
                .uri(uri)
                .addHeader("Content-Type", "application/json")
                .queryParams(parameterMap)
                .build(), apiTimeout, true, auth);
    }


    public void invalidate() {
        httpClient.stop();
    }

    @Override
    public void disconnect() {
        httpClient.stop();
    }

    @Override
    public void validate() {
    }
    public HttpAuthentication getAuthentication() {
        return authentication;
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    public HttpRequestBuilder getHttpRequestBuilder() {
        return httpRequestBuilder;
    }

    public int getApiTimeout() {
        return apiTimeout;
    }

}
