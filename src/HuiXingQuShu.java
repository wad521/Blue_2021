import java.util.Scanner;

public class HuiXingQuShu {
    private static int m, n;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        m = input.nextInt();
        n = input.nextInt();
        if (m <= 200 && n <= 200) {
            int[][] num = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    num[i][j] = input.nextInt();
                }
            }
            show(num);
        }
    }

    public static void show(int[][] num) {
        int count = 0;
        int len = m * n;
        int x = 0, y = 0;
        while (count < len) {
            while (x < m && num[x][y] != -1) {
                count++;
                if(count==len){
                    System.out.print(num[x][y]);
                }else{
                    System.out.print(num[x][y] + " ");
                }

                num[x][y] = -1;
                x++;
            }
            x--;
            y++;
            //System.out.println("x和y" + x + " " + y);
            while (y < n && num[x][y] != -1) {
                count++;
                if(count==len){
                    System.out.print(num[x][y]);
                }else{
                    System.out.print(num[x][y] + " ");
                }
                num[x][y] = -1;
                y++;
            }
            x--;
            y--;
            //System.out.println("x和y" + x + " " + y);
            while (x >= 0 && num[x][y] != -1) {
                count++;
                if(count==len){
                    System.out.print(num[x][y]);
                }else{
                    System.out.print(num[x][y] + " ");
                }
                num[x][y] = -1;
                x--;
            }
            x++;
            y--;
            //System.out.println("x和y" + x + " " + y);
            while (y >= 0 && num[x][y] != -1) {
                count++;
                if(count==len){
                    System.out.print(num[x][y]);
                }else{
                    System.out.print(num[x][y] + " ");
                }
                num[x][y] = -1;
                y--;
            }
            x++;
            y++;
            //System.out.println("x和y" + x + " " + y);
        }
    }
}
