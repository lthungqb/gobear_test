package com.gobear.car.Utils;

import com.gobear.car.GetCarMakes;
import com.gobear.car.GetCarModels;
import com.gobear.car.GetCarVarients;
import com.gobear.car.GetYears;
import com.jayway.jsonpath.JsonPath;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import org.json.JSONArray;
import org.json.JSONException;
import org.testng.SkipException;

import java.util.Random;

public class Car {

    public static Random r = new Random();

    /**
     * Get supported years
     *
     * @return
     */
    public static String getRandomYears() throws JSONException {
        GetYears getYears = new GetYears();
        getYears.expectResponseStatus(HttpResponseStatusType.OK_200);

        JSONArray carYearList = new JSONArray(JsonPath.parse(getYears.callAPI().asString()).read("Years").toString());

        if (carYearList.length() < 1)
            throw new SkipException("There was no year supported");
        else if (carYearList.length() == 1)
            return carYearList.getString(0);
        else
            return carYearList.getString(r.nextInt(carYearList.length()-1));
    }

    public static String getRandomCarMakeIds(String carYear) throws JSONException {
        GetCarMakes getCarMakes = new GetCarMakes();
        getCarMakes.expectResponseStatus(HttpResponseStatusType.OK_200);
        getCarMakes.addUrlParameter("year", carYear);

        JSONArray carMakeIdList = new JSONArray(JsonPath.parse(getCarMakes.callAPI().asString()).read("CarMakes").toString());

        if (carMakeIdList.length() < 1)
            throw new SkipException("There was no make ID supported for year: " + carYear);
        else if (carMakeIdList.length() == 1)
            return carMakeIdList.getJSONObject(0).getString("ID");
        else
            return carMakeIdList.getJSONObject(r.nextInt(carMakeIdList.length()-1)).getString("ID");
    }

    public static String getRandomCarModelId(String carYear, String carMakeId) throws JSONException {
        GetCarModels getCarModels = new GetCarModels(carMakeId);
        getCarModels.expectResponseStatus(HttpResponseStatusType.OK_200);
        getCarModels.addUrlParameter("year", carYear);

        JSONArray carModelList = new JSONArray(JsonPath.parse(getCarModels.callAPI().asString()).read("CarModels").toString());

        if (carModelList.length() < 1)
            throw new SkipException("There was no model supported for year: " + carYear + "car make ID: " + carMakeId);
        else if (carModelList.length() == 1)
            return carModelList.getJSONObject(0).getString("ID");
        else
            return carModelList.getJSONObject(r.nextInt(carModelList.length()-1)).getString("ID");
    }

    public static String getRandomCarBodyTypeId(String carYear, String carMakeId, String carModelId) throws JSONException {
        GetCarVarients getCarVarients = new GetCarVarients(carMakeId, carModelId);
        getCarVarients.expectResponseStatus(HttpResponseStatusType.OK_200);
        getCarVarients.addUrlParameter("year", carYear);

        JSONArray carBodyTypeList = new JSONArray(JsonPath.parse(getCarVarients.callAPI().asString()).read("CarBodyTypes").toString());

        if (carBodyTypeList.length() < 1)
            throw new SkipException("There was no body type supported for year: " + carYear + "care make ID: " + carMakeId + "car model ID: " + carModelId);
        else if (carBodyTypeList.length() == 1)
            return carBodyTypeList.getJSONObject(0).getString("ID");
        else
            return carBodyTypeList.getJSONObject(r.nextInt(carBodyTypeList.length()-1)).getString("ID");
    }
}
