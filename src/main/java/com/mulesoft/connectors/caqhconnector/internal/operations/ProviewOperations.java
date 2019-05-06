/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */

package com.mulesoft.connectors.caqhconnector.internal.operations;

import com.mulesoft.connectors.caqhconnector.api.*;
import com.mulesoft.connectors.caqhconnector.api.ResponseStatus;
import com.mulesoft.connectors.caqhconnector.internal.config.CAQHConfiguration;
import com.mulesoft.connectors.caqhconnector.internal.connection.CAQHConnection;
import com.mulesoft.connectors.caqhconnector.internal.error.ErrorProvider;
import com.mulesoft.connectors.caqhconnector.internal.service.ProviewService;
import com.mulesoft.connectors.caqhconnector.internal.service.ProviewServiceImpl;
import org.mule.connectors.commons.template.operation.ConnectorOperations;
import org.mule.runtime.extension.api.annotation.error.Throws;
import org.mule.runtime.extension.api.annotation.metadata.fixed.OutputJsonType;
import org.mule.runtime.extension.api.annotation.metadata.fixed.OutputXmlType;
import org.mule.runtime.extension.api.annotation.param.*;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.runtime.operation.Result;

import java.io.InputStream;
import java.util.List;

import static org.mule.runtime.extension.api.annotation.param.MediaType.APPLICATION_JSON;
import static org.mule.runtime.extension.api.annotation.param.MediaType.*;

public class ProviewOperations extends ConnectorOperations<CAQHConfiguration, CAQHConnection, ProviewService> {

    public ProviewOperations() {
        super(ProviewServiceImpl::new);
    }

    /**
     * Method to get the status of a previous Add to Roster request, and the results if the request is complete.
     * If a provider is unable to be added to the roster due to an Exception, then the Exception_Description field contains a value and the identifying fields submitted
     * in the Add to Roster Web Service is returned instead of the values from the system.
     *
     * @param configuration Configuration Object
     * @param connection    Connection object.
     * @param batch_id      System-generated unique Batch ID from ADD request.
     * @return status of add request in json format
     */
    @DisplayName(value = "Get Status - Add to Roster")
    @Throws(ErrorProvider.class)
    @MediaType(value = ANY, strict = false)
    public Result<GetAddStatusDTO, ResponseStatus> getResultOfAddRequest(@Config CAQHConfiguration configuration, @Connection CAQHConnection connection, String batch_id) {
        return newExecutionBuilder(configuration, connection)
                .execute(ProviewService::getResultOfAddService).withParam(batch_id);
    }

    /**
     * GET request to receive the status of a previous Update on Roster request, and the results if the request is complete.
     * If a provider is unable to be updated on the roster due to an exception, then the Update_Description field contains the exception.
     *
     * @param configuration Configuration Object
     * @param connection    Connection object.
     * @param batch_id      System-generated unique Batch ID from UPDATE request.
     * @return status of update request in json
     */
    @DisplayName(value = "Get Status - Update to Roster")
    @Throws(ErrorProvider.class)
    @MediaType(value = ANY, strict = false)
    public Result<GetUpdateResultDTO, ResponseStatus> getResultOfUpdateRequest(@Config CAQHConfiguration configuration, @Connection CAQHConnection connection, String batch_id) {
        return newExecutionBuilder(configuration, connection)
                .execute(ProviewService::getResultOfUpdateService).withParam(batch_id);
    }

    /**
     * GET request to receive the status of a previous Delete from Roster request, and the results if the request is complete.
     * If a provider is unable to be deleted from the roster due to an exception, then the Delete_Description field contains the exception.
     *
     * @param configuration Configuration Object
     * @param connection    Connection object.
     * @param batch_id      System-generated unique Batch ID from UPDATE request.
     * @return status of delete request in json
     */
    @DisplayName(value = "Get Status - Delete from Roster")
    @Throws(ErrorProvider.class)
    @MediaType(value = ANY, strict = false)
    public Result<GetDeleteResultDTO, ResponseStatus> getResultOfDeleteRequest(@Config CAQHConfiguration configuration, @Connection CAQHConnection connection, String batch_id) {
        return newExecutionBuilder(configuration, connection)
                .execute(ProviewService::getResultOfDeleteService).withParam(batch_id);
    }

    /**
     * The ProView Status Check API web service can be used by Participating Organizations to view the status of providers in CAQH ProView. Before requesting ProView Status Check API access,
     * POs should have a business case and an existing application with which to consume and use the web service. The ProView Status Check API accepts one provider at a time.
     * This method returns a JSON response with the status of provider or indicate that a provider could not be found with Provider_Found_Flag equal to N.
     *
     * @param configuration    Configuration Object
     * @param connection       Connection object
     * @param Organization_Id  Participating Organization Identifier.
     * @param Caqh_Provider_Id CAQH assigned provider Identifier.
     * @return Json response containing provider's status.
     */
    @DisplayName(value = "Get Provider Status - ProView")
    @Throws(ErrorProvider.class)
    @MediaType(value = ANY, strict = false)
    public Result<GetProviderStatusDTO, ResponseStatus> getProviderStatusProview(@Config CAQHConfiguration configuration, @Connection CAQHConnection connection, String Organization_Id, String Caqh_Provider_Id) {
        return newExecutionBuilder(configuration, connection)
                .execute(ProviewService::getProviderStatusProviewService).withParam(Organization_Id).withParam(Caqh_Provider_Id);
    }

    /**
     * This method returns the xml response received by Credentialing API web service which is used by Participating Organizations to access real-time provider data from CAQH ProView.
     * Before requesting the Credentialing API access,
     * POs should have a business case and an existing application with which to consume and use the web service.
     * The credentialing API is designed to accept one CAQH Provider ID at a time and disemminate information for that provider based on other parameters provided in the API call.
     * The Credentialing API service will return provider data only if it satisfies ALL of the following criteria:
     * 1. Provider application status is Complete.
     * 2. Provider has Authorized the Participating Organization to see their information.
     * Participating Organization roster status of the Provider is active.
     * Data will be filtered based on Delegated/Non-Delegated and Participating/Non-Participating relationships between the participating organization and the requested provider.
     *
     * @param configuration     Configuration Object
     * @param connection        Connection object.
     * @param organizationId    Participating Organization Identifier.
     * @param caqhProviderId    CAQH assigned provider Identifier.
     * @param attestationDate   Date on which provider was last first attested.Required (Only within the past 3 years).
     * @param credentialSection (Optional) If not specified, the service will return all sections.
     * @return credentialling information of the provider in xml format.
     */
    @DisplayName(value = "Get Provider Credentials")
    @Throws(ErrorProvider.class)
    @MediaType(value = APPLICATION_JSON, strict = false)
    @OutputJsonType(schema = "metadata/provider.json")
    public Result<InputStream, ResponseStatus> getProviderCredentials(@Config CAQHConfiguration configuration, @Connection CAQHConnection connection, String caqhProviderId, String organizationId, String attestationDate, @Optional String credentialSection) {
        return newExecutionBuilder(configuration, connection)
                .execute(ProviewService::getProviderCredentialsService).withParam(caqhProviderId).withParam(organizationId).withParam(attestationDate).withParam(credentialSection);
    }

    /**
     * This method returns the PDF document in response to request that allows a participating organization to retrieve a provider's supporting document
     * The supporting documents will be returned only if the following are true:
     * 1. The requesting user's associated PO ID matches with the incoming PO ID, or if the incoming is the child of the user's associated PO ID.
     * 2. The provider is on the participating organization's roster.
     * 3. The provider has given authorization to the participating organization.
     * 4. The provider's CAQH ProView data profile is in a complete status, e.g. Initial Profile Complete or Re-attestation.
     * If these criteria are not satisfied then the supporting document for that CAQH Provider ID is not be returned and the appropriate response code is be supplied.
     *
     * @param configuration   Configuration Object
     * @param connection      Connection object.
     * @param organization_id Participating Organization Identifier.
     * @param caqhProvider_id CAQH assigned provider Identifier.
     * @param doc_Type        Single Supporting Document Type.
     * @return pdf document uploaded by provider.
     */
    @DisplayName(value = "Get Provider Documents")
    @Throws(ErrorProvider.class)
    @MediaType(value = ANY, strict = false)
    public Result<InputStream, ResponseStatus> getProviderDocument(@Config CAQHConfiguration configuration, @Connection CAQHConnection connection, String caqhProvider_id, String organization_id, String doc_Type) {
        return newExecutionBuilder(configuration, connection)
                .execute(ProviewService::getProviderDocumentService).withParam(caqhProvider_id).withParam(organization_id).withParam(doc_Type);
    }

    /**
     * A PO can add one or more providers to the roster by submitting a call to the API. For this
     * there are different required and optional fields for the Quick Add verses the Initial Add, and at least one of the fields with an asterisk (*) is required to process an Initial Add.
     * This method returns the batch_id that is generated on successful addition of Providers on roster.
     *
     * @param configuration    Configuration Object
     * @param connection       Connection object.
     * @param addRequestBodies List of providers to be added to Roster.
     * @return batch_id for the request.
     */
    @DisplayName("Add Providers - ProView")
    @Throws(ErrorProvider.class)
    @MediaType(value = APPLICATION_JSON, strict = false)
    @OutputJsonType(schema = "metadata/PUT-POST-DEL-roster-response.json")
    public Result<InputStream, ResponseStatus> addToRosterRequestPv(@Config CAQHConfiguration configuration,
                                                                    @Connection CAQHConnection connection,
                                                                    @Content List<RequestToAddRosterPVDTO> addRequestBodies) {
        return newExecutionBuilder(configuration, connection)
                .execute(ProviewService::addToRosterRequestPvService).withParam(addRequestBodies);
    }

    /**
     * Method to delete one or more providers from the roster using PUT.
     * Returns the batch_id that is generated on successful deletion of Providers from roster.
     *
     * @param configuration       Configuration Object
     * @param connection          Connection object.
     * @param deleteRequestBodies List of providers to be deleted from Roster.
     * @return batch_id for the request.
     */
    @DisplayName("Delete Providers - ProView (PUT)")
    @MediaType(value = APPLICATION_JSON, strict = false)
    @OutputJsonType(schema = "metadata/PUT-POST-DEL-roster-response.json")
    public Result<InputStream, ResponseStatus> deleteFromRosterRequestPv(@Config CAQHConfiguration configuration,
                                                                         @Connection CAQHConnection connection,
                                                                         @Content List<RequestToDeleteRosterDADTO> deleteRequestBodies) {
        return newExecutionBuilder(configuration, connection)
                .execute(ProviewService::deleteFromRosterRequestPvService).withParam(deleteRequestBodies);
    }

    /**
     * Method to delete one or more providers from the roster using POST.
     * Returns the batch_id that is generated on successful deletion of Providers from roster.
     *
     * @param configuration       Configuration Object
     * @param connection          Connection object.
     * @param deleteProviewBodies List of providers to be deleted from Proview.
     * @return batch_id for the request.
     */
    @DisplayName("Delete Providers - ProView (POST)")
    @MediaType(value = APPLICATION_JSON, strict = false)
    @OutputJsonType(schema = "metadata/PUT-POST-DEL-roster-response.json")
    public Result<InputStream, ResponseStatus> deleteFromProviewApi(@Config CAQHConfiguration configuration,
                                                                    @Connection CAQHConnection connection,
                                                                    @Content List<RequestToDeleteRosterDADTO> deleteProviewBodies) {
        return newExecutionBuilder(configuration, connection)
                .execute(ProviewService::deleteFromProviewApiService).withParam(deleteProviewBodies);
    }

    /**
     * Method to update one or more providers existing on roster using PUT.
     * Returns the batch_id that is generated on successful update of Providers on roster.
     *
     * @param configuration Configuration Object
     * @param connection    Connection object.
     * @param details       List of providers to be updated in Roster.
     * @return batch_id for the request.
     */
    @DisplayName("Update Providers - ProView (PUT)")
    @Throws(ErrorProvider.class)
    @MediaType(value = APPLICATION_JSON, strict = false)
    @OutputJsonType(schema = "metadata/PUT-POST-DEL-roster-response.json")
    public Result<InputStream, ResponseStatus> updateToRosterRequestPvByPutRequest(@Config CAQHConfiguration configuration,
                                                                                   @Connection CAQHConnection connection,
                                                                                   @Content List<RequestToUpdatePVDTO> details) {
        return newExecutionBuilder(configuration, connection)
                .execute(ProviewService::updateToRosterRequestPvByPutService).withParam(details);
    }

    /**
     * Method to update one or more providers existing on roster using POST.
     * Returns the batch_id that is generated on successful update of Providers on roster.
     *
     * @param configuration        Configuration Object
     * @param connection           Connection object.
     * @param updateProviewDetails List of providers to be updated in Proview.
     * @return batch_id for the request.
     */
    @DisplayName("Update Providers - ProView (POST)")
    @Throws(ErrorProvider.class)
    @MediaType(value = APPLICATION_JSON, strict = false)
    @OutputJsonType(schema = "metadata/PUT-POST-DEL-roster-response.json")
    public Result<InputStream, ResponseStatus> updateToRosterRequestPv(@Config CAQHConfiguration configuration,
                                                                       @Connection CAQHConnection connection,
                                                                       @Content List<RequestToUpdatePVDTO> updateProviewDetails) {
        return newExecutionBuilder(configuration, connection)
                .execute(ProviewService::updateToRosterRequestPvService).withParam(updateProviewDetails);
    }
}

