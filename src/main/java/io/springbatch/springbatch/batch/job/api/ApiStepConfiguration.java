package io.springbatch.springbatch.batch.job.api;

import io.springbatch.springbatch.batch.partition.ProductPartitioner;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

@Configuration
@RequiredArgsConstructor
public class ApiStepConfiguration {

    private final StepBuilderFactory stepBuilderFactory;
    private final ProductPartitioner partitioner;
    private final EntityManagerFactory entityManagerFactory;

    private final int chunkSize = 10;
}
