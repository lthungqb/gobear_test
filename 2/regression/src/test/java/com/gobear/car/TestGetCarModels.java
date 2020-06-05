package com.gobear.car;

import com.gobear.car.Utils.Car;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
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

        Random r = new Random();
        JSONArray yearList = new JSONArray(Car.getYears());
        String randomYear = yearList.getString(r.nextInt(yearList.length()-1));

        JSONArray carIdList = new JSONArray(Car.getCarIds(randomYear));
        Object[][] carIds = new Object[5][2];

        for (int i = 0; i < 5; i++) {
            carIds[i][0] = randomYear;
            carIds[i][1] = carIdList.getJSONObject(i).getString("ID");
        }
        return carIds;
    }

}
