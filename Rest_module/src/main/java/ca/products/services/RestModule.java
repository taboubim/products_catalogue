package ca.products.services;

import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

import java.util.HashMap;

/**
 * Created by mtaboubi on 16-07-17.
 */
public class RestModule extends JerseyServletModule {

    @Override
    protected void configureServlets() {

        HashMap<String, String> params = new HashMap<>();
        params.put(PackagesResourceConfig.PROPERTY_PACKAGES, "ca.products.services");
        params.put(JSONConfiguration.FEATURE_POJO_MAPPING, "true");
        params.put(ResourceConfig.FEATURE_DISABLE_WADL, "true");

        serve("/*").with(GuiceContainer.class, params);
    }
}