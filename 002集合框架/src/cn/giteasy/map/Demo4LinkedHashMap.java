package cn.giteasy.map;

import java.util.LinkedHashMap;

public class Demo4LinkedHashMap {

	/**
	 * @param args
	 * LinkedHashMap���Ա�֤��ô�����ôȡ
	 */
	public static void main(String[] args) {
		LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put("����", 23);
		linkedHashMap.put("����", 24);
		linkedHashMap.put("����", 26);
		linkedHashMap.put("����", 25);
		
		System.out.println(linkedHashMap);
		/**
		 * ���
		 * {����=23, ����=24, ����=26, ����=25}
		 */
	}

}
