package com.sample.strings;

import com.sample.ds.strings.StringAlgorithms;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringAlgorithmsTest {

    @Test
    public void shouldReturnMaxWindowOf_three() {
        //Arrange
        String s = "abcde";
        StringAlgorithms stringAlgorithms = new StringAlgorithms();
        //Act

        assertThat(stringAlgorithms.findLengthOfLongestSubstringOf(3, s)).isEqualTo(3);

    }

    @Test
    public void shouldNotReturnAnyString() {
        //Arrange
        String s = "aaaaaaaaa";
        StringAlgorithms stringAlgorithms = new StringAlgorithms();
        assertThat(stringAlgorithms.findLengthOfLongestSubstringOf(3, s)).isEqualTo(0);


    }

    //
    @Test
    public void shouldReturn_max_lenght_two() {
        //Arrange
        String s = "ab";
        StringAlgorithms stringAlgorithms = new StringAlgorithms();
        assertThat(stringAlgorithms.findLengthOfLongestSubstringOf(1, s)).isEqualTo(1);

    }

    @Test
    public void shouldReturn_MaxLength_16() {
        //Arrange
        String s = "aabbbccccddddddeeeeee";
        StringAlgorithms stringAlgorithms = new StringAlgorithms();
        //Act
        assertThat(stringAlgorithms.findLengthOfLongestSubstringOf(3, s)).isEqualTo(16);

    }

    @Test
    public void shouldReturn_MaxLength_2() {
        //Arrange
        String s = "ab";
        StringAlgorithms stringAlgorithms = new StringAlgorithms();
        //Act
        assertThat(stringAlgorithms.findLengthOfLongestSubstringOf(2, s)).isEqualTo(2);

    }

    @Test
    public void shouldReturn_MaxLength_6() {
        //Arrange
        String s = "abccddee";
        StringAlgorithms stringAlgorithms = new StringAlgorithms();
        //Act
        assertThat(stringAlgorithms.findLengthOfLongestSubstringOf(3, s)).isEqualTo(6);

    }

    @Test
    public void shouldReturn_MaxLength_7() {
        //Arrange
        String s = "abcdefghaaaa";
        StringAlgorithms stringAlgorithms = new StringAlgorithms();
        //Act
        assertThat(stringAlgorithms.findLengthOfLongestSubstringOf(4, s)).isEqualTo(7);

    }

    @Test
    public void shouldFindRightPalindrome() {
        //Arrange
        String s = "abba";
        StringAlgorithms stringAlgorithms = new StringAlgorithms();
        //Act
        assertThat(stringAlgorithms.findLogestPalindrome(s)).isEqualTo("abba");

    }

    @Test
    public void shouldFindRightPalindrome_of_5_length() {
        //Arrange
        String s = "abcba";
        StringAlgorithms stringAlgorithms = new StringAlgorithms();
        //Act
        assertThat(stringAlgorithms.findLogestPalindrome(s)).isEqualTo("abcba");

    }

    @Test
    public void shouldFindRightPalindrome_of_same_seq() {
        //Arrange
        String s = "aaaa";
        StringAlgorithms stringAlgorithms = new StringAlgorithms();
        //Act
        assertThat(stringAlgorithms.findLogestPalindrome(s)).isEqualTo("aaaa");

    }

    @Test
    public void shouldFindRightPalindrome_of_same_odd_seq() {
        //Arrange
        String s = "aaaaa";
        StringAlgorithms stringAlgorithms = new StringAlgorithms();
        //Act
        assertThat(stringAlgorithms.findLogestPalindrome(s)).isEqualTo("aaaaa");

    }

    @Test
    public void shouldFindRightPalindrome_of_long_seq() {
        //Arrange
        String s = "forgeeksskeegfor";
        StringAlgorithms stringAlgorithms = new StringAlgorithms();
        //Act
        assertThat(stringAlgorithms.findLogestPalindrome(s)).isEqualTo("geeksskeeg");

    }

    @Test
    public void shouldFindRightPalindrome_of_long_seq_odd() {
        //Arrange
        String s = "forgeekshskeegfor";
        StringAlgorithms stringAlgorithms = new StringAlgorithms();
        //Act
        assertThat(stringAlgorithms.findLogestPalindrome(s)).isEqualTo("geekshskeeg");

    }
}