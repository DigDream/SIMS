package com.student.sb.ui;

import javax.swing.JFrame;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

/*
 * 
 */

public class Main extends JFrame {
	public static void main(String[] args) {
		try {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.frameBorderStyle.generalNoTranslucencyShadow;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e) {
			e.printStackTrace();
		}
		UIManager.put("RootPane.setupButtonVisible", false);
		Main mJframe = new Main();
		mJframe.setBounds(100, 100, 300, 300);
		mJframe.setVisible(true);

	}

}
