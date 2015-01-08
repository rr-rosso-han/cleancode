package graph;

import java.util.*;

/**
 * Created by jiahan on 1/5/15.
 */
public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode graph) {
        if (graph == null) {
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        return cloneGraphDFS(graph, map);
    }
    private UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        map.put(node, cloneNode);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraphDFS(neighbor, map));
        }
        return cloneNode;
    }

    public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode graph) {
        if (graph == null) {
            return null;
        }
        return bfs(graph);
    }

    private UndirectedGraphNode bfs(UndirectedGraphNode graph) {

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        q.add(graph);
        UndirectedGraphNode graphCopy = new UndirectedGraphNode(graph.label);
        map.put(graph, graphCopy);

        while (!q.isEmpty()) {
            UndirectedGraphNode node = q.poll();
            for (UndirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.get(node).neighbors.add(map.get(neighbor));
                } else {
                    UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.label);
                    map.get(node).neighbors.add(neighborCopy);
                    map.put(neighbor, neighborCopy);
                    q.add(neighbor);
                }
            }
        }
        return graphCopy;
    }
}
