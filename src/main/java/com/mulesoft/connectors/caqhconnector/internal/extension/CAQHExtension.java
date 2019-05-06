/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.mulesoft.connectors.caqhconnector.internal.extension;

import com.mulesoft.connectors.caqhconnector.internal.config.CAQHConfiguration;
import com.mulesoft.connectors.caqhconnector.internal.connection.provider.CAQHConnectionProvider;
import com.mulesoft.connectors.caqhconnector.internal.error.ErrorTypes;
import org.mule.runtime.extension.api.annotation.Configurations;
import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;
import org.mule.runtime.extension.api.annotation.license.RequiresEnterpriseLicense;

import static org.mule.runtime.api.meta.Category.SELECT;

/**
 * This is the main class of an extension, is the entry point from which configurations, connection providers, operations
 * and sources are going to be declared.
 */
@Xml(prefix = "caqh")
@RequiresEnterpriseLicense(allowEvaluationLicense = true)
@Extension(name = "CAQH", category = SELECT)
@Configurations(CAQHConfiguration.class)
@ConnectionProviders ({CAQHConnectionProvider.class})
@org.mule.runtime.extension.api.annotation.error.ErrorTypes(ErrorTypes.class)
public class CAQHExtension {

}
