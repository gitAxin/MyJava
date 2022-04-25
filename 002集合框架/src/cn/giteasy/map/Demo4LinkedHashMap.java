package cn.giteasy.map;

import java.util.LinkedHashMap;

public class Demo4LinkedHashMap {

	/**
	 * @param args
	 * LinkedHashMap可以保证怎么存就怎么取
	 */
	public static void main(String[] args) {
		LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put("张三", 23);
		linkedHashMap.put("李四", 24);
		linkedHashMap.put("赵六", 26);
		linkedHashMap.put("王五", 25);
		
		System.out.println(linkedHashMap);
		/**
		 * 输出
		 * {张三=23, 李四=24, 赵六=26, 王五=25}
		 */
	}

}
