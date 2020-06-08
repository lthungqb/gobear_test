package com.gobear.car;

import com.gobear.car.Utils.Car;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import org.json.JSONArray;
import org.json.JSONException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.ws.rs.GET;
import java.util.Random;

@Test
public class TestGetCarInsurances extends AbstractTest {


    @Test(dataProvider = "build_insurance_params")
    public void testGetCarInsurances_Success(String carYear, String carMakeId, String carModelId, String carBodyTypeId,
                                             Boolean isPrivateUsage, Boolean isStillPaying, String sumInsured, String fmv,
                                             Boolean requestAon, Boolean requestPa, Boolean requestRa, String classification,
                                             String coverageValue_VTPL) {

        GetCarInsurances getCarInsurances = new GetCarInsurances();
        getCarInsurances.expectResponseStatus(HttpResponseStatusType.OK_200);
        getCarInsurances.addUrlParameter("carYear", carYear);
        getCarInsurances.addUrlParameter("carMakeId", carMakeId);
        getCarInsurances.addUrlParameter("carModelId", carModelId);
        getCarInsurances.addUrlParameter("carBodyTypeId", carBodyTypeId);
        getCarInsurances.addUrlParameter("isPrivateUsage", isPrivateUsage.toString());
        getCarInsurances.addUrlParameter("isStillPaying", isStillPaying.toString());
        getCarInsurances.addUrlParameter("sumInsured", sumInsured);
        getCarInsurances.addUrlParameter("fmv", fmv);
        getCarInsurances.addUrlParameter("requestAon", requestAon.toString());
        getCarInsurances.addUrlParameter("requestPa", requestPa.toString());
        getCarInsurances.addUrlParameter("requestRa", requestRa.toString());
        getCarInsurances.addUrlParameter("classification", classification);
        getCarInsurances.addUrlParameter("coverageValue_VTPL", coverageValue_VTPL);

        String rs = getCarInsurances.callAPI().asString();
        if (!rs.equals("null"))
            getCarInsurances.validateResponseAgainstJSONSchema(GetCarInsurances.RS_SCHEMA);
    }


    @DataProvider(name = "build_insurance_params")
    private Object[][] buildInsuranceParams() throws JSONException {
        String randomCarYear = Car.getRandomYears();
        String randomCarMakeId = Car.getRandomCarMakeIds(randomCarYear);
        String randomCarModelId = Car.getRandomCarModelId(randomCarYear, randomCarMakeId);
        String randonCarBodyTypeId = Car.getRandomCarBodyTypeId(randomCarYear, randomCarMakeId, randomCarModelId);

        return new Object[][] {
                // {carYear, carMakeId, carModelId, carBodyTypeId, isPrivateUsage, isStillPaying, sumInsured, fmv, requestAon, requestPa, requestRa, classification, CoverageValue_VTPL}
                {randomCarYear, randomCarMakeId, randomCarModelId, randonCarBodyTypeId, false, true, "1160000", "1160000", true, false, false, "1", "200000"},
                {randomCarYear, randomCarMakeId, randomCarModelId, randonCarBodyTypeId, true, true, "1160000", "1160000", true, false, false, "1", "200000"}
        };
    }

}
