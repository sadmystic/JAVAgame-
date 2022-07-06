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
	* 移动属性：
	* 1.单属性 配合 方向枚举类型使用
	* 2.双属性 上下 和 左右 配合boolean值
	* 				约定 0代表不动，1代表上，2代表下
	* 3.4属性 上下左右 boolean配合
	* 				同时按上和下 后按重置先按的
	* 图片读取到内存中，加载器临时处理方法，手动编写存储到内存
	* */
	private int hp=5;
	private boolean left = false;
	private boolean up = false;;
	private boolean right = false;
	private boolean down = false;



	//记录面向方向,默认为up


	private boolean pkType=false;//攻击状态true,false停止

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
	 * 面向对象中第1个思想： 对象自己的事情自己做
	 */
	@Override
	public void showElement(Graphics g) {
		//绘画图片
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

	//添加子弹
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
		//工厂构造对象
		//传递固定格式{x:3,y:5,f:up}
		ElementObj element = new PlayFile().createElement(this.toString());
		element.setName("play");
		//装入集合
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
		//被调用一次 就减少一次血

			this.hp--;
			if (this.hp>0){
				return;
			}
		super.setLive(live);
	}


}
