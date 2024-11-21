package org.tkdgus.springbatch5demo.batch.tasklet;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class FirstBatchConfig {
    private final JobRepository jobRepository;
    private final PlatformTransactionManager platformTransactionManager;
    private final Tasklet firstTask;
    private final Tasklet secondTask;


    @Bean
    public Job firstJob() {
        return new JobBuilder("FIRST_BATCH", jobRepository)
                .start(firstStep())
                .incrementer(new RunIdIncrementer())
                .build();
    }

    @Bean
    public Step firstStep() {
        return new StepBuilder(  "FIRST_BATCH_STEP1", jobRepository)
                .tasklet(firstTask, platformTransactionManager)
                .build();
    }

    @Bean
    public Job secondJob() {
        return new JobBuilder("SECOND_BATCH", jobRepository)
                .start(secondStep())
                .incrementer(new RunIdIncrementer())
                .build();
    }

    @Bean
    public Step secondStep() {
        return new StepBuilder(  "SECOND_BATCH", jobRepository)
                .tasklet(secondTask, platformTransactionManager)
                .build();
    }

}
