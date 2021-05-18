package 生活大爆炸版石头剪刀布;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] grade = new int[][]{{0,-1,1,1,-1},{1,0,-1,1,-1},{-1,1,0,-1,1},{-1,-1,1,0,1},{1,1,-1,-1,0}};
        int result_a=0,result_b=0;
        int n= input.nextInt();
        int na = input.nextInt();
        int nb = input.nextInt();
        int [] a = new int[na];
        int [] b = new int[nb];
        for (int i = 0; i < na; i++) {
            a[i]=input.nextInt();
        }
        for (int i = 0; i < nb; i++) {
            b[i]=input.nextInt();
        }
        int a_num,b_num;
        for (int i = 0; i < n; i++) {
            a_num=a[i%na];
            b_num=b[i%nb];
            //0表示“剪刀”，1表示“石头”，2表示“布”，3表示“蜥蜴人”， 4表示“斯波克”
            if(grade[a_num][b_num]==0){
                continue;
            }else if(grade[a_num][b_num]==1){
                result_a+=1;
            }else if(grade[a_num][b_num]==-1){
                result_b+=1;
            }
        }
        System.out.println(result_a+" "+result_b);
    }
}
