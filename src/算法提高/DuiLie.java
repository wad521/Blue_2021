package 算法提高;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DuiLie {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Queue<Edges> q1 = new LinkedList<Edges>();
        int a,b;
        for (int i = 0; i < n; i++) {
            a = input.nextInt();
            if(a==1){
                b=input.nextInt();
                q1.offer(new Edges(a,b));
            }else{
                q1.offer(new Edges(a,0));
            }
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        Integer x,y;
        for (int i = 1; i <= n; i++) {
            Edges e = q1.poll();
            x = e.x;
            if(x==1){
                y=e.y;
                queue.offer(y);
            }else if(x==2){
                if(queue.size()==0){
                    System.out.println("no");
                    break;
                }else {
                    Integer num = queue.poll();
                    System.out.println(num);
                }
            }else if(x==3){
                System.out.println(queue.size());
            }
        }
    }
}

class Edges{
    Integer x,y;
    public Edges(){

    }
    public Edges(int x1,int y1){
        x = (Integer)x1;
        y = (Integer)y1;
    }
}
