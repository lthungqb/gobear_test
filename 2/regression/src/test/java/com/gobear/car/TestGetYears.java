package com.gobear.car;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import org.testng.annotations.Test;

@Test
public class TestGetYears extends AbstractTest {

    public void testGetYears_Success() {
        GetYears getYears = new GetYears();
        getYears.expectResponseStatus(HttpResponseStatusType.OK_200);

        getYears.callAPI();
        getYears.validateResponseAgainstJSONSchema(GetYears.RS_SCHEMA);
    }
}
