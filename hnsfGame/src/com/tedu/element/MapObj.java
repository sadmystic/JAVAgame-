package com.tedu.element;

import javax.swing.*;
import java.awt.*;

public class MapObj extends ElementObj{
    //Ѫ������
    private int hp;


    @Override
    public void showElement(Graphics g) {
        g.drawImage(this.getIcon().getImage(),
                this.getX(),this.getY(),
                this.getW(),this.getH(),null);

    }

    //ǽ����,x,y
    @Override
    public ElementObj createElement(String str) {
        String[]arr=str.split(",");
        ImageIcon icon=null;
        switch (arr[0]){//����ͼƬ��Ϣ
            case "GRASS":icon=new ImageIcon("image/wall/grass.png");
                         this.setName("GRASS");break;
            case "BRICK":icon=new ImageIcon("image/wall/brick.png");
                        this.setName("BRICK");break;
            case "RIVER":icon=new ImageIcon("image/wall/river.png");
                        this.setName("RIVER");break;
            case "IRON":icon=new ImageIcon("image/wall/iron.png");
                        this.hp=4;this.setName("IRON");break;
        }
        int x=Integer.parseInt(arr[1]);
        int y=Integer.parseInt(arr[2]);
        int w=icon.getIconWidth();
        int h=icon.getIconHeight();
        this.setX(x);
        this.setY(y);
        this.setW(w);
        this.setH(h);
        this.setIcon(icon);

        return this;
    }

    @Override
    public void setLive(boolean live) {
        //������һ�� �ͼ���һ��Ѫ
        if("IRON".equals(this.getName())){//��ǽ��Ҫ����
            this.hp--;
            if (this.hp>0){
                return;
            }
        }
        if("RIVER".equals(this.getName())){//��ǽ��Ҫ����
                return;
        }
        super.setLive(live);
    }
}