/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.mulesoft.connectors.caqhconnector.api;

import com.fasterxml.jackson.annotation.*;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
        "first_name",
        "middle_name",
        "last_name",
        "name_suffix",
        "gender",
        "address1",
        "address2",
        "city",
        "state",
        "zip",
        "zip_extn",
        "phone",
        "fax",
        "email",
        "practice_state",
        "birthdate",
        "ssn",
        "short_ssn",
        "dea",
        "upin",
        "type",
        "tax_id",
        "npi",
        "license_state",
        "license_number"

})

public class ProviderDTO {

    @JsonProperty("first_name")
    private String first_name;

    @JsonProperty("middle_name")
    private String middle_name;

    @JsonProperty("last_name")
    private String last_name;

    @JsonProperty("name_suffix")
    private String name_suffix;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("address1")
    private String address1;

    @JsonProperty("address2")
    private String address2;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("zip")
    private String zip;


    @JsonProperty("zip_extn")
    private String zip_extn;


    @JsonProperty("phone")
    private String phone;

    @JsonProperty("fax")
    private String fax;

    @JsonProperty("email")
    private String email;

    @JsonProperty("practice_state")
    private String practice_state;

    @JsonProperty("birthdate")
    private String birthdate;

    @JsonProperty("ssn")
    private String ssn;

    @JsonProperty("short_ssn")
    private String short_ssn;

    @JsonProperty("upin")
    private String upin;

    @JsonProperty("dea")
    private String dea;

    @JsonProperty("npi")
    private String npi;

    @JsonProperty("type")
    private String type;

    @JsonProperty("tax_id")
    private String tax_id;

    @JsonProperty("license_number")
    private String license_number;

    @JsonProperty("license_state")
    private String license_state;



    public String getFirstName() {
        return first_name;
    }


    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public String getMiddleName() {
        return middle_name;
    }

    public void setMiddleName(String middle_name) {
        this.middle_name = middle_name;
    }

    @JsonProperty("last_name")
    public String getLastName() {
        return last_name;
    }

    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }


    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getLicenseNumber() {
        return license_number;
    }

    public void setLicenseNumber(String license_number) {
        this.license_number = license_number;
    }

    public String getLicenseState() {
        return license_state;
    }

    public void setLicenseState(String license_state) {
        this.license_state = license_state;
    }

    public String getUpin() {
        return upin;
    }

    public void setUpin(String upin) {
        this.upin = upin;
    }

    public String getDea() {
        return dea;
    }

    public void setDea(String dea) {
        this.dea = dea;
    }

    public String getNpi() {
        return npi;
    }

    public void setNpi(String npi) {
        this.npi = npi;
    }

    public String getPracticeState() {
        return practice_state;
    }

    public void setPracticeState(String practice_state) {
        this.practice_state = practice_state;
    }

    public String getNameSuffix() {
        return name_suffix;
    }

    public void setNameSuffix(String name_suffix) {
        this.name_suffix = name_suffix;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getZipExtn() {
        return zip_extn;
    }

    public void setZipExtn(String zip_extn) {
        this.zip_extn = zip_extn;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @JsonProperty("short_ssn")
    public String getShortSsn() {
        return short_ssn;
    }

    @JsonProperty("short_ssn")
    public void setShortSsn(String short_ssn) {
        this.short_ssn = short_ssn;
    }

    public String getTaxId() {
        return tax_id;
    }

    public void setTaxId(String tax_id) {
        this.tax_id = tax_id;
    }
}


