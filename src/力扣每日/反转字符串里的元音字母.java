package 力扣每日;

/**
 * @author:yxl
 **/
public class 反转字符串里的元音字母 {
    public static void main(String[] args) {

    }

    public String reverseVowels(String s) {
        //双指针
        int n =s.length();
        // i 前指针   j 尾指针
        int i =0 , j = n - 1;
        char[] arr = s.toCharArray();

        while (i<j){
            while (i<n && !check(arr[i])){
                i++;
            }
            while (j>0 && !check(arr[j])){
                j++;
            }
            if(i<j){
                swap(i,j,arr);
                i++;
                j++;
            }
        }
        return new String(arr);
    }

    public boolean check(char c){
        if("aeiouAEIOU".indexOf(c)>=0){
            return true;
        }
        return false;
    }

    public void swap(int i , int j,char[] arr){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
