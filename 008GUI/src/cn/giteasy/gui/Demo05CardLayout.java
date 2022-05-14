package cn.giteasy.gui;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * 卡片布局管理器
 */
public class Demo05CardLayout {


	public static void main(String[] args) {
		Frame f = new Frame("CardLayout");
		f.setSize(400, 600);
		f.setVisible(true);
		//创建2个Panel容器，一个存放按钮,一个存放卡片
		Panel p1 = new Panel();
		Panel p2 = new Panel();

		//创建5个按钮，并将其添加到p1中
		Button b1 = new Button("number 1");
		Button b2 = new Button("number 2");
		Button b3 = new Button("number 3");
		Button b4 = new Button("number 4");
		Button b5 = new Button("number 5");
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);


		//将p2设置为CardLayout，并添加5个组件，每个组件都相当于一个卡片
		CardLayout cardLayout = new CardLayout();
		p2.setLayout(cardLayout);
		p2.add("number 1",new Button("number 1"));
		p2.add("number 2",new Button("number 2"));
		p2.add("number 3",new Button("number 3"));
		p2.add("number 4",new Button("number 4"));
		p2.add("number 5",new Button("number 5"));


		//将p1中的5个按钮，分别添加监听事件，当用户单击时，显示指定的卡片
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				cardLayout.show(p2,command);

			}
		};

		b1.addActionListener(listener);
		b2.addActionListener(listener);
		b3.addActionListener(listener);
		b4.addActionListener(listener);
		b5.addActionListener(listener);

		//将两个Panel容器添加到Frame中
		f.add(p1,BorderLayout.NORTH);
		f.add(p2);


	}

}
