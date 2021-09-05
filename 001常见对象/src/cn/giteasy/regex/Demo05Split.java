package cn.giteasy.regex;

public class Demo05Split {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "张三.李四.sally";
		String[] arr = s.split("\\.");				//通过正则表达式切割字符串
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		/*
		张三
		李四
		sally
		 */
	}



}
