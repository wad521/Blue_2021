package 历届真题;

import java.util.*;

/**
 * @author:yxl
 **/
public class 日志统计 {
    static class message {
        int ts;
        int id;

        public message(int ts, int id) {
            this.ts = ts;
            this.id = id;
        }
    }


    //测试数据
    //7 10 2
    //0 1
    //0 10
    //10 10
    //9 1
    //100 3
    //100 3
    //10 1
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int D = input.nextInt();
        int K = input.nextInt();
        //构建日志记录数组
        message[] messages = new message[N];
        for (int i = 0; i < N; i++) {
            int ts = input.nextInt();
            int id = input.nextInt();
            messages[i] = new message(ts, id);
        }
        input.close();
        Arrays.sort(messages, new Comparator<message>() {
            @Override
            public int compare(message o1, message o2) {
                if (o1.ts > o2.ts) {
                    return 1;
                } else
                    return -1;
            }
        });
        for (message s : messages) {
            System.out.println(s.ts + " " + s.id);
        }
        //存储窗口内id出现的次数
        int[] key = new int[100001];
        Arrays.fill(key, 0);
        //窗口的左右边界
        int l = 0, r = 0;

        Set<Integer> result = new HashSet<Integer>();
        while (r < N) {
            if (messages[r].ts - messages[l].ts < D) {
                key[messages[r].id]++;
                if(key[messages[r].id]>=K){
                    result.add(messages[r].id);
                }
                r++;
            } else {
                key[messages[l].id]--;
                l++;
            }
        }



        System.out.println(result);
        for(Integer re : result){
            System.out.println(re);
        }
    }
}
