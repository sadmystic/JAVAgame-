package com.tedu.game;

import com.tedu.controller.GameListener;
import com.tedu.controller.GameThread;
import com.tedu.show.GameJFrame;
import com.tedu.show.GameMainJPanel;

public class GameStart {
	/**
	 * �����Ψһ���
	 */

	static GameJFrame gj=new GameJFrame();

	public static void main(String[] args) {
		gameStart(0);

	}

	//���߳�


	static public void gameStart(int mapid){
		//ʵ�������߳�
		GameMainJPanel jp=
				new GameMainJPanel();
		//ʵ��������
		GameListener listnner=new GameListener();
		GameThread th=new GameThread(1);
		gj.setThead(th);
//		ע��
		gj.setjPanel(jp);
		gj.setKeyListener(listnner);;
		gj.start();
	}

/*	static public void gameStart(){

		*//**ʵ������壬ע�뵽jframe��*//*
		GameMainJPanel jp=
				new GameMainJPanel();
		//ʵ��������
		GameListener listnner=new GameListener();
		GameThread th=new GameThread(5);
		gj.setThead(th);
//		ע��
		gj.setjPanel(jp);
		gj.setKeyListener(listnner);

		gj.start();
	}
*/

	static public void setTh(int mapid){
		//ʵ�������߳�
		GameThread th=new GameThread(mapid);
		gj.setThead(th);

	}



}
