package 力扣每日;

/**
 * @author:yxl
 **/
public class 压缩字符串 {
    public int compress(char[] chars) {
        //low指向第一个重复元素   fast指向最后一个重复元素   count记录长度
        int low=0,fast=0,count =0;
        int idx=0;
        while (fast<chars.length){
            while (fast<chars.length && chars[fast] == chars[low]){
                count++;
                fast++;
            }

            //根据count情况进行判断
            if(count == 1){
                chars[idx] = chars[low];
                idx++;
            }else {
                //防止是2位数即以上
                String temp = Integer.toString(count);
                chars[idx] = chars[low];
                idx++;
                for (int i = 0; i < temp.length(); i++) {
                    chars[idx] = temp.charAt(i);
                    idx++;
                }
            }
            count = 0;
            low = fast;
        }
        return idx;
    }
}
