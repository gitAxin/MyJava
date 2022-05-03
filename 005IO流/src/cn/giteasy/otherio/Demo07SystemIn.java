package cn.giteasy.otherio;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Demo07SystemIn {

	/**
	 * BufferedReader实现键盘录入
	 */
	//public static void main(String[] args) throws IOException {
	//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		//InputStreamReader转换流
	//	System.out.println("请输入：");
	//	String line = br.readLine();
	//	System.out.println(line);
	//	br.close();
	//
	//}



	/**
	 * Scanner实现键盘录入
	 */
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		System.out.println("请输入：");
		String line = sc.nextLine();
		System.out.println(line);
		sc.close();
	}

}
