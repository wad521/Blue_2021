package LeetCode_3月;

import java.util.Arrays;

/**
 * @author:yxl
 **/
public class MyHashSet {
    private int[] data;
    private static final int SIZE = 13_333;     // 10000 / 0.75
    private static final int NULL = -1;
    private static final int DELETED = -2;      // deleted mark

    public MyHashSet() {
        data = new int[SIZE];
        Arrays.fill(data, NULL);
    }

    public void add(int key) {
        data[hash(key)] = key;
    }

    public void remove(int key) {
        data[hash(key)] = DELETED;    // -2: deleted mark
    }

    public boolean contains(int key) {
        return data[hash(key)] != NULL;
    }

    private int hash(int key) {
        int i = key % SIZE;
        while (data[i] != key && data[i] != NULL) {
            i = (i + 1) % SIZE;
        }
        return i;
    }
}
