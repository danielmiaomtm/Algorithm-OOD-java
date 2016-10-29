// Heap.java

import java.io.Serializable;

public class Heap implements Serializable{
    private int heapLength;
    private int [] data;

    public int getHeapLength() {
        return heapLength;
    }

    public void setHeapLength(int heapLength) {
        this.heapLength = heapLength;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }
}

//Heapsort.java

/**
 * Created with IntelliJ IDEA.
 * Date: 2014/8/17
 * Time: 15:39
 */
public class HeapSort {
    public final static int getLeft(int i) {
        return i << 1;
    }

    public final static int getRight(int i) {
        return (i << 1) + 1;
    }

    public final static int getParent(int i) {
        return i >> 1;
    }

    /**
     * 保持堆的性质
     *
     * @param heap
     * @param i
     */
    public static void maxHeapify(Heap heap, int i) {
        if (null == heap || null == heap.getData() || heap.getData().length <= 0 || i < 0)
            return;
        int l = getLeft(i);
        int r = getRight(i);
        int largest = 0;
        if (l < heap.getHeapLength() && heap.getData()[l] > heap.getData()[i])
            largest = l;
        else
            largest = i;
        if (r < heap.getHeapLength() && heap.getData()[r] > heap.getData()[largest])
            largest = r;
        if (largest != i) {
            int tmp = heap.getData()[i];
            heap.getData()[i] = heap.getData()[largest];
            heap.getData()[largest] = tmp;
            maxHeapify(heap, largest);
        }
    }

    /**
     * 建立最大堆
     *
     * @param array
     * @return
     */
    public static Heap bulidMaxHeap(int[] array) {
        if (null == array || array.length <= 0)
            return null;
        Heap heap = new Heap();
        heap.setData(array);
        heap.setHeapLength(array.length);
        for (int i = (array.length >> 1); i >= 0; i--)
            maxHeapify(heap, i);
        return heap;
    }

    /**
     * 堆排序
     *
     * @param array
     */
    public static void heapSort(int[] array) {
        if (null == array || array.length <= 0)
            return;
        Heap heap = bulidMaxHeap(array);
        if (null == heap)
            return;
        for (int i = heap.getHeapLength() - 1; i > 0; i--) {
            int tmp = heap.getData()[0];
            heap.getData()[0] = heap.getData()[i];
            heap.getData()[i] = tmp;
            heap.setHeapLength(heap.getHeapLength() - 1);
            maxHeapify(heap, 0);
        }
    }
}


//测试

public class Main {

    public static void main(String[] args) {
        int a[] = {9, 3, 4, 1, 5, 10, 7};
        System.out.println("Hello World!");
        Sort sort = new Sort();
//        sort.bubbleSort(a);
//        sort.selectSort(a);
//        sort.insertionSort(a);
        HeapSort.heapSort(a);
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }
}
