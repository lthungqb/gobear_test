package com.gobear.car;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import org.testng.annotations.Test;

@Test
public class TestGetBaseCases extends AbstractTest {

    public void testGetBaseCase_Success() {
        GetBaseCases getBaseCases = new GetBaseCases();
        getBaseCases.expectResponseStatus(HttpResponseStatusType.OK_200);

        getBaseCases.callAPI();
    }
}
