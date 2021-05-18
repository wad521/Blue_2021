package 基础练习;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Huffuman {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            Integer num = new Integer(input.nextInt());
            queue.offer(num);
        }
        int sum = 0;
        while (queue.size() > 1) {
            Integer first = queue.poll();
            Integer second = queue.poll();
            sum += (first + second);
            queue.offer(first + second);
        }
        System.out.println(sum);
    }
}
