package com.sample.ds.strings;

import java.lang.reflect.GenericDeclaration;
import java.util.*;
import java.util.stream.Collectors;

public class StringAlgorithms {
    /**
     * find length of longest subsring of k unique characters
     * @param kUniqueChar
     * @param string
     * @return
     */
    public int findLengthOfLongestSubstringOf(int kUniqueChar, String string) {
        int[] availableCharCount = new int[27];
        char delim = 'a' + 26;
        String modifiedStr = string + delim;
        HashSet<Set<Integer>> subStringIndicesSet = new HashSet<>();
        int windowBegin = 0;
        int maxWindowLength = 0;
        availableCharCount[modifiedStr.charAt(0) - 'a'] = 1;
        for (int idx = 1; idx < modifiedStr.length(); idx++) {
            availableCharCount[modifiedStr.charAt(idx) - 'a']++;
            if (isMaxLength(availableCharCount, kUniqueChar)) {
                availableCharCount[modifiedStr.charAt(windowBegin) - 'a']--;
                maxWindowLength = idx - windowBegin > maxWindowLength ? idx - windowBegin : maxWindowLength;
                windowBegin++;
            }
        }
        return maxWindowLength;

    }

    private boolean isMaxLength(int[] availableCharCount, int kUniqueChar) {
        int totalUniqueChar = 0;
        for (int count : availableCharCount) {
            totalUniqueChar = count > 0 ? totalUniqueChar + 1 : totalUniqueChar;
        }
        return totalUniqueChar > kUniqueChar;
    }


    /**
     * find longest palindrome of a string
     * @param s
     * @return
     */
    public String findLogestPalindrome(String s) {
        int maxLength = 0;
        int beginIndex = 0;
        int endIndex = 0;

        for (int index = 0; index < s.length(); index++) {
            int right = index;
            int left = index - 1;
            int evenLength = findPalindromLength(s, left, right);
            int oddLength = findPalindromLength(s, index, index);
            if (evenLength > oddLength && maxLength < evenLength) {
                maxLength = evenLength;
                beginIndex = left - (evenLength / 2 - 1);
                endIndex = right + (evenLength / 2 - 1);
            } else if (maxLength < oddLength) {
                maxLength = oddLength;
                beginIndex = index - oddLength / 2;
                endIndex = index + oddLength / 2;
            }
        }
        int validBegIndex = returnValidIndex(s, beginIndex);
        int validEndIndex = returnValidIndex(s, endIndex);
        return s.substring(validBegIndex, validEndIndex + 1);
    }

    private int returnValidIndex(String s, int beginIndex) {
        if (beginIndex < 0)
            return 0;
        else if (beginIndex >= s.length())
            return s.length() - 1;
        return beginIndex;
    }

    private int findPalindromLength(String s, int left, int right) {
        int max_length = 1;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            max_length = right - left + 1;
            left--;
            right++;
        }
        return max_length;
    }

    /**
     * find all permutations of the given array elements
     * @param nums
     * @return
     */

    public List<List<Integer>> permute(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        List<List<Integer>> finalPermu = new ArrayList<>();
        findPermutations(numSet, finalPermu, new ArrayList<Integer>());
        return finalPermu;


    }

    private void findPermutations(HashSet<Integer> numSet, List<List<Integer>> permutations, ArrayList<Integer> currentPermutation) {
        numSet.remove(currentPermutation);
        for (Integer num : numSet) {
            currentPermutation.add(num);
            findPermutations(numSet, permutations, currentPermutation);
        }
        permutations.add(currentPermutation);
    }
}