package com.gobear.car;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetBaseCases extends AbstractApiMethodV2 {

    // Define template
    public static final String RS_SCHEMA = "template/GetBaseCases/rs.schema";

    // Constructors

    public GetBaseCases() {
        super(null, null, new Properties());
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
