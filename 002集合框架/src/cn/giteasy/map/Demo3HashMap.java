package cn.giteasy.map;

import cn.giteasy.common.Student;

import java.util.HashMap;


/**
 * * A:������ʾ
 * HashMap���ϼ���Studentֵ��String�İ���
 * ����ѧ������,����ÿһ��ѧ��
 * ֵ���ַ�������,����ѧ��������
 */
public class Demo3HashMap {

    public static void main(String[] args) {
        HashMap<Student, String> hm = new HashMap<>();
        hm.put(new Student("����", 23), "����");
        hm.put(new Student("����", 23), "�Ϻ�");
        hm.put(new Student("����", 24), "����");
        hm.put(new Student("����", 25), "����");

        System.out.println(hm);
    }
}
