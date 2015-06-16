package com.student.sb.ui;

import javax.swing.JFrame;

/*
 * 这里可以尝试模板方法模式。
 */

public class BaseJFrame extends JFrame {

	public BaseJFrame() {

	}

	public static int getScreenHeight() {
		return ((int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
	}

	public static int getScreenWidth() {
		return ((int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
	}

}
