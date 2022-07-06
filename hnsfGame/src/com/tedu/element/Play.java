package com.tedu.element;

import com.tedu.manager.ElementManager;
import com.tedu.manager.GameElement;
import com.tedu.manager.GameLoad;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

public class Play extends ElementObj{
	/*
	* �ƶ����ԣ�
	* 1.������ ��� ����ö������ʹ��
	* 2.˫���� ���� �� ���� ���booleanֵ
	* 				Լ�� 0��������1�����ϣ�2������
	* 3.4���� �������� boolean���
	* 				ͬʱ���Ϻ��� �������Ȱ���
	* ͼƬ��ȡ���ڴ��У���������ʱ���������ֶ���д�洢���ڴ�
	* */
	private int hp=5;
	private boolean left = false;
	private boolean up = false;;
	private boolean right = false;
	private boolean down = false;



	//��¼������,Ĭ��Ϊup


	private boolean pkType=false;//����״̬true,falseֹͣ

	public Play(){}

	public Play(int x, int y, int w, int h, ImageIcon icon) {
		super(x, y, w, h, icon);

	}

	@Override
	public ElementObj createElement(String str) {
		String[] split = str.split(",");
		this.setName("play");
		this.setX(Integer.parseInt(split[0]));
		this.setY(Integer.parseInt(split[1]));
		ImageIcon icon2 = GameLoad.imgMap.get(split[2]);
		this.setW(icon2.getIconWidth());
		this.setH(icon2.getIconHeight());
		this.setFx("up");
		this.setIcon(icon2);

		return this;
	}

	/**
	 * ��������е�1��˼�룺 �����Լ��������Լ���
	 */
	@Override
	public void showElement(Graphics g) {
		//�滭ͼƬ
		g.drawImage(this.getIcon().getImage(), 
				this.getX(), this.getY(), 
				this.getW(), this.getH(), null);
	}

	public void keyClick(boolean bl,int key){
		if (bl){
			switch (key){
				case 37:
					this.up=false;this.down=false;
					this.right=false;this.setFx("left");this.left=true;break;
				case 38:
					this.left=false;this.right=false;
					this.down=false;this.setFx("up");this.up=true;break;
				case 39:
					this.up=false;this.down=false;
					this.left=false;this.setFx("right");this.right=true;break;
				case 40:
					this.left=false;this.right=false;
					this.up=false;this.setFx("down");this.down=true;break;
				case 32:
					this.pkType=true;break;

			}}
		else{
			switch (key){
				case 37:this.left=false;break;
				case 38:this.up=false;break;
				case 39:this.right=false;break;
				case 40:this.down=false;break;
				case 32:this.pkType=false;break;
			}
		}


	}

	@Override
	public void move(){
		this.setOldx(this.getX());
		this.setOldy(this.getY());

		if(this.left && this.getX()>0){
			this.setX(this.getX()-5);
		}
		if(this.up && this.getY()>0){
			this.setY(this.getY()-5);
		}
		if(this.right && this.getX()<790-this.getW()){
			this.setX(this.getX()+5);
		}
		if(this.down && this.getY()<600-2*this.getH()){
			this.setY(this.getY()+5);
		}
//		System.out.println(this.getX()+" "+this.getY());
	}

	@Override
	protected void updateImage(long gameTime){
		this.setIcon(GameLoad.imgMap.get(this.getFx()));
	}

	private long filetime=0;

	//����ӵ�
	@Override
	public void add(long gameTime) {
		if(gameTime-filetime>10){
			filetime=gameTime;
		}
		else return;
		if(!this.pkType){
			return;
		}
		this.pkType=false;
		//�����������
		//���ݹ̶���ʽ{x:3,y:5,f:up}
		ElementObj element = new PlayFile().createElement(this.toString());
		element.setName("play");
		//װ�뼯��
		ElementManager.getManager().addElement(element, GameElement.PLAYFILE);

	}

	@Override
	public String toString() {

		int x=this.getX();
		int y=this.getY();
		switch (this.getFx()){
			case "up": x+=10;break;
			case "left": y+=10;break;
			case "right": x+=25;y+=10;break;
			case "down":y+=25;x+=10;break;
		}
		return "x:"+x+",y:"+y+",f:"+this.getFx();
	}

	@Override
	public void setLive(boolean live) {
		//������һ�� �ͼ���һ��Ѫ

			this.hp--;
			if (this.hp>0){
				return;
			}
		super.setLive(live);
	}


}
