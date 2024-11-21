package org.tkdgus.springbatch5demo.schedule;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.quartz.*;
import org.quartz.impl.matchers.KeyMatcher;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class TestQuartzConfig {
    private final Scheduler scheduler;

    @PostConstruct
    public void schedulerConfig() throws SchedulerException {
        JobKey jobKey = new JobKey("FIRST_JOB");
        JobDetail firstJob = JobBuilder.newJob()
                .withIdentity(jobKey)
                .ofType(FirstJob.class)
                .build();
        Trigger firstTrigger = TriggerBuilder.newTrigger()
                .withIdentity("FIRST_TRIGGER")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * * * ?"))
                .forJob(firstJob)
                .build();

        JobDetail secondJob = JobBuilder.newJob()
                .withIdentity("SECOND_JOB")
                .ofType(SecondJob.class)
                .build();
        Trigger secondTrigger = TriggerBuilder.newTrigger()
                .withIdentity("SECOND_TRIGGER")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * * * ?"))
                .forJob(secondJob)
                .build();
//
        scheduler.scheduleJob(firstJob, firstTrigger);
        scheduler.scheduleJob(secondJob, secondTrigger);

        scheduler.getListenerManager().addJobListener(new GlobalJobListener());
        scheduler.getListenerManager().addJobListener(new FirstJobListener(), KeyMatcher.keyEquals(jobKey));

    }
}
