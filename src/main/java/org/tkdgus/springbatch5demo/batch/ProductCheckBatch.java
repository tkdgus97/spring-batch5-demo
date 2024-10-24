package org.tkdgus.springbatch5demo.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.tkdgus.springbatch5demo.entity.Product;
import org.tkdgus.springbatch5demo.repository.ProductRepository;

@Slf4j
@Configuration
public class ProductCheckBatch {
    private final ProductRepository productRepository;
    private final JobRepository jobRepository;
    private final PlatformTransactionManager platformTransactionManager;

    public ProductCheckBatch(ProductRepository productRepository, JobRepository jobRepository,
                             PlatformTransactionManager platformTransactionManager) {
        this.productRepository = productRepository;
        this.jobRepository = jobRepository;
        this.platformTransactionManager = platformTransactionManager;
        log.info("{}", this.platformTransactionManager.hashCode());

    }

    @Bean
    public Job checkBuyCountZeroJob() {
        return new JobBuilder("cntZero", jobRepository)
                .start()
                .build()
    }

    @Bean
    public Step countZeroStep() {
        return new StepBuilder("cntZero", jobRepository)
                .chunk(100 ,platformTransactionManager)
                .reader()
                .processor()
                .writer()
    }

    @Bean
    public RepositoryItemReader<Product>
}
