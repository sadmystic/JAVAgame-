package com.tedu.element;

import javax.swing.*;
import java.awt.*;

/*
玩家子弹类，玩家对象调用和创建
*
子类开发步骤:
 1.继承与元素基类；重写show方法
 2.按照需求选择性重写其他方法例如：move
 3.定义子类特有属性

*/
public class PlayFile extends ElementObj{

    private int attack;//攻击力
    private int moveNum=3;//移动速度值

    public PlayFile(){}

    //对创建这个对象的过程封装,返回值就是对象实体
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
    * 对于子弹来说:1.出边界 2.碰撞 3.玩家放保险
    * 处理方式，当达到死亡条件时，只进行修改死亡状态的操作
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
