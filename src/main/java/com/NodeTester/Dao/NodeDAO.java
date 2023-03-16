package com.NodeTester.Dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.springframework.stereotype.Repository;

@Repository
public class NodeDAO {

    private final Map<Integer, Set<Integer>> map = new HashMap<>();   

    public void addNode(int node1, int node2) {
        map.computeIfAbsent(node1, k -> new HashSet<>()).add(node2);
        map.computeIfAbsent(node2, k -> new HashSet<>()).add(node1);
    }

    public boolean checkIfConnected(int node1, int node2) {      
        if (!map.containsKey(node1) || !map.containsKey(node2)) {
            return false;
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node1);
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            visited.add(currNode);
            if (currNode == node2) {           
                return true;
            }
            for (int neighbor : map.getOrDefault(currNode, Collections.emptySet())) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);          
                }
            }
        }
        return false;
    }
}

