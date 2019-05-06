/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.mulesoft.connectors.caqhconnector.internal.service;

import com.mulesoft.connectors.caqhconnector.api.GetAddStatusDTO;
import com.mulesoft.connectors.caqhconnector.api.GetDeleteResultDTO;
import com.mulesoft.connectors.caqhconnector.api.GetUpdateResultDTO;
import com.mulesoft.connectors.caqhconnector.api.GetProviderStatusDTO;
import com.mulesoft.connectors.caqhconnector.api.RequestToAddRosterPVDTO;
import com.mulesoft.connectors.caqhconnector.api.RequestToDeleteRosterDADTO;
import com.mulesoft.connectors.caqhconnector.api.RequestToUpdatePVDTO;
import com.mulesoft.connectors.caqhconnector.api.ResponseStatus;
import org.mule.connectors.commons.template.service.ConnectorService;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.runtime.operation.Result;

import java.io.InputStream;
import java.util.List;

public interface ProviewService extends ConnectorService {

    Result<GetAddStatusDTO, ResponseStatus> getResultOfAddService(String batch_id);

    Result<GetUpdateResultDTO, ResponseStatus> getResultOfUpdateService(String batch_id);

    Result<GetDeleteResultDTO, ResponseStatus> getResultOfDeleteService(String batch_id);

    Result<GetProviderStatusDTO, ResponseStatus> getProviderStatusProviewService(String Organization_Id, String Caqh_Provider_Id);

    Result<InputStream, ResponseStatus> getProviderCredentialsService(String caqhProviderId, String organizationId, String attestationDate, @Optional String credentialSection);

    Result<InputStream, ResponseStatus> getProviderDocumentService(String caqhProvider_id, String organization_id, String doc_Type);

    Result<InputStream, ResponseStatus> addToRosterRequestPvService(List<RequestToAddRosterPVDTO> addRequestBodies);

    Result<InputStream, ResponseStatus> deleteFromRosterRequestPvService(List<RequestToDeleteRosterDADTO> deleteRequestBodies);

    Result<InputStream, ResponseStatus> deleteFromProviewApiService(List<RequestToDeleteRosterDADTO> deleteProviewBodies);

    Result<InputStream, ResponseStatus> updateToRosterRequestPvByPutService(List<RequestToUpdatePVDTO> details);

    Result<InputStream, ResponseStatus> updateToRosterRequestPvService(List<RequestToUpdatePVDTO> updateProviewDetails);
}
