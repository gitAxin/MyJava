package cn.giteasy.map;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * ������
 * HashMap��Hashtable������
 * ��ͬ��:
 * �ײ㶼�ǹ�ϣ�㷨,����˫�м���
 * ����:
 * 	1,HashMap���̲߳���ȫ��,Ч�ʸ�,JDK1.2�汾
 * 	  Hashtable���̰߳�ȫ��,Ч�ʵ�,JDK1.0�汾��
 * 	2,HashMap���Դ洢null����nullֵ
 * 	  Hashtable�����Դ洢null����nullֵ
 */
public class Demo7Hashtable {


	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put(null, 23);
		hm.put("����", null);
		System.out.println(hm);  //{null=23, ����=null}
		
		Hashtable<String, Integer> ht = new Hashtable<>();
		ht.put(null, 23);// java.lang.NullPointerException
		ht.put("����", null);// java.lang.NullPointerException
		System.out.println(ht);

	}

}
