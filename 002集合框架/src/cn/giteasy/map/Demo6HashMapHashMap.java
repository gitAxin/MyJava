package cn.giteasy.map;

import cn.giteasy.common.Student;

import java.util.HashMap;

/**
 * A:������ʾ
 * ����Ƕ��֮HashMapǶ��HashMap
 */

public class Demo6HashMapHashMap {


	public static void main(String[] args) {
		//����map1
		HashMap<Student, String> map1 = new HashMap<>();
		map1.put(new Student("����", 23), "����");
		map1.put(new Student("����", 24), "����");
		map1.put(new Student("����", 25), "�Ϻ�");
		map1.put(new Student("����", 26), "����");
		
		//����map2
		HashMap<Student, String> map2 = new HashMap<>();
		map2.put(new Student("��ɮ", 1023), "����");
		map2.put(new Student("�����",1024), "����");
		map2.put(new Student("��˽�",1025), "�Ϻ�");
		map2.put(new Student("ɳ����",1026), "����");
		
		//����Ƕ�׼���
		HashMap<HashMap<Student, String>, String> hashMap = new HashMap<>();
		hashMap.put(map1, "map1");
		hashMap.put(map2, "map2");


		//����˫�м���
		for(HashMap<Student, String> h : hashMap.keySet()) {		//hm.keySet()�������˫�м����м��ļ���
			String value = hashMap.get(h);						//get(h)���ݼ������ȡֵ����
			//��������˫�м��϶���
			for(Student key : h.keySet()) {					//h.keySet()��ȡ���������е�ѧ��������
				String value2 = h.get(key);
				
				System.out.println(key + "=" + value2 + "=" + value);
			}
		}
		
	}

}
