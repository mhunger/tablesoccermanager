package org.hungerhome.soccermanager.api.config;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

public class SoccerManagerRestMvcConfiguration extends RepositoryRestMvcConfiguration
{
    @Override
    public RepositoryRestConfiguration config() {
        RepositoryRestConfiguration config = super.config();
        config.setBaseUri("/api");
        return config;
    }
}
