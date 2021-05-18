package 算法提高;

import java.util.Arrays;
import java.util.Scanner;

public class 书院主持人 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int key = m, idx = 0, count = 1;
        int[] num = new int[m];
        Arrays.fill(num,1);
        while (key!=1){
            if(num[idx]==1){
                if(count==n){
                    key--;
                    num[idx]=-1;
                    count=1;
                    idx=(idx+1)%m;
                }else{
                    count++;
                    idx=(idx+1)%m;
                }
            }else{
                idx=(idx+1)%m;
            }
        }
        for (int i = 0; i < m; i++) {
            if(num[i]==1){
                System.out.println(i+1);
            }
        }
    }
}

