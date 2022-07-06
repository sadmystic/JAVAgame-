package com.tedu.game;

import com.tedu.controller.GameListener;
import com.tedu.controller.GameThread;
import com.tedu.show.GameJFrame;
import com.tedu.show.GameMainJPanel;

public class GameStart {
	/**
	 * 程序的唯一入口
	 */

	static GameJFrame gj=new GameJFrame();

	public static void main(String[] args) {
		gameStart(0);

	}

	//主线程


	static public void gameStart(int mapid){
		//实例化主线程
		GameMainJPanel jp=
				new GameMainJPanel();
		//实例化监听
		GameListener listnner=new GameListener();
		GameThread th=new GameThread(1);
		gj.setThead(th);
//		注入
		gj.setjPanel(jp);
		gj.setKeyListener(listnner);;
		gj.start();
	}

/*	static public void gameStart(){

		*//**实例化面板，注入到jframe中*//*
		GameMainJPanel jp=
				new GameMainJPanel();
		//实例化监听
		GameListener listnner=new GameListener();
		GameThread th=new GameThread(5);
		gj.setThead(th);
//		注入
		gj.setjPanel(jp);
		gj.setKeyListener(listnner);

		gj.start();
	}
*/

	static public void setTh(int mapid){
		//实例化主线程
		GameThread th=new GameThread(mapid);
		gj.setThead(th);

	}



}
