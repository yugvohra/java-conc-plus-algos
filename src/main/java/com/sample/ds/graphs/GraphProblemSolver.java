package com.sample.ds.graphs;

import java.util.*;

public class GraphProblemSolver {
    private static int id=0;

    /**
     * Finds the mother node of a connected component
     * @param graph
     * @return
     */
    public int findMotherNode(int[][]graph){
        HashSet<Integer> visited =new HashSet<>();
        LinkedList<Integer>proposedMotherNodes = new LinkedList<>();
        int sourceNode = 0;
       for(int i =0 ; i<graph.length;i++)
        getMothers(i,graph,visited,proposedMotherNodes);
        return proposedMotherNodes.getLast();
    }

    /**
     * finds the bridges within a graph
     * bridges are edges that if taken away breaks the graph
     * @param graph
     * @return
     */
    public List<List<Integer>> findBridges(int[][] graph){
        List<List<Integer>> bridges = new ArrayList<>();
        Set<Integer>visited = new HashSet<>();
        int[] ids = new int[graph.length];
        int[]low = new int[graph.length];
        findBridgeinDFTraversal(-1,3,graph,bridges,visited,ids,low);
        return bridges;
    }


    /**
     * Finds the bridges while iterative graph in DF fashion
     *
     * An edge uv is a bridge if id[u]<lowLink[v]
     * @param parent
     * @param node
     * @param graph
     * @param bridges
     * @param visited
     * @param ids
     * @param low
     */
    private void findBridgeinDFTraversal(int parent, int node, int[][] graph, List<List<Integer>> bridges, Set<Integer> visited, int[] ids, int[] low) {
        ids[node]=id++;
        visited.add(node);
        low[node]=ids[node];
        for(int adJNode= 0; adJNode<graph.length;adJNode++){
            if(graph[node][adJNode]==0||adJNode==parent)
                continue;
            if(!visited.contains(adJNode)){
                findBridgeinDFTraversal(node,adJNode,graph,bridges,visited,ids,low);
                low[node]=Math.min(low[node],low[adJNode]);
            }
            else{
                low[node]=Math.min(ids[adJNode],low[node]);
            }
            if(ids[node]<low[adJNode]){
                bridges.add(List.of(adJNode,node));
            }
        }
    }

    /**
     * Get all mother nodes of the graph
     * @param node
     * @param graph
     * @param visited
     * @param proposedMotherNodes
     */
    private void getMothers(int node, int[][] graph, HashSet<Integer> visited, LinkedList<Integer> proposedMotherNodes) {
        visited.add(node);
        int[]adjs = graph[node];
        for(int index =0; index<adjs.length;index++){
            if(adjs[index]==0||visited.contains(index))
                continue;
            getMothers(index,graph,visited,proposedMotherNodes);
        }
        proposedMotherNodes.addLast(node);
    }
}
