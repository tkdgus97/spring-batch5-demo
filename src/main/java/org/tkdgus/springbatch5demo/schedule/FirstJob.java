package org.tkdgus.springbatch5demo.schedule;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.scheduling.quartz.QuartzJobBean;

@RequiredArgsConstructor
@Slf4j
public class FirstJob extends QuartzJobBean {
    private final JobLauncher jobLauncher;
    private final JobRegistry jobRegistry;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("FIRST JOB START {}", LocalDateTime.now());
        JobParameters params = new JobParametersBuilder()
                .addLocalDateTime("FIRST_JOB_PARAM",LocalDateTime.now())
                .toJobParameters();
        try {
            jobLauncher.run(jobRegistry.getJob("FIRST_BATCH"), params);
        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException | NoSuchJobException e) {
            throw new RuntimeException(e);
        }
    }
}
