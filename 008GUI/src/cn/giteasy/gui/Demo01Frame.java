package cn.giteasy.gui;

import java.awt.Frame;
import java.awt.Toolkit;


public class Demo01Frame {


	public static void main(String[] args) {
		Frame f = new Frame("我的第一个窗口");
		//设置窗体大小
		f.setSize(400, 600);
		//设置窗体位置
		f.setLocation(500, 50);
		//设置图标
		f.setIconImage(Toolkit.getDefaultToolkit().createImage(".\\008GUI\\weixin.png"));
		//设置窗体可见
		f.setVisible(true);
	}
}
