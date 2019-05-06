/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.mulesoft.connectors.caqhconnector.internal.operations;

import com.mulesoft.connectors.caqhconnector.api.RequestToAddRosterPVDTO;
import com.mulesoft.connectors.caqhconnector.api.RequestToDeleteRosterDADTO;
import com.mulesoft.connectors.caqhconnector.api.RequestToUpdateDADTO;
import com.mulesoft.connectors.caqhconnector.api.ResponseStatus;
import com.mulesoft.connectors.caqhconnector.internal.config.CAQHConfiguration;
import com.mulesoft.connectors.caqhconnector.internal.connection.CAQHConnection;
import com.mulesoft.connectors.caqhconnector.internal.error.ErrorProvider;
import com.mulesoft.connectors.caqhconnector.internal.service.DirectAssureService;
import com.mulesoft.connectors.caqhconnector.internal.service.DirectAssureServiceImpl;
import com.mulesoft.connectors.caqhconnector.api.GetProviderStatusDTO;
import org.mule.connectors.commons.template.operation.ConnectorOperations;

import org.mule.runtime.extension.api.annotation.error.Throws;
import org.mule.runtime.extension.api.annotation.metadata.fixed.OutputJsonType;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.Content;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.runtime.operation.Result;
import org.mule.runtime.http.api.domain.message.response.HttpResponse;

import java.io.*;
import java.util.List;

import static com.mulesoft.connectors.caqhconnector.internal.exception.ExceptionHandler.checkError;
import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;


public class DirectAssureOperations extends ConnectorOperations<CAQHConfiguration, CAQHConnection, DirectAssureService>{

	public DirectAssureOperations() {
		super(DirectAssureServiceImpl::new);
	}

    /**
     * A PO can add one or more providers to the roster by submitting a call to the API. For this
     * there are different required and optional fields for the Quick Add verses the Initial Add, and at least one of the fields with an asterisk (*) is required to process an Initial Add.
     * Returns the batch_id that is generated on successful addition of Providers on roster.
     *
     * @param configuration     Configuration Object
     * @param connection        Connection object.
     * @param addToDABodies     List of providers to be added to Roster.
     * @return batch_id for the request
     */
    @DisplayName("Add roster-DirectAssure")
    @Throws(ErrorProvider.class)
    @MediaType(value = MediaType.APPLICATION_JSON, strict = false)
    @OutputJsonType(schema = "metadata/PUT-POST-DEL-roster-response.json")

    public Result<InputStream, ResponseStatus> addToRosterRequestDa(@Config CAQHConfiguration configuration, @Connection CAQHConnection connection, @Content List<RequestToAddRosterPVDTO> addToDABodies) {
        return newExecutionBuilder(configuration, connection)
                .execute(DirectAssureService::addToRosterRequestDaService).withParam(addToDABodies);
    }

    /**
     * Method to update one or more providers existing on roster.
     * Returns the batch_id that is generated on successful update of Providers on roster.
     *
     * @param configuration         Configuration Object
     * @param connection            Connection object.
     * @param updateDAByPutRequests List of providers to be updated in Roster.
     * @return batch_id for the request
    */
    @DisplayName("Update roster-DirectAssure")
    @Throws(ErrorProvider.class)
    @MediaType(value = MediaType.APPLICATION_JSON, strict = false)
    @OutputJsonType(schema = "metadata/PUT-POST-DEL-roster-response.json")
    public Result<InputStream, ResponseStatus> updateToRosterRequestDaByPutRequest(@Config CAQHConfiguration configuration,
                                                                              @Connection CAQHConnection connection,
                                                                              @Content List<RequestToUpdateDADTO> updateDAByPutRequests) {

		return newExecutionBuilder(configuration, connection)
				.execute(DirectAssureService::updateToRosterRequestDaByPutService).withParam(updateDAByPutRequests);
    }

    /**
	 * Method to update one or more providers existing on roster.
	 * Returns the batch_id that is generated on successful update of Providers on roster.
	 *
	 * @param configuration          Configuration Object
	 * @param connection             Connection object.
	 * @param updateDAByPostRequests List of providers to be updated in Proview.
	 * @return batch_id for the request
	 */
    @DisplayName("Update proview-DirectAssure")
    @Throws(ErrorProvider.class)
    @MediaType(value = MediaType.APPLICATION_JSON, strict = false)
    @OutputJsonType(schema = "metadata/PUT-POST-DEL-roster-response.json")
    public Result<InputStream, ResponseStatus> updateToProviewApiDa(@Config CAQHConfiguration configuration, @Connection CAQHConnection connection,
                                                               @Content List<RequestToUpdateDADTO> updateDAByPostRequests) {
		return newExecutionBuilder(configuration, connection)
				.execute(DirectAssureService::updateToProviewApiDaService).withParam(updateDAByPostRequests);
    }

    /**
     * Method to delete one or more providers from the roster.
     * Returns the batch_id that is generated on successful deletion of Providers from roster.
     *
     * @param configuration         Configuration Object
     * @param connection            Connection object
     * @param deleteDAByPutBodies   List of providers to be deleted from Roster.
     * @return batch_id for the request
     */
    @DisplayName("Delete roster-DirectAssure")
    @Throws(ErrorProvider.class)
    @MediaType(value = MediaType.APPLICATION_JSON, strict = false)
    @OutputJsonType(schema = "metadata/PUT-POST-DEL-roster-response.json")
    public Result<InputStream, ResponseStatus> deleteFromRosterRequestDaByPutRequest(@Config CAQHConfiguration configuration, @Connection CAQHConnection connection,
                                                                                @Content List<RequestToDeleteRosterDADTO> deleteDAByPutBodies) {
		return newExecutionBuilder(configuration, connection)
				.execute(DirectAssureService::deleteFromRosterRequestDaByPutService).withParam(deleteDAByPutBodies);
    }

    /**
     * Method to delete one or more providers from the roster.
     * Returns the batch_id that is generated on successful deletion of Providers from roster.
     *
     * @param configuration          Configuration Object
     * @param connection             Connection object
     * @param deleteDAByPostBodies   List of providers to be deleted from Proview.
     * @return batch_id for the request
     */
    @DisplayName("Delete proview-DirectAssure")
    @Throws(ErrorProvider.class)
    @MediaType(value = MediaType.APPLICATION_JSON, strict = false)
    @OutputJsonType(schema = "metadata/PUT-POST-DEL-roster-response.json")
    public Result<InputStream, ResponseStatus> deleteFromProviewApiDa(@Config CAQHConfiguration configuration, @Connection CAQHConnection connection,
                                                                 @Content List<RequestToDeleteRosterDADTO> deleteDAByPostBodies) {
		return newExecutionBuilder(configuration, connection)
				.execute(DirectAssureService::deleteFromProviewApiDaService).withParam(deleteDAByPostBodies);
	}

    /**
     * The DirectAssure Status Check API web service can be used by Participating Organizations to view the status of providers in CAQH ProView.
     * Before requesting DirectAssure Status Check API access, POs should have a business case and an existing application with which to consume and use the web service.
     * The DirectAssure Status Check API accepts one provider at a time.
     *
     * @param configuration    Configuration Object
     * @param connection       Connection object.
     * @param Organization_Id  Participating Organization Identifier.
     * @param Caqh_Provider_Id CAQH assigned provider Identifier.
     * @return Json response containing provider's status.
     */
    @DisplayName(value = "Get provider status-DirectAssure")
    @Throws(ErrorProvider.class)
    @MediaType(value = ANY, strict = false)
    public Result<GetProviderStatusDTO, ResponseStatus> getProviderStatusDa(@Config CAQHConfiguration configuration, @Connection CAQHConnection connection, String Organization_Id, String Caqh_Provider_Id) {

    	return newExecutionBuilder(configuration, connection)
				.execute(DirectAssureService::getProviderStatusDaService).withParam(Organization_Id).withParam(Caqh_Provider_Id);
    }

}
