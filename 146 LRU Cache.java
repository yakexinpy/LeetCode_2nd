public class LRUCache {
    
    class DoubleLinkedNode{
        int key;
        int value;
        DoubleLinkedNode pre;
        DoubleLinkedNode next;
        public DoubleLinkedNode(int k, int val){
            key = k;
            value = val;
        }
    }
    
    DoubleLinkedNode head, tail;
    int size;
    int cap;
    Map<Integer, DoubleLinkedNode> map;
    
    public LRUCache(int capacity) {
       size = 0;
       cap = capacity;
       map = new HashMap<Integer, DoubleLinkedNode>();
    }
    
    private void setHead(DoubleLinkedNode node){
        node.pre = null;
        node.next = head;
        if(head != null)
            head.pre = node;
        head = node;
        
        if(tail == null)
            tail = node;
        
    }
    
    private void removeNode(DoubleLinkedNode node){
        if(node.pre == null)
            head = node.next;
        else
            node.pre.next = node.next;
        
        if(node.next == null)
            tail = node.pre;
        else
            node.next.pre = node.pre;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            DoubleLinkedNode node = map.get(key);
            removeNode(node);
            setHead(node);
            return node.value;
        }
        else
            return -1;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            DoubleLinkedNode node = map.get(key);
            node.value = value;
            removeNode(node);
            setHead(node);
        }
        else{
            if(size == cap){
                map.remove(tail.key);
                tail = tail.pre;
                if(tail != null) tail.next = null;
                size--;
            }
            DoubleLinkedNode node = new DoubleLinkedNode(key, value);
            map.put(key, node);
            setHead(node);
            size++;
        }
    }
}
