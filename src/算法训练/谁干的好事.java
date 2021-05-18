package 算法训练;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 谁干的好事 {

    static int[] goodMan = new int[5];//1表示做好事，0表示没做好事（下标分别对应A~E）
    static int[] truthMan = new int[5];//1表示说真话，0表示说假话
    static Set<String> list = new HashSet<String>();//存放最后可能的所有结果

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();//做好事的人数
        char[] str = sc.next().toCharArray();
        char x = str[0];//x的值（A~E之间的一个字符）
        int truth = sc.nextInt();//说真话的人数

        searchGood(0, num, truth, x);//找做好事的人
        outputResult();//输出最后的结果
    }

    //1.寻找做好事的人(k:表当前找到做好事的人数；num:表做好事的人数； truth:表说真话的人数； x:表A~E之间的一个字符)
    private static void searchGood(int k,int num,int truth,char x){
        if(k == num){//1.1已找到所有做好事的人
            searchTruth(0, truth, x);//再寻找说真话的人
            return;
        }
        for(int i=0;i<5;i++){//1.2 没有找到所有做好事的人(则逐个进行测试)
            if(goodMan[i] == 0){//当前的人i 没有做过好事
                goodMan[i] = 1;//设置i做过好事,当前做好事的人数为k+1
                searchGood(k+1, num, truth, x);
                goodMan[i] = 0;//若设置i做过好事不合适，则将其重置为没有做过好事
            }
        }

    }

    //2.寻找说真话的人(k:表当前找到说真话的人数；truth：表说真话的人数；x:表A~E之间的一个字符)
    private static void searchTruth(int k, int truth, char x) {
        if(k == truth){//2.1 已找到所有说真话的人
            if(judge(x)){//如果查找的结果没有矛盾，将其加入到结果集中
                addResult();
            }
            return;
        }

        for(int i=0;i<5;i++){//2.2 没有找到所有说真话的人
            if(truthMan[i] == 0){//将i设置为说真话的人,当前说真话的人数为k+1
                truthMan[i]=1;
                searchTruth(k+1, truth, x);//继续找说真话的人
                truthMan[i]=0;//如果测试i说真话不合理，则设置为0
            }
        }

    }

    //3.判断x是否合理（即当取x时，A、B、C、D、E说真话和说假话 都没有矛盾）
    private static boolean judge(char x) {
        boolean A = (goodMan[0]^goodMan[x-'A']) == truthMan[0];//如果是true，则说明没有矛盾（A说假话和真话都没有矛盾）
        boolean B = (goodMan[2]+goodMan[4]>=1) == (truthMan[1] == 1);
        boolean C = (goodMan[0]+goodMan[2]+goodMan[3]>=1) == (truthMan[2]==1);
        boolean D = (goodMan[1]+goodMan[2]==0)==(truthMan[3]==1);
        boolean E = (goodMan[4]^truthMan[4]) == 1;
        return A && B && C && D && E;
    }

    //4.将最终结果加入到结果集中
    private static void addResult() {
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<5;i++){
            if(goodMan[i]==1){//是好人,添加到bulider
                builder.append((char)('A'+i));
            }
        }
        list.add(builder.toString());//将可能的结果存放在list集合中
    }

    //5.输出最后结果
    private static void outputResult(){
        if(list.size()==0){
            System.out.println("0");
            return;
        }
        for(String s:list){
            System.out.println(s);
        }
    }


}
