package com.student.sb.ui;

import javax.swing.JFrame;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.student.sb.utils.PropertiesUtils;

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
		mJframe.setBounds((getScreenWidth() - 300) / 2, (getScreenHeight() - 300) / 2, 300, 300);
		mJframe.setVisible(true);
		mJframe.setTitle("SIMS-学生信息管理系统");
		
		System.out.println(PropertiesUtils.readKey("ISFIRST").equals("true"));
	}
	
	public static int getScreenHeight(){
		return ((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
	}
	
	public static int getScreenWidth(){
		return ((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
	}

}
