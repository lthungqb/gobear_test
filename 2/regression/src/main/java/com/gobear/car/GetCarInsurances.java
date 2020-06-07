package com.gobear.car;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetCarInsurances extends AbstractApiMethodV2 {

    // Define template

    // Constructors

    public GetCarInsurances() {
        super(null, null, new Properties());
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
