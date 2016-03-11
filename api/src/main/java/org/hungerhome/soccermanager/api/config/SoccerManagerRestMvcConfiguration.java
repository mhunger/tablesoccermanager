package org.hungerhome.soccermanager.api.config;

import org.hungerhome.soccermanager.api.framework.PlayerEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SoccerManagerRestMvcConfiguration extends RepositoryRestMvcConfiguration
{
    @Override
    public RepositoryRestConfiguration config() {
        RepositoryRestConfiguration config = super.config();
        config.setBaseUri("/api");
        return config;
    }

    @Bean
    PlayerEventHandler playerEventHandler() {
        return new PlayerEventHandler();
    }

    @Bean
    DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://soccer.dev/soccermanager_test");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }

}
