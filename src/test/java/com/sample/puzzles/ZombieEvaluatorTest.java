package com.sample.puzzles;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ZombieEvaluatorTest {
    @Test
    public void shouldKill_allHumansIn_two_days() {
        int input[][] = {{0, 0, 0}, {0, 0, 1}};
        ZombieEvaluator zombieEvaluator = new ZombieEvaluator();
        int numberOFDays = zombieEvaluator.daysToApoclypse(input);
        assertThat(numberOFDays).isEqualTo(3);
    }

}