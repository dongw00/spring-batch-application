package io.springbatch.springbatch.batch.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public ModelMapper mapper() {
        ModelMapper mapper = new ModelMapper();
        // setting

        return mapper;
    }
}
