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
        "po_provider_id"

})

public class RequestToUpdateDADTO {


    @JsonProperty("caqh_provider_id")
    private String caqhProviderId;

    @JsonProperty("po_provider_id")
    private String poProviderId;

    @JsonProperty("organization_id")
    private String organizationId;

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

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }
}


