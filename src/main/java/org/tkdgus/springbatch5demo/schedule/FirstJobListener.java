package org.tkdgus.springbatch5demo.schedule;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

@Slf4j
public class FirstJobListener implements JobListener {
    @Override
    public String getName() {
        return FirstJobListener.class.getName();
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {
        log.info("FIRST START BEFORE LISTENER : {}", jobExecutionContext.getJobDetail().getKey().getName());
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();

    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {
        log.info("JOB 실행 취소 : {}", jobExecutionContext.getJobDetail().getKey().getName());
    }

    @Override
    public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {
        if (e != null) {
            e.printStackTrace();
        }
        log.info("JOB 실행 완료 : {}", jobExecutionContext.getJobDetail().getKey().getName());
    }
}
