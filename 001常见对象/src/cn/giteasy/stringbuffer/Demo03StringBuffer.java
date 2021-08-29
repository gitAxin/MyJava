package cn.giteasy.stringbuffer;

public class Demo03StringBuffer {


	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		//sb.deleteCharAt(5);					//异常StringIndexOutOfBoundsException
		sb.append("hello");
		sb.deleteCharAt(4);
		System.out.println(sb);//hell

		sb.delete(0, 2);
		System.out.println(sb);//"ll"

		sb.delete(0, sb.length());
		System.out.println(sb);//""
		
		sb = new StringBuffer();
		System.out.println(sb);//""
	}

}