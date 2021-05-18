import java.math.BigInteger;
import java.util.Scanner;

public class Lqiao {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a = input.next();
        String b =input.next();
        BigInteger a1 = new BigInteger(a);
        BigInteger b1 = new BigInteger(b);
        BigInteger c = a1.add(b1);
        System.out.println(c);
        int[] A = new int[101];
        int[] B=new int[101];
        int[] C = new int[101];
        int coun = 0;
        for (int i = a.length()-1; i>=0 ; i--) {
            A[coun++]=Integer.parseInt(a.substring(i,i+1));
        }
        coun=0;
        for (int i = b.length()-1; i>=0 ; i--) {
            B[coun++]=Integer.parseInt(b.substring(i,i+1));
        }
        int yu = 0;
        for (int i = 0; i < 101; i++) {
            C[i]=(A[i]+B[i]+yu)%10;
            if(A[i]+B[i]+yu>=10)
                yu=1;
            else
                yu=0;
        }
        for (int i = 100; i >=0; i--) {
            if (C[i]!=0){
                coun=i;
                break;
            }
        }
        for (int i = coun; i >=0 ; i--) {
            System.out.print(C[i]);
        }
    }
}