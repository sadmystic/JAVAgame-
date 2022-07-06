package com.tedu.element;

import java.awt.*;

import javax.swing.ImageIcon;

/**
 * @说明 所有元素的基类。
 * @author renjj
 *
 */
public abstract class ElementObj {

	private String fx;
	private String name;
	private int oldx,oldy;
	private int x;
	private int y;
	private int w;
	private int h;
	private ImageIcon icon;
//	还有。。。。 各种必要的状态值，例如：是否生存.
	private boolean live=true;//生存状态ture存在,false死亡
	
	public ElementObj() {	//这个构造其实没有作用，只是为继承的时候不报错写的	
	}
	/**
	 * @说明 带参数的构造方法; 可以由子类传输数据到父类
	 * @param x    左上角X坐标
	 * @param y    左上角y坐标
	 * @param w    w宽度
	 * @param h    h高度
	 * @param icon  图片
	 */
	public ElementObj(int x, int y, int w, int h, ImageIcon icon) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.icon = icon;
	}
	/**
	 * @说明 抽象方法，显示元素
	 * @param g  画笔 用于进行绘画
	 */
	public abstract void showElement(Graphics g);

	/*
	* 只有需要键盘监听的子类才重写这个方法
	* true代表按下，false代表松开
	* key 代表键盘code值
	* */
	public void keyClick(boolean bl,int key){

	}
	/*
	* 需要移动的子类实现方法
	* */
	protected void move(){}
	/*
	* 设计模式 模板模式;在模板模式中定义 对象执行方法的先后顺序，由子类选择性重写方法
	*         1.移动 2.换装 3.子弹发射
	* */
	public final void model(long gameTime){
	//先换装
		updateImage(gameTime);
	//在移动
		move();
	//发射子弹
		add(gameTime);
	}

	protected void updateImage(long gameTime) {}

	protected void add(long gameTime) {}
	//死亡方法
	public  void die(){}//死亡也是一个对象

	public ElementObj createElement(String str){return null;}


	/*
	* 返回元素的碰撞矩形对象 实时返回
	* */
	public Rectangle getRectangle() {

		return new Rectangle(x, y, w, h);
	}

	/*
	* 碰撞方法
	* 传入 一个是this 一个是传入值
	* 返回true有碰撞 false无碰撞
	* */
	public boolean pk(ElementObj obj){

		return this.getRectangle().intersects(obj.getRectangle());
	}

	/**
	 * 只要是 VO类 POJO 就要为属性生成 get和set方法
	 */
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public ImageIcon getIcon() {
		return icon;
	}
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	public int getOldx() {
		return oldx;
	}

	public void setOldx(int oldx) {
		this.oldx = oldx;
	}

	public int getOldy() {
		return oldy;
	}

	public void setOldy(int oldy) {
		this.oldy = oldy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public String getFx() {
		return fx;
	}

	public void setFx(String fx) {
		this.fx = fx;
	}
}










