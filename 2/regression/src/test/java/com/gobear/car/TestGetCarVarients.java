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

        Random r = new Random();

        JSONArray yearList = new JSONArray(Car.getYears());
        String randomYear = yearList.getString(r.nextInt(yearList.length()-1));

        JSONArray carIdList = new JSONArray(Car.getCarIds(randomYear));
        String randomCarId = carIdList.getJSONObject(r.nextInt(carIdList.length()-1)).getString("ID");

        JSONArray carModelList = new JSONArray(Car.getCarModelId(randomYear, randomCarId));

        int noOfTest = r.nextInt(carModelList.length() - 1)+1;
        Object[][] carModelIds = new Object[noOfTest][3];

        for (int i = 0; i < noOfTest; i++) {
            carModelIds[i][0] = randomYear;
            carModelIds[i][1] = randomCarId;
            carModelIds[i][2] = carModelList.getJSONObject(i).getString("ID");

        }
        return carModelIds;
    }

}
