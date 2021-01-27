package com.pvsoul.eec.eeccenter.config;

import com.pvsoul.eec.eeccenter.provider.RuntimeExceptionProvider;
import com.pvsoul.eec.eeccenter.provider.ValidationExceptionProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.autoconfigure.jersey.ResourceConfigCustomizer;
import org.springframework.context.annotation.Configuration;


/**
 * Jersey配置类
 *
 */
@Configuration
public class JerseyConfig implements ResourceConfigCustomizer {

    @Override
    public void customize(ResourceConfig config) {
        config.register(com.pvsoul.eec.eeccenter.resource.EccCenterResource.class);
        config.registerClasses(ValidationExceptionProvider.class);
        config.registerClasses(RuntimeExceptionProvider.class);
    }
}