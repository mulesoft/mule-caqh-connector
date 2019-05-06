/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.mulesoft.connectors.caqhconnector.internal.service;

import com.mulesoft.connectors.caqhconnector.api.*;
import com.mulesoft.connectors.caqhconnector.api.ResponseStatus;
import com.mulesoft.connectors.caqhconnector.internal.config.CAQHConfiguration;
import com.mulesoft.connectors.caqhconnector.internal.connection.CAQHConnection;
import com.mulesoft.connectors.caqhconnector.internal.util.CAQHUtil;
import com.mulesoft.connectors.caqhconnector.internal.util.Constants;
import com.mulesoft.connectors.caqhconnector.internal.util.Urls;
import com.mulesoft.connectors.caqhconnector.internal.util.RequestService;
import org.mule.connectors.commons.template.service.DefaultConnectorService;
import org.mule.runtime.api.util.MultiMap;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.runtime.operation.Result;
import org.mule.runtime.http.api.HttpConstants;
import org.mule.runtime.http.api.domain.entity.InputStreamHttpEntity;
import org.mule.runtime.http.api.domain.message.request.HttpRequest;
import org.mule.runtime.http.api.domain.message.response.HttpResponse;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.mulesoft.connectors.caqhconnector.internal.attributes.AttributesUtil.setResponseAttributes;
import static com.mulesoft.connectors.caqhconnector.internal.attributes.AttributesUtil.setResponseAttributesForSend;
import static com.mulesoft.connectors.caqhconnector.internal.exception.ExceptionHandler.checkError;
import static com.mulesoft.connectors.caqhconnector.internal.exception.ExceptionHandler.checkErrorAsync;
import static com.mulesoft.connectors.caqhconnector.internal.util.ClassForName.*;
import static org.mule.runtime.extension.api.annotation.param.MediaType.APPLICATION_JSON;

public class ProviewServiceImpl extends DefaultConnectorService<CAQHConfiguration, CAQHConnection> implements ProviewService {
    public ProviewServiceImpl(CAQHConfiguration config, CAQHConnection connection) {
        super(config, connection);
    }

    public Result<GetAddStatusDTO, ResponseStatus> getResultOfAddService(String batch_id)
    {
        String strUri = getConfig().getAddress() + Urls.ROSTER_API + Urls.API + Urls.ROSTER;
        HttpRequest request = getConnection().getHttpRequestBuilder().method(HttpConstants.Method.GET).uri(strUri)
                .addQueryParam(Constants.BATCH_ID, batch_id)
                .build();
        HttpResponse httpResponse = RequestService.requestCall(request, false, getConnection());
        InputStream response = httpResponse.getEntity().getContent();
        checkError(httpResponse);
        Object dto1 = CAQHUtil.getDtoObject(response, GET_ADD_STATUS_DTO);
        GetAddStatusDTO dto = GetAddStatusDTO.class.cast(dto1);
        return Result.<GetAddStatusDTO, ResponseStatus>builder().output(dto).attributes(setResponseAttributesForSend(httpResponse)).build();
    }

    public Result<GetUpdateResultDTO, ResponseStatus> getResultOfUpdateService(String batch_id)
    {
        String strUri = getConfig().getAddress() + Urls.ROSTER_API + Urls.API + Urls.ROSTER;
        HttpRequest request = getConnection().getHttpRequestBuilder().method(HttpConstants.Method.GET).uri(strUri)
                .addQueryParam(Constants.BATCH_ID, batch_id)
                .build();
        HttpResponse httpResponse = RequestService.requestCall(request, false, getConnection());
        InputStream response = httpResponse.getEntity().getContent();
        checkError(httpResponse);
        Object dto1 = CAQHUtil.getDtoObject(response, GET_UPDATE_RESULT_DTO);
        GetUpdateResultDTO dto = GetUpdateResultDTO.class.cast(dto1);
        return Result.<GetUpdateResultDTO, ResponseStatus>builder().output(dto).attributes(setResponseAttributesForSend(httpResponse)).build();
    }

    public Result<GetDeleteResultDTO, ResponseStatus> getResultOfDeleteService(String batch_id)
    {
        String strUri = getConfig().getAddress() + Urls.ROSTER_API + Urls.API + Urls.ROSTER;
        HttpRequest request = getConnection().getHttpRequestBuilder().method(HttpConstants.Method.GET).uri(strUri)
                .addQueryParam(Constants.BATCH_ID, batch_id)
                .build();
        HttpResponse httpResponse = RequestService.requestCall(request, false, getConnection());
        InputStream response = httpResponse.getEntity().getContent();
        checkError(httpResponse);
        Object dto1 = CAQHUtil.getDtoObject(response, GET_DELETE_RESULT_DTO);
        GetDeleteResultDTO dto = GetDeleteResultDTO.class.cast(dto1);
        return Result.<GetDeleteResultDTO, ResponseStatus>builder().output(dto).attributes(setResponseAttributesForSend(httpResponse)).build();
    }

    public Result<GetProviderStatusDTO, ResponseStatus> getProviderStatusProviewService(String Organization_Id, String Caqh_Provider_Id)
    {
        String strUri = getConfig().getAddress() + Urls.ROSTER_API + Urls.API + Urls.PROVIDER_STATUS;
        HttpRequest request = getConnection().getHttpRequestBuilder().method(HttpConstants.Method.GET).uri(strUri)
                .addQueryParam(Constants.ORGANIZATION_ID_STATUS, Organization_Id)
                .addQueryParam(Constants.CAQH_PROVIDER_ID_STATUS, Caqh_Provider_Id)
                .addQueryParam(Constants.PRODUCT, Constants.PROVIEW)
                .build();
        HttpResponse httpResponse = RequestService.requestCall(request, false, getConnection());
        InputStream response = httpResponse.getEntity().getContent();
        checkError(httpResponse);
        Object dto1 = CAQHUtil.getDtoObject(response, GET_PROVIDERS_STATUS_DTO);
        GetProviderStatusDTO dto = GetProviderStatusDTO.class.cast(dto1);
        return Result.<GetProviderStatusDTO, ResponseStatus>builder().output(dto).attributes(setResponseAttributesForSend(httpResponse)).build();
    }

    public Result<InputStream, ResponseStatus> getProviderCredentialsService(String caqhProviderId, String organizationId, String attestationDate, @Optional String credentialSection)
    {
        String strUri = getConfig().getAddress() + Urls.CREDENTIALING_API + Urls.API + Urls.V2 + Urls.ENTITIES;
        HttpRequest request = getConnection().getHttpRequestBuilder().method(HttpConstants.Method.GET).uri(strUri)
                .addQueryParam(Constants.CAQH_PROVIDER_ID, caqhProviderId)
                .addQueryParam(Constants.ORGANIZATION_ID, organizationId)
                .addQueryParam(Constants.ATTESTATION_DATE, attestationDate)
                .addQueryParam(Constants.CREDENTIAL_SECTION, credentialSection)
                .build();
        HttpResponse httpResponse = RequestService.requestCall(request, false, getConnection());
        checkError(httpResponse);
        InputStream response = httpResponse.getEntity().getContent();
        return Result.<InputStream, ResponseStatus> builder().output(response).attributes(setResponseAttributesForSend(httpResponse)).build();
    }

    public Result<InputStream, ResponseStatus> getProviderDocumentService(String caqhProvider_id, String organization_id, String doc_Type)
    {
        String strUri = getConfig().getAddress() + Urls.DOCUMENT_API + Urls.API + Urls.SUPPORT_DOCS;
        HttpRequest request = getConnection().getHttpRequestBuilder().method(HttpConstants.Method.GET).uri(strUri)
                .addQueryParam(Constants.CAQHPROVIDERID, caqhProvider_id)
                .addQueryParam(Constants.ORGANIZATIONID, organization_id)
                .addQueryParam(Constants.DOC_TYPE, doc_Type)
                .build();
        HttpResponse httpResponse = RequestService.requestCall(request, false, getConnection());
        checkError(httpResponse);
        InputStream response = httpResponse.getEntity().getContent();
        return Result.<InputStream, ResponseStatus>builder().output(response).attributes(setResponseAttributesForSend(httpResponse)).build();
    }

    public Result<InputStream, ResponseStatus> addToRosterRequestPvService(List<RequestToAddRosterPVDTO> addRequestBodies)
    {
        String strUri = getConfig().getAddress() + Urls.ROSTER_API + Urls.API + Urls.ROSTER;
        InputStream inputPayload = CAQHUtil.getInputStreamData(addRequestBodies);
        HttpRequest request = getConnection().getHttpRequestBuilder().method(HttpConstants.Method.POST).uri(strUri)
                .addQueryParam(Constants.PRODUCT, Constants.PROVIEW)
                .entity(new InputStreamHttpEntity(inputPayload))
                .addHeader(Constants.CONTENT_TYPE, APPLICATION_JSON)
                .build();
        HttpResponse httpResponse = RequestService.requestCall(request, false, getConnection());
        checkError(httpResponse);
        InputStream response = httpResponse.getEntity().getContent();
        return Result.<InputStream, ResponseStatus>builder().output(response).attributes(setResponseAttributesForSend(httpResponse)).build();
    }

    public Result<InputStream, ResponseStatus> deleteFromRosterRequestPvService(List<RequestToDeleteRosterDADTO> deleteRequestBodies)
    {
        String strUri = getConfig().getAddress() + Urls.ROSTER_API + Urls.API + Urls.DE_ROSTER;
        InputStream inputPayload = CAQHUtil.getInputStreamData(deleteRequestBodies);
        HttpRequest request = getConnection().getHttpRequestBuilder().method(HttpConstants.Method.PUT).uri(strUri)
                .addQueryParam(Constants.PRODUCT, Constants.PROVIEW)
                .entity(new InputStreamHttpEntity(inputPayload))
                .addHeader(Constants.CONTENT_TYPE, APPLICATION_JSON)
                .build();
        HttpResponse httpResponse = RequestService.requestCall(request, false, getConnection());
        checkError(httpResponse);
        InputStream response = httpResponse.getEntity().getContent();
        return Result.<InputStream, ResponseStatus>builder().output(response).attributes(setResponseAttributesForSend(httpResponse)).build();
    }

    public Result<InputStream, ResponseStatus> deleteFromProviewApiService(List<RequestToDeleteRosterDADTO> deleteProviewBodies)
    {
        String strUri = getConfig().getAddress() ;
        String actualUrl = new StringBuilder(strUri).append(Urls.PROVIEW_API)
                .append(Urls.API).append(Urls.DE_ROSTER).toString();
        byte[] byteArray = CAQHUtil.getByteArrayData(deleteProviewBodies);
        MultiMap<String, String> qParams = new MultiMap<>();
        qParams.put(Constants.PRODUCT, Constants.PROVIEW);
        CompletableFuture<HttpResponse> response = getConnection().sendAsyncRequest(HttpConstants.Method.POST,actualUrl,qParams, byteArray);
        checkErrorAsync(response);
        InputStream str = CAQHUtil.getContentInputStream(response);
        return Result.<InputStream,ResponseStatus>builder().output(str).attributes(setResponseAttributes(response)).build();
    }

    public Result<InputStream, ResponseStatus> updateToRosterRequestPvByPutService(List<RequestToUpdatePVDTO> details)
    {
        String strUri = getConfig().getAddress() + Urls.ROSTER_API + Urls.API + Urls.ROSTER;
        InputStream inputPayload = CAQHUtil.getInputStreamData(details);
        HttpRequest request = getConnection().getHttpRequestBuilder().method(HttpConstants.Method.PUT).uri(strUri)
                .addQueryParam(Constants.PRODUCT, Constants.PROVIEW)
                .entity(new InputStreamHttpEntity(inputPayload))
                .addHeader(Constants.CONTENT_TYPE, APPLICATION_JSON)
                .build();
        HttpResponse httpResponse = RequestService.requestCall(request, true, getConnection());
        checkError(httpResponse);
        InputStream response = httpResponse.getEntity().getContent();
        return Result.<InputStream, ResponseStatus>builder().output(response).attributes(setResponseAttributesForSend(httpResponse)).build();
    }

    public Result<InputStream, ResponseStatus> updateToRosterRequestPvService(List<RequestToUpdatePVDTO> updateProviewDetails)
    {
        String strUri = getConfig().getAddress() ;
        String actualUrl = new StringBuilder(strUri).append(Urls.PROVIEW_API)
                .append(Urls.API).append(Urls.ROSTER).append(Urls.POST_UPDATE_ROSTER).toString();
        byte[] byteArray = CAQHUtil.getByteArrayData(updateProviewDetails);
        MultiMap<String, String> qParams = new MultiMap<>();
        qParams.put(Constants.PRODUCT, Constants.PROVIEW);
        CompletableFuture<HttpResponse> response = getConnection().sendAsyncRequest(HttpConstants.Method.POST,actualUrl,qParams, byteArray);
        checkErrorAsync(response);
        InputStream str = CAQHUtil.getContentInputStream(response);
        return Result.<InputStream,ResponseStatus>builder().output(str).attributes(setResponseAttributes(response)).build();
    }
}


