package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiahan on 1/5/15.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
