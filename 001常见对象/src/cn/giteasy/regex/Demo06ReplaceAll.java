package cn.giteasy.regex;

public class Demo06ReplaceAll {

	/**
	 * * A:正则表达式的替换功能
	 * String类的功能：public String replaceAll(String regex,String replacement)
	 */
	public static void main(String[] args) {
		String s = "wo111 ai222 bei jing 13ti2an an me0n.";
		String regex = "\\d";			//\\d代表的是任意数字
		
		String s2 = s.replaceAll(regex, "");
		System.out.println(s2);
	}

}
