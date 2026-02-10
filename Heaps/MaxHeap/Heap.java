
import java.util.ArrayList;

class Heap<T extends Comparable<T>> {

    ArrayList<T> list;

    public Heap() {
        list = new ArrayList<>();
    }

    private void swap(int first, int second) {
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return index * 2 + 1;
    }

    private int right(int index) {
        return index * 2 + 2;
    }

    // tc : log n
    public void insert(T value) {
        list.add(value);
        upheap(list.size() - 1);
    }

    private void upheap(int index) {
        if (index == 0) {
            return;
        }
        int p = parent(index);
        if (list.get(p).compareTo(list.get(index)) < 0) {
            swap(p, index);
            upheap(p);
        }
    }

    // tc : log n
    public T remove() {
        if (list.isEmpty()) {
            throw new RuntimeException("Removing from empty heap !");
        }
        T temp = list.get(0);
        T last = list.remove(list.size() - 1);
        if (!list.isEmpty()) {
            list.set(0, last);
            downheap(0);
        }
        return temp;
    }

    private void downheap(int index) {
        int max = index;
        int l = left(index);
        int r = right(index);

        if (l < list.size() && list.get(max).compareTo(list.get(l)) < 0) {
            max = l;
        }

        if (r < list.size() && list.get(max).compareTo(list.get(r)) < 0) {
            max = r;
        }

        if (max != index) {
            swap(max, index);
            downheap(max);
        }
    }

    // tc : n log n
    public ArrayList<T> heapSort() {
        ArrayList<T> data = new ArrayList<>();
        while (!list.isEmpty()) {
            data.add(remove());
        }
        return data;
    }

}
