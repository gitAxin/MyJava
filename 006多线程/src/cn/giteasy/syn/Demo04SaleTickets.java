package cn.giteasy.syn;

/**
 * 需求:
 * 动物园售票,一共100张票,通过四个窗口售卖，卖完停止。
 * 使用Runnable接口实现
 * @author Axin
 */
public class Demo04SaleTickets {


	public static void main(String[] args) {
		//所有的票
		Ticket tickets = new Ticket();
		//4个窗口卖票
		new Thread(tickets,"1号窗口").start();
		new Thread(tickets,"2号窗口").start();
		new Thread(tickets,"3号窗口").start();
		new Thread(tickets,"4号窗口").start();


		/**
		 * 多次启动线程同一个线程是不合法的。 特别是，一旦线程完成执行不能再重新启动。
		 * 异常
		 * IllegalThreadStateException - 如果线程已经启动。
		 * ---来自JDK文档
		 *
		 */
		//Thread t1 = new Thread(tickets);
		//t1.start();
		//t1.start();
		//t1.start();
		//t1.start();
	}

}

/**
 * 所有的票
 */
class Ticket implements Runnable {
	/**
	 * 总票数
	 */
	private int ticket = 100;

	@Override
	public void run() {
		//开票卖票
		doSale();
	}
	public void doSale(){
		while(true) {
			synchronized(this) {
				if(ticket <= 0) {
					//停止卖票
					break;
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

				System.out.println(Thread.currentThread().getName() + "卖掉第 " + ticket-- + " 号票");
			}
		}
	}
}
