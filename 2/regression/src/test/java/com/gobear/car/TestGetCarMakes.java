package com.gobear.car;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class TestGetCarMakes extends AbstractTest {

    @Test(dataProvider = "getYear")
    public void testGetBaseCase_Success(String year) {
        GetCarMakes getCarMakes = new GetCarMakes();
        getCarMakes.expectResponseStatus(HttpResponseStatusType.OK_200);
        getCarMakes.addUrlParameter("year", year);

        getCarMakes.callAPI();
    }

    @DataProvider(name = "getYear")
    private Object[][] getYear() {
        return new Object[][] {
                {2017},
                {2016},
                {2015},
                {2014},
                {2013},
                {2012},
                {2011}
        };
    }

}
