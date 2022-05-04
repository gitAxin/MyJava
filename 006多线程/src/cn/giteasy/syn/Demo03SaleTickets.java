package cn.giteasy.syn;

/**
 * 需求:
 * 动物园售票,一共100张票,通过四个窗口售卖，卖完停止。
 */
public class Demo03SaleTickets {


	public static void main(String[] args) {
		/**
		 *	4个窗口卖票
		 */
		new TicketWindow("1号窗口").start();
		new TicketWindow("2号窗口").start();
		new TicketWindow("3号窗口").start();
		new TicketWindow("4号窗口").start();
	}

}

/**
 * 售票窗口
 */
class TicketWindow extends Thread {
	/**
	 * 总票数
	 */
	private static int ticket = 100;

	/**
	 * 	窗口名称
	 */
	private String windowName;

	//private static Object lock = new Object();		//如果用引用数据类型成员变量当作锁对象,必须是静态的，否则，每次创建当前对象都是一个新的对象


	public TicketWindow(String windowName) {
		super(windowName);
		this.windowName = windowName;
	}

	@Override
	public void run() {
		//开票卖票
		doSale();
	}
	public void doSale(){
		while(true) {
			synchronized(TicketWindow.class) { //如果使用this,不会起到作用，因为是4个TicketWindow对象卖票，不是同一个对象
				if(ticket <= 0) {
					//停止卖票
					break;
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				System.out.println(getName() + "卖掉第 " + ticket-- + " 号票");
			}
		}
	}
}
