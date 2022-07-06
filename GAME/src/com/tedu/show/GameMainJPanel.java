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
 * @˵�� ��Ϸ����Ҫ���
 * @author renjj
 * @����˵�� ��Ҫ����Ԫ�ص���ʾ��ͬʱ���н����ˢ��(���߳�)
 * 
 * @���⻰ java����ʵ��˼����Ӧ���ǣ����̳л����ǽӿ�ʵ��
 *
 * @���߳�ˢ�� 1.����ʵ���߳̽ӿ�
 * 			 2.���ඨ��һ���ڲ�����ʵ��
 */
public class GameMainJPanel extends JPanel implements Runnable{

	//	����������
	private ElementManager em;


	public GameMainJPanel() {

		this.setBackground(Color.getHSBColor(60,60,140));
		this.setBounds(0,20,800,600);
		init();

	}

	public void init() {
		em = ElementManager.getManager();//�õ�Ԫ�ع���������
	}
	
	@Override  //���ڻ滭��    Graphics ���� ר�����ڻ滭��
	public void paint(Graphics g) {

		super.paint(g);
		
		Map<GameElement, List<ElementObj>> all = em.getGameElements();
//		GameElement.values();//����ö�ٵ�˳��
		for(GameElement ge:GameElement.values()) {
			List<ElementObj> list = all.get(ge);
			for (int i = 0; i < list.size(); i++) {
				ElementObj obj = list.get(i);
				obj.showElement(g);//����ÿ������Լ���show��������Լ�����ʾ
			}
		}
//		if(gg==1){
//			em.getGameElements().clear();
//			new GameThread(5).gameLoad(5);
//			g.setColor(Color.red);
//			g.setFont(new Font("����",Font.BOLD,35));
//			g.drawString("GAMEOVER",170,300);
//			g.setColor(Color.green);
//			g.setFont(new Font("����",Font.BOLD,29));
//			g.drawString("yh����������Ļ����λ�����¿�ʼ",10,350);
//		}

	}


	@Override
	public void run() {
		while(true){
			this.repaint();
//			һ����������߳�ʹ������
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


}











