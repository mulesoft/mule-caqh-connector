/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.mulesoft.connectors.caqhconnector.internal.config;

import com.mulesoft.connectors.caqhconnector.internal.connection.CAQHConnection;
import com.mulesoft.connectors.caqhconnector.internal.operations.ProviewOperations;
import com.mulesoft.connectors.caqhconnector.internal.connection.provider.CAQHConnectionProvider;
import com.mulesoft.connectors.caqhconnector.internal.operations.DirectAssureOperations;
import com.mulesoft.connectors.caqhconnector.internal.util.Constants;
import com.mulesoft.connectors.caqhconnector.internal.util.RequestService;
import com.mulesoft.connectors.caqhconnector.internal.util.Urls;
import org.mule.connectors.commons.template.config.ConnectorConfig;
import org.mule.runtime.api.connection.ConnectionValidationResult;
import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.http.api.HttpConstants;
import org.mule.runtime.http.api.domain.message.request.HttpRequest;
import org.mule.runtime.http.api.domain.message.response.HttpResponse;

import static com.mulesoft.connectors.caqhconnector.internal.util.Constants.TEST_BATCH_ID;

/**
 * This class represents an extension configuration, values set in this class are commonly used across multiple
 * operations since they represent something core from the extension.
 */
@Operations({DirectAssureOperations.class, ProviewOperations.class})
@ConnectionProviders(CAQHConnectionProvider.class)
public class CAQHConfiguration implements ConnectorConfig {

    @Parameter
    protected static String address;
    @Parameter
    @Optional protected String version;

    public String getAddress() {
        return address;
    }

    public String getVersion() {
        return version;
    }

    public static String getAddressValue(){
        return address;
    }

}
