package cn.giteasy.map;

import cn.giteasy.common.Student;

import java.util.HashMap;

/**
 * A:案例演示
 * 集合嵌套之HashMap嵌套HashMap
 */

public class Demo6HashMapHashMap {


	public static void main(String[] args) {
		//定义map1
		HashMap<Student, String> map1 = new HashMap<>();
		map1.put(new Student("张三", 23), "北京");
		map1.put(new Student("李四", 24), "北京");
		map1.put(new Student("王五", 25), "上海");
		map1.put(new Student("赵六", 26), "广州");
		
		//定义map2
		HashMap<Student, String> map2 = new HashMap<>();
		map2.put(new Student("唐僧", 1023), "北京");
		map2.put(new Student("孙悟空",1024), "北京");
		map2.put(new Student("猪八戒",1025), "上海");
		map2.put(new Student("沙和尚",1026), "广州");
		
		//定义嵌套集合
		HashMap<HashMap<Student, String>, String> hashMap = new HashMap<>();
		hashMap.put(map1, "map1");
		hashMap.put(map2, "map2");


		//遍历双列集合
		for(HashMap<Student, String> h : hashMap.keySet()) {		//hm.keySet()代表的是双列集合中键的集合
			String value = hashMap.get(h);						//get(h)根据键对象获取值对象
			//遍历键的双列集合对象
			for(Student key : h.keySet()) {					//h.keySet()获取集合总所有的学生键对象
				String value2 = h.get(key);
				
				System.out.println(key + "=" + value2 + "=" + value);
			}
		}
		
	}

}
