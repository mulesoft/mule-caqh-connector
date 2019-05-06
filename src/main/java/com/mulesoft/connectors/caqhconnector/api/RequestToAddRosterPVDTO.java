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
        "last_recredential_date",
        "next_recredential_date",
        "delegation_flag",
        "application_type",
        "affiliation_flag",
        "organization_id",
        "region_id"

})

public class RequestToAddRosterPVDTO {

    @JsonProperty("provider")
    private ProviderDTO provider;

    @JsonProperty("caqh_provider_id")
    private String caqhProviderId;

    @JsonProperty("po_provider_id")
    private String poProviderId;
    @JsonProperty("last_recredential_date")
    private String lastRecredentialDate;

    @JsonProperty("next_recredential_date")
    private String nextRecredentialDate;

    @JsonProperty("delegation_flag")
    private String delegationFlag;

    @JsonProperty("application_type")
    private String applicationType;


    @JsonProperty("affiliation_flag")
    private String affiliationFlag;


    @JsonProperty("organization_id")
    private String organizationId;

    @JsonProperty("region_id")
    private String regionId;

    public ProviderDTO getProvider() {
        return provider;
    }

    public void setProvider(ProviderDTO provider) {
        this.provider = provider;
    }

    public String getCaqhProviderId() {
        return caqhProviderId;
    }

    public void setCaqhProviderId(String caqhProviderId) {
        this.caqhProviderId = caqhProviderId;
    }

    public String getPoProviderId() {
        return poProviderId;
    }

    public void setPoProviderId(String poProviderId) {
        this.poProviderId = poProviderId;
    }

    public String getLastRecredentialDate() {
        return lastRecredentialDate;
    }

    public void setLastRecredentialDate(String lastRecredentialDate) {
        this.lastRecredentialDate = lastRecredentialDate;
    }

    public String getNextRecredentialDate() {
        return nextRecredentialDate;
    }

    public void setNextRecredentialDate(String nextRecredentialDate) {
        this.nextRecredentialDate = nextRecredentialDate;
    }

    public String getDelegationFlag() {
        return delegationFlag;
    }

    public void setDelegationFlag(String delegationFlag) {
        this.delegationFlag = delegationFlag;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public String getAffiliationFlag() {
        return affiliationFlag;
    }

    public void setAffiliationFlag(String affiliationFlag) {
        this.affiliationFlag = affiliationFlag;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }
}


