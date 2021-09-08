package cn.giteasy.common;

public class Student extends Person{

    public Student() {
    }

    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        Student stu = (Student) obj;
        return this.getName().equals(stu.getName()) && this.getAge() == stu.getAge();
    }


}
