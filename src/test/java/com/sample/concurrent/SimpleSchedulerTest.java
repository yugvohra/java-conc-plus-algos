package com.sample.concurrent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
class SimpleSchedulerTest {

    SimpleScheduler simpleScheduler;

    @BeforeEach
    public void setup() {
        simpleScheduler = new SimpleScheduler(Executors.newSingleThreadScheduledExecutor());
    }

    @Test
    public void shouldScheduleTask_After_10_seconds() throws InterruptedException, ExecutionException {
        //Arrange
        AtomicInteger counter = new AtomicInteger();
        //Act
        ScheduledFuture future = simpleScheduler.schduleTask((() -> counter.getAndIncrement()));
        future.get();

        //Assert
        assertThat(counter.get()).isEqualTo(1);

    }
}