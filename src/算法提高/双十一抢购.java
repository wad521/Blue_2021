package 算法提高;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 双十一抢购 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //sum表示小G的可用金额
        double sum = input.nextDouble();
        //N表示她看上的物品个数
        int N = input.nextInt();
        //创建所有商品的集合
        Goods[] arr = new Goods[N];
        //给商品赋值
        for (int i = 0; i < N; i++) {
            arr[i] = new Goods();
            arr[i].num = i + 1;
            arr[i].price = input.nextDouble();
            arr[i].off = input.nextInt();

        }

        Arrays.sort(arr, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                //“赚”的多少降序
                if (o1.price * o1.off < o2.price * o2.off) {
                    return 1;
                }
                else if (o1.price * o1.off == o2.price * o2.off) {
                    //“赚”一样多的情况下，铵价格升序
                    if (o1.price < o2.price) {
                        return -1;
                    }
                    else if (o1.price == o2.price) {
                        //价格一样，按编号升序
                        if (o1.num < o2.num) {
                            return -1;
                        }
                        else {
                            return 1;
                        }
                    }
                    else {
                        return 1;
                    }
                }
                else {
                    return -1;
                }
            }
        });

//        for (Goods s : arr) {
//            System.out.println(s.num + " " + s.price + " " + s.off);
//        }

        //创建一个结果的数组，进行存储要购买的序号
        int[] result = new int[N];
        //用来存储商品的数目
        int count = 0;
        //按照刚才排号的顺序，进行购买
        for (int i = 0; i < N; i++) {
            double realPrice = arr[i].price - arr[i].price * arr[i].off * 0.5;
            if (realPrice <= sum) {
                sum -= realPrice;
                result[count] = arr[i].num;
                count++;
            }
        }
        //如果没有商品的话，就输出0，结束程序
        if (count == 0) {
            System.out.print(0);
            System.exit(0);
        }
        //给商品号进行排序
        Arrays.sort(result);
        for (int i = 0; i < N; i++) {
            if (result[i] != 0) {
                System.out.print(result[i] + " ");
            }

        }
    }
}

class Goods {
    int num;//序号
    double price;//原价
    int off;//折扣

    public Goods() {
        num = 0;
        price = 0;
        off = 0;
    }
}

