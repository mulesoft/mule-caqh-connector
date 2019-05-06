/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.mulesoft.connectors.caqhconnector.internal.service;

import com.mulesoft.connectors.caqhconnector.api.GetProviderStatusDTO;
import com.mulesoft.connectors.caqhconnector.api.RequestToAddRosterPVDTO;
import com.mulesoft.connectors.caqhconnector.api.RequestToUpdateDADTO;
import com.mulesoft.connectors.caqhconnector.api.RequestToDeleteRosterDADTO;
import com.mulesoft.connectors.caqhconnector.api.ResponseStatus;
import org.mule.connectors.commons.template.service.ConnectorService;
import org.mule.runtime.extension.api.runtime.operation.Result;

import java.io.InputStream;
import java.util.List;

public interface DirectAssureService extends ConnectorService {

    Result<InputStream, ResponseStatus> addToRosterRequestDaService(List<RequestToAddRosterPVDTO> addToDABodies);

    Result<GetProviderStatusDTO, ResponseStatus> getProviderStatusDaService(String Organization_Id, String Caqh_Provider_Id);

    Result<InputStream, ResponseStatus> updateToRosterRequestDaByPutService(List<RequestToUpdateDADTO> updateDAByPutRequests);

    Result<InputStream, ResponseStatus> updateToProviewApiDaService(List<RequestToUpdateDADTO> updateDAByPostRequests);

    Result<InputStream, ResponseStatus> deleteFromRosterRequestDaByPutService(List<RequestToDeleteRosterDADTO> deleteDAByPutBodies);

    Result<InputStream, ResponseStatus> deleteFromProviewApiDaService(List<RequestToDeleteRosterDADTO> deleteDAByPostBodies);
}
