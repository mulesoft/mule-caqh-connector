/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package caqhconnector;

import com.mulesoft.connectors.caqhconnector.api.RequestToAddRosterPVDTO;
import com.mulesoft.connectors.caqhconnector.api.RequestToDeleteRosterDADTO;
import com.mulesoft.connectors.caqhconnector.api.RequestToUpdateDADTO;
import com.mulesoft.connectors.caqhconnector.api.RequestToUpdatePVDTO;
import org.junit.Assert;
import org.junit.Test;
import org.mule.functional.junit4.MuleArtifactFunctionalTestCase;
import org.mule.runtime.api.event.Event;

import java.util.List;

public class CAQHPostOperationsIT extends MuleArtifactFunctionalTestCase {
        @Override
        protected String getConfigFile() {
            return "test-caqh-post-operations.xml";
        }

    //Test to check post operation - Add to roster request.Corresponds to get method "addToRosterRequestPv" in ProviewOperations class
    @Test
    public void executePostAddToRosterPvOperation() throws Exception {
            List<RequestToAddRosterPVDTO> PvProviderData = TestDataBuilder.createAddToRosterData();
        Event caqhTest = flowRunner("add-to-roster-daFlow").withPayload(PvProviderData).run();
        Object payloadValue= caqhTest.getMessage().getPayload().getValue();
        Assert.assertNotNull(payloadValue);

    }

    //Test to check post operation - Add to roster request.Corresponds to get method "addToRosterRequestDa" in DirectAssureOperations class
    @Test
   public void executePostAddToRosterDaOperation() throws Exception {

        List<RequestToAddRosterPVDTO> PvProviderData = TestDataBuilder.createAddToRosterData();
        Event caqhTest = flowRunner("add-to-roster-daFlow").withPayload(PvProviderData).run();
        Object payloadValue= caqhTest.getMessage().getPayload().getValue();
        Assert.assertNotNull(payloadValue);

    }
    //Test to check delete using post operation on Proview API - delete from roster request.Corresponds to get method "deleteFromProviewApiDa" in DirectAssureOperations class
    @Test
    public void deleteFromProviewApiDaTest() throws Exception {
        List<RequestToDeleteRosterDADTO> DaProviderData = TestDataBuilder.DeleteFromRosterRequestPV();
        Event caqhTest = flowRunner("delete-proview-DirectAssure-requestFlow").withPayload(DaProviderData).run();
        Object payloadValue= ( caqhTest.getMessage().getPayload().getValue());
        Assert.assertNotNull(payloadValue);
    }

    //Test to check post operation - delete from roster request.Corresponds to get method "deleteFromRosterRequestPv" in ProviewOperations class
    @Test
    public void deleteFromProviewApiPVTest() throws Exception {
        List<RequestToDeleteRosterDADTO> PvProviderData = TestDataBuilder.DeleteFromRosterRequestPV();
        Event caqhTest = flowRunner("delete-from-proview-pvFlow").withPayload(PvProviderData).run();
        Object payloadValue= ( caqhTest.getMessage().getPayload().getValue());
        Assert.assertNotNull(payloadValue);
    }

    //Test to check post operation - update to roster request.Corresponds to get method "updateToRosterRequestPv" in Proview Operations class
    @Test
    public void executePutUpdateRosterByPV() throws Exception {
        List<RequestToUpdatePVDTO> PvProviderData = TestDataBuilder.UpdateToPvRosterPutData();
        Event caqhTest = flowRunner("update-on-proview-requestFlow").withPayload(PvProviderData).run();
        Object payloadValue= ( caqhTest.getMessage().getPayload().getValue());
        Assert.assertNotNull(payloadValue);
    }

    //Test to check post operation on Proview API - update to roster request.Corresponds to get method "updateToProviewApiDa" in DirectAssureOperations class
    @Test
    public void updateToProviewApiDaTest() throws Exception {
        List<RequestToUpdateDADTO> DaProviderData = TestDataBuilder.UpdateToDaRosterPutData();
        Event caqhTest = flowRunner("update-proview-DirectAssure-requestFlow").withPayload(DaProviderData).run();
        Object payloadValue= (caqhTest.getMessage().getPayload().getValue());
        Assert.assertNotNull(payloadValue);
    }
}
