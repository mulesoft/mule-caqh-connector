/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.mulesoft.connectors.caqhconnector.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
        "batch_status",
        "batch_time",
        "roster_result"
})

public class GetAddStatusDTO {

    @JsonProperty("batch_status")
    private String batchStatus;

    @JsonProperty("batch_time")
    private String batchTime;

    @JsonProperty("roster_result")
    private List<RosterResponse> rosterResult;

    @JsonProperty("batch_status")
    public String getBatchStatus() {
        return batchStatus;
    }

    @JsonProperty("batch_status")
    public void setBatchStatus(String batchStatus) {
        this.batchStatus = batchStatus;
    }

    @JsonProperty("batch_time")
    public String getBatchTime() {
        return batchTime;
    }

    @JsonProperty("batch_time")
    public void setBatchTime(String batchTime) {
        this.batchTime = batchTime;
    }

    @JsonProperty("roster_result")
    public List<RosterResponse> getRosterResult() {
        return rosterResult;
    }

    @JsonProperty("roster_result")
    public void setRosterResult(List<RosterResponse> rosterResult) {
        this.rosterResult = rosterResult;
    }
}

