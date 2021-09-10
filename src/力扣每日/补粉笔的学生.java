package 力扣每日;

/**
 * @author:yxl
 **/
public class 补粉笔的学生 {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long sum =0;
        for(int num : chalk){
            sum+=num;
        }

        k %= sum;
        int i =0;
        while(k>=chalk[i]){
            k-=chalk[i];
            i = (i+1)%n;
        }
        return i;
    }


    public static void main(String[] args) {
        int a =100;
        long b =15;

        //int类型直接 % 或者 / long型 报错
        //eg： a = a%b;

        //a %= b; a = a /b;

        //a = (int) (a%b);
    }
}
