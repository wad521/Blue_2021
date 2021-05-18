package 基础练习;

import java.util.Scanner;

public class JieCheng {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] num = new int[3000];//1000!阶乘2568位
        num[1] = 1;//数组下标为1表示个位，依次类推
        int up = 0;//表示进位

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <num.length; j++) {
                int s = num[j] * i + up;
                num[j] = s % 10;
                up = s / 10;
            }
        }
        int idx = num.length-1;
        for (int i = num.length-1; i >=1 ; i--) {
            if(num[i]!=0){
                idx = i;
                break;
            }
        }
        for (int i = idx;i>=1;i--){
            System.out.print(num[i]);
        }
    }
}
