package com.sample.puzzles;

import java.util.*;

public class GraphPathFinder {
    /**
     * Dirty algorithm to find all paths
     * @param adj
     * @param src
     * @param dest
     * @return
     */
    public Set<Set<Integer>> findAllPaths(int[][] adj, int src, int dest) {
        LinkedHashSet<Integer> path = new LinkedHashSet<>();
        LinkedList<PathHolder> queue = new LinkedList<>();
        Set<Set<Integer>> allPaths = new HashSet<>();
        path.add(src);
        queue.addLast(new PathHolder(src, path));
        while (!queue.isEmpty()) {
            PathHolder pathHolder = queue.removeFirst();
            int[] adjacentNodes = adj[pathHolder.getNode()];
            for (int node = 0; node < adjacentNodes.length; node++) {
                if (adjacentNodes[node] == 0)
                    continue;
                if (node == dest) {
                    LinkedHashSet finalPath = new LinkedHashSet(pathHolder.getPath());
                    finalPath.add(dest);
                    allPaths.add(finalPath);
                } else if (!pathHolder.getPath().contains(node)) {
                    LinkedHashSet finalPath = new LinkedHashSet(pathHolder.getPath());
                    finalPath.add(node);
                    queue.addLast(new PathHolder(node, finalPath));
                }
            }

        }
        return allPaths;
    }

    private static class PathHolder {
        final int node;
        final LinkedHashSet<Integer> path;

        private PathHolder(int node, LinkedHashSet<Integer> path) {
            this.node = node;
            this.path = path;
        }

        public int getNode() {
            return node;
        }

        public LinkedHashSet<Integer> getPath() {
            return path;
        }
    }
}
