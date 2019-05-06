/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package caqhconnector;
import com.mulesoft.connectors.caqhconnector.api.*;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.mule.functional.junit4.MuleArtifactFunctionalTestCase;
import org.mule.runtime.api.event.Event;
import org.mule.runtime.core.api.event.CoreEvent;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CAQHGetOperationsIT extends MuleArtifactFunctionalTestCase {
    @Override
    protected String getConfigFile() {
        return "test-mule-config.xml";
    }
    private List<RosterResponse> rosterResult;
    private List<RosterResult> rosterResultForUpdate;
    private List<DerosterResult> deRosterResult;

    //Test 1 to check the status of an add to roster post request.Corresponds to get method "getResultOfAddRequest" in ProviewOperations class
    @Test
    public void getResponseForAddRoster1TestIT() throws Exception{
        Event caqhTest = flowRunner("get-add-statusFlow").run();
        GetAddStatusDTO payloadValue = ((GetAddStatusDTO) caqhTest
                .getMessage()
                .getPayload()
                .getValue());
        rosterResult = payloadValue.getRosterResult();
        RosterResponse res= rosterResult.get(0);
        assertThat(res.getProvider().getFirstName(), is("Jennifer"));
        assertThat(res.getProvider().getLastName(), is("Simons"));
        assertThat(res.getProvider().getAddress1(), is("abcd1"));
        assertThat(res.getProvider().getAddressCity(), is("Anchorage"));
        assertThat(res.getProvider().getAddressState(), is("AK"));
        assertThat(res.getProvider().getAddressZip(), is("99501"));
        assertThat(res.getPoProviderId(), is("123445"));
        assertThat(res.getOrganizationId(), is("6013"));
    }


    //Test 2 to check the status of an add to roster post request.Corresponds to get method "getResultOfAddRequest" in ProviewOperations class
    @Test
    public void getResponseForAddRoster2Test() throws Exception{
        Event caqhTest = flowRunner("get-add-statusFlow").run();
        GetAddStatusDTO payloadValue = ((GetAddStatusDTO) caqhTest
                .getMessage()
                .getPayload()
                .getValue());
        assertThat(payloadValue.getBatchStatus(), is("Complete"));
    }

    //Test to check the status of an update to roster request.Corresponds to get method "getResultOfUpdateRequest" in ProviewOperations class
    @Test
    public void getResponseForUpdateRosterTest() throws Exception{
        Event caqhTest = flowRunner("get-update-statusFlow").run();
        GetUpdateResultDTO payloadValue = ((GetUpdateResultDTO) caqhTest
                .getMessage()
                .getPayload()
                .getValue());
        rosterResultForUpdate = payloadValue.getRosterResult();
        RosterResult res = rosterResultForUpdate.get(0);
        assertThat(res.getCaqhProviderId(), is("16032633"));
    }


    //Test to check the status of an delete from roster request.Corresponds to get method "getResultOfDeleteRequest" in ProviewOperations class
    @Test
    public void getResponseForDeleteRosterTest() throws Exception{
        Event caqhTest = flowRunner("get-delete-statusFlow").run();
        GetDeleteResultDTO payloadValue = ((GetDeleteResultDTO) caqhTest
                .getMessage()
                .getPayload()
                .getValue());
        deRosterResult = payloadValue.getDerosterResult();
        DerosterResult res = deRosterResult.get(0);
        assertThat(res.getCaqhProviderId(), is("16000391"));
    }

    //Test to check the status of a Provider on roster.Corresponds to get method "getProviderStatusProview" in ProviewOperations class
    @Test
    public void getProviderStatusPvTest() throws Exception{
        Event caqhTest = flowRunner("get-provider-status-proviewFlow").run();
        GetProviderStatusDTO payloadValue = ((GetProviderStatusDTO) caqhTest
                .getMessage()
                .getPayload()
                .getValue());
        assertThat(payloadValue.getProviderFoundFlag(), is("Y"));
        assertThat(payloadValue.getOrganizationId(), is("6013"));
        assertThat(payloadValue.getPoProviderId(), is("321"));
        assertThat(payloadValue.getRosterStatus(), is("ACTIVE"));
        assertThat(payloadValue.getProviderStatus(), is("Re-Attestation"));
        assertThat(payloadValue.getProviderStatusDate(), is("20190225"));
        assertThat(payloadValue.getProviderPracticeState(), is("MI"));
        assertThat(payloadValue.getProviderStatus(), is("Re-Attestation"));
        assertThat(payloadValue.getAuthorizationFlag(), is("Y"));
        assertThat(payloadValue.getCaqhProviderId(), is("16033455"));

    }

    //Test to check the status of a Provider on roster.Corresponds to get method "getProviderStatusDA" in DirectAssureOperations class
    @Test
    public void getProviderStatusPDaTest() throws Exception{
        Event caqhTest = flowRunner("get-provider-status-directAssureFlow").run();
        GetProviderStatusDTO payloadValue = ((GetProviderStatusDTO) caqhTest
                .getMessage()
                .getPayload()
                .getValue());
        assertThat(payloadValue.getProviderFoundFlag(), is("Y"));
        assertThat(payloadValue.getOrganizationId(), is("6013"));
        assertThat(payloadValue.getPoProviderId(), is("3210"));
        assertThat(payloadValue.getRosterStatus(), is("ACTIVE"));
        assertThat(payloadValue.getProviderStatus(), is("Re-Attestation"));
        assertThat(payloadValue.getProviderStatusDate(), is("20190225"));
        assertThat(payloadValue.getProviderPracticeState(), is("MI"));
        assertThat(payloadValue.getProviderStatus(), is("Re-Attestation"));
        assertThat(payloadValue.getAuthorizationFlag(), is("Y"));
        assertThat(payloadValue.getCaqhProviderId(), is("16033455"));

    }

    //Test to check the credentialling information of a Provider on roster.Corresponds to get method "getProviderCredentials" in ProviewOperations class
    @Test
    public void getProviderCredentialsTest() throws Exception {
        Event caqhTest = flowRunner("get-provider-credentialsFlow").run();
        Object payloadValue= (caqhTest.getMessage().getPayload().getClass().getCanonicalName());
        JSONObject jObject  = new JSONObject(payloadValue);
        Assert.assertNotNull(jObject);
    }

    //Test to check the uploaded documents of a Provider on roster.Corresponds to get method "getProviderDocument" in ProviewOperations class
    @Test
    public void getProviderDocumentTest() throws Exception{
        Event caqhTest = flowRunner("get-provider-documentFlow").run();
        Object payloadValue = ( ((CoreEvent) caqhTest).getMessage().getPayload());
        JSONObject jObject  = new JSONObject(payloadValue);
        Assert.assertNotNull(jObject);    }



}


