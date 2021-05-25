package 国赛;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 大胖子走迷宫 {
    private static int n, k, result;
    private static char[][] map;
    private static boolean[][] visit;
    public static int[][] points = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static class Node {
        int x, y, time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    //判断经历时间time后，胖子的宽度
    static int culcate(int time) {
        if (time / k == 1)
            return 1;
        else if (time / k == 0)
            return 2;
        else
            return 0;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        k = input.nextInt();
        map = new char[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = input.next().toCharArray();
        }
        visit[2][2] = true;
        bfs();
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(2, 2, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x == n - 3 && node.y == n - 3) {
                System.out.println(node.time);
                return;
            }
            //若胖子直接卡住，不到k或者2k时间无法通过缝隙，则一直等待。
            queue.add(new Node(node.x, node.y, node.time + 1));

            //走到下一个结点才会变瘦
            //即（2,2）点时间0 ，(2,3)点时间1.
            //判断四个方向
            for (int[] point : points) {
                int xx = node.x + point[0];
                int yy = node.y + point[1];

                int fat = culcate(node.time);
                //判断是否超界
                if (xx - fat < 0 || xx + fat > n - 1 || yy - fat < 0 || yy + fat > n - 1)
                    continue;
                //是否被访问过
                if (visit[xx][yy])
                    continue;

                boolean flag = true;
                if (fat != 0) {
                    for (int x = xx - fat; x <= xx + fat; x++) {
                        for (int y = yy - fat; y <= yy + fat; y++) {
                            if (map[x][y] == '*')
                                flag = false;
                        }
                    }
                } else {
                    if (map[xx][yy] == '*')
                        flag = false;
                }

                if(!flag)
                    continue;

                visit[xx][yy] = true;
                queue.add(new Node(xx, yy, node.time + 1));
            }
        }
    }
}
