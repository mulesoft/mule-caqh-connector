/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.mulesoft.connectors.caqhconnector.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
        "organization_id",
        "caqh_provider_id",
        "po_provider_id",
        "roster_status",
        "authorization_flag",
        "provider_status",
        "provider_status_date",
        "provider_practice_state",
        "provider_found_flag"

})

public class GetProviderStatusDTO {

    @JsonProperty("organization_id")
    private String organization_id;

    @JsonProperty("caqh_provider_id")
    private String caqh_provider_id;

    @JsonProperty("po_provider_id")
    private String po_provider_id;

    @JsonProperty("roster_status")
    private String roster_status;

    @JsonProperty("authorization_flag")
    private String authorization_flag;

    @JsonProperty("provider_status")
    private String provider_status;

    @JsonProperty("provider_status_date")
    private String provider_status_date;

    @JsonProperty("provider_practice_state")
    private String provider_practice_state;

    @JsonProperty("provider_found_flag")
    private String provider_found_flag;

    public String getOrganizationId() {
        return organization_id;
    }

    public void setOrganizationId(String organization_id) {
        this.organization_id = organization_id;
    }

    public String getCaqhProviderId() {
        return caqh_provider_id;
    }

    public void setCaqhProviderId(String caqh_provider_id) {
        this.caqh_provider_id = caqh_provider_id;
    }

    public String getPoProviderId() {
        return po_provider_id;
    }


    public String getRosterStatus() {
        return roster_status;
    }


    public String getAuthorizationFlag() {
        return authorization_flag;
    }


    public String getProviderStatus() {
        return provider_status;
    }


    public String getProviderStatusDate() {
        return provider_status_date;
    }


    public String getProviderPracticeState() {
        return provider_practice_state;
    }


    public String getProviderFoundFlag() {
        return provider_found_flag;
    }


}
