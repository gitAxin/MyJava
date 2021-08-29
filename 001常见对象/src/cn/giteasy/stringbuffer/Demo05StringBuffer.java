package cn.giteasy.stringbuffer;

public class Demo05StringBuffer {

	/**
	 * * A:StringBuffer的截取功能
		* public String substring(int start):
			* 从指定位置截取到末尾
		* public String substring(int start,int end):
			* 截取从指定位置开始到结束位置，包括开始位置，不包括结束位置
	* B:注意事项
		* 注意:返回值类型不再是StringBuffer本身
	 */
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("hello world");
		//返回的是一个新的对象,原对象内容不变
		String str = sb.substring(6);

		System.out.println(sb);//hello world
		System.out.println(str);//world


		
		String str3 = sb.substring(6, 8); //wo
		System.out.println(str3);
	}

}
