/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.mulesoft.connectors.caqhconnector.internal.connection.provider;

import com.mulesoft.connectors.caqhconnector.api.GetUpdateResultDTO;
import com.mulesoft.connectors.caqhconnector.internal.connection.CAQHConnection;
import com.mulesoft.connectors.caqhconnector.internal.connection.provider.param.ConnectionParameterGroup;
import com.mulesoft.connectors.caqhconnector.internal.auth.CreateAuthentication;
import com.mulesoft.connectors.caqhconnector.internal.exception.CAQHConnectorException;
import com.mulesoft.connectors.caqhconnector.internal.util.CAQHUtil;
import com.mulesoft.connectors.caqhconnector.internal.util.Constants;
import com.mulesoft.connectors.caqhconnector.internal.util.RequestService;
import com.mulesoft.connectors.caqhconnector.internal.util.Urls;
import org.mule.connectors.commons.template.connection.ConnectorConnectionProvider;
import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.extension.api.annotation.Expression;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.api.connection.ConnectionValidationResult;
import org.mule.runtime.api.connection.PoolingConnectionProvider;
import org.mule.runtime.api.connection.ConnectionProvider;
import org.mule.runtime.api.connection.CachedConnectionProvider;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Placement;
import org.mule.runtime.http.api.HttpConstants;
import org.mule.runtime.http.api.HttpService;
import org.mule.runtime.http.api.client.HttpClient;
import org.mule.runtime.http.api.client.HttpClientConfiguration;
import org.mule.runtime.http.api.client.auth.HttpAuthentication;
import org.mule.runtime.http.api.domain.message.request.HttpRequest;
import org.mule.runtime.http.api.domain.message.response.HttpResponse;
import org.mule.runtime.http.api.tcp.TcpClientSocketProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;


import java.io.InputStream;
import java.util.concurrent.CompletableFuture;

import static com.mulesoft.connectors.caqhconnector.internal.config.CAQHConfiguration.getAddressValue;
import static com.mulesoft.connectors.caqhconnector.internal.exception.ExceptionHandler.checkError;
import static com.mulesoft.connectors.caqhconnector.internal.exception.ExceptionHandler.getError;
import static com.mulesoft.connectors.caqhconnector.internal.util.ClassForName.GET_UPDATE_RESULT_DTO;
import static com.mulesoft.connectors.caqhconnector.internal.util.Constants.BATCH_ID;
import static com.mulesoft.connectors.caqhconnector.internal.util.Constants.TEST_BATCH_ID;
import static com.mulesoft.connectors.caqhconnector.internal.util.RequestService.sendAsyncRequest;
import static org.mule.runtime.api.meta.ExpressionSupport.NOT_SUPPORTED;
import static org.mule.runtime.extension.api.annotation.param.ParameterGroup.CONNECTION;


/**
 * This class (as it's name implies) provides connection instances and the funcionality to disconnect and validate those
 * connections.
 * <p>
 * All connection related parameters (values required in order to create a connection) must be
 * declared in the connection providers.
 * <p>
 * This particular example is a {@link PoolingConnectionProvider} which declares that connections resolved by this provider
 * will be pooled and reused. There are other implementations like {@link CachedConnectionProvider} which lazily creates and
 * caches connections or simply {@link ConnectionProvider} if you want a new connection each time something requires one.
 */
public class CAQHConnectionProvider extends ConnectorConnectionProvider<CAQHConnection> implements ConnectionProvider<CAQHConnection> {

  private static final Logger logger = LoggerFactory.getLogger(CAQHConnectionProvider.class);

  @ParameterGroup(name = CONNECTION)
  @Placement(order = 1)
  private ConnectionParameterGroup connectionParams;

  @Parameter
  private String username;
  @Parameter
  private String password;

  private HttpAuthentication authGen;


  @Inject
  private HttpService httpService;

  @Override
  public CAQHConnection connect() throws ConnectionException {
    authGen = CreateAuthentication.createAuth(username, password);
    HttpClient httpClient = httpService.getClientFactory().create(new HttpClientConfiguration.Builder()
            .setTlsContextFactory(connectionParams.getTlsContext())
            .setClientSocketProperties(TcpClientSocketProperties.builder()
                    .connectionTimeout(connectionParams.getConnectionTimeout())
                    .build())
            .setMaxConnections(connectionParams.getMaxConnections())
            .setUsePersistentConnections(connectionParams.getUsePersistentConnections())
            .setConnectionIdleTimeout(connectionParams.getConnectionIdleTimeout())
            .setStreaming(connectionParams.isStreamResponse())
            .setResponseBufferSize(connectionParams.getResponseBufferSize())
            .setName("CAQHConfiguration")
            .build());
    httpClient.start();

    return new CAQHConnection(httpClient,connectionParams.getConnectionTimeout(), authGen,username, password);
  }

  @Override
  public void disconnect(CAQHConnection connection) {
    try {
      connection.invalidate();
    } catch (Exception e) {
	    logger.info("Error while disconnecting :", e);
    }
  }

  @Override
  public ConnectionValidationResult validate(CAQHConnection connection) {
	  String address = getAddressValue();
	  String strUri = address + Urls.ROSTER_API + Urls.API + Urls.ROSTER;
	  HttpRequest request = connection.getHttpRequestBuilder().method(HttpConstants.Method.GET).uri(strUri)
			  .addQueryParam(BATCH_ID, TEST_BATCH_ID).build();
	  CompletableFuture<HttpResponse> response = sendAsyncRequest(request, true, connection);
	  try {
		  if (response.get().getStatusCode() != 200) {
			  String str = response.get().getStatusCode() + "";
			  return ConnectionValidationResult.failure(str, new CAQHConnectorException(response.get().getReasonPhrase(),getError(response.get().getStatusCode())));
		  }
	  } catch (Exception e) {
		  logger.info("Error happened while validating the connection : " + e);
	  }
	  return ConnectionValidationResult.success();
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }
}