package com.gobear.car;

import com.gobear.car.Utils.Car;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import gherkin.lexer.Ca;
import org.json.JSONArray;
import org.json.JSONException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

@Test
public class TestGetCarVarients extends AbstractTest {

    @Test(dataProvider = "getCarModelId")
    public void testGetCarVarients_Success(String year, String carId, String carModelId) {
        GetCarVarients getCarVarients = new GetCarVarients(carId, carModelId);
        getCarVarients.expectResponseStatus(HttpResponseStatusType.OK_200);
        getCarVarients.addUrlParameter("year", year);

        getCarVarients.callAPI();
    }


    @DataProvider(name = "getCarModelId")
    private Object[][] getCarModelId() throws JSONException {
        String randomYear = Car.getRandomYears();
        String randomCareMakeId = Car.getRandomCarMakeIds(randomYear);

        return new Object[][] {
                {randomYear, randomCareMakeId, Car.getRandomCarModelId(randomYear, randomCareMakeId)}
        };

    }

}
