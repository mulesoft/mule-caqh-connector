/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.mulesoft.connectors.caqhconnector.internal.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.mule.runtime.http.api.domain.message.response.HttpResponse;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CAQHUtil {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(CAQHUtil.class);

    public static InputStream getInputStreamData(Collection collection){

        Gson gson = new Gson();
        String json = gson.toJson(collection);

        InputStream inputStreamData = null;
        try {
            inputStreamData = IOUtils.toInputStream(json, "UTF-8");

        } catch (IOException e) {
            logger.info("Error :", e);
        }

        return inputStreamData;

    }

    public static byte[] getByteArrayData(Collection collection){

        Gson gson = new Gson();

        String jsonBody = gson.toJson(collection);

        byte[] byteArrayData = jsonBody.getBytes(StandardCharsets.UTF_8);

        return byteArrayData;

    }

    public static InputStream getContentInputStream(CompletableFuture<HttpResponse> response) {

        InputStream inputStream = null;
        try {
            inputStream = response.get().getEntity().getContent();
            return inputStream;
        } catch (ExecutionException ex) {
            logger.info("Error :", ex);
        } catch (InterruptedException ex) {
            logger.info("Error :", ex);
        } catch (Exception ex) {
            logger.info("Error :", ex);
        }
        return inputStream;
    }

    public static Object getDtoObject (InputStream response, String className){
        Object dto = null;
        try {
            Class classDTO = Class.forName(className);
            String responseStr = IOUtils.toString(response, "UTF-8");
            ObjectMapper mapper = new ObjectMapper();
            dto = mapper.readValue(responseStr, classDTO);
            return dto;
        } catch (IOException e) {
            logger.info("Error :", e);
        }catch (ClassNotFoundException e){
            logger.info("Error :", e);
        }
        return dto;
    }

}
