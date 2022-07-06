package com.tedu.element;

import javax.swing.*;
import java.awt.*;

public class MapObj extends ElementObj{
    //血量设置
    private int hp;


    @Override
    public void showElement(Graphics g) {
        g.drawImage(this.getIcon().getImage(),
                this.getX(),this.getY(),
                this.getW(),this.getH(),null);

    }

    //墙类型,x,y
    @Override
    public ElementObj createElement(String str) {
        String[]arr=str.split(",");
        ImageIcon icon=null;
        switch (arr[0]){//设置图片信息
            case "GRASS":icon=new ImageIcon("image/wall/grass.png");
                         this.setName("GRASS");break;
            case "BRICK":icon=new ImageIcon("image/wall/Nangua.gif");
                        this.setName("BRICK");break;
            case "RIVER":icon=new ImageIcon("image/wall/river.png");
                        this.setName("RIVER");break;
            case "IRON":icon=new ImageIcon("image/wall/wall2.gif");
                        this.hp=4;this.setName("IRON");break;
        }
        int x=Integer.parseInt(arr[1]);
        int y=Integer.parseInt(arr[2]);
        int w=25;
        int h=25;
        this.setX(x);
        this.setY(y);
        this.setW(w);
        this.setH(h);
        this.setIcon(icon);

        return this;
    }

    @Override
    public void setLive(boolean live) {
        //被调用一次 就减少一次血
        if("IRON".equals(this.getName())){//南瓜要一下
            this.hp--;
            if (this.hp>0){
                return;
            }
        }
        if("RIVER".equals(this.getName())){//坚果需要四下
                return;
        }
        super.setLive(live);
    }
}
