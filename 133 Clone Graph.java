/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        q.offer(node);
        map.put(node, new UndirectedGraphNode(node.label));
        
        while(!q.isEmpty()){
            UndirectedGraphNode cur = q.poll();
            UndirectedGraphNode newNode = map.get(cur);
            for(UndirectedGraphNode udn : cur.neighbors){
                if(!map.containsKey(udn)){
                    map.put(udn, new UndirectedGraphNode(udn.label));
                    q.offer(udn);
                    newNode.neighbors.add(map.get(udn));
                }
                else{
                    newNode.neighbors.add(map.get(udn));
                }
            }
        }
        return map.get(node);
    }
}
