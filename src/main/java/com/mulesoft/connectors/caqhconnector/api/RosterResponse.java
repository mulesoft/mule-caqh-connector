/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.mulesoft.connectors.caqhconnector.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
        "provider",
        "caqh_provider_id",
        "po_provider_id",
        "organization_id",
        "roster_status",
        "authorization_flag",
        "non_responder_flag",
        "delegation_flag",
        "affiliation_flag",
        "anniversary_date",
        "exception_description"
})

public class RosterResponse {

    @JsonProperty("provider")
    private Provider provider;

    @JsonProperty("caqh_provider_id")
    private String caqhProviderId;

    @JsonProperty("po_provider_id")
    private String poProviderId;

    @JsonProperty("organization_id")
    private String organizationId;

    @JsonProperty("roster_status")
    private String rosterStatus;

    @JsonProperty("authorization_flag")
    private String authorizationFlag;

    @JsonProperty("non_responder_flag")
    private String nonResponderFlag;

    @JsonProperty("delegation_flag")
    private String delegationFlag;

    @JsonProperty("affiliation_flag")
    private String affiliationFlag;

    @JsonProperty("anniversary_date")
    private String anniversaryDate;

    @JsonProperty("exception_description")
    private String exceptionDescription;

    @JsonProperty("provider")
    public Provider getProvider() {
        return provider;
    }

    @JsonProperty("provider")
    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    @JsonProperty("caqh_provider_id")
    public String getCaqhProviderId() {
        return caqhProviderId;
    }

    @JsonProperty("caqh_provider_id")
    public void setCaqhProviderId(String caqhProviderId) {
        this.caqhProviderId = caqhProviderId;
    }

    @JsonProperty("po_provider_id")
    public String getPoProviderId() {
        return poProviderId;
    }

    @JsonProperty("po_provider_id")
    public void setPoProviderId(String poProviderId) {
        this.poProviderId = poProviderId;
    }

    @JsonProperty("organization_id")
    public String getOrganizationId() {
        return organizationId;
    }

    @JsonProperty("organization_id")
    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    @JsonProperty("roster_status")
    public String getRosterStatus() {
        return rosterStatus;
    }

    @JsonProperty("roster_status")
    public void setRosterStatus(String rosterStatus) {
        this.rosterStatus = rosterStatus;
    }

    @JsonProperty("authorization_flag")
    public String getAuthorizationFlag() {
        return authorizationFlag;
    }

    @JsonProperty("authorization_flag")
    public void setAuthorizationFlag(String authorizationFlag) {
        this.authorizationFlag = authorizationFlag;
    }

    @JsonProperty("non_responder_flag")
    public String getNonResponderFlag() {
        return nonResponderFlag;
    }

    @JsonProperty("non_responder_flag")
    public void setNonResponderFlag(String nonResponderFlag) {
        this.nonResponderFlag = nonResponderFlag;
    }

    @JsonProperty("delegation_flag")
    public String getDelegationFlag() {
        return delegationFlag;
    }

    @JsonProperty("delegation_flag")
    public void setDelegationFlag(String delegationFlag) {
        this.delegationFlag = delegationFlag;
    }

    @JsonProperty("affiliation_flag")
    public String getAffiliationFlag() {
        return affiliationFlag;
    }

    @JsonProperty("affiliation_flag")
    public void setAffiliationFlag(String affiliationFlag) {
        this.affiliationFlag = affiliationFlag;
    }

    @JsonProperty("anniversary_date")
    public String getAnniversaryDate() {
        return anniversaryDate;
    }

    @JsonProperty("anniversary_date")
    public void setAnniversaryDate(String anniversaryDate) {
        this.anniversaryDate = anniversaryDate;
    }

    @JsonProperty("exception_description")
    public String getExceptionDescription() {
        return exceptionDescription;
    }

    @JsonProperty("exception_description")
    public void setExceptionDescription(String exceptionDescription) {
        this.exceptionDescription = exceptionDescription;
    }
}


