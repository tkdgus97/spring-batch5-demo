package org.tkdgus.springbatch5demo.schedule;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class TestSchedulerConfig {
    private final Scheduler scheduler;

    @PostConstruct
    public void configSchedule() throws SchedulerException {
        JobDetail job = JobBuilder.newJob()
                .withIdentity("FIRST_JOB")
                .ofType(CustomJob.class)
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("FIRST_TRIGGER")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * * * ?"))
                .forJob(job)
                .build();

        scheduler.scheduleJob(job, trigger);
        scheduler.getListenerManager().addJobListener(new CustomJobListener());
    }

}
