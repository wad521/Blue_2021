package 力扣每日;
import java.util.*;
/**
 * @author:yxl
 **/
public class 超级丑数 {
    public static void main(String[] args) {

    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        set.add(1L);
        queue.add(1L);
        while (n-- > 0){
            long num = queue.poll();
            if (n==0){
                return (int)num;
            }
            //因为每一个数因子都在primes里。
            for(int x : primes){
                if(!set.contains(num*x)){
                    set.add(num*x);
                    queue.add(num*x);
                }
            }
        }
        return -1;
    }
}
