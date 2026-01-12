import java.util.*;
public class Q460 {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1,1);
        cache.put(2,2);

        System.out.print(cache.get(1)); 

        cache.put(3, 3); 

        System.out.print(cache.get(2)); 
        System.out.print(cache.get(3)); 
        cache.put(4, 4);

        System.out.print(cache.get(1)); 
        System.out.print(cache.get(3)); 
        System.out.print(cache.get(4)); 
    }
}

class LFUCache {
    private static class Node {
        int key, value, cnt;

        Node(int k, int v, int c) {
            key = k;
            value = v;
            cnt = c;
        }
    }

    int capacity;
    HashMap<Integer, Node> map;
    // to achieve orderd keys
    TreeMap<Integer, LinkedList<Node>> freq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.freq = new TreeMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            freq.get(node.cnt).remove(node);
            if(freq.get(node.cnt).isEmpty()){
                freq.remove(node.cnt);
            }
            if (freq.containsKey(node.cnt + 1)) {
                freq.get(node.cnt + 1).addFirst(node);
            } else {
                LinkedList<Node> list = new LinkedList<>();
                list.add(node);
                freq.put(node.cnt + 1, list);
            }
            node.cnt = node.cnt + 1;
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            freq.get(node.cnt).remove(node);
            if(freq.get(node.cnt).isEmpty()){
                freq.remove(node.cnt);
            }
            if (freq.containsKey(node.cnt + 1)) {
                freq.get(node.cnt + 1).addFirst(node);
            } else {
                LinkedList<Node> list = new LinkedList<>();
                list.add(node);
                freq.put(node.cnt + 1, list);
            }
            node.value = value;
            node.cnt = node.cnt + 1;
        } else {
            Node node = new Node(key, value, 1);
            if (map.size() >= capacity) {
                map.remove(freq.get(freq.firstKey()).getLast().key);
                freq.get(freq.firstKey()).removeLast();
                if(freq.get(freq.firstKey()).isEmpty()){
                    freq.remove(freq.firstKey());
                }
            }
            map.put(key, node);
            
            if (freq.containsKey(1)) {
                freq.get(1).addFirst(node);
            } else {
                LinkedList<Node> list = new LinkedList<>();
                list.add(node);
                freq.put(1, list);
            }
        }
    }
}
