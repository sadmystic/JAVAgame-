package com.tedu.controller;

import com.tedu.element.ElementObj;
import com.tedu.manager.ElementManager;
import com.tedu.manager.GameElement;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.tedu.manager.GameElement.*;

/*
* @说明 监听类，监听用户操作
*
* */
public class GameListener implements KeyListener {
    private ElementManager em=ElementManager.getManager();

    private Set<Integer> set=new HashSet<Integer>();
    @Override
    public void keyTyped(KeyEvent e) {
    }
/*
* 左37 上38 右39 下40
* */
    @Override
    public void keyPressed(KeyEvent e) {
        //拿到玩家集合
//        System.out.println("按下"+e.getKeyCode());
        int key=e.getKeyCode();
        if(set.contains(key)){
            //如果包含了直接结束方法
            return;
        }
        set.add(key);
        List<ElementObj> play = em.getElementsByKey(GameElement.PLAY);
        for(ElementObj obj : play) {
            obj.keyClick(true,e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(!set.contains(e.getKeyCode())){//如果不存在，就停止
            return;
        }//存在
        set.remove(e.getKeyCode());
        List<ElementObj> play = em.getElementsByKey(GameElement.PLAY);
        for(ElementObj obj : play) {
            obj.keyClick(false,e.getKeyCode());
        }
    }
}
