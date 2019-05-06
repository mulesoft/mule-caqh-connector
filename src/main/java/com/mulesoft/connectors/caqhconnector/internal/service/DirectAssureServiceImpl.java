/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.mulesoft.connectors.caqhconnector.internal.service;

import com.mulesoft.connectors.caqhconnector.api.GetProviderStatusDTO;
import com.mulesoft.connectors.caqhconnector.api.RequestToAddRosterPVDTO;
import com.mulesoft.connectors.caqhconnector.api.RequestToDeleteRosterDADTO;
import com.mulesoft.connectors.caqhconnector.api.RequestToUpdateDADTO;
import com.mulesoft.connectors.caqhconnector.api.ResponseStatus;
import com.mulesoft.connectors.caqhconnector.internal.config.CAQHConfiguration;
import com.mulesoft.connectors.caqhconnector.internal.connection.CAQHConnection;
import com.mulesoft.connectors.caqhconnector.internal.util.CAQHUtil;
import com.mulesoft.connectors.caqhconnector.internal.util.Urls;
import com.mulesoft.connectors.caqhconnector.internal.util.Constants;
import com.mulesoft.connectors.caqhconnector.internal.util.RequestService;
import org.mule.connectors.commons.template.service.DefaultConnectorService;
import org.mule.runtime.api.util.MultiMap;
import org.mule.runtime.extension.api.runtime.operation.Result;
import org.mule.runtime.http.api.HttpConstants;
import org.mule.runtime.http.api.domain.message.request.HttpRequest;
import org.mule.runtime.http.api.domain.message.response.HttpResponse;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.mulesoft.connectors.caqhconnector.internal.attributes.AttributesUtil.setResponseAttributes;
import static com.mulesoft.connectors.caqhconnector.internal.attributes.AttributesUtil.setResponseAttributesForSend;
import static com.mulesoft.connectors.caqhconnector.internal.exception.ExceptionHandler.checkError;
import static com.mulesoft.connectors.caqhconnector.internal.exception.ExceptionHandler.checkErrorAsync;
import static com.mulesoft.connectors.caqhconnector.internal.util.ClassForName.GET_PROVIDERS_STATUS_DTO;

public class DirectAssureServiceImpl extends DefaultConnectorService<CAQHConfiguration, CAQHConnection> implements DirectAssureService {

    public DirectAssureServiceImpl(CAQHConfiguration config, CAQHConnection connection) {
        super(config, connection);
    }

    @Override
    public Result<InputStream, ResponseStatus> addToRosterRequestDaService(List<RequestToAddRosterPVDTO> addToDABodies) {
        String strUri = getConfig().getAddress();
        String actualUrl = new StringBuilder(strUri).append(Urls.ROSTER_API).append(Urls.API).append(Urls.ROSTER).toString();
        byte[] byteArray = CAQHUtil.getByteArrayData(addToDABodies);
        MultiMap<String, String> qParams = new MultiMap<>();
        qParams.put(Constants.PRODUCT, Constants.DIRECT_ASSURE);
        CompletableFuture<HttpResponse> response = getConnection().sendAsyncRequest(HttpConstants.Method.POST, actualUrl, qParams, byteArray);
        checkErrorAsync(response);
        InputStream str = CAQHUtil.getContentInputStream(response);
        return Result.<InputStream, ResponseStatus>builder().output(str).attributes(setResponseAttributes(response)).build();
    }

    @Override
    public Result<GetProviderStatusDTO, ResponseStatus> getProviderStatusDaService(String Organization_Id, String Caqh_Provider_Id){
        String strUri = getConfig().getAddress() + Urls.ROSTER_API + Urls.API + Urls.PROVIDER_STATUS;
        HttpRequest request = getConnection().getHttpRequestBuilder().method(HttpConstants.Method.GET).uri(strUri)
                .addQueryParam(Constants.PRODUCT, Constants.DIRECT_ASSURE)
                .addQueryParam(Constants.ORGANIZATION_ID_STATUS, Organization_Id)
                .addQueryParam(Constants.CAQH_PROVIDER_ID_STATUS, Caqh_Provider_Id)
                .build();
        HttpResponse httpResponse = RequestService.requestCall(request, true, getConnection());
        checkError(httpResponse);
        InputStream response = httpResponse.getEntity().getContent();
        Object dto1 = CAQHUtil.getDtoObject(response, GET_PROVIDERS_STATUS_DTO);
        GetProviderStatusDTO dto = GetProviderStatusDTO.class.cast(dto1);
        return Result.<GetProviderStatusDTO, ResponseStatus>builder().output(dto).attributes(setResponseAttributesForSend(httpResponse)).build();
    }

    @Override
    public Result<InputStream, ResponseStatus> updateToRosterRequestDaByPutService(List<RequestToUpdateDADTO> updateDAByPutRequests) {
        String strUri = getConfig().getAddress();
        String actualUrl = new StringBuilder(strUri).append(Urls.ROSTER_API).append(Urls.API).append(Urls.ROSTER).toString();
        byte[] byteArray = CAQHUtil.getByteArrayData(updateDAByPutRequests);
        MultiMap<String, String> qParams = new MultiMap<>();
        qParams.put(Constants.PRODUCT, Constants.DIRECT_ASSURE);
        CompletableFuture<HttpResponse> response = getConnection().sendAsyncRequest(HttpConstants.Method.PUT, actualUrl, qParams, byteArray);
        checkErrorAsync(response);
        InputStream str = CAQHUtil.getContentInputStream(response);
        return Result.<InputStream, ResponseStatus>builder().output(str).attributes(setResponseAttributes(response)).build();
    }

    @Override
    public Result<InputStream, ResponseStatus> updateToProviewApiDaService(List<RequestToUpdateDADTO> updateDAByPostRequests) {
        String strUri = getConfig().getAddress();
        String actualUrl = new StringBuilder(strUri).append(Urls.PROVIEW_API).append(Urls.API).append(Urls.ROSTER).append(Urls.POST_UPDATE_ROSTER).toString();
        byte[] byteArray = CAQHUtil.getByteArrayData(updateDAByPostRequests);
        MultiMap<String, String> qParams = new MultiMap<>();
        qParams.put(Constants.PRODUCT, Constants.DIRECT_ASSURE);
        CompletableFuture<HttpResponse> response = getConnection().sendAsyncRequest(HttpConstants.Method.POST, actualUrl, qParams, byteArray);
        checkErrorAsync(response);
        InputStream str = CAQHUtil.getContentInputStream(response);
        return Result.<InputStream, ResponseStatus>builder().output(str).attributes(setResponseAttributes(response)).build();
    }

    @Override
    public Result<InputStream, ResponseStatus> deleteFromRosterRequestDaByPutService(List<RequestToDeleteRosterDADTO> deleteDAByPutBodies) {
        String strUri = getConfig().getAddress();
        String actualUrl = new StringBuilder(strUri).append(Urls.ROSTER_API).append(Urls.API).append(Urls.DE_ROSTER).toString();
        byte[] byteArray = CAQHUtil.getByteArrayData(deleteDAByPutBodies);
        MultiMap<String, String> qParams = new MultiMap<>();
        qParams.put(Constants.PRODUCT, Constants.DIRECT_ASSURE);
        CompletableFuture<HttpResponse> response = getConnection().sendAsyncRequest(HttpConstants.Method.PUT, actualUrl, qParams, byteArray);
        checkErrorAsync(response);
        InputStream str = CAQHUtil.getContentInputStream(response);
        return Result.<InputStream, ResponseStatus>builder().output(str).attributes(setResponseAttributes(response)).build();
    }

    @Override
    public Result<InputStream, ResponseStatus> deleteFromProviewApiDaService(List<RequestToDeleteRosterDADTO> deleteDAByPostBodies) {
        String strUri = getConfig().getAddress();
        String actualUrl = new StringBuilder(strUri).append(Urls.PROVIEW_API)
                .append(Urls.API).append(Urls.DE_ROSTER).toString();
        byte[] byteArray = CAQHUtil.getByteArrayData(deleteDAByPostBodies);
        MultiMap<String, String> qParams = new MultiMap<>();
        qParams.put(Constants.PRODUCT, Constants.DIRECT_ASSURE);
        CompletableFuture<HttpResponse> response = getConnection().sendAsyncRequest(HttpConstants.Method.POST, actualUrl, qParams, byteArray);
        checkErrorAsync(response);
        InputStream str = CAQHUtil.getContentInputStream(response);
        return Result.<InputStream, ResponseStatus>builder().output(str).attributes(setResponseAttributes(response)).build();
    }
}
