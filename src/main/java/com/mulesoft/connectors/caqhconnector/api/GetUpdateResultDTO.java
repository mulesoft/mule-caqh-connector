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

public class GetUpdateResultDTO {

    @JsonProperty("batch_time")
    private String batch_time;

    @JsonProperty("batch_status")
    private String batch_status;

    @JsonProperty("roster_result")
    private List<RosterResult> roster_result;

    public String getBatchTime() {
        return batch_time;
    }

    public void setBatchTime(String batch_time) {
        this.batch_time = batch_time;
    }

    public String getBatchStatus() {
        return batch_status;
    }

    public void setBatchStatus(String batch_status) {
        this.batch_status = batch_status;
    }

    public List<RosterResult> getRosterResult() {
        return roster_result;
    }

    public void setRosterResult(List<RosterResult> roster_result) {
        this.roster_result = roster_result;
    }
}

