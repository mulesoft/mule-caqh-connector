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
        "delete_description"
})


public class DerosterResult {

    @JsonProperty("organization_id")
    private String organization_id;

    @JsonProperty("caqh_provider_id")
    private String caqh_provider_id;

    @JsonProperty("delete_description")
    private String delete_description;

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

    public String getDeleteDescription() {
        return delete_description;
    }

    public void setDeleteDescription(String delete_description) {
        this.delete_description = delete_description;
    }
}
