package cn.giteasy.thread2;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer类:计时器
 */
public class Demo03Timer {


	public static void main(String[] args) throws InterruptedException {
		Timer timer = new Timer();

		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse("2022-05-08 16:37:00", pattern);
		//转为date对象
		Date date = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());

		/**
		 * 会单独启动一个线程，在指定时间安排指定任务
		 * 	第一个参数: 运行的任务
		 * 	第二个参数：执行的时间
		 * 	第三个参数：是过多长时间再重复执行
		 */
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("起床写代码!");
			}
		}, date, 3000);

		while (true) {
			Thread.sleep(1000);
			System.out.println(new Date());
		}
	}
}


