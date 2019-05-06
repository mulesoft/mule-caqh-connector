/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.mulesoft.connectors.caqhconnector.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
        "first_name",
        "middle_name",
        "last_name",
        "type",
        "address1",
        "address2",
        "address_city",
        "address_state",
        "address_zip",
        "birthdate",
        "license_number",
        "license_state",
        "upin",
        "dea",
        "npi",
        "practice_state",
        "status",
        "status_date"

})

public class Provider {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("middle_name")
    private String middleName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("type")
    private String type;

    @JsonProperty("address1")
    private String address1;

    @JsonProperty("address2")
    private String address2;

    @JsonProperty("address_city")
    private String addressCity;

    @JsonProperty("address_state")
    private String addressState;

    @JsonProperty("address_zip")
    private String addressZip;

    @JsonProperty("birthdate")
    private String birthdate;

    @JsonProperty("license_number")
    private String licenseNumber;

    @JsonProperty("license_state")
    private String licenseState;

    @JsonProperty("upin")
    private String upin;

    @JsonProperty("dea")
    private String dea;

    @JsonProperty("npi")
    private String npi;

    @JsonProperty("practice_state")
    private String practiceState;

    @JsonProperty("status")
    private String status;

    @JsonProperty("status_date")
    private String statusDate;

    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("middle_name")
    public String getMiddleName() {
        return middleName;
    }

    @JsonProperty("middle_name")
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }
    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @JsonProperty("type")
    public String getType() {
        return type;
    }
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }
    @JsonProperty("address1")
    public String getAddress1() {
        return address1;
    }
    @JsonProperty("address1")
    public void setAddress1(String address1) {
        this.address1 = address1;
    }
    @JsonProperty("address2")
    public String getAddress2() {
        return address2;
    }
    @JsonProperty("address2")
    public void setAddress2(String address2) {
        this.address2 = address2;
    }
    @JsonProperty("address_city")
    public String getAddressCity() {
        return addressCity;
    }
    @JsonProperty("address_city")
    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }
    @JsonProperty("address_state")
    public String getAddressState() {
        return addressState;
    }
    @JsonProperty("address_state")
    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }
    @JsonProperty("address_zip")
    public String getAddressZip() {
        return addressZip;
    }
    @JsonProperty("address_zip")
    public void setAddressZip(String addressZip) {
        this.addressZip = addressZip;
    }
    @JsonProperty("birthdate")
    public String getBirthdate() {
        return birthdate;
    }
    @JsonProperty("birthdate")
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    @JsonProperty("license_number")
    public String getLicenseNumber() {
        return licenseNumber;
    }
    @JsonProperty("license_number")
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
    @JsonProperty("license_state")
    public String getLicenseState() {
        return licenseState;
    }
    @JsonProperty("license_state")
    public void setLicenseState(String licenseState) {
        this.licenseState = licenseState;
    }
    @JsonProperty("upin")
    public String getUpin() {
        return upin;
    }
    @JsonProperty("upin")
    public void setUpin(String upin) {
        this.upin = upin;
    }
    @JsonProperty("dea")
    public String getDea() {
        return dea;
    }
    @JsonProperty("dea")
    public void setDea(String dea) {
        this.dea = dea;
    }
    @JsonProperty("npi")
    public String getNpi() {
        return npi;
    }
    @JsonProperty("npi")
    public void setNpi(String npi) {
        this.npi = npi;
    }
    @JsonProperty("practice_state")
    public String getPracticeState() {
        return practiceState;
    }
    @JsonProperty("practice_state")
    public void setPracticeState(String practiceState) {
        this.practiceState = practiceState;
    }
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }
    @JsonProperty("status_date")
    public String getStatusDate() {
        return statusDate;
    }
    @JsonProperty("status_date")
    public void setStatusDate(String statusDate) {
        this.statusDate = statusDate;
    }
}


