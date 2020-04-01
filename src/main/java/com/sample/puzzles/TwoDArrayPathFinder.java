package com.sample.puzzles;

import java.util.*;

public class TwoDArrayPathFinder {
    public Set<PathHolder> findAllPaths(int[][] array) {
//        int[][] graph = generateGraph(array);
        LinkedList<PathHolder> queue = new LinkedList<>();
        PathNode src = new PathNode(0,0, array[0][0]);
        PathNode dest = new PathNode(array.length-1,array[0].length-1, array[array.length-1][array[0].length-1]);
        LinkedHashSet<PathNode> srcPAth = new LinkedHashSet<>();
        srcPAth.add(src);
        PathHolder srcHolder = new PathHolder(src, srcPAth, src.getValue());
        queue.addLast(srcHolder);
        Set<PathHolder>paths = new HashSet<>();
        while(!queue.isEmpty()){
            PathHolder current = queue.removeFirst();
            Set<PathNode> adjacentPathNode = getAdjNodes(current.getPathNode(),array);
            for(PathNode node : adjacentPathNode){
                LinkedHashSet finalPath = new LinkedHashSet(current.getCurrentPAth());
                if(node.equals(dest)){
                    finalPath.add(dest);
                    int mini = dest.getValue()< current.getCurrentMinin()? dest.getValue(): current.getCurrentMinin();
                    paths.add(new PathHolder(node,finalPath,mini));
                }
                else{
                    finalPath.add(node);
                    int mini = node.getValue()< current.getCurrentMinin()? node.getValue(): current.getCurrentMinin();
                    queue.addLast(new PathHolder(node, finalPath, mini));
                }
            }

        }
        return paths;
    }

    public int findMaxOfMinValuesInPaths(Set<PathHolder>paths){
        int currentMin = Integer.MIN_VALUE;
        for(PathHolder pathHolder :paths)
            currentMin =currentMin>pathHolder.getCurrentMinin()?currentMin:pathHolder.getCurrentMinin();
        return currentMin;
    }

    private Set<PathNode> getAdjNodes(PathNode pathNode, int[][]array) {
        int i = pathNode.getI();
        int j = pathNode.getJ();
        Set<PathNode>adjNodes = new HashSet<>();
        if(i<array.length-1)
            adjNodes.add(new PathNode(i+1,j, array[i+1][j]));
        if(j<array[i].length -1)
            adjNodes.add(new PathNode(i,j+1, array[i][j+1]));
        return adjNodes;
    }

    private static class PathNode {
        final int i;
        final int j;
        final int value;

        private PathNode(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        public int getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PathNode)) return false;
            PathNode pathNode = (PathNode) o;
            return getI() == pathNode.getI() &&
                    getJ() == pathNode.getJ();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getI(), getJ());
        }

        @Override
        public String toString() {
            return " "+ value;
        }
    }

    private static class PathHolder {
        final PathNode pathNode;
        final LinkedHashSet<PathNode> currentPAth;
        final int currentMinin;

        private PathHolder(PathNode pathNode, LinkedHashSet<PathNode> currentPAth, int currentMinin) {
            this.pathNode = pathNode;
            this.currentPAth = currentPAth;
            this.currentMinin = currentMinin;
        }

        public PathNode getPathNode() {
            return pathNode;
        }

        public LinkedHashSet<PathNode> getCurrentPAth() {
            return currentPAth;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PathHolder)) return false;
            PathHolder that = (PathHolder) o;
            return getCurrentMinin() == that.getCurrentMinin() &&
                    Objects.equals(getPathNode(), that.getPathNode()) &&
                    Objects.equals(getCurrentPAth(), that.getCurrentPAth());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getPathNode(), getCurrentPAth(), getCurrentMinin());
        }

        public int getCurrentMinin() {
            return currentMinin;
        }

        @Override
        public String toString() {
            return "PathHolder{" +
                    "currentPAth=" + currentPAth +
                    ", currentMinin=" + currentMinin +
                    '}';
        }
    }
}
