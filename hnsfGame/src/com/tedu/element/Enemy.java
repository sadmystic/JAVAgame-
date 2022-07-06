package com.tedu.element;

import com.tedu.manager.ElementManager;
import com.tedu.manager.GameElement;
import com.tedu.manager.GameLoad;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Enemy extends ElementObj{

    private int hp=2;
    @Override
    public void showElement(Graphics g) {
        g.drawImage(this.getIcon().getImage(),this.getX(),this.getY(),this.getW(),this.getH(),null);
    }

    @Override
    public void move(){

        this.setOldx(this.getX());
        this.setOldy(this.getY());


/*        if(this.getX()<=0){
            this.setFx("up");
        }
        if(this.getX()>=800-this.getW()){
            this.setFx("down");
        }
        if(this.getY()<=0){
            this.setFx("right");
        }
        if(this.getY()>=500-this.getW()){
            this.setFx("left");
        }*/


        if(this.getFx()=="left" ){
            if(this.getX()<=0){
                this.setFx("up");
            }
            else {
                this.setX(this.getX() - 2);
                this.setFx("left");
            }
        }
        if(this.getFx()=="up"  ){
            if(this.getY()<=0){
                this.setFx("right");
            }else {
                this.setY(this.getY() - 2);
                this.setFx("up");
            }
            }
        if(this.getFx()=="right" ){
            if(this.getX()>=790-this.getW()){
                this.setFx("down");
            }else {
            this.setX(this.getX()+2);
            this.setFx("right");
            }
        }
        if(this.getFx()=="down"  ){
            if(this.getY()>=600-2*this.getH()){
                this.setFx("left");
            }else {
            this.setY(this.getY()+2);
            this.setFx("down");
            }
        }



    }


    @Override
    public ElementObj createElement(String str) {
        Random ran=new Random();
        int x= ran.nextInt(400);
        int y=ran.nextInt(400);
//        int x=0;
//        int y=0;
        this.setName("enemy");
        this.setFx("up");
        this.setX(x);
        this.setY(y);
        this.setH(35);
        this.setW(35);
        this.setIcon(new ImageIcon("image/tank/bot/bot_up.png"));
        return this;
    }

    @Override
    protected void updateImage(long gameTime){
        this.setIcon(GameLoad.imgMap2.get(this.getFx()));
    }

    private long time=0;

    public void add(long gameTime) {
        //工厂构造对象
        //传递固定格式{x:3,y:5,f:up}
        if(gameTime-time>100)
        {
            time=gameTime;
        }
        else return;

        ElementObj element = new PlayFile().createElement(this.toString());
        element.setName("enemy");
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
    public void die() {
        this.setIcon(new ImageIcon("image/boom/boom.png"));
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
