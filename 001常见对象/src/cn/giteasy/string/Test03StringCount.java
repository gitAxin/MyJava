package cn.giteasy.string;

/**
 * 统计下列不同字符的个数
 * "ABCDEabcd123456!@#$%^"
 *
 * @author axin
 * @date 2021/8/29
 */
public class Test03StringCount {
    public static void main(String[] args) {

        String s1 = "ABCDEabcd123456!@#$%^&";
        int upperCaseCount = 0;
        int lowerCaseCount = 0;
        int numCount = 0;
        int otherCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                upperCaseCount ++;
            }else if( c >= 'a' && c <= 'z'){
                lowerCaseCount ++;
            }else if(c >= '0' && c <= '9'){
                numCount ++;
            }else{
                otherCount ++;
            }
        }
        System.out.println("大写:" + upperCaseCount);//5
        System.out.println("小写:" + lowerCaseCount );//4
        System.out.println("数字:" + numCount );//6
        System.out.println("其他:" + otherCount);//7


    }
}
