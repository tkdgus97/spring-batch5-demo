package org.tkdgus.springbatch5demo.schedule;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

@Slf4j
public class CustomJobListener implements JobListener {
    @Override
    public String getName() {
        return CustomJobListener.class.getName();
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {
        log.info("job start before : {}", jobExecutionContext.getJobDetail().getKey().getName());
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        if (jobDataMap.get("v1") == null) {
            jobDataMap.put("v1",1);
        }
//        jobDataMap.putIfAbsent("v1", 1);
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {
    }

    @Override
    public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {
    }
}
