package cn.giteasy.stringbuffer;

public class Demo04StringBuffer {

	/**
	 * * A:StringBuffer的替换功能
			* public StringBuffer replace(int start,int end,String str):
				* 从start开始到end用str替换
		* B:StringBuffer的反转功能
			* public StringBuffer reverse():
				* 字符串反转
	 */
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("hello");
		sb.replace(0, 3, "***");
		System.out.println(sb);	//***lo
		
		sb.reverse();
		System.out.println(sb);//ol***
	}

}
