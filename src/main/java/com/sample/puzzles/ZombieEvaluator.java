package com.sample.puzzles;

import java.util.LinkedList;

public class ZombieEvaluator {

    public int daysToApoclypse(int[][] world) {
        int numberOfHumansAlive = findTotalHumansInThe(world);
        int numberOfdays =0;
        LinkedList<ValueHolder> valueHolders = new LinkedList<>();

            for (int i = 0; i < world.length; i++) {
                for (int j = 0; j < world[i].length; j++) {
                    if (world[i][j] == 1)
                        valueHolders.addLast(new ValueHolder(i,j,1));
                }
            }

        while(!valueHolders.isEmpty()){
            ValueHolder zombie = valueHolders.pollFirst();
            numberOfdays = zombie.getDayIndex()>numberOfdays? zombie.getDayIndex(): numberOfdays;
            numberOfHumansAlive -=numberOfNearByHumansKilled(zombie,world,valueHolders);
            if(numberOfHumansAlive<=0)
                break;
        }
        return numberOfdays;
    }


    private static class ValueHolder {
        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        public int getDayIndex() {
            return dayIndex;
        }

        private final int i;
        private final int j;
        private final int dayIndex;

        private ValueHolder(int i, int j, int dayIndex) {
            this.i = i;
            this.j = j;
            this.dayIndex = dayIndex;
        }

    }

    private int numberOfNearByHumansKilled(ValueHolder valueHolder, int[][] world,LinkedList<ValueHolder> valueHolders) {
        int killedHumans = 0;
        int day = valueHolder.getDayIndex();
        int i =valueHolder.getI();
        int j =valueHolder.getJ();
        killedHumans = killHuman(i - 1, j, world,valueHolders,day) ? killedHumans + 1 : killedHumans;
        killedHumans = killHuman(i + 1, j, world,valueHolders,day) ? killedHumans + 1 : killedHumans;
        killedHumans = killHuman(i, j - 1, world,valueHolders,day) ? killedHumans + 1 : killedHumans;
        killedHumans = killHuman(i, j + 1, world,valueHolders,day) ? killedHumans + 1 : killedHumans;
        return killedHumans;

    }

    private int findTotalHumansInThe(int[][] world) {
        int i = world.length;
        int humansAlive = 0;
        for (int index = 0; index < i; index++) {
            for (int j = 0; j < world[index].length; j++) {
                humansAlive = world[index][j] < 1 ? humansAlive + 1 : humansAlive;
            }
        }
        return humansAlive;
    }

    private boolean validIndices(int i, int j, int[][] array) {
        if( i <0 || i >= array.length)
            return false;
        int totalColumn = array[i].length;
        return j >= 0 && j < totalColumn;
    }

    private boolean killHuman(int i, int j, int[][] world, LinkedList<ValueHolder> valueHolders,int day) {
        boolean isKilled = false;
        if (validIndices(i, j, world)&&world[i][j]<=0) {
            world[i][j] = 1;
            valueHolders.add(new ValueHolder(i,j,day+1));
            isKilled = true;
        }
        return isKilled;
    }
}
