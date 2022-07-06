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
* @˵�� �����࣬�����û�����
*
* */
public class GameListener implements KeyListener {
    private ElementManager em=ElementManager.getManager();

    private Set<Integer> set=new HashSet<Integer>();
    @Override
    public void keyTyped(KeyEvent e) {
    }
/*
* ��37 ��38 ��39 ��40
* */
    @Override
    public void keyPressed(KeyEvent e) {
        //�õ���Ҽ���
//        System.out.println("����"+e.getKeyCode());
        int key=e.getKeyCode();
        if(set.contains(key)){
            //���������ֱ�ӽ�������
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
        if(!set.contains(e.getKeyCode())){//��������ڣ���ֹͣ
            return;
        }//����
        set.remove(e.getKeyCode());
        List<ElementObj> play = em.getElementsByKey(GameElement.PLAY);
        for(ElementObj obj : play) {
            obj.keyClick(false,e.getKeyCode());
        }
    }
}
