package com.sample.ds;

public class DynamicProblemSolver {

    public DynamicProblemSolver() {
    }

    /**
     * given an array of share prices where price[i]
     * refers to price on day i
     * <p>
     * this function finds the maximum profile possible over n days of stock price
     *
     * @param prices
     * @return
     */
    public int maxProfitOfShares(int[] prices) {
        int buyPrice = prices[0];
        int sellingPrice = prices[0];
        int profit = 0;
        for (int idx = 1; idx < prices.length; idx++) {
            if (prices[idx] < buyPrice) {
                buyPrice = prices[idx];
                sellingPrice = buyPrice;
            } else if (sellingPrice < prices[idx]) {
                sellingPrice = prices[idx];
            } else if (sellingPrice > prices[idx]) {
                profit += sellingPrice - buyPrice;
                buyPrice = prices[idx];
                sellingPrice = buyPrice;
            }
        }
        return profit;
    }


    /**
     * Classic problem to place flowers in a bed where
     * adjacent flowers compete for resources
     *
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowersInBed(int[] flowerbed, int n) {
        for (int idx = 0; idx < flowerbed.length; idx++) {
            if (flowerbed[idx] == 1)
                continue;
            if (isRightEmpty(flowerbed, idx) && isLeftEmpty(flowerbed, idx)) {
                n--;
                flowerbed[idx] = 1;
            }
        }
        return n == 0;
    }

    public boolean isRightEmpty(int[] flowerbed, int idx) {
        return (idx == flowerbed.length - 1) || flowerbed[idx + 1] == 0;
    }

    public boolean isLeftEmpty(int[] flowerbed, int idx) {
        return idx == 0 || flowerbed[idx - 1] == 0;
    }
}
