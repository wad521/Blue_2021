package 历届真题;

/**
 * @author:yxl
 **/
public class 打印图形 {
    static int N = 70;

    public static void main(String[] args) {
        String a[][] = new String[N][N];
        int i, j;
        for (i = 0; i < N; i++)
            for (j = 0; j < N; j++)
                a[i][j] = " ";

        f(a, 4, 0, 0);

        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) System.out.printf("%s", a[i][j]);
            System.out.println();
        }
    }

    public static void f(String a[][], int rank, int row, int col) {
        if (rank == 1) {
            a[row][col] = "*";
            return;
        }

        int w = 1;
        int i;
        for (i = 0; i < rank - 1; i++) w *= 2;
        //填空：
        f(a, rank - 1, row, col + w / 2);
        f(a, rank - 1, row + w / 2, col);
        f(a, rank - 1, row + w / 2, col + w);
    }
}
