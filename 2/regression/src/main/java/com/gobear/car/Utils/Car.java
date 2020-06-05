package com.gobear.car.Utils;

import com.gobear.car.GetCarMakes;
import com.gobear.car.GetYears;
import com.jayway.jsonpath.JsonPath;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import net.minidev.json.JSONArray;

public class Car {

    /**
     * Get supported years
     *
     * @return
     */
    public static String getYears() {
        GetYears getYears = new GetYears();
        getYears.expectResponseStatus(HttpResponseStatusType.OK_200);

        return JsonPath.parse(getYears.callAPI().asString()).read("Years").toString();
    }

    public static String getCarIds(String year) {
        GetCarMakes getCarMakes = new GetCarMakes();
        getCarMakes.expectResponseStatus(HttpResponseStatusType.OK_200);
        getCarMakes.addUrlParameter("year", year);

        return JsonPath.parse(getCarMakes.callAPI().asString()).read("CarMakes").toString();
    }
}
