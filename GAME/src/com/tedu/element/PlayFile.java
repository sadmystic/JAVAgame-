package com.tedu.element;

import javax.swing.*;
import java.awt.*;

/*
����ӵ��࣬��Ҷ�����úʹ���
*
���࿪������:
 1.�̳���Ԫ�ػ��ࣻ��дshow����
 2.��������ѡ������д�����������磺move
 3.����������������

*/
public class PlayFile extends ElementObj{

    private int attack;//������
    private int moveNum=3;//�ƶ��ٶ�ֵ

    public PlayFile(){}

    //�Դ����������Ĺ��̷�װ,����ֵ���Ƕ���ʵ��
    @Override
    public ElementObj createElement(String str){
        String[] split = str.split(",");
        for (String str1:split
             ) {
            String[] split2 = str1.split(":");
            switch (split2[0]){
                case "x":this.setX(Integer.parseInt(split2[1]));break;
                case "y":this.setY(Integer.parseInt(split2[1]));break;
                case "f":this.setFx(split2[1]);break;
            }
        }

        this.setW(10);
        this.setH(10);
        return this;
    }
    @Override
    public void showElement(Graphics g) {
        g.setColor(Color.green);

        g.fillOval(this.getX(),this.getY(),this.getW(),this.getH());
    }

    @Override
    protected void move() {
        if(this.getX()<0 || this.getX()>800 || this.getY()<0 || this.getY()>600){
            this.setLive(false);
            return;
        }
        switch (this.getFx()){
            case "up":this.setY(this.getY()-this.moveNum);break;
            case "left":this.setX(this.getX()-this.moveNum);break;
            case "right":this.setX(this.getX()+this.moveNum);break;
            case "down":this.setY(this.getY()+this.moveNum);break;
        }
    }
    /*
    * �����ӵ���˵:1.���߽� 2.��ײ 3.��ҷű���
    * ����ʽ�����ﵽ��������ʱ��ֻ�����޸�����״̬�Ĳ���
    * */

    @Override
    public void die() {}

    private long time=0;
    @Override
    protected void updateImage(long gameTime) {
    	if("enemy".equals(getName())){
    		return ;
    	}
    	if(gameTime-time>20) {
    		this.setLive(false);
    	}
//        if(gameTime-time>5){
////            System.out.println("time:"+time+" "+"gameTime:"+gameTime);
//            time=gameTime;
//            this.setW(this.getW()+2);
//            this.setH(this.getH()+2);
//        }
    }
}
