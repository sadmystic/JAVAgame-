package com.tedu.element;

import java.awt.*;

import javax.swing.ImageIcon;

/**
 * @˵�� ����Ԫ�صĻ��ࡣ
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
//	���С������� ���ֱ�Ҫ��״ֵ̬�����磺�Ƿ�����.
	private boolean live=true;//����״̬ture����,false����
	
	public ElementObj() {	//���������ʵû�����ã�ֻ��Ϊ�̳е�ʱ�򲻱���д��	
	}
	/**
	 * @˵�� �������Ĺ��췽��; ���������ഫ�����ݵ�����
	 * @param x    ���Ͻ�X����
	 * @param y    ���Ͻ�y����
	 * @param w    w���
	 * @param h    h�߶�
	 * @param icon  ͼƬ
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
	 * @˵�� ���󷽷�����ʾԪ��
	 * @param g  ���� ���ڽ��л滭
	 */
	public abstract void showElement(Graphics g);

	/*
	* ֻ����Ҫ���̼������������д�������
	* true�����£�false�����ɿ�
	* key �������codeֵ
	* */
	public void keyClick(boolean bl,int key){

	}
	/*
	* ��Ҫ�ƶ�������ʵ�ַ���
	* */
	protected void move(){}
	/*
	* ���ģʽ ģ��ģʽ;��ģ��ģʽ�ж��� ����ִ�з������Ⱥ�˳��������ѡ������д����
	*         1.�ƶ� 2.��װ 3.�ӵ�����
	* */
	public final void model(long gameTime){
	//�Ȼ�װ
		updateImage(gameTime);
	//���ƶ�
		move();
	//�����ӵ�
		add(gameTime);
	}

	protected void updateImage(long gameTime) {}

	protected void add(long gameTime) {}
	//��������
	public  void die(){}//����Ҳ��һ������

	public ElementObj createElement(String str){return null;}


	/*
	* ����Ԫ�ص���ײ���ζ��� ʵʱ����
	* */
	public Rectangle getRectangle() {

		return new Rectangle(x, y, w, h);
	}

	/*
	* ��ײ����
	* ���� һ����this һ���Ǵ���ֵ
	* ����true����ײ false����ײ
	* */
	public boolean pk(ElementObj obj){

		return this.getRectangle().intersects(obj.getRectangle());
	}

	/**
	 * ֻҪ�� VO�� POJO ��ҪΪ�������� get��set����
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










