package com.tedu.show;

import com.tedu.controller.GameListener;
import com.tedu.controller.GameThread;
import com.tedu.game.GameStart;
import com.tedu.manager.GameLoad;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * @˵�� ��Ϸ���� ��Ҫʵ�ֵĹ��ܣ��رգ���ʾ�������С��
 * @author renjj
 * @����˵��   ��ҪǶ�����,�������̵߳ȵ�
 * @����˵��  swing awt  �����С����¼�û��ϴ�ʹ������Ĵ�����ʽ��
 * 
 * @���� 1.���󶨵�����
 *       2.������
 *       3.��Ϸ���߳�����
 *       4.��ʾ����
 */
public class GameJFrame extends JFrame{
	public static final int FRESH=20;
	public static int GameX = 800;//GAMEX
	public static int GameY = 620;
	private JPanel jPanel =null; //������ʵ�����
	private KeyListener  keyListener=null;//���̼���
	private MouseMotionListener mouseMotionListener=null; //������
	private MouseListener mouseListener=null;
	private Thread thead=null;  //��Ϸ���߳�
	
	public GameJFrame() {
		init();
	}
	public void init() {

		this.setSize(GameX, GameY); //���ô����С
		this.setTitle("��ʬ��սֲ��");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����˳����ҹر�
		this.setLocationRelativeTo(null);//��Ļ������ʾ
//		��������
	}


	/*���岼��: ���Խ� �浵��������button   �������չ��*/
	public void addButton() {
		this.setLayout(null);//���ָ�ʽ��������ӿؼ�
		JButton button = new JButton("�л��ؿ�");
		button.setBounds(0,0,100,20);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		this.add(button);
	}

	/*����*/
	public void addJOptionPane(int i,int a){
		if(i==1)
			JOptionPane.showMessageDialog(null, "����,���¿�ʼ��");
		else
			JOptionPane.showMessageDialog(null, "Ӯ��,�÷�Ϊ:"+a+"��һ�أ�");

	}
//-------------------------
	public void addMenu(){
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		JMenu menuFile = new JMenu("�л��ؿ�(Q)"), menuEdit = new JMenu("�༭(E)"), menuView = new JMenu("�鿴(V)");
		menuFile.setMnemonic('Q');
		menuEdit.setMnemonic('E');
		menuView.setMnemonic('V');
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuView);

		JMenu itemOpen = new JMenu("�ؿ�");
		itemOpen.setMnemonic('O');
		JMenuItem itemOpen1 = new JMenuItem("1");
		JMenuItem itemOpen2 = new JMenuItem("2");
		JMenuItem itemOpen3 = new JMenuItem("3");
		JMenuItem itemOpen4 = new JMenuItem("4");
		JMenuItem itemOpen5 = new JMenuItem("5");
		JMenuItem itemOpen6 = new JMenuItem("6");
		JMenuItem itemOpen7 = new JMenuItem("7");
		JMenuItem itemOpen8 = new JMenuItem("8");
		JMenuItem itemOpen9 = new JMenuItem("9");
		JMenuItem itemOpen10 = new JMenuItem("10");
		itemOpen1.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				GameThread gameThread = new GameThread(1);
				gameThread.gameLoad(1);

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		itemOpen2.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				GameThread gameThread = new GameThread(2);
				gameThread.gameLoad(2);
			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		itemOpen3.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				GameThread gameThread = new GameThread(3);
				gameThread.gameLoad(3);
			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		itemOpen4.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				GameThread gameThread = new GameThread(4);
				gameThread.gameLoad(4);
			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		itemOpen5.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				GameThread gameThread = new GameThread(5);
				gameThread.gameLoad(5);
			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		itemOpen6.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				GameThread gameThread = new GameThread(6);
				gameThread.gameLoad(6);
			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
			itemOpen7.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {

				}

				@Override
				public void mousePressed(MouseEvent e) {
					GameThread gameThread = new GameThread(7);
					gameThread.gameLoad(7);
				}

				@Override
				public void mouseReleased(MouseEvent e) {

				}

				@Override
				public void mouseEntered(MouseEvent e) {

				}

				@Override
				public void mouseExited(MouseEvent e) {

				}
			});
				itemOpen8.addMouseListener(new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent e) {

					}

					@Override
					public void mousePressed(MouseEvent e) {
						GameThread gameThread = new GameThread(8);
						gameThread.gameLoad(8);
					}

					@Override
					public void mouseReleased(MouseEvent e) {

					}

					@Override
					public void mouseEntered(MouseEvent e) {

					}

					@Override
					public void mouseExited(MouseEvent e) {

					}
				});
					itemOpen9.addMouseListener(new MouseListener() {
						@Override
						public void mouseClicked(MouseEvent e) {

						}

						@Override
						public void mousePressed(MouseEvent e) {
							GameThread gameThread = new GameThread(9);
							gameThread.gameLoad(9);
						}

						@Override
						public void mouseReleased(MouseEvent e) {

						}

						@Override
						public void mouseEntered(MouseEvent e) {

						}

						@Override
						public void mouseExited(MouseEvent e) {

						}
					});
						itemOpen10.addMouseListener(new MouseListener() {
							@Override
							public void mouseClicked(MouseEvent e) {

							}

							@Override
							public void mousePressed(MouseEvent e) {
								GameThread gameThread = new GameThread(10);
								gameThread.gameLoad(10);
							}

							@Override
							public void mouseReleased(MouseEvent e) {

							}

							@Override
							public void mouseEntered(MouseEvent e) {

							}

							@Override
							public void mouseExited(MouseEvent e) {

							}
		});
		itemOpen.add(itemOpen1);
		itemOpen.add(itemOpen2);
		itemOpen.add(itemOpen3);
		itemOpen.add(itemOpen4);
		itemOpen.add(itemOpen5);
		itemOpen.add(itemOpen6);
		itemOpen.add(itemOpen7);
		itemOpen.add(itemOpen8);
		itemOpen.add(itemOpen9);
		itemOpen.add(itemOpen10);
		menuFile.add(itemOpen);

//--------------------------


	}

	/**
	 * ��������
	 */
	public void start() {
		if(jPanel!=null) {
			this.add(jPanel);
		}
		if(keyListener !=null) {
			this.addKeyListener(keyListener);
		}
		if(thead !=null) {
			thead.start();//�����߳�
		}
		//�Ӱ�ť
//		this.addButton();
		//�Ӳ˵�
		this.addMenu();

//		�����ˢ��
		this.setVisible(true);//��ʾ����
		if(this.jPanel instanceof Runnable){
			//�Ѿ����������ж�
			new Thread((Runnable) this.jPanel).start();
		}
	}


	//���¿�ʼ
	public void stop(){

		new Thread((Runnable) this.jPanel).start();
	}



	
	/*setע�룺�ȴ��ѧϰssm ͨ��set����ע�������ļ��ж�ȡ������;�������ļ�
	 * �е����ݸ�ֵΪ�������
	 * ����ע�룺��Ҫ��Ϲ��췽��
	 * spring ��ioc ���ж�����Զ����ɣ�����
	 * */
	public void setjPanel(JPanel jPanel) {
		this.jPanel = jPanel;
	}
	public void setKeyListener(KeyListener keyListener) {
		this.keyListener = keyListener;
	}
	public void setMouseMotionListener(MouseMotionListener mouseMotionListener) {
		this.mouseMotionListener = mouseMotionListener;
	}
	public void setMouseListener(MouseListener mouseListener) {
		this.mouseListener = mouseListener;
	}
	public void setThead(Thread thead) {
		this.thead = thead;
	}
	
	
	
	
}





