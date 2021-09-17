package cn.giteasy.common;

/**
 * Demo class
 *
 * @author axin
 * @date 2021/9/17
 */
public class HashSetPerson {

    private String name;
    private int age;
    public HashSetPerson() {
        super();

    }
    public HashSetPerson(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "HashSetPerson [name=" + name + ", age=" + age + "]";
    }

	//@Override
	//public boolean equals(Object obj) {
	//	System.out.println("HashSetPerson equals() ");
    //    HashSetPerson p = (HashSetPerson)obj;
	//	return this.name.equals(p.name) && this.age == p.age;
	//}

    /**
     *  hashCode 尽量让其不同,这样就减少了调用equals方法方法再进行比较,开发中一般都是IDE自动生成即可
     */
	//@Override
	//public int hashCode() {
	//	final int NUM = 38;
	//	return name.hashCode() * NUM + age;
	//}

    /*
     * 为什么是31?
     * 1,31是一个质数,质数是能被1和自己本身整除的数
     * 2,31这个数既不大也不小
     * 3,31这个数好算,2的五次方-1,2向左移动5位
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)						//调用的对象和传入的对象是同一个对象
            return true;						//直接返回true
        if (obj == null)						//传入的对象为null
            return false;						//返回false
        if (getClass() != obj.getClass())		//判断两个对象对应的字节码文件是否是同一个字节码
            return false;						//如果不是直接返回false
        HashSetPerson other = (HashSetPerson) obj;			//向下转型
        if (age != other.age)					//调用对象的年龄不等于传入对象的年龄
            return false;						//返回false
        if (name == null) {						//调用对象的姓名为null
            if (other.name != null)				//传入对象的姓名不为null
                return false;					//返回false
        } else if (!name.equals(other.name))	//调用对象的姓名不等于传入对象的姓名
            return false;						//返回false
        return true;							//返回true
    }


}
