/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.mulesoft.connectors.caqhconnector.api;

import org.mule.runtime.api.util.MultiMap;

public class ResponseStatus {

    public ResponseStatus() {
    }

    private int statusCode;
    private MultiMap<String, String> headers;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }


    public MultiMap<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(MultiMap<String, String> headers) {
        this.headers = headers;
    }

    @Override
    public String toString() {
        return "Response Status{" +
                "Status Code =" + statusCode +
                ", Headers =" + headers +
                "}";
    }
}
