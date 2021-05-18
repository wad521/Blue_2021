package 算法训练;

import java.util.*;

public class ALGO_8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = input.nextInt();
        }
        Queue<Psz> que = new LinkedList<Psz>();
        for (int i = 0; i < m; i++) {
            int p = input.nextInt();
            int s = input.nextInt();
            int z = input.nextInt();
            Psz w = new Psz(p, s, z);
            que.offer(w);
        }
        input.close();
        while (!que.isEmpty()) {
            Psz point = que.poll();
            int p = point.p;
            int s = point.s-1;
            int z = point.z-1;
            if (p == 1) {
                num[s] = z;
            } else if (p == 2) {
                int sum = 0;
                for (int i = s; i <= z; i++) {
                    sum += num[i];
                }
                System.out.println(sum);
            }else if(p==3){
                int max = Integer.MIN_VALUE;
                for (int i = s; i <=z ; i++) {
                    if(num[i]>max){
                        max = num[i];
                    }
                }
                System.out.println(max);
            }
        }
    }
}

class Psz {
    public int p;
    public int s;
    public int z;

    public Psz(int p, int s, int z) {
        this.p = p;
        this.s = s;
        this.z = z;
    }
}