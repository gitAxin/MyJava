package cn.giteasy.thread2;

import java.io.IOException;

/**
 * @author Axin
 */
public class Demo02Runtime {


	public static void main(String[] args) throws IOException {
		Runtime r = Runtime.getRuntime();			//获取运行时对象,单例模式
		//r.exec("shutdown -s -t 300"); 		//300秒后关机
		//r.exec("shutdown -a");				//取消关机
	}

}
