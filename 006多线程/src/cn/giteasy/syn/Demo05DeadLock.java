package cn.giteasy.syn;

/**
 * 死锁的演示
 * 如果同步代码嵌套, 使用相同锁, 就有可能出现死锁
 *
 */
public class Demo05DeadLock {


	private static String s1 = "筷子左";
	private static String s2 = "筷子右";

	/**
	 * 为了看到死锁效果，请多次执行以下代码或增加sleep毫秒数。
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				synchronized(s1) {
					System.out.println(getName() + "...获取" + s1 + "等待" + s2);

					synchronized(s2) {
						try {
							//为了能大概率看到死锁的效果，添加sleep
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(getName() + "...拿到" + s2 + "开吃");
					}
				}
			}
		}.start();
		
		new Thread() {
			@Override
			public void run() {
				synchronized(s2) {
					System.out.println(getName() + "...获取" + s2 + "等待" + s1);
					synchronized(s1) {
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(getName() + "...拿到" + s1 + "开吃");
					}
				}
			}
		}.start();
	}
}
