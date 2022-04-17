package cn.giteasy.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
public class Demo1_Map {

    /**
     * * A:Map���ϵĹ��ܸ���
     * a:��ӹ���
     * V put(K key,V value):���Ԫ�ء�
     * ������ǵ�һ�δ洢����ֱ�Ӵ洢Ԫ�أ�����null
     * ��������ǵ�һ�δ��ڣ�����ֵ����ǰ��ֵ�滻����������ǰ��ֵ
     * b:ɾ������
     * void clear():�Ƴ����еļ�ֵ��Ԫ��
     * V remove(Object key)�����ݼ�ɾ����ֵ��Ԫ�أ�����ֵ����
     * c:�жϹ���
     * boolean containsKey(Object key)���жϼ����Ƿ����ָ���ļ�
     * boolean containsValue(Object value):�жϼ����Ƿ����ָ����ֵ
     * boolean isEmpty()���жϼ����Ƿ�Ϊ��
     * d:��ȡ����
     * Set<Map.Entry<K,V>> entrySet():
     * V get(Object key):���ݼ���ȡֵ
     * Set<K> keySet():��ȡ���������м��ļ���
     * Collection<V> values():��ȡ����������ֵ�ļ���
     * e:���ȹ���
     * int size()�����ؼ����еļ�ֵ�Եĸ���
     */
    public static void main(String[] args) {
        demo1();
        //demo2();
        //demo3();
    }

    private static void demo3() {
        Map<String, Integer> map = new HashMap<>();
        map.put("����", 23);
        map.put("����", 24);
        map.put("����", 25);
        map.put("����", 26);

        Collection<Integer> c = map.values();
        System.out.println(c);//[24, 23, 25, 26]
        System.out.println(map.size());//4
    }


    public static void demo2() {
        Map<String, Integer> map = new HashMap<>();
        map.put("����", 23);
        map.put("����", 24);
        map.put("����", 25);
        map.put("����", 26);

        Integer value = map.remove("����");				//���ݼ�ɾ��Ԫ��,���ؼ���Ӧ��ֵ
        //System.out.println(value);//23  ���ر�ɾ���ļ���Ӧ��ֵ
        //System.out.println(map);//{����=24, ����=25, ����=26}


        System.out.println(map.containsKey("����"));//false	//�ж��Ƿ��������ļ�
        System.out.println(map.containsValue(100));//false		//�ж��Ƿ���������ֵ

    }

    public static void demo1() {
        Map<String, Integer> map = new HashMap<>();
        Integer i1 = map.put("����", 23);
        Integer i2= map.put("����", 24);
        Integer i3 = map.put("����", 25);
        Integer i4 = map.put("����", 26);
        Integer i5 = map.put("����", 26);					//��ͬ�ļ����洢,ֵ����,�ѱ����ǵ�ֵ����

        System.out.println(map);//{����=24, ����=26, ����=25, ����=26}

        System.out.println(i1);//null
        System.out.println(i2);//null
        System.out.println(i3);//null
        System.out.println(i4);//null
        System.out.println(i5);//23   ���и��ǵ�ʱ��,�Ż᷵�ر����ǵ�ֵ
    }

}
