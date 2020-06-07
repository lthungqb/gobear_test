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
public class TestGetCarModels extends AbstractTest {

    @Test(dataProvider = "getCarIds")
    public void testGetCarModels_Success(String year, String carId) {
        GetCarModels getCarModels = new GetCarModels(carId);
        getCarModels.expectResponseStatus(HttpResponseStatusType.OK_200);
        getCarModels.addUrlParameter("year", year);

        getCarModels.callAPI();
    }


    @DataProvider(name = "getCarIds")
    private Object[][] getCarIds() throws JSONException {
        String randomYear = Car.getRandomYears();

        return new Object[][] {
                {randomYear, Car.getRandomCarMakeIds(randomYear)},
                {randomYear, Car.getRandomCarMakeIds(randomYear)}
        };
    }

}
