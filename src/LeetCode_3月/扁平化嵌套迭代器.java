package LeetCode_3月;

import java.util.*;

/**
 * @author:yxl
 **/
public class 扁平化嵌套迭代器 {
}
//
//public class NestedIterator implements Iterator<Integer> {
//
//    Deque<Integer> queue = new ArrayDeque<>();
//
//    public NestedIterator(List<NestedInteger> nestedList) {
//        dfs(nestedList);
//    }
//
//    @Override
//    public Integer next() {
//        return hasNext() ? queue.pollFirst() : -1;
//    }
//
//    @Override
//    public boolean hasNext() {
//        return !queue.isEmpty();
//    }
//
//    void dfs(List<NestedInteger> list) {
//        for (NestedInteger item : list) {
//            if (item.isInteger()) {
//                queue.addLast(item.getInteger());
//            } else {
//                dfs(item.getList());
//            }
//        }
//    }
//}