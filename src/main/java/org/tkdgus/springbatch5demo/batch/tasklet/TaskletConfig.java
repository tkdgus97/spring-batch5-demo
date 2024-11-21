package org.tkdgus.springbatch5demo.batch.tasklet;

import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskletConfig {

    @Bean
    public Tasklet firstTask() {
        return new FirstTask();
    }

    @Bean
    public Tasklet secondTask() {
        return new SecondTask();
    }
}
