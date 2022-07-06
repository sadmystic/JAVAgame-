package com.tedu.element;

import com.tedu.manager.GameLoad;

import javax.swing.*;
import java.awt.*;

public class Man extends ElementObj{

    private int hp=1;
    @Override
    public void showElement(Graphics g) {
        g.drawImage(this.getIcon().getImage(),this.getX(),this.getY(),this.getW(),this.getH(),null);
    }

    public Man() {
    }

    public Man(int x, int y, int w, int h, ImageIcon icon) {
        super(x, y, w, h, icon);
    }

    @Override
    public ElementObj createElement(String str) {
        this.setName("man");
        ImageIcon icon=new ImageIcon("image/wall/base.png");
        this.setX(360);
        this.setY(520);
        this.setW(icon.getIconWidth());
        this.setH(icon.getIconHeight());
        this.setIcon(icon);

        return this;
    }
}
