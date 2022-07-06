package com.tedu.show;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.tedu.controller.GameThread;
import com.tedu.element.ElementObj;
import com.tedu.element.Play;
import com.tedu.manager.ElementManager;
import com.tedu.manager.GameElement;

/**
 * @说明 游戏的主要面板
 * @author renjj
 * @功能说明 主要进行元素的显示，同时进行界面的刷新(多线程)
 * 
 * @题外话 java开发实现思考的应该是：做继承或者是接口实现
 *
 * @多线程刷新 1.本类实现线程接口
 * 			 2.本类定义一个内部类来实现
 */
public class GameMainJPanel extends JPanel implements Runnable{

	//	联动管理器
	private ElementManager em;


	public GameMainJPanel() {

		this.setBackground(Color.getHSBColor(60,60,140));
		this.setBounds(0,20,800,600);
		init();

	}

	public void init() {
		em = ElementManager.getManager();//得到元素管理器对象
	}
	
	@Override  //用于绘画的    Graphics 画笔 专门用于绘画的
	public void paint(Graphics g) {

		super.paint(g);
		
		Map<GameElement, List<ElementObj>> all = em.getGameElements();
//		GameElement.values();//定义枚举的顺序
		for(GameElement ge:GameElement.values()) {
			List<ElementObj> list = all.get(ge);
			for (int i = 0; i < list.size(); i++) {
				ElementObj obj = list.get(i);
				obj.showElement(g);//调用每个类的自己的show方法完成自己的显示
			}
		}
//		if(gg==1){
//			em.getGameElements().clear();
//			new GameThread(5).gameLoad(5);
//			g.setColor(Color.red);
//			g.setFont(new Font("楷体",Font.BOLD,35));
//			g.drawString("GAMEOVER",170,300);
//			g.setColor(Color.green);
//			g.setFont(new Font("楷体",Font.BOLD,29));
//			g.drawString("yh提醒你点击屏幕任意位置重新开始",10,350);
//		}

	}


	@Override
	public void run() {
		while(true){
			this.repaint();
//			一般情况，多线程使用休眠
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


}











