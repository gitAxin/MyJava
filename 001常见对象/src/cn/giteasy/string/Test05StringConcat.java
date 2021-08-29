package cn.giteasy.string;

/**
 * 字符串拼接
 *  int[] arr = {101,102,103,104,105,106};
 * 将一个 整数型数组 拼接成以下格式,并输出
 * "[101,102,103,104,105,106]"
 *
 * @author axin
 * @date 2021/8/29
 */
public class Test05StringConcat {
    public static void main(String[] args) {
        int[] arr = {101,102,103,104,105,106};
        String result = "[";
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
            if(i != arr.length - 1){
                result += ",";
            }else{
                result += ']';
            }
        }
        System.out.println(result);
    }
}
