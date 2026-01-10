import java.util.*;
public class Q146 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);

        System.out.println(cache.get(1)); 

        cache.put(3, 3); 

        System.out.println(cache.get(2)); 
        cache.put(4, 4);

        System.out.println(cache.get(1)); 
        System.out.println(cache.get(3)); 
        System.out.println(cache.get(4)); 
    }
}

// optimal
// tc : 1
// sc : capacity
class LRUCache {

    private static class Node {
        int key, value;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    int capacity;
    LinkedList<Node> list;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.list = new LinkedList<>();
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            list.remove(node);
            list.addFirst(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            list.remove(node);
            node.value = value;
            list.addFirst(node);
            map.put(key, node);
        } else {
            if (map.size() >= capacity) {
                Node lru = list.removeLast();
                map.remove(lru.key);
            }
            Node node = new Node(key, value);
            list.addFirst(node);
            map.put(key, node);
        }
    }
}

// brute
// tc : n
// sc : 2n
class LRUCache2 {

    ArrayList<Integer> list = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();

    int capacity = 0;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(key)) {
                    list.remove(i);
                    list.add(key);
                    break;
                }
            }
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(key)) {
                    list.remove(i);
                    break;
                }
            }
            list.add(key);
        } else {
            if (map.size() >= capacity) {
                map.remove(list.get(0));
                list.remove(0);
            }
            list.add(key);
        }
        map.put(key, value);
    }
}
