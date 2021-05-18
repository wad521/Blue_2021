package 基础练习;

import java.util.Scanner;

public class Rabbit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int v1, v2, t, s, l;
        v1 = input.nextInt();
        v2 = input.nextInt();
        t = input.nextInt();
        s = input.nextInt();
        l = input.nextInt();
        int s1 = 0, s2 = 0;//兔子、乌龟各自跑到路程
        int i = 0;//时间
        //比赛未结束进行循环
        while (s1 < l && s2 < l) {
            //兔子超越乌龟t米,兔子休息s秒，乌龟不休息
            if (s1 - s2 >= t) {
                for (int j = 1; j <= s; j++) {
                    i++;
                    s2+=v2;
                    if(s2>=l){
                        break;
                    }
                }
            }else{
                i++;
                s1 += v1;
                s2 += v2;
            }
        }
        if (s1 == s2) {
            System.out.println("D");
            System.out.println(i);
        } else if (s1 > s2) {
            System.out.println("R");
            System.out.println(i);
        } else {
            System.out.println("T");
            System.out.println(i);
        }
    }
}
