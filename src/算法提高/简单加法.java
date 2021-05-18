package 算法提高;

/**
 * @author:yxl
 **/
public class 简单加法 {
    public static void main(String[] args) {
        int cout = 0;
        for (int i = 1; i < 1000; i++) {
            if(i%3==0||i%5==0){
                cout+=i;
            }
        }
        System.out.println(cout);
    }
}
