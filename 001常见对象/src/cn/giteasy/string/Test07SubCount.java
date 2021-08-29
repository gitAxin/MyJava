package cn.giteasy.string;

/**
 * 案例演示:在大字符串中统计子串出现的次数
 *
 * @author axin
 * @date 2021/8/29
 */
public class Test07SubCount {
    public static void main(String[] args) {
        String str = "buguanshibaimaohaishiheimao,nengdaidaolaosujiushihaomao";
        String sub = "mao";
        int length = str.length();

        int index = 0;
        int count = 0;
        //方法一:
        //while((index = str.indexOf(sub,index+ sub.length())) != -1){
        //    count++;
        //}

        //方法二:
        while((index = str.indexOf(sub)) != -1){
            count++;
            str = str.substring(index + sub.length());
        }
        //
        System.out.println(count);//3




    }
}
