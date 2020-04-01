package com.sample.concurrent;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SimpleScheduler {
    private final ScheduledExecutorService scheduledExecutorService;

    public SimpleScheduler(ScheduledExecutorService scheduledExecutorService) {
        this.scheduledExecutorService = scheduledExecutorService;
    }

    public ScheduledFuture schduleTask(Runnable task) {
        return scheduledExecutorService.schedule(task, 10, TimeUnit.SECONDS);
    }
}
