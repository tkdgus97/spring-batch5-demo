package org.tkdgus.springbatch5demo.schedule;

import jakarta.annotation.PostConstruct;
import java.sql.BatchUpdateException;
import lombok.RequiredArgsConstructor;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

@Configuration
@RequiredArgsConstructor
public class TestQuartzConfig {
    private final Scheduler scheduler;

    @PostConstruct
    public void schedulerConfig() throws SchedulerException {
        JobDetail firstJob = JobBuilder.newJob()
                .withIdentity("FIRST_JOB")
                .ofType(TestFirstJob.class)
                .build();
        Trigger firstTrigger = TriggerBuilder.newTrigger()
                .withIdentity("FIRST_TRIGGER")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * * * ?"))
                .forJob(firstJob)
                .build();

        JobDetail secondJob = JobBuilder.newJob()
                .withIdentity("SECOND_JOB")
                .ofType(TestSecondJob.class)
                .build();
        Trigger secondTrigger = TriggerBuilder.newTrigger()
                .withIdentity("SECOND_TRIGGER")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * * * ?"))
                .forJob(secondJob)
                .build();

        scheduler.scheduleJob(firstJob, firstTrigger);
        scheduler.scheduleJob(secondJob, secondTrigger);
    }
}
