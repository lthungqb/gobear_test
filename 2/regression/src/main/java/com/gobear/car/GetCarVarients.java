package com.gobear.car;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetCarVarients extends AbstractApiMethodV2 {

    // Define template

    // Constructors

    public GetCarVarients(String carId, String carModelId) {
        super(null, null, new Properties());
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("carId", carId);
        replaceUrlPlaceholder("carModelId", carModelId);
    }
}
