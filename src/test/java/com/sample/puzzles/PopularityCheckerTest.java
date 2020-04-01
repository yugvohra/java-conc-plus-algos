package com.sample.puzzles;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PopularityCheckerTest {

    @Test
    public void shouldReturn_2_popularToys() {
        int numToys = 6;
        int topToys = 2;
        String[] toys = {"elmo", "elsa", "legos", "drone", "tablet", "warcraft"};
        int numQuotes = 6;
        String[] quotes = {"Elmo is the hottest of the season! Elmo will be on every kid's wishlist!", "The new Elmo dolls are super high quality", "Expect the Elsa dolls to be very popular this year, Elsa!",
                "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good", "For parents of older kids, look into buying them a drone", "Warcraft is slowly rising in popularity ahead of the holiday season"};
        PopularityChecker popularityChecker = new PopularityChecker();

        String[] expectedToys = {"elmo", "elsa"};

        assertThat(popularityChecker.findNPopularToys(topToys, numToys, toys, numQuotes, quotes)).isEqualTo(expectedToys);
    }

}