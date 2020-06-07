package com.gobear.car;

import com.gobear.car.Utils.Car;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import org.json.JSONArray;
import org.json.JSONException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class TestGetCarMakes extends AbstractTest {

    @Test(dataProvider = "getYear")
    public void testGetCarMakes_Success(String year) {
        GetCarMakes getCarMakes = new GetCarMakes();
        getCarMakes.expectResponseStatus(HttpResponseStatusType.OK_200);
        getCarMakes.addUrlParameter("year", year);

        getCarMakes.callAPI();
        getCarMakes.validateResponseAgainstJSONSchema(GetCarMakes.RS_SCHEMA);
    }


    @DataProvider(name = "getYear")
    private Object[][] getYear() throws JSONException {
        return new Object[][] {
                {Car.getRandomYears()},
                {Car.getRandomYears()},
                {Car.getRandomYears()},
                {Car.getRandomYears()},
        };
    }

}
