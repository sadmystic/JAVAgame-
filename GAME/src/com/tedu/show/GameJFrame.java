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
 * @说明 游戏窗体 主要实现的功能：关闭，显示，最大最小化
 * @author renjj
 * @功能说明   需要嵌入面板,启动主线程等等
 * @窗体说明  swing awt  窗体大小（记录用户上次使用软件的窗体样式）
 * 
 * @分析 1.面板绑定到窗体
 *       2.监听绑定
 *       3.游戏主线程启动
 *       4.显示窗体
 */
public class GameJFrame extends JFrame{
	public static final int FRESH=20;
	public static int GameX = 800;//GAMEX
	public static int GameY = 620;
	private JPanel jPanel =null; //正在现实的面板
	private KeyListener  keyListener=null;//键盘监听
	private MouseMotionListener mouseMotionListener=null; //鼠标监听
	private MouseListener mouseListener=null;
	private Thread thead=null;  //游戏主线程
	
	public GameJFrame() {
		init();
	}
	public void init() {

		this.setSize(GameX, GameY); //设置窗体大小
		this.setTitle("僵尸大战植物");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置退出并且关闭
		this.setLocationRelativeTo(null);//屏幕居中显示
//		。。。。
	}


	/*窗体布局: 可以讲 存档，读档。button   给大家扩展的*/
	public void addButton() {
		this.setLayout(null);//布局格式，可以添加控件
		JButton button = new JButton("切换关卡");
		button.setBounds(0,0,100,20);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		this.add(button);
	}

	/*弹窗*/
	public void addJOptionPane(int i,int a){
		if(i==1)
			JOptionPane.showMessageDialog(null, "输了,重新开始！");
		else
			JOptionPane.showMessageDialog(null, "赢了,得分为:"+a+"下一关！");

	}
//-------------------------
	public void addMenu(){
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		JMenu menuFile = new JMenu("切换关卡(Q)"), menuEdit = new JMenu("编辑(E)"), menuView = new JMenu("查看(V)");
		menuFile.setMnemonic('Q');
		menuEdit.setMnemonic('E');
		menuView.setMnemonic('V');
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuView);

		JMenu itemOpen = new JMenu("关卡");
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
	 * 启动方法
	 */
	public void start() {
		if(jPanel!=null) {
			this.add(jPanel);
		}
		if(keyListener !=null) {
			this.addKeyListener(keyListener);
		}
		if(thead !=null) {
			thead.start();//启动线程
		}
		//加按钮
//		this.addButton();
		//加菜单
		this.addMenu();

//		界面的刷新
		this.setVisible(true);//显示界面
		if(this.jPanel instanceof Runnable){
			//已经做了类型判断
			new Thread((Runnable) this.jPanel).start();
		}
	}


	//重新开始
	public void stop(){

		new Thread((Runnable) this.jPanel).start();
	}



	
	/*set注入：等大家学习ssm 通过set方法注入配置文件中读取的数据;讲配置文件
	 * 中的数据赋值为类的属性
	 * 构造注入：需要配合构造方法
	 * spring 中ioc 进行对象的自动生成，管理。
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





