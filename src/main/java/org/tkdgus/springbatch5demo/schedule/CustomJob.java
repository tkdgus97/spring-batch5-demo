package org.tkdgus.springbatch5demo.schedule;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;

@Slf4j
public class CustomJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        JobDataMap map = getJobDataMap(context);
        log.info("Job Start : {} , {}", LocalDateTime.now(), map.getInt("v1"));

        map.put("v1",map.getInt("v1") + 1);
    }

    private JobDataMap getJobDataMap(JobExecutionContext context) {
        return  context.getJobDetail().getJobDataMap();
    }
}
