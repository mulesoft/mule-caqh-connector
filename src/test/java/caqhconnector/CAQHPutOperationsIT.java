/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package caqhconnector;

import com.mulesoft.connectors.caqhconnector.api.RequestToDeleteRosterDADTO;
import com.mulesoft.connectors.caqhconnector.api.RequestToUpdateDADTO;
import com.mulesoft.connectors.caqhconnector.api.RequestToUpdatePVDTO;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.mule.functional.junit4.MuleArtifactFunctionalTestCase;
import org.mule.runtime.api.event.Event;

import java.util.List;
public class CAQHPutOperationsIT extends MuleArtifactFunctionalTestCase {

    @Override
    protected String getConfigFile() {
        return "test-caqh-put-operations.xml";
    }

    //Test to check put operation - update to roster request.Corresponds to get method "updateToRosterRequestDaByPutRequest" in DirectAssureOperations class
    @Test
    public void executePutUpdateRosterByDA() throws Exception {
        List<RequestToUpdateDADTO> DaProviderData = TestDataBuilder.UpdateToDaRosterPutData();
        Event caqhTest = flowRunner("update-to-roster-request-da-by-put-requestFlow").withPayload(DaProviderData).run();
        Object payloadValue = caqhTest.getMessage().getPayload().getValue();
        Assert.assertNotNull(payloadValue);
    }

    //Test to check put operation - update to roster request.Corresponds to get method "updateToRosterRequestPvByPutRequest" in ProviewOperations class
    @Test
    public void executePutUpdateRosterByPV() throws Exception {
        List<RequestToUpdatePVDTO> PvProviderData = TestDataBuilder.UpdateToPvRosterPutData();
        Event caqhTest = flowRunner("update-to-roster-request-pv-by-put-requestFlow").withPayload(PvProviderData).run();
        Object payloadValue= ( caqhTest.getMessage().getPayload().getValue());
        Assert.assertNotNull(payloadValue);
    }

    //Test to check delete using put operation - delete from roster request.Corresponds to get method "deleteFromRosterRequestDaByPutRequest" in DirectAssureOperations class
    @Test
    public void executeDeleteFromRosterRequestDaByPutRequest() throws Exception {
        List<RequestToDeleteRosterDADTO> DaProviderData = TestDataBuilder.DeleteFromRosterRequestPV();
        Event caqhTest = flowRunner("delete-from-roster-request-da-by-put-requestFlow").withPayload(DaProviderData).run();
        Object payloadValue= (caqhTest.getMessage().getPayload().getValue());
        Assert.assertNotNull(payloadValue);
    }

    //Test to check put operation - delete from roster request.Corresponds to get method "deleteFromRosterRequestPv" in ProviewOperations class
    @Test
    public void executeDeleteFromRosterRequestPV() throws Exception {
        List<RequestToDeleteRosterDADTO> PvProviderData = TestDataBuilder.DeleteFromRosterRequestPV();
        Event caqhTest = flowRunner("delete-from-roster-request-pvFlow").withPayload(PvProviderData).run();
        Object payloadValue= (caqhTest.getMessage().getPayload().getValue());
        Assert.assertNotNull(payloadValue);
    }
}
