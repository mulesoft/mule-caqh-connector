/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package caqhconnector;

import com.mulesoft.connectors.caqhconnector.api.*;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuilder {

    private TestDataBuilder() {
        throw new IllegalStateException("Test DataBuilder Class");
    }

    static List<RequestToAddRosterPVDTO> createAddToRosterData() {
        RequestToAddRosterPVDTO add =  new RequestToAddRosterPVDTO();
        ProviderDTO dto = new ProviderDTO();
        List<RequestToAddRosterPVDTO> provider = new ArrayList<RequestToAddRosterPVDTO>();
        dto.setFirstName("Jennifer");
        dto.setLastName("Simons");
        dto.setAddress1("abc 123");
        dto.setCity("CA");
        dto.setAddress2("");
        dto.setBirthdate("");
        dto.setDea("");
        dto.setEmail("");
        dto.setFax("");
        dto.setGender("");
        dto.setLicenseNumber("");
        dto.setLicenseState("");
        dto.setMiddleName("");
        dto.setNameSuffix("");
        dto.setNpi("");
        dto.setPhone("");
        dto.setPracticeState("");
        dto.setShortSsn("");
        dto.setSsn("");
        dto.setTaxId("");
        dto.setType("");
        dto.setZipExtn("");
        dto.setZip("");
        add.setProvider(dto);
        provider.add(add);

        return provider;
    }
   public static List<RequestToUpdateDADTO> UpdateToDaRosterPutData() {

        List<RequestToUpdateDADTO> add = new ArrayList<RequestToUpdateDADTO>();
        RequestToUpdateDADTO updateDaRoster = new RequestToUpdateDADTO();

       updateDaRoster.setOrganizationId("6013");
       updateDaRoster.setCaqhProviderId("16033455");
       updateDaRoster.setPoProviderId("3210");

        add.add(updateDaRoster);
        return add;
    }
    public static List<RequestToUpdatePVDTO> UpdateToPvRosterPutData() {

        List<RequestToUpdatePVDTO> add = new ArrayList<RequestToUpdatePVDTO>();
        RequestToUpdatePVDTO updatePvRoster = new RequestToUpdatePVDTO();

        updatePvRoster.setOrganizationId("6013");
        updatePvRoster.setCaqhProviderId("1000");
        updatePvRoster.setAffiliationFlag("A");
        updatePvRoster.setPoProviderId("100010");
        updatePvRoster.setNextRecredentialDate("2020/09/09");
        updatePvRoster.setLastRecredentialDate("2018/09/09");
        updatePvRoster.setApplicationType("2");
        updatePvRoster.setDelegationFlag("Y");

        add.add(updatePvRoster);
        return add;
    }

    public static List<RequestToDeleteRosterDADTO> DeleteFromRosterRequestPV() {

        List<RequestToDeleteRosterDADTO> add = new ArrayList<RequestToDeleteRosterDADTO>();
        RequestToDeleteRosterDADTO updateDaRoster = new RequestToDeleteRosterDADTO();

        updateDaRoster.setOrganizationId("6013");
        updateDaRoster.setCaqhProviderId("16000391");

        add.add(updateDaRoster);
        return add;
    }

}
