package com.student.sb.ui;

import javax.swing.JFrame;

public class BaseJFrame extends JFrame{
	
	public static int getScreenHeight() {
		return ((int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
	}

	public static int getScreenWidth() {
		return ((int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
	}

}
